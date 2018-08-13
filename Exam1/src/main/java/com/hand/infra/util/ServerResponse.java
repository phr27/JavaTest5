package com.hand.infra.util;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ServerResponse<T> {

    private static final ServerResponse<Object> OK = new ServerResponse<>(0, null, null);

    private int status;

    private String msg;

    private T data;

    public static ServerResponse<Object> getOK() {
        return OK;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static ServerResponse<Object> createOK() {
        return OK;
    }

    public static ServerResponse<Object> createError(int status, String msg) {
        return new ServerResponse<>(status, msg, null);
    }

    public static <T> ServerResponse<T> createOK(T data) {
        return new ServerResponse<>(0, null, data);
    }

    public static <T> ServerResponse<T> createOK(String msg, T data) {
        return new ServerResponse<>(0, msg, data);
    }

}
