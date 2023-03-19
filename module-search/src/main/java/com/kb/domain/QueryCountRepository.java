package com.kb.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryCountRepository extends JpaRepository<QueryCount, Long> {

    QueryCount findByQuery(String query);

}
