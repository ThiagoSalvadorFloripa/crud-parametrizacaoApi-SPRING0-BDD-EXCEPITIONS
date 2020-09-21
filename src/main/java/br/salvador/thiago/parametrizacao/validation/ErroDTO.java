package br.salvador.thiago.parametrizacao.validation;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErroDTO {

    private String campo;
    private String erro;
}
