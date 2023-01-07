package org.example.poducer_consumer;

import java.util.LinkedList;
public class Channel {
    private final LinkedList<String> dataBuffer = new LinkedList<>();
    private final int maxSize;

    public Channel(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void put(String data) throws InterruptedException {
        while(dataBuffer.size() >= maxSize) {
            wait();
        }

        dataBuffer.addLast(data);

        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while(dataBuffer.size() <= 0) {
            wait();
        }

        String data = dataBuffer.pollFirst();
        notifyAll();

        //System.out.println("\t" + dataBuffer.size());

        return data;
    }
}
