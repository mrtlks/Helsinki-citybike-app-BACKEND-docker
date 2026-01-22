@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()

                // Frontendin API-pyynnöt avoimia
                .antMatchers("/api/**").permitAll()

                // Kaikki muu vaatii salasanan
                .anyRequest().authenticated()
            .and()
            .httpBasic(); // Basic Auth salasanalle
    }
}
