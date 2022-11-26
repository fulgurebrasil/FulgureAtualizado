package sh.surge.fulgure.fulgure_brasil.security.jwt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {
    @Value("${ifsp.app.jwtSecret}")
    private String jwtSecret;

    @Value("${ifsp.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    private final String TOKEN_PREFIX = "Bearer";
    private final String HEADER_STRING = "Authorization";

    // Métod que gera um Token JWT e insere na resposta
    public void generateJwtString(HttpServletResponse response, String username) throws IOException {
        // Gera o Token JWT
        String JWT = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

        // Adiciona o Token no Header da Resposta ...
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        // .. e também no Body como JSON.
        response.getWriter().write(
                "{\"data\": { \"token\":\"" + JWT + "\"}}");
    }

    // Retorna o nome de usuário criptografado dentro do Token JWT.
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    // Verifica se um Token JWT enviado por um client é válido
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            System.err.printf("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            System.err.printf("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            System.err.printf("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.err.printf("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.printf("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
