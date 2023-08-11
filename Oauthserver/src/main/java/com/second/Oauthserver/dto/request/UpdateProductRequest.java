package com.second.Oauthserver.dto.request;

import com.second.Oauthserver.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequest {


    private String name;
    private Integer price;

    private StatusEnum status;

}
