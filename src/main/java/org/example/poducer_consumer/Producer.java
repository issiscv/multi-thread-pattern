package org.example.poducer_consumer;

public class Producer extends Thread {
    private final Channel channel;
    private int number = 0;

    public Producer(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        try {
            while(true) {
                //Thread.sleep(200);

                String data = "[DATA-" + number + "@" + getName() + "]";
                channel.put(data);
                number++;
            }
        } catch(InterruptedException e) {
            //.
        }
    }
}
