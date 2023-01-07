package org.example.read_write;

public class Lock {

    private int readingReaders = 0;
    private int waitingReaders = 0;
    private boolean preferReader = false;

    private int waitingWriters = 0;
    private int writingWriters = 0;
    private boolean preferWriter = true;

    public synchronized void readLock() throws InterruptedException {
        waitingReaders++;//읽기를 기다림 증가
        try {
            //쓰고있는 writer 가 하나 이상이거나, 기다리고 있는 writer 가 하나 이상이며 쓰고자 할 경우 read 락 걸림 
            while(writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
                wait();
            }
        } finally {
            waitingReaders--;//읽기를 기다림 감소
        }

        readingReaders++;//현재 읽고 있음 증가
    }
    
    //unlock 을 하면 현재 읽고 있음 감소
    //읽고자 함으로 변경
    public synchronized void readUnlock() {
        readingReaders--;
        preferWriter = true;
        preferReader = false;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;
        try {
            while(readingReaders > 0 || writingWriters > 0 || (preferReader && waitingReaders > 0)) {
                wait();
            }

        } finally {
            waitingWriters--;
        }

        writingWriters++;
    }

    public synchronized void writeUnlock() {
        writingWriters--;
        preferWriter = false;
        preferReader = true;
        notifyAll();
    }

}
