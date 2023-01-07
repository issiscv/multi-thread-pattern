package org.example.read_write;

public class Main {
    public static void main(String[] args) {
        //공유 자원
        Data data = new Data();

        Reader readerThread1 = new Reader(data);
        readerThread1.start();

        Reader readerThread2 = new Reader(data);
        readerThread2.start();

        Reader readerThread3 = new Reader(data);
        readerThread3.start();

        String[] weeks = {"월", "화", "수", "목", "금", "토", "일"};
        String[] numbers = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
        String[] digits = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        Writer writerThread1 = new Writer(data, weeks);
        writerThread1.start();

        Writer writerThread2 = new Writer(data, numbers);
        writerThread2.start();

        Writer writerThread3 = new Writer(data, digits);
        writerThread3.start();
    }

}