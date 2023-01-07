package org.example.poducer_consumer;

public class Consumer extends Thread {
    private final Channel channel;

    public Consumer(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        try {
            while(true) {
                String data = channel.get();

                //Thread.sleep(100);
                System.out.println("#: " + getName() + " consumes " + data);
            }
        } catch(InterruptedException e) {
            //.
        }
    }
}
