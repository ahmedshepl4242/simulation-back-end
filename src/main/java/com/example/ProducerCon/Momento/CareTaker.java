package com.example.ProducerCon.Momento;

import java.util.LinkedList;
import java.util.Queue;

public class CareTaker {
    private static  volatile CareTaker instance;
    private Queue<Momento> momentos = new LinkedList<>();
    private Queue<Momento> secmomentos = new LinkedList<>();
    private CareTaker() {
        // Private constructor to prevent instantiation outside the class
    }
    public  void setCareTakernull()
    {
        this.secmomentos=new LinkedList<>();
        this.momentos=new LinkedList<>();
    }

    public Queue<Momento> getSecmomentos() {
        return secmomentos;
    }

    public synchronized static CareTaker getInstance() {
        if (instance == null) {
            synchronized (CareTaker.class) {
                if (instance == null) {
                    instance = new CareTaker();
                }
            }
        }
        return instance;
    }

    public Momento getMomento() {
        if(momentos.size()==0)
        {
            return new Momento("null","null","null",0);
        }
        Momento momento = momentos.poll();
        secmomentos.offer(momento);
        return momento;
    }

    public synchronized void addMomento(Momento momento) {
        synchronized (CareTaker.class){
            momentos.offer(momento);
//        for (Momento m:momentos)
//        {
//            System.out.print(m);
//        }
            System.out.println(momento);
            System.out.println("--------------------------------------------");
        }
    }

}
