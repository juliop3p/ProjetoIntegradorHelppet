package com.helppet.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/usuarios/logar").permitAll()
				.antMatchers("/usuarios/cadastrar").permitAll()
				.antMatchers(HttpMethod.GET, "/produtos").permitAll()
				.antMatchers(HttpMethod.GET, "/produtos/{id}").permitAll()
				.antMatchers(HttpMethod.GET, "/produtos/produto/{produto}").permitAll()
				.antMatchers(HttpMethod.GET, "/categorias").permitAll()
				.antMatchers(HttpMethod.GET, "/categorias/{id}").permitAll()
				.antMatchers(HttpMethod.GET, "/categorias/secaocategoria/{secaocategoria}").permitAll()
				.antMatchers(HttpMethod.GET, "/categorias/subsecaocategoria/{subsecaocategoria}").permitAll()
				.antMatchers(HttpMethod.GET, "/categorias/animalcategoria/{animalcategoria}").permitAll()
				.antMatchers(HttpMethod.POST, "/produtos").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/produtos/{id}").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/produtos/{id}").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/categorias").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/categorias/{id}").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/categorias/{id}").hasRole("ADMIN").anyRequest().authenticated().and()
				.httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.cors().and().csrf().disable();

	}

}
