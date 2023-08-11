package com.second.Oauthserver.dto.response;

import com.second.Oauthserver.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductResponse {
    private String name;

    private Integer price;

    private StatusEnum status;

    private LocalDateTime createdDateTime;

    private LocalDateTime updatedDateTime;
}
