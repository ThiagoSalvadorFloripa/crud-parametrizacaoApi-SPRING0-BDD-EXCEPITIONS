package br.salvador.thiago.parametrizacao.controller.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Field {

    private String fieldName;
    private String message;
}
