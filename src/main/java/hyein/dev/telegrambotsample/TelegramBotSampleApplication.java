package hyein.dev.telegrambotsample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hyein.dev.telegrambotsample.dto.KsearchLogAnalysisDto;
import hyein.dev.telegrambotsample.properties.TelegramProperties;
import hyein.dev.telegrambotsample.telegram.TelegramMessage;
import hyein.dev.telegrambotsample.telegram.TelegramMessenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class TelegramBotSampleApplication implements CommandLineRunner {
    @Autowired
    private TelegramProperties telegramProperties;
    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotSampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sendUrl = telegramProperties.getSendMessageUrl();
        TelegramMessage telegramMessage = TelegramMessage.builder().chatId(telegramProperties.getChatId()).text(generateMessage()).build();

        TelegramMessenger.sendMessage(sendUrl, objectMapper.writeValueAsString(telegramMessage));
    }

    private String generateMessage() throws JsonProcessingException {
        KsearchLogAnalysisDto ksearchLogAnalysisDto = KsearchLogAnalysisDto.builder().msg("한번발생").build();
        String text = "안녕하세요~\n인터넷망에서 보내는 메시지 입니다.\n" + objectMapper.writeValueAsString(ksearchLogAnalysisDto);
        return text;
    }
}
