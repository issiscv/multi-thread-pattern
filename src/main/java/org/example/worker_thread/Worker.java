package org.example.worker_thread;

import org.example.worker_thread.request.Request;

public class Worker extends Thread {
    private final Channel channel;

    public Worker(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while(true) {
            Request request = channel.takeRequest();
            request.execute();
        }
    }
}
