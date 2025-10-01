package com.example.bt9.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    // Spring sẽ tự động inject CustomUserDetailsService vì nó được đánh dấu @Service
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(null); // Giả sử bạn sẽ inject repository vào đây
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/new").hasAnyAuthority("USER", "ADMIN", "EDITOR", "CREATOR")
                        .requestMatchers("/edit/**").hasAnyAuthority("ADMIN", "CREATOR")
                        .requestMatchers("/delete/**").hasAnyAuthority("ADMIN", "EDITOR")
                        .requestMatchers("/delete/").hasAuthority("ADMIN")
                       
                        .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
                  
                        .requestMatchers("/api/**").permitAll()
 
                        .anyRequest().authenticated()
                )
                

                .httpBasic(withDefaults())
                .formLogin(form -> form
                        .loginPage("/login") 
                        .permitAll() 
                )
                
                .logout(logout -> logout.permitAll())

                .exceptionHandling(ex -> ex.accessDeniedPage("/403"))
                
                .build();
    }

   
	/*
	 * @Bean public AuthenticationProvider authenticationProvider(UserDetailsService
	 * userDetailsService, PasswordEncoder passwordEncoder) { // Sửa ở dòng này:
	 * Truyền passwordEncoder vào constructor DaoAuthenticationProvider provider =
	 * new DaoAuthenticationProvider(passwordEncoder);
	 * 
	 * // Sau đó chỉ cần set userDetailsService là đủ
	 * provider.setUserDetailsService(userDetailsService);
	 * 
	 * return provider; }
	 * 
	 * // Quản lý toàn bộ quá trình xác thực
	 * 
	 * @Bean public AuthenticationManager
	 * authenticationManager(AuthenticationConfiguration config) throws Exception {
	 * return config.getAuthenticationManager(); }
	 */
    
    
}