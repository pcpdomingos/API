package br.org.generation.meuGame.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{//Definindo que o login será criado através do banco de dados
		
		auth.userDetailsService(userDetailsService); //O objeto "auth" cria uma nova instância no userDetailsService que serve para recuperar 
														//os dados do usuário no banco de dados												
	}
	
	@Bean//permite que a instância pode ser injetada em qualquer classe, a qualquer momento sem precisar da annotation @Autowired
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();//Método para criptografar a senha do usuário
	}
	
	@Override//Método de sobrecarga
	protected void configure(HttpSecurity http) throws Exception{//Classe HttpSecurity, permite configurar a segurança baseada na web para solicitações http específicas (endpoints)
		
		http.authorizeRequests()//autoriza requests
		.antMatchers("/usuarios/logar").permitAll()//informa qual acesso será liberado
		.antMatchers("/usuarios/cadastrar").permitAll()
		.anyRequest().authenticated()//informa que as demais requisições não serão liberadas
		.and().httpBasic()//cria um model de login básico
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//faz com a validação do token não supra
		.and().cors()//libera o acesso ao front
		.and().csrf().disable();//faz com que o "programa" fique em aberto para que possamos operar através do postman
	}

}
