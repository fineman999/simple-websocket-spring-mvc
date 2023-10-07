package shop.simple_websocket_spring_mvc.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public record Trade(String username, String action, String symbol) {

        @Builder
        public Trade {
        }

    public Trade getResult() {
        return this;
    }
}
