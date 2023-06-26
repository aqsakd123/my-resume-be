package com.example.resumepro.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "currenUserAditor")
public class JpaConfig {

    @Bean
    public AuditorAware<String> currenUserAditor(){
        return new CurrentUserAuditor();
    }
}
