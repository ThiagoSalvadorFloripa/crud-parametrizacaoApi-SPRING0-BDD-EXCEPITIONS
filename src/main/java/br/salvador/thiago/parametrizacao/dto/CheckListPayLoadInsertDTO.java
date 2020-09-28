package br.salvador.thiago.parametrizacao.dto;

import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckListPayLoadInsertDTO {

    private Long id;
    @NotNull
    private String produto;
    @NotNull
    private String nome_documento;
    @NotNull
    private String etapa_jornada_venda;
    @NotNull
    private Boolean obrigatoriedade;
    @NotNull
    private LocalDateTime data_vigencia;

    @NotNull
    private String usuario;
    @NotNull
    private Boolean habilitado;

}
