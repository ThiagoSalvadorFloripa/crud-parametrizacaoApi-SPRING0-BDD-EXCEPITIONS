package br.salvador.thiago.parametrizacao.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = false, of = { "codigoProdutoOperacional", "codigoMobilidade" })
@Getter @Setter
@Entity
public class ParametroProdutoEsteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParametroRegraEsteira;

    @NotNull
    private Integer codigoProdutoOperacional;

    @NotNull
    private Integer codigoMobilidade;

    @NotNull
    @Length(min = 1, max = 1)
    private String indicadorHabilitado;

    @NotNull
    @Length(min = 1, max = 1)
    private String indicadorValidaRegraNegocio;

    @NotNull
    @Length(min = 1, max = 1)
    private String indicadorLastoLCA;

    @NotNull
    @Length(min = 1, max = 1)
    private String indicadorPlanoPagamentoPersonalizado;

    @NotNull
    private Integer quantidadeMaximaParcela;

    @NotNull
    private Integer quantidadePrazoValidade;

    @NotNull
    private LocalDateTime dataInicioVigencia;

    @NotNull
    private LocalDateTime dataFimVigencia;

    @NotNull
    private Integer codigoUsuarioInclusao;

    @NotNull
    private Integer codigoUsuarioAlteracao;

    @NotNull
    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;
}
