package shop.simple_websocket_spring_mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import shop.simple_websocket_spring_mvc.domain.Trade;

import java.security.Principal;

@Slf4j
@Controller
public class PortfolioController {

    @MessageMapping("/trade")
    @SendToUser("/queue/position-updates")
    public String trade(Trade trade, Principal principal) {
        log.info("trade: {}", trade.username());
        log.info("principal: {}", principal.getName());

        return "[" + System.currentTimeMillis() + ": " + trade.username() + "]";
    }
}
