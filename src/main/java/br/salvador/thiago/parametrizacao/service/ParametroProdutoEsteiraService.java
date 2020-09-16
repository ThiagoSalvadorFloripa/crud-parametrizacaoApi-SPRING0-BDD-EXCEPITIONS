package br.salvador.thiago.parametrizacao.service;

import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraPostDto;
import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraResponseDto;
import br.salvador.thiago.parametrizacao.model.ParametroProdutoEsteira;
import br.salvador.thiago.parametrizacao.repository.ParametroProdutoEsteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ParametroProdutoEsteiraService {

    @Autowired
    private ParametroProdutoEsteiraRepository parametroProdutoEsteiraRepository;

    public ParametroProdutoEsteiraResponseDto save(ParametroProdutoEsteiraPostDto objectDto) {
        validateIndicadoresByRegex(objectDto, "S|N");

        ParametroProdutoEsteira objectToSave = this.fromDto(objectDto);
        objectToSave.setIdParametroRegraEsteira(null);
        objectToSave.setDataCriacao(LocalDateTime.now());

        return new ParametroProdutoEsteiraResponseDto(
                this.parametroProdutoEsteiraRepository.save(objectToSave)
        );
    }

    private void validateIndicadoresByRegex(ParametroProdutoEsteiraPostDto objectDto, String regex) {
        if(regex == null)
            throw new NullPointerException("Parâmetro regex da função de validação de " +
                    "indicadores precisa conter um expressão");

        if(!objectDto.getIndicadorLastoLCA().matches(regex)) {
            throw new IllegalArgumentException("Parâmetro 'indicadorLastoLCA' precisa ser " + regex);
        }

        if(!objectDto.getIndicadorHabilitado().matches(regex)) {
            throw new IllegalArgumentException("Parâmetro 'indicadorHabilitado' precisa ser " + regex);
        }

        if(!objectDto.getIndicadorPlanoPagamentoPersonalizado().matches(regex)) {
            throw new IllegalArgumentException("Parâmetro 'indicadorPlanoPagamentoPersonalizado' precisa ser " + regex);
        }

        if(!objectDto.getIndicadorValidaRegraNegocio().matches(regex)) {
            throw new IllegalArgumentException("Parâmetro 'getIndicadorValidaRegraNegocio' precisa ser " + regex);
        }
    }

    public ParametroProdutoEsteira fromDto(ParametroProdutoEsteiraPostDto objectDto) {
        return new ParametroProdutoEsteira(
                null,
                objectDto.getCodigoProdutoOperacional(),
                objectDto.getCodigoMobilidade(),
                objectDto.getIndicadorHabilitado(),
                objectDto.getIndicadorValidaRegraNegocio(),
                objectDto.getIndicadorLastoLCA(),
                objectDto.getIndicadorPlanoPagamentoPersonalizado(),
                objectDto.getQuantidadeMaximaParcela(),
                objectDto.getQuantidadePrazoValidade(),
                objectDto.getDataInicioVigencia(),
                objectDto.getDataFimVigencia(),
                objectDto.getCodigoUsuarioInclusao(),
                objectDto.getCodigoUsuarioAlteracao(),
                null,
                null
        );
    }
}
