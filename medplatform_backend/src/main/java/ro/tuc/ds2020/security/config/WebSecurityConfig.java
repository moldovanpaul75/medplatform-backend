package ro.tuc.ds2020.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ro.tuc.ds2020.security.jwt.JwtAccessDeniedHandler;
import ro.tuc.ds2020.security.jwt.JwtAuthEntryPoint;
import ro.tuc.ds2020.security.jwt.JwtFilter;
import ro.tuc.ds2020.services.UserAuthenticationService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true
    //, securedEnabled = true)
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserAuthenticationService userAuthenticationService;

    @Autowired
    private JwtAuthEntryPoint authEntryPoint;

    @Autowired
    private JwtAccessDeniedHandler accessDeniedHandler;

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userAuthenticationService).passwordEncoder(passwordEncoder());
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtFilter authenticationJwtTokenFilter() {
        return new JwtFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    //config paths and requests that Spring Security will ignore
    @Override
    public void configure(WebSecurity web){
        web.ignoring()
                .antMatchers(
                        "/",
                        "/address"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable() //disable cors and csrf

                .exceptionHandling()        //exception handlers
                .authenticationEntryPoint(authEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)

                .and()          //create no session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()          //everyone can go to login
                .authorizeRequests()
                .antMatchers("/auth")
                .permitAll()

                .antMatchers("/user_role/**").hasAuthority("ROLE_doctor")
                .anyRequest().authenticated()
        ;

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }


}
