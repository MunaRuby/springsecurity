package com.example.classtask;

import com.example.classtask.filters.JWTDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Slf4j
@Configuration
@PropertySources({@PropertySource(value = "classpath:jwt.properties")})
public class AppConfig {
    @Value("${jwt.secret}")
    private String SECRET_KEY;
    @Value("${jwt.tokenPrefix}")
    private String tokenPrefix;
    @Value("${jwt.expirationDate}")
    private Long expirationDate;


    @Bean
    public JWTDataSource getJwtDataSource() {
        JWTDataSource jwtDataSource = new JWTDataSource();
        jwtDataSource.setSecretKey(SECRET_KEY);
        jwtDataSource.setTokenPrefix(tokenPrefix);
        jwtDataSource.setExpirationDate(expirationDate);

        return jwtDataSource;
    }
}
