package br.salvador.thiago.parametrizacao.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_checkList")
public class CheckList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private LocalDateTime data_criacao;
    @NotNull
    private String usuario;
    @NotNull
    private Boolean habilitado;

    public CheckList(Long id, String produto, String nome_documento, Boolean obrigatoriedade,
                     LocalDateTime data_vigencia, LocalDateTime data_criacao, String usuario, Boolean habilitado) {
    }
}
