package ro.tuc.ds2020.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;
import ro.tuc.ds2020.security.jwt.JwtAccessDeniedHandler;
import ro.tuc.ds2020.security.jwt.JwtAuthEntryPoint;
import ro.tuc.ds2020.security.jwt.JwtFilter;
import ro.tuc.ds2020.services.UserAuthenticationService;


@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true
     , securedEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserAuthenticationService userAuthenticationService;

    @Autowired
    private JwtAuthEntryPoint authEntryPoint;

    @Autowired
    private JwtAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private CorsFilter corsFilter;

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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //disable csrf because our token is invulnerable

                //add cors filter
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)

                .exceptionHandling()        //exception handlers
                .authenticationEntryPoint(authEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)

                .and()          //create no session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()

                .antMatchers("/auth").permitAll()

                .antMatchers("/user_authentication").access("hasAuthority('ROLE_doctor')")

                .antMatchers("/caregiver").access("hasAuthority('ROLE_doctor') " +
                                                                    "or hasAuthority('ROLE_caregiver')")

                .antMatchers("/doctor").access("hasAuthority('ROLE_doctor')")

                .antMatchers("/medical_record").access("hasAuthority('ROLE_doctor')"+
                                                                    "or hasAuthority('ROLE_patient')")

                .antMatchers("/medication").access("hasAuthority('ROLE_doctor')")

                .antMatchers("/medication_plan").access("hasAuthority('ROLE_doctor')"+
                                                                     "or hasAuthority('ROLE_patient')")

                .antMatchers("/patient").access("hasAuthority('ROLE_doctor') "+
                                                                    "or hasAuthority('ROLE_patient')")

                .antMatchers("/side_effect").access("hasAuthority('ROLE_doctor')")

                .antMatchers("/user_role").access("hasAuthority('ROLE_doctor')")

                .antMatchers("/address").access("hasAuthority('ROLE_doctor') " +
                                                                    "or hasAuthority('ROLE_caregiver')" +
                                                                    "or hasAuthority('ROLE_patient')")

                .antMatchers("/medplanrpc").permitAll()

                .antMatchers("/socket").permitAll()
//                .antMatchers("/**").denyAll()   //block all other requests
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
        ;

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }


}
