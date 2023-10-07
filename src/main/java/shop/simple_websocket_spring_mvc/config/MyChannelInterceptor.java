package shop.simple_websocket_spring_mvc.config;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

public class MyChannelInterceptor implements ChannelInterceptor {

        @Override
        public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
            System.out.println("afterSendCompletion");
        }

        @Override
        public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
            System.out.println("postSend");
        }

        @Override
        public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
            System.out.println("afterReceiveCompletion");
        }

        @Override
        public Message<?> preSend(Message<?> message, MessageChannel channel) {

//            StompHeaderAccessor accessor =
//                    MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
//            if (StompCommand.CONNECT.equals(accessor.getCommand())) {
//                Authentication user = ... ; // access authentication header(s)
//                accessor.setUser(user);
//            }
            System.out.println("preSend");
            StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
            System.out.println(accessor.getCommand());
            return message;
        }

        @Override
        public boolean preReceive(MessageChannel channel) {
            System.out.println("preReceive");
            return true;
        }

        @Override
        public Message<?> postReceive(Message<?> message, MessageChannel channel) {
            System.out.println("postReceive");
            return message;
        }
}
