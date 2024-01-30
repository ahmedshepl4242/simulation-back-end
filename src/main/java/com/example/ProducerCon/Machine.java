package com.example.ProducerCon;



import com.example.ProducerCon.Momento.CareTaker;
import com.example.ProducerCon.Momento.Momento;
import com.example.ProducerCon.Observer.Observable;
import com.example.ProducerCon.Observer.Observer;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Machine implements Runnable, Observable {
    private static final SecureRandom RANDOM = new SecureRandom();
    private Product product;
    private FactoryQueue next;
    private CareTaker careTaker=CareTaker.getInstance();
    private ArrayList<FactoryQueue>factoryQueues=new ArrayList<>();
     private String id;
     private int Speed;

     private  boolean disconnected=false;

    public boolean isDisconnected() {
        return disconnected;
    }

    private FactoryQueue lastqueue;
    private int endpoint;

    public void setNext(FactoryQueue next) {
        this.next = next;
    }

    public Machine(Product product, String id, int speed,FactoryQueue lastqueue,int endpoint) {
        this.product = product;
        this.id = id;
        Speed = speed;
        this.lastqueue=lastqueue;
        this.endpoint=endpoint;
    }


    @Override
    public void run() {

        try {
            for (;;){
            while (disconnected||product==null) {
                if (endpoint==lastqueue.getSizee())
                {
                      careTaker.addMomento(new Momento("end","end","end",0));
                    return;
                }
                notifyOAll();
            }
           produce();
            }
        } catch (InterruptedException e) {
            return;
        }
    }
    public  void produce() throws InterruptedException {
        Thread.sleep(RANDOM.nextInt(Speed));

                  next.update(product,id);
                //  careTaker.addMomento(createMomento(next.getSize(),next.getId(),null));
                          product=null;


    }




    @Override
    public void addObserver(Observer observer) {
        factoryQueues.add((FactoryQueue) observer);
    }

    @Override
    public void removeObserver(Observer observer) {

        factoryQueues.remove(observer);
    }

    @Override
    public synchronized void notifyOAll() throws InterruptedException {
        for (FactoryQueue f:factoryQueues)
        {
            this.product=f.consume(id);
            Thread.sleep(RANDOM.nextInt(Speed));
            if (this.product!=null)
            {
               // careTaker.addMomento(createMomento(f.getSize(),f.getId(),product.getColor()));
                disconnected=false;
                break;
            }

           }
    }
    public Momento createMomento(int size, String qid, String color) {
        return new Momento(id,qid, color,size );
    }


}
