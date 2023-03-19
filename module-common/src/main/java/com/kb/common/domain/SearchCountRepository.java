package com.kb.common.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchCountRepository extends JpaRepository<SearchCount, Long> {

    SearchCount findByQuery(String query);

}
