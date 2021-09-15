package hyein.dev.telegrambotsample.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KsearchLogAnalysisDto {
    private Integer msgId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // 안하면 long 이다
    private Date analyzeDate; // String 이면 text, Date 면 date type
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date analyzeStartTime;
    private AtomicInteger occurCnt;
    private String msg;
    private List<String> references;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @JsonProperty("@timestamp")
    private Date timestamp;
}
