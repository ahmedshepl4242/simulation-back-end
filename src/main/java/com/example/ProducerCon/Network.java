package com.example.ProducerCon;


import com.example.ProducerCon.Momento.CareTaker;

import java.awt.*;
import java.util.*;

public class Network {
    ArrayList<Thread>threads=null;
    public void run(ArrayList<String>ms,ArrayList<ArrayList<String>>From,ArrayList<String>to)
    {

        Random random = new Random();
        ArrayList<Integer>Speeds=new ArrayList<>();
        for(int i=1000;i<1800;)
        {
            Speeds.add(i);
            i=i+100;
        }
        ArrayList<Machine>machines=new ArrayList<>();
        HashMap<String,FactoryQueue>Qs=new HashMap<>();
        for(ArrayList<String> fs:From)
        {
            for (String f:fs){
            if(Qs.get(f)==null)
            {
                Qs.put(f,new FactoryQueue(f));
            }
            }
        }
       int MAX_CAPICITY=11;
        Qs.put(to.get(to.size()-1),new FactoryQueue(to.get(to.size()-1)));
        int j=0;
        for (String m:ms)
        {
            machines.add(new Machine(null,m,Speeds.get(random.nextInt(5)),Qs.get(to.get(to.size()-1)),MAX_CAPICITY));
            for(String f:From.get(j))
            {
                machines.get(j).addObserver(Qs.get(f));
            }
            machines.get(j).setNext(Qs.get(to.get(j)));
            j++;
        }

        Queue<Product> products=new LinkedList<>();
        System.out.println(MAX_CAPICITY);
        for(int i=0;i<MAX_CAPICITY;i++)
        {
            products.add(new Product(generateRandomColor()));
        }
        for (Product p:products)
        {
            Qs.get(From.get(0).get(0)).addproduct(p);
        }
        threads=new ArrayList<>();
        for(Machine m:machines)
        {
            threads.add(new Thread(m));
        }

        for (Thread th:threads)
        {
            th.start();

        }
    }
    public void stop()
    {
        for (Thread th:threads) {
            th.interrupt();
        }
        threads=null;
        CareTaker careTaker=CareTaker.getInstance();
        careTaker.setCareTakernull();
    }
    public static Color generateRandomColor() {
        Random random = new Random();
        int red = random.nextInt(256); // Red component in the range 0-255
        int green = random.nextInt(256); // Green component in the range 0-255
        int blue = random.nextInt(256); // Blue component in the range 0-255

        return new Color(red, green, blue);
    }
}
