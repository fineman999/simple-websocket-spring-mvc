package shop.simple_websocket_spring_mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import shop.simple_websocket_spring_mvc.config.MyBean;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MyController {

    private final MyBean myBean;

    @MessageMapping("/action")
    public void handleAction() {
        throw new MyBusinessException("Action not allowed");
    }

    @MessageExceptionHandler
    @SendToUser(destinations = "/queue/errors", broadcast = false)
    public String handleException(MyBusinessException exception) {
        return exception.getMessage();
    }

    @MessageMapping("/attribute")
    public void handleAttribute(SimpMessageHeaderAccessor headerAccessor) {
        Map<String, Object> attributes = headerAccessor.getSessionAttributes();
        attributes.put("foo", "bar");
        // ...
    }
}
