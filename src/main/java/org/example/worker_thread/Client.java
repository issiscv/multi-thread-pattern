package org.example.worker_thread;

import org.example.worker_thread.request.OneRequest;
import org.example.worker_thread.request.Request;
import org.example.worker_thread.request.TwoRequest;

import java.util.Random;
public class Client extends Thread {
    private final Channel channel;
    private static final Random random = new Random();

    public Client(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; true; i++) {
                Request request;
                Thread.sleep(random.nextInt(1000));
                if(random.nextInt(2) == 0) {
                    request = new OneRequest(getName(), i);
                } else {
                    request = new TwoRequest(getName(), i);
                }

                channel.putRequest(request);
            }
        } catch(InterruptedException e) {
            //.
        }
    }
}