package br.salvador.thiago.parametrizacao.controller.exception.message;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class Field {

    private String fieldName;
    private String message;
}
