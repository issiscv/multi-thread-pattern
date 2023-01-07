package org.example.worker_thread.request;

public class OneRequest extends Request {
    public OneRequest(String threadName, int threadNumber) {
        super(threadName, threadNumber);
    }
    public void execute() {
        String result = "ECHO: " + number + "@" + clentName;
        System.out.println(Thread.currentThread().getName() + " -> " + result);
    }
}
