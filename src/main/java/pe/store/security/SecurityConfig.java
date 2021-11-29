package pe.store.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/area/listar").permitAll()
                .antMatchers(HttpMethod.POST,"/area/**").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.PUT,"/area/**").hasAnyAuthority("Admin","EDITOR")
                .antMatchers(HttpMethod.DELETE,"/area/**").hasAnyAuthority("Admin")

                .antMatchers("/cliente/listar").permitAll()
                .antMatchers(HttpMethod.POST,"/cliente/**").hasAnyAuthority("Admin","USERVENTA")
                .antMatchers(HttpMethod.PUT,"/cliente/**").hasAnyAuthority("Admin","USERVENTA")
                .antMatchers(HttpMethod.DELETE,"/cliente/**").hasAnyAuthority("Admin")

                .antMatchers("/marca/listar").hasAnyAuthority("Admin","USERALMACEN")
                .antMatchers(HttpMethod.POST,"/marca/**").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.PUT,"/marca/**").hasAnyAuthority("Admin","USERALMACEN")
                .antMatchers(HttpMethod.DELETE,"/marca/**").hasAnyAuthority("Admin")

                .antMatchers("/categoria/listar").hasAnyAuthority("Admin","USERALMACEN")
                .antMatchers(HttpMethod.POST,"/categoria/**").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.PUT,"/categoria/**").hasAnyAuthority("Admin","USERALMACEN")
                .antMatchers(HttpMethod.DELETE,"/categoria/**").hasAnyAuthority("Admin")

                .antMatchers("/producto/listar").permitAll()
                .antMatchers(HttpMethod.POST,"/producto/**").hasAnyAuthority("Admin","USERALMACEN")
                .antMatchers(HttpMethod.PUT,"/producto/**").hasAnyAuthority("Admin","USERALMACEN")
                .antMatchers(HttpMethod.DELETE,"/producto/**").hasAnyAuthority("Admin")

                .antMatchers("/empleado/listar").hasAuthority("Admin")
                .antMatchers(HttpMethod.POST,"/empleado/**").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.PUT,"/empleado/**").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.DELETE,"/empleado/**").hasAnyAuthority("Admin");

        http.authorizeRequests().and().httpBasic();
        http.authorizeRequests().and().csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
