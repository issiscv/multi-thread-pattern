package org.example.Future;

public class RealResult {
    private final String resultData;

    public RealResult(int count, char c) {
        char[] buffer = new char[count];
        for(int i=0; i<count; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                //.
            }
        }
        this.resultData = new String(buffer);
    }

    public String get() {
        return resultData;
    }
}
