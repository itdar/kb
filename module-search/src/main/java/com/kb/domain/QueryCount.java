package com.kb.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class QueryCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String query;

    @Column
    private Integer count;

    @Column
    @CreatedDate
    private LocalDateTime createdTime;

    @Column
    @LastModifiedDate
    private LocalDateTime modifiedTime;

    public QueryCount(String query, Integer count) {
        this.query = query;
        this.count = count;
    }

    public static QueryCount of(String query, int count) {
        return new QueryCount(query, count);
    }

}
