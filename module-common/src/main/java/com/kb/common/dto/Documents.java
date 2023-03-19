package com.kb.common.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Documents {

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
