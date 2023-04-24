package com.jesuitasrioja.chessbase_back.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ChessbaseExceptions extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;

    public ChessbaseExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
