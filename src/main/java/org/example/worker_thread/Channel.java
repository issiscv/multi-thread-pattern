package org.example.worker_thread;

import org.example.worker_thread.request.Request;

import java.util.LinkedList;
public class Channel {
    private final int maxCountRequests;
    private final LinkedList<Request> requestQueue = new LinkedList<Request>();

    public Channel(int maxCountRequests) {
        this.maxCountRequests = maxCountRequests;
    }

    public synchronized void putRequest(Request request) {
        while(requestQueue.size() >= maxCountRequests) {
            try {
                wait();
            } catch(InterruptedException e) {
                //.
            }
        }

        requestQueue.addLast(request);
        notifyAll();
    }

    public synchronized Request takeRequest() {
        while(requestQueue.size() <= 0) {
            try {
                wait();
            } catch(InterruptedException e) {
                //.
            }
        }

        Request request = requestQueue.pollFirst();
        notifyAll();
        return request;
    }
}
