package shop.simple_websocket_spring_mvc.controller;

public class MyBusinessException extends RuntimeException {
    public MyBusinessException(String message) {
        super(message);
    }
}
