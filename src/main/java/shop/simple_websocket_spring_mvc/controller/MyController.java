package shop.simple_websocket_spring_mvc.controller;

import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    @MessageMapping("/action")
    public void handleAction() {
        throw new MyBusinessException("Action not allowed");
    }

    @MessageExceptionHandler
    @SendToUser(destinations = "/queue/errors", broadcast = false)
    public String handleException(MyBusinessException exception) {
        return exception.getMessage();
    }
}
