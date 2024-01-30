package com.example.ProducerCon.Observer;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyOAll() throws InterruptedException;
}
