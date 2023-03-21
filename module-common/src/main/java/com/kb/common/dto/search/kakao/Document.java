package com.kb.common.dto.search.kakao;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Document {

    private String title;

    private String contents;

    private String url;

    private String blogname;

    private String thumbnail;

    /**
     * [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz]
     */
    private LocalDateTime dateTime;

}
