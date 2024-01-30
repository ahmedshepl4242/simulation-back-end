package com.example.ProducerCon.Momento;

public class Momento {
    private String mid;
    private String qid;
    private String color;
    private int size;
    private long time;

    public Momento(String mid, String qid, String color, int size) {
        this.mid = mid;
        this.qid = qid;
        this.color = color;
        this.size = size;
        this.time = System.currentTimeMillis();
    }

    public String getMid() {
        return mid;
    }

    public String getQid() {
        return qid;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Momento{" +
                "mid='" + mid + '\'' +
                ", qid='" + qid + '\'' +
                ", color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
