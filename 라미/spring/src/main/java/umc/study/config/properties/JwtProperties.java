package umc.study.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("jwt.token")
public class JwtProperties {
    private String secretKey;
    private Expiration expiration = new Expiration();

    @Getter
    @Setter
    public static class Expiration{
        private Long access;
        // TODO: refreshToken
    }
}