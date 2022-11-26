package sh.surge.fulgure.fulgure_brasil.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sh.surge.fulgure.fulgure_brasil.model.Usuario;
import sh.surge.fulgure.fulgure_brasil.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Encontra um usuário no banco de dados
        Usuario usuario = usuarioRepository.findByNome(username).stream().findFirst().get();
        // Depois retorna um objeto UserDetailsImpl com base no usuário encontrado
        return new UserDetailsImpl(usuario);        
    } 
}
