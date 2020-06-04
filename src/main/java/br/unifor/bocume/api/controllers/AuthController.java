package br.unifor.bocume.api.controllers;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.unifor.bocume.api.configs.JwtTokenProvider;
import br.unifor.bocume.api.repositories.UsuarioRepository;
import br.unifor.bocume.api.services.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/controllers")
public class AuthController {

	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    private UsuarioService usuarioService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthBody dado) {
        try {
            String login = dado.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, dado.getSenha()));
            String token = jwtTokenProvider.gerarToken(login);
            Map<Object, Object> model = new HashMap<>();
            model.put("login", login);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("E-mail ou senha invalidos");
        }
    }
   
	
}
