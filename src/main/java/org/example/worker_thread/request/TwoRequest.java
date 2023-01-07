package org.example.worker_thread.request;


public class TwoRequest extends Request {
    public TwoRequest(String name, int number) {
        super(name, number);
    }
    public void execute() {
        String result = "POWER: " + (number*number) + "@" + clentName;
        System.out.println(Thread.currentThread().getName() + " -> " + result);
    }
}
