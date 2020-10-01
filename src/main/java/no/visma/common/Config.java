package no.visma.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
