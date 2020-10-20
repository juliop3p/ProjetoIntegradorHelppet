package com.helppet.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.helppet.model.UsuarioModel;
import com.helppet.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

		Optional<UsuarioModel> user = userRepository.findByEmailUsuario(userEmail);
		user.orElseThrow(() -> new UsernameNotFoundException(userEmail + "não encontrado"));
		
		return user.map(UserDetailsImpl::new).get();

	}

}
