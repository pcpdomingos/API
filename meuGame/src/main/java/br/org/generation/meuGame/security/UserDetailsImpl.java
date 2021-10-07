package br.org.generation.meuGame.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.org.generation.meuGame.model.Usuario;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl(Usuario usuario) {
		this.userName = usuario.getUsuario();
		this.password = usuario.getSenha();
	}
	
	public UserDetailsImpl () {	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {//não há nenhuma autorização negada
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {//Indica se a conta do usuário expirou.
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {//Indica se o usuário está bloqueado ou desbloqueado.
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {//indica se as credenciais do usuário (senha) expiraram.
		
		return true;
	}

	@Override
	public boolean isEnabled() {//Indica se o usuário está habilitado ou desabilitado. Se mudar para false nenhum usuário poderá logar.

		return true;
	}
	

}
