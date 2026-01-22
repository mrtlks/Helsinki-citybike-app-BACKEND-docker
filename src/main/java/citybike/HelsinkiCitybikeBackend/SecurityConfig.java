package citybike.HelsinkiCitybikeBackend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll() // frontend avoin
                .anyRequest().authenticated()           // kaikki muu vaatii kirjautumisen
            )
            .httpBasic(); // Basic Auth

        return http.build();
    }
}
