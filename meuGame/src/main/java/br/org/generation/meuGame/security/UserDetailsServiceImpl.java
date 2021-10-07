package br.org.generation.meuGame.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.generation.meuGame.model.Usuario;
import br.org.generation.meuGame.repository.UsuarioRepository;

@Service//A annotation @Service indica que esta é uma Classe de Serviço, ou seja, implementa regras de negócio da aplicação
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {//obter os dados de um usuário com um determinado nome de usuário. 
		
		Optional<Usuario> usuario = userRepository.findByUsuario(userName);//fara a busca do usuário no Banco de dados, com o método findByUsuario, assinado na interface UsuarioRepository
		
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));//Se o usuário não existir, o método lança uma Exception do tipo UsernameNotFoundException.
		
		return usuario.map(UserDetailsImpl::new).get();//Retorna um objeto do tipo UserDetailsImpl criado com os dados recuperado do banco de dados. O operador ::
														//faz parte de uma expressão que referencia um método, complementando 
														//uma função lambda. Neste exemplo, o operador faz referência ao construtor da Classe UserDetailsImpl. 
		
		
	}
	
	

}
