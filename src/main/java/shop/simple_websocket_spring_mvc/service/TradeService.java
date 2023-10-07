package shop.simple_websocket_spring_mvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import shop.simple_websocket_spring_mvc.domain.Trade;


@RequiredArgsConstructor
@Service
public class TradeService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public void afterTradeExecuted(Trade trade) {
        simpMessagingTemplate.convertAndSendToUser(trade.getUsername(), "/queue/position-updates", trade.getResult());
    }
}
