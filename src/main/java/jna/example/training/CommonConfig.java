package jna.example.training;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.SessionTrackingMode;
import java.util.Collections;

@Configuration
public class CommonConfig {

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        // 初回アクセス時に、URLにSessionIDが付与されるのを防ぐ
        ServletContextInitializer initializer = servletContext -> {
            servletContext.setSessionTrackingModes(
                    Collections.singleton(SessionTrackingMode.COOKIE)
            );
        };
        return initializer;
    }

}