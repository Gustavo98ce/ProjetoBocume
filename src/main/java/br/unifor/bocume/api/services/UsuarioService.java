package br.unifor.bocume.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.unifor.bocume.api.models.Role;
import br.unifor.bocume.api.models.Usuario;
import br.unifor.bocume.api.repositories.UsuarioRepository;


@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
	
    public Optional<Usuario> buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public void salvarUsuario(Usuario usuario) {
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
    }
    
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findUsuarioByEmail(email);
        if(usuario != null) {
            List<GrantedAuthority> authorities = getUserAuthority(usuario.getRole());
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("Login not found");
        }
	}
	
	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }
	
	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

}
