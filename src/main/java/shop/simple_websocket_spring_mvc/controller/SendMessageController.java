package shop.simple_websocket_spring_mvc.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequiredArgsConstructor
@Controller
public class SendMessageController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping(path = "/send", method = POST)
    public void send(String message) {
        String text = "[" + System.currentTimeMillis() + ": " + message + "]";
        simpMessagingTemplate.convertAndSend("/topic/send", text);
    }
}
