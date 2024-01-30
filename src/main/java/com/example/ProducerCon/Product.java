package com.example.ProducerCon;

import java.awt.*;

public class Product {
private Color color;
private Long id;


    public Product(Color color, Long id) {
        this.color = color;
        this.id = id;
    }

    public Product(Color color) {
        this.color = color;
    }

    public String getColor() {

        String hexFloatColor = String.format("#%02X%02X%02X",
                this.color.getRed(), this.color.getGreen(),this.color.getBlue());
        return hexFloatColor;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
