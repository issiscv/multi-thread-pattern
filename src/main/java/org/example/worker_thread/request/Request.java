package org.example.worker_thread.request;


public abstract class Request {
    protected final String clentName;
    protected final int number;

    public Request(String clentName, int number) {
        this.clentName = clentName;
        this.number = number;
    }

    public abstract void execute();
}