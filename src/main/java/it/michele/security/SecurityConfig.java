package it.michele.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private javax.sql.DataSource dataSource;
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("SecurityConfig.configure");
		
		org.springframework.security.crypto.password.PasswordEncoder passwordEncoder = passwordEncoder();
		
		//System.out.println("Password	--->	"+passwordEncoder.encode("12345"));
		//auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("{noop}12345")).roles("ADMIN");
		//auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("{noop}12345")).roles("USER");
		auth.getDefaultUserDetailsService();
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("SELECT username as pricipal, password as credentials, active FROM users WHERE username = ?")
			.authoritiesByUsernameQuery("SELECT username as principal, role as role FROM users_roles WHERE username = ?")
			.passwordEncoder(passwordEncoder).rolePrefix("ROLE");
		
		
		
		/*auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN", "USER");
		auth.inMemoryAuthentication().withUser("user").password("1234").roles("USER");
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username as principal, password as credentials, active from utenti where username=?")
		.authoritiesByUsernameQuery("select username as principal, role as role from user_role where username=?")
		.rolePrefix("ROLE_");*/
		//.passwordEncoder(new Md4PasswordEncoder());
	}
	
	
	
	/*@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		return super.userDetailsService();
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//http.httpBasic();
		http.headers().frameOptions().sameOrigin().httpStrictTransportSecurity().disable();
		
		/*http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/index").authenticated();*/
		
		
		
		http.authorizeRequests().antMatchers("**/insert", "**/openUpdate/**", "**/update", "**/delete/**").hasRole("USER");
		http.authorizeRequests().antMatchers("**/insert", "**/openUpdate/**", "**/update", "**/delete/**").hasRole("ADMIN");
		
		http.authorizeRequests().antMatchers("/", "/index", "/login", "**/list*", "/css/**", "/js/**", "/img/**",
			"/biografia/list", "/poesia/list", "/racconti/list", "/pubblicazioni/list", "/contattoPage",
			"/messaggio", "/pubblicazioni/dettaglio/**")
		.permitAll().anyRequest().permitAll();
		http.authorizeRequests().antMatchers().permitAll().anyRequest().authenticated();
			
		
		http.authorizeRequests()
		.antMatchers("index").access("hasRole('ROLE_ADMIN')")		
		.anyRequest().permitAll()
		.and()
		  .formLogin().loginPage("/index")
		  .usernameParameter("username").passwordParameter("password")
		.and()
		  .logout().logoutSuccessUrl("/index?logout")	
		 .and()
		 .exceptionHandling().accessDeniedPage("/403")
		.and()
		  .csrf().disable();
		
		http.authorizeRequests().anyRequest().authenticated();	
		
/*		http.formLogin().loginPage("/login");
		http.csrf().disable();
		http.exceptionHandling().accessDeniedPage("/403");
*/		
	}
//		http.formLogin().loginPage("/login");

	
	public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("http://localhost:8080/MicheleProject/",
	    		"**/biografia/list", "**/poesia/list", "**/racconti/list", "**/pubblicazioni", "**/contattoPage",
	    		"/components/**", "/application/**", "**/list", "/css/**", "/js/**", "/img/**", "/icon/**");
	}
	

}