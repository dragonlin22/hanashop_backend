package com.dragonlin.hanashopapi.dtos.response;

import lombok.Data;

@Data
public class ResponseWrapperDTO {
    private boolean status;
    private String message;
    private Object data;
}
