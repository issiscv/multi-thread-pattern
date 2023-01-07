package org.example.poducer_consumer;

public class Main {
    public static void main(String[] args) {
        //buffer 의 사이즈를 10
        Channel channel = new Channel(10);

        Producer producerThread1 = new Producer("PRODUCER-1", channel);
        producerThread1.start();

        Producer producerThread2 = new Producer("PRODUCER-2", channel);
        producerThread2.start();


        Consumer consumerThread1 = new Consumer("CONSUMER-A", channel);
        consumerThread1.start();

        Consumer consumerThread2 = new Consumer("CONSUMER-B", channel);
        consumerThread2.start();

        Consumer consumerThread3 = new Consumer("CONSUMER-C", channel);
        consumerThread3.start();

        Consumer consumerThread4 = new Consumer("CONSUMER-D", channel);
        consumerThread4.start();
    }
}