package hyein.dev.telegrambotsample.telegram;


import hyein.dev.telegrambotsample.util.OkHttpClientUtils;
import lombok.*;
import okhttp3.Response;

import java.net.URI;

public class TelegramMessenger {

    /**
     * 텔레그램 메시지 전송
     *
     * @param sendUri
     * @param telegramMessage  {"chat_id" : "00000000", "text" : "This is message" }
     * @return
     */
    public static Response sendMessage(String sendUri, String telegramMessage) {
        return OkHttpClientUtils.postRequest(sendUri, telegramMessage);
    }
}
