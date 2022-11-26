package sh.surge.fulgure.fulgure_brasil.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import sh.surge.fulgure.fulgure_brasil.security.services.UserDetailsServiceImpl;

// Será executado uma vez a cada requisição ao servidor
// É automaticamente inserido como um filtro de uma requisição HTTP ao servidor
@Component
public class AuthenticationJwtFilter extends OncePerRequestFilter{
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Se existir Token JWT, faz a autenticação do usuário
        String token = parseJwt(request);
        // Se o Token JWT for válido ...
        if(token != null && jwtUtils.validateJwtToken(token)){
            // ... Recupera o nome de usuário do Token JWT ...
            String username = jwtUtils.getUserNameFromJwtToken(token);
            // ... e carrega ele do banco usuando o UserDetailsServiceImpl ...
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // ... agora cria-se o objeto de autenticação compatível com o Spring security ...
            UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            
            // ... e por insere dentro do mesmo para seguir nos próximos passos (filtros) ...
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }   

        // Executa os próximos filtros, caso não haja nenhuma execeção no código acima
        filterChain.doFilter(request, response);
    }

    // Verifica se na requisição foi enviada o Token da requisição
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
    
        if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
          // Retorna só o Token contido no Header
          return headerAuth.substring(7, headerAuth.length());
        }
    
        return null;
    }
}
