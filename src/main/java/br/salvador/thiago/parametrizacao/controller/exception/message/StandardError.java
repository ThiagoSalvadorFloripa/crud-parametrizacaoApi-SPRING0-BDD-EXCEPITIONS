package br.salvador.thiago.parametrizacao.controller.exception.message;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class StandardError {

    private HttpStatus httpStatus;
    private String message;
    private String exception;
    private LocalDateTime dateTime;

    public StandardError(long currentTimeMillis, int value, String não_encontrado, String message, String requestURI) {
    }
}
