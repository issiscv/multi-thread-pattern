package org.example.worker_thread;

//producer consumer 와 비슷하다~
public class Main {
    public static void main(String[] args) {
        //공유자원 저장소 저장소
        Channel channel = new Channel(30);

        //consumer
        //쓰레드가 5개 있는 쓰레드 풀 생성
        WorkerPool workerPool = new WorkerPool(5, channel);
        workerPool.start();//모든 쓰레드 시작

        //producer
        //3개의 쓰레드가 병령적으로 channel 에 request 삽입
        //worker 풀의 5개의 쓰레드는 channel 에 접근하여 지속적으로 요청을 처리
        ClientPool clientPool = new ClientPool(50, channel);
        clientPool.start();

//        Client clientThread1 = new Client(channel);
//        clientThread1.start();
//
//        Client clientThread2 = new Client(channel);
//        clientThread2.start();
//
//        Client clientThread3 = new Client(channel);
//        clientThread3.start();
    }
}