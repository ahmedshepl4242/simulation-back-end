package com.example.ProducerCon;



import com.example.ProducerCon.Momento.CareTaker;
import com.example.ProducerCon.Momento.Momento;
import com.example.ProducerCon.Observer.Observer;

import java.util.LinkedList;
import java.util.Queue;

public class FactoryQueue implements Observer {
    private final Object lock = new Object();
    private CareTaker careTaker=CareTaker.getInstance();


    private  Queue<Product>products=new LinkedList<>();
//    private  Queue<Integer>size=new LinkedList<>();
    private  int sizee=0;
     private String id;


    public FactoryQueue( String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public synchronized int getSizee()
    {
        return sizee;
    }
    public String getId() {
        return id;
    }

//    public synchronized int getSize() {
//        return size.poll();
//    }
    public void addproduct(Product product)
    {
        products.offer(product);
        sizee++;
//        size.offer(sizee);
    }


    public synchronized Product consume(String mid) throws InterruptedException {
        if(products.size()>0)
        {
        sizee--;
//        size.offer(sizee);
            Product product=products.poll();

            System.out.println("decremented"+id+sizee);
            careTaker.addMomento(createMomento(sizee,mid,product.getColor()));
            return product;
        }
        return null;

    }
    @Override
    public synchronized void update(Product product,String mid) {
        sizee++;
        System.out.println("incremented "+id+sizee);
            this.products.offer(product);
//            size.offer(sizee);
            careTaker.addMomento(createMomento(sizee,mid,null));

    }
    public Momento createMomento(int size, String mid, String color) {
        return new Momento(mid,id, color,size );
    }

}
