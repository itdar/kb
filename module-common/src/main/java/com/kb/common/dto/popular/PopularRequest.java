package com.kb.common.dto.popular;

import com.kb.common.domain.popular.PopularSize;
import lombok.Data;

@Data
public class PopularRequest {

    private int size;

    public PopularSize toSize() {
        return PopularSize.of(this.size);
    }

}
