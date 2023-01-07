package org.example.Future;


public class Result {
    private RealResult real = null;

    public synchronized void setRealResult(RealResult real) {
        if(this.real != null) {
            return;
        }

        this.real = real;

        notifyAll();
    }

    public synchronized String get() {
        while(real == null) {
            try {
                wait();
            } catch(InterruptedException e) {
                //.
            }
        }

        return real.get();
    }
}
