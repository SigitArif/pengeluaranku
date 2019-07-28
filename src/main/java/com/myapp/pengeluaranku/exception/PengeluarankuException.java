package com.myapp.pengeluaranku.exception;

import com.myapp.pengeluaranku.enums.StatusCode;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class PengeluarankuException extends RuntimeException {

    private StatusCode code = null;
    private HttpStatus status = null;

    public PengeluarankuException() {
        super();
    }

    public PengeluarankuException(String message) {
        super(message);
    }

    public PengeluarankuException(String message, StatusCode code) {
        super(message);
        this.code = code;
    }

    public PengeluarankuException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public PengeluarankuException(String message, HttpStatus status, StatusCode code) {
        super(message);
        this.status = status;
        this.code = code;
    }
}
