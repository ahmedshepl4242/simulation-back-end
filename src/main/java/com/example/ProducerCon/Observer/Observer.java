package com.example.ProducerCon.Observer;

import com.example.ProducerCon.Product;

public interface Observer {
    void update(Product product, String mid);
}
