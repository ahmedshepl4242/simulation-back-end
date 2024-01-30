package com.example.ProducerCon.Controller;

import java.util.ArrayList;

public class GraphRequest
{
    private ArrayList<String> ms;
    private ArrayList<ArrayList<String>>from;
    private ArrayList<String>to;

    public GraphRequest(ArrayList<String> ms, ArrayList<ArrayList<String>> from, ArrayList<String> to) {
        this.ms = ms;
        this.from = from;
        this.to = to;
    }

    public ArrayList<String> getMs() {
        return ms;
    }

    public ArrayList<ArrayList<String>> getFrom() {
        return from;
    }

    public ArrayList<String> getTo() {
        return to;
    }

}
