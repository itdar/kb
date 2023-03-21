package com.kb.common.dto.search;

import com.kb.common.dto.search.kakao.Document;
import com.kb.common.dto.search.naver.Item;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Data;

@Data
public class Content {

    private final String title;
    private final String description;
    private final String url;
    private final String blogName;
    private final LocalDateTime dateTime;

    public static Content of(Document document) {
        return new Content(
            document.getTitle(),
            document.getContents(),
            document.getUrl(),
            document.getBlogname(),
            document.getDateTime()
        );
    }

    public static Content of(Item item) {
        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse(item.getPostdate(), DATEFORMATTER);
        return new Content(
            item.getTitle(),
            item.getDescription(),
            item.getLink(),
            item.getBloggername(),
            LocalDateTime.of(localDate, LocalDateTime.now().toLocalTime())
        );
    }
}
