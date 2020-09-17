package br.salvador.thiago.parametrizacao.validation;

import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraPayloadDto;
import br.salvador.thiago.parametrizacao.validation.rules.IsNullOrExceptRule;
import br.salvador.thiago.parametrizacao.validation.rules.IsValueInRangeOrExceptRule;

import java.util.ArrayList;
import java.util.List;

public class ParametroProdutoEsteiraPayloadValidation implements ObjectValidation {

    private ParametroProdutoEsteiraPayloadDto objectToValidate;

    public ParametroProdutoEsteiraPayloadValidation(ParametroProdutoEsteiraPayloadDto toValidate) {
        this.objectToValidate = toValidate;
    }

    @Override
    public void execute() {
        this.verifyNullParams();
        this.verifyIndicadoresValueParams();
    }

    private void verifyNullParams() {
        new IsNullOrExceptRule(this.objectToValidate).doLogic("json");
        new IsNullOrExceptRule(this.objectToValidate.getCodigoMobilidade()).doLogic("codigoMobilidade");
        new IsNullOrExceptRule(this.objectToValidate.getCodigoProdutoOperacional()).doLogic("codigoProdutoOperacional");
        new IsNullOrExceptRule(this.objectToValidate.getCodigoUsuarioAlteracao()).doLogic("usuarioAlteracao");
        new IsNullOrExceptRule(this.objectToValidate.getDataFimVigencia()).doLogic("dataFimVigencia");
        new IsNullOrExceptRule(this.objectToValidate.getDataInicioVigencia()).doLogic("dataInicioVigencia");
        new IsNullOrExceptRule(this.objectToValidate.getCodigoUsuarioInclusao()).doLogic("usuarioInclusao");
        new IsNullOrExceptRule(this.objectToValidate.getIndicadorHabilitado()).doLogic("indicadorHabilitado");
        new IsNullOrExceptRule(this.objectToValidate.getIndicadorLastoLCA()).doLogic("indicadorHabilidade");
        new IsNullOrExceptRule(this.objectToValidate.getIndicadorPlanoPagamentoPersonalizado()).doLogic("indicadorPlanoPagamentoPersonalizado");
        new IsNullOrExceptRule(this.objectToValidate.getIndicadorValidaRegraNegocio()).doLogic("indicadorValidaRegraNegocio");
        new IsNullOrExceptRule(this.objectToValidate.getQuantidadeMaximaParcela()).doLogic("quantidadeParcelaMaxima");
        new IsNullOrExceptRule(this.objectToValidate.getQuantidadePrazoValidade()).doLogic("quantidadePrazoValidade");
    }

    private void verifyIndicadoresValueParams() {
        List<Object> rangeValues = new ArrayList<>();
        rangeValues.add('S');
        rangeValues.add('N');

        new IsValueInRangeOrExceptRule(this.objectToValidate.getIndicadorHabilitado(), rangeValues)
                .doLogic("indicadorHabilitado");
        new IsValueInRangeOrExceptRule(this.objectToValidate.getIndicadorLastoLCA(), rangeValues)
                .doLogic("indicadorLastoLCA");
        new IsValueInRangeOrExceptRule(this.objectToValidate.getIndicadorPlanoPagamentoPersonalizado(), rangeValues)
                .doLogic("indicadorPlanoPagamentoPersonalizado");
        new IsValueInRangeOrExceptRule(this.objectToValidate.getIndicadorValidaRegraNegocio(), rangeValues)
                .doLogic("indicadorValidaRegraNegocio");
    }
}
