package org.example.Future;

//Proxy 클래스는 어떤 결과를 얻기 위한 코드의 실행을 스레드로 실행해 주는 대리자이다.
public class Proxy {

    //Proxy는 어떤 코드의 실행을 스레드로 실행해주고 바로 Result 클래스 타입의 객체를 반환한다.
    public Result run(final int count, final char c) {
        //wrapping
        final Result result = new Result();

        new Thread(() -> {
            RealResult realData = new RealResult(count, c);
            result.setRealResult(realData);
        }).start();

        return result;
    }
}
