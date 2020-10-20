package com.helppet.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.helppet.model.UsuarioModel;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1l;

	public String userEmail;
	public String password;
	public boolean isAdmin;

	public UserDetailsImpl() {
	}

	public UserDetailsImpl(UsuarioModel user) {
		this.userEmail = user.getEmailUsuario();
		this.password = user.getSenhaUsuario();
		this.isAdmin = user.isAdmin();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {	
		return this.isAdmin ? AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN") : AuthorityUtils.createAuthorityList("ROLE_USER");
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
