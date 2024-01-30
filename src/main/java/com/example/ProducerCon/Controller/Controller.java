package com.example.ProducerCon.Controller;


import com.example.ProducerCon.Controller.GraphRequest;
import com.example.ProducerCon.Momento.CareTaker;
import com.example.ProducerCon.Momento.Momento;
import com.example.ProducerCon.Service;

import java.util.ArrayList;
import java.util.Queue;

import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class Controller {
    Service service=new Service();
    @PostMapping("/run")
    public void run(@RequestBody GraphRequest graphRequest){
        service.run(graphRequest.getMs(),graphRequest.getFrom(),graphRequest.getTo());
    }

    @GetMapping("/update")
    public Momento getMomment()
    {
        Momento momento=service.getMomment();

        System.out.println(momento+"abdlraaaaaaaaaaaaaaaaaaaaaaazik");
        return momento;
    }

    @PostMapping("/end")
    public void endSimulation()
    {
         service.stopsimulation();
    }
    @GetMapping("/replay")
    public ArrayList<Momento> reply()
    {
        CareTaker careTaker=CareTaker.getInstance();
        ArrayList<Momento> replayy=new ArrayList<>();
        Queue<Momento> q = careTaker.getSecmomentos();
        while(!q.isEmpty()) {
            replayy.add(q.poll());
        }
        return replayy;

    }

}
