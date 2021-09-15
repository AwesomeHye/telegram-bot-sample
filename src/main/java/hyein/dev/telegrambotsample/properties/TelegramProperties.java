package hyein.dev.telegrambotsample.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "telegram")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class TelegramProperties {
    private String sendMessageUrl;
    private String chatId;
}
