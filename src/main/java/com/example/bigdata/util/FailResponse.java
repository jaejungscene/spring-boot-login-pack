package com.example.bigdata.util;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FailResponse implements Response{
    private StatusEnum status;
    private String errorMessage;

    @Builder
    public FailResponse(StatusEnum status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
