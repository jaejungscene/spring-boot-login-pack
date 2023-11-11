package com.example.bigdata.util;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SuccessResponse implements Response {

    private StatusEnum status;
    private String message;
    private Object data;

    @Builder
    public SuccessResponse(StatusEnum status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
