package org.example.Future;

public class Main {
    public static void main(String[] args) {
        System.out.println("START");

        Proxy proxy = new Proxy();
        
        //3개의 연산을 병렬적으로 실행
        Result result1 = proxy.run(10, 'A');
        Result result2 = proxy.run(30, 'B');
        Result result3 = proxy.run(20, 'C');

        //나중에 비동기적으로 결과값을 받는다/
        System.out.println("result1 = " + result1.get());
        System.out.println("result2 = " + result2.get());
        System.out.println("result3 = " + result3.get());

        System.out.println("END");
    }
}