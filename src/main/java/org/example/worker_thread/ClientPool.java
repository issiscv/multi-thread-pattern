package org.example.worker_thread;

public class ClientPool {

    private Client[] clients;

    public ClientPool(int countThreads, Channel channel) {
        clients = new Client[countThreads];
        for (int i = 0; i < countThreads; i++) {
            clients[i] = new Client("client" + (char)('A' + i % 26), channel);
        }
    }

    public void start() {
        for (int i = 0; i < clients.length; i++) {
            clients[i].start();
        }
    }

}
