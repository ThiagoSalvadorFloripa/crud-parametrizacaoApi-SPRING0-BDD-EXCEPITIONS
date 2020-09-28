package br.salvador.thiago.parametrizacao.dto;

import br.salvador.thiago.parametrizacao.model.CheckList;
import com.sun.istack.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckListPayLoadDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private LocalDateTime data_criacao;
    @NotNull
    private String usuario;
    @NotNull
    private Boolean habilitado;

    public CheckListPayLoadDTO(CheckList obj) {
        id = obj.getId();
        produto = obj.getProduto();
        nome_documento = obj.getNome_documento();
        etapa_jornada_venda = obj.getEtapa_jornada_venda();
        obrigatoriedade = obj.getObrigatoriedade();
        data_vigencia = obj.getData_vigencia();
        data_criacao = obj.getData_criacao();
        usuario = obj.getUsuario();
        habilitado = obj.getHabilitado();

    }

}
