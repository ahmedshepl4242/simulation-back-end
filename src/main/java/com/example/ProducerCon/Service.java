package com.example.ProducerCon;


import com.example.ProducerCon.Momento.CareTaker;
import com.example.ProducerCon.Momento.Momento;

import java.util.ArrayList;
import java.util.Queue;

public class Service
{
    Network network=new Network();
    public void run(ArrayList<String> ms, ArrayList<ArrayList<String>>From, ArrayList<String>to)
    {
        network.run(ms,From,to);
    }
    public Momento getMomment()
    {
        CareTaker careTaker= CareTaker.getInstance();
        return careTaker.getMomento();
    }
    public void stopsimulation()
    {
        network.stop();
    }
    



}
