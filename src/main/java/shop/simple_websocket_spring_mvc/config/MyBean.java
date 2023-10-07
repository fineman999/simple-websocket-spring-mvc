package shop.simple_websocket_spring_mvc.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyBean {

    @PostConstruct
    public void init() {
        System.out.println("MyBean is created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("MyBean is destroyed");
    }
}
