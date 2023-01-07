package org.example.worker_thread;


public class WorkerPool {
    private final Worker[] threadPool;

    public WorkerPool(int countThreads, Channel channel) {
        threadPool = new Worker[countThreads];
        for(int i=0; i<threadPool.length; i++) {
            threadPool[i] = new Worker("Worker-" + i, channel);
        }
    }

    public void start() {
        for(int i=0; i<threadPool.length; i++) {
            threadPool[i].start();
        }
    }
}
