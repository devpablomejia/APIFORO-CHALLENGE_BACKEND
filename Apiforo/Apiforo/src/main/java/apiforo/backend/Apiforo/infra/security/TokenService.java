package apiforo.backend.Apiforo.infra.security;

import apiforo.backend.Apiforo.domain.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generatorToken(User user){
        try {
            var algorithm = Algorithm.HMAC256("1234567");
            return JWT.create()
                    .withIssuer("api.foro")
                    .withExpiresAt(expiresDate())
                    .withSubject(user.getLogin())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
           throw  new RuntimeException("ERROR AL GENERAR EL TOKEN JTW", exception);
        }
    }

    private Instant expiresDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }

    public String getSubject(String tokenJWT){
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("api.foro")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception){
           throw new RuntimeException("OOPS, HUBO UN ERROR EN EL TOKEN: invalido o expirado", exception);
        }
    }
}
