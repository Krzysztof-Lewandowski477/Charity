package pl.coderslab.charity.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public SecurityConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return PasswordEncoderFactories.createDelegatingPasswordEncoder ();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication ()
                .dataSource ( dataSource )
                .passwordEncoder ( passwordEncoder () )
                .usersByUsernameQuery ( "SELECT username, password, active FROM users WHERE username = ?" )
                .authoritiesByUsernameQuery ( "SELECT u.username, r.name FROM users u JOIN users_roles ur ON u.id = ur.user_id JOIN roles r ON ur.roles_id = r.id WHERE u.username = ?" );
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring ().antMatchers ( "/public_html/**" ,"/image/**").antMatchers ( "/webjars/**" )
                .antMatchers ( "/h2-console","/h2-console/**" );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests ()
                .antMatchers ( "/image/**","/**"  ).permitAll ()
                .antMatchers ( "/register" ).permitAll ()
                .antMatchers ( "/login" ).permitAll ()
                .antMatchers ( "/logout","/contacts").authenticated ()
                .antMatchers ( "/user","/user/**" ).hasRole ( "USER" )
                .antMatchers ( "/admin", "/admin/**" ).hasRole ( "ADMIN" )
                .anyRequest ().authenticated ()
                .and ()
                .formLogin ()
                .loginPage ( "/login")
                .usernameParameter ( "username" )
                .passwordParameter ( "password" )
                .defaultSuccessUrl ( "/index" )
                .and ()
                .logout ()
                .logoutUrl ( "/logout" )
                .logoutSuccessUrl ( "/login" )
                .and ()
                .csrf ();
        log.debug ( "logowanie{}", http );
    }

}