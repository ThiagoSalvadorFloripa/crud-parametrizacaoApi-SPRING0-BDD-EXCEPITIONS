package br.salvador.thiago.parametrizacao.service;

import br.salvador.thiago.parametrizacao.controller.exception.ObjectNotFoundException;
import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraPayloadDto;
import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraResponseDto;
import br.salvador.thiago.parametrizacao.dto.mapper.ParametroProdutoEsteiraPayloadMapper;
import br.salvador.thiago.parametrizacao.dto.mapper.ParametroProdutoEsteiraResponseMapper;
import br.salvador.thiago.parametrizacao.model.ParametroProdutoEsteira;
import br.salvador.thiago.parametrizacao.repository.ParametroProdutoEsteiraRepository;
import br.salvador.thiago.parametrizacao.validation.ObjectValidation;
import br.salvador.thiago.parametrizacao.validation.ParametroProdutoEsteiraPayloadValidation;
import br.salvador.thiago.parametrizacao.validation.rules.IsNullOrExceptRule;
import br.salvador.thiago.parametrizacao.validation.rules.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParametroProdutoEsteiraService {

    @Autowired
    private ParametroProdutoEsteiraRepository parametroProdutoEsteiraRepository;

    @Autowired
    private ParametroProdutoEsteiraPayloadMapper parametroProdutoEsteiraPayloadMapper;

    @Autowired
    private ParametroProdutoEsteiraResponseMapper parametroProdutoEsteiraResponseMapper;

    private Logger logger = LoggerFactory.getLogger(ParametroProdutoEsteiraService.class);

    public ParametroProdutoEsteiraResponseDto save(ParametroProdutoEsteiraPayloadDto objectDto) {
        this.validaObjetoParametroProdutoEsteiraPayloadDto(objectDto);
        this.preparaParametroProdutoEsteiraParaSalvar(objectDto);

        return this.parametroProdutoEsteiraResponseMapper
                .toParametroProdutoEsteiraResponseDto(this.parametroProdutoEsteiraRepository
                        .save(preparaParametroProdutoEsteiraParaSalvar(objectDto)));
    }

    public ParametroProdutoEsteiraResponseDto update(
            Integer idParametroRegraEsteira,
            ParametroProdutoEsteiraPayloadDto objectDto) {
        this.validaIdParametroRegraEsteira(idParametroRegraEsteira);
        this.validaObjetoParametroProdutoEsteiraPayloadDto(objectDto);

        return this.parametroProdutoEsteiraResponseMapper
                .toParametroProdutoEsteiraResponseDto(this.parametroProdutoEsteiraRepository
                        .save(preparaParametroProdutoEsteiraParaAtualizar(idParametroRegraEsteira, objectDto)));
    }

    public ParametroProdutoEsteiraResponseDto findById(Integer idParametroRegraEsteira) {
        validaIdParametroRegraEsteira(idParametroRegraEsteira);

        ParametroProdutoEsteira responseEntity = this.parametroProdutoEsteiraRepository
                .findById(idParametroRegraEsteira)
                .orElseThrow(() ->
                        new ObjectNotFoundException(idParametroRegraEsteira, "Parametro de Produto Esteira")
                );

         return this.parametroProdutoEsteiraResponseMapper.toParametroProdutoEsteiraResponseDto(responseEntity);
    }

    public List<ParametroProdutoEsteiraResponseDto> findAll() {
        return this.parametroProdutoEsteiraResponseMapper
                .toParametroProdutoEsteiraResponseDtos(this.parametroProdutoEsteiraRepository.findAll());
    }

    private void validaObjetoParametroProdutoEsteiraPayloadDto(ParametroProdutoEsteiraPayloadDto objectDto) {
        this.logger.info("Validando objeto ParametroProdutoEsteira {}", objectDto);
        ObjectValidation validation = new ParametroProdutoEsteiraPayloadValidation(objectDto);
        validation.execute();
        this.logger.info("Validação de objeto ParametroProdutoEsteira concluída {}", objectDto);
    }

    private void validaIdParametroRegraEsteira(Integer idParametroRegraEsteira) {
        this.logger.info("Validando dados para encontrar ParametroProdutoEsteira de id " + idParametroRegraEsteira);

        Rule isNull = new IsNullOrExceptRule(idParametroRegraEsteira);
        isNull.doLogic("iidParametroRegraEsteira");

        this.logger.info("Validação de dados para encontrar ParametroProdutoEsteira de id " + idParametroRegraEsteira + " concluída");
    }

    private ParametroProdutoEsteira preparaParametroProdutoEsteiraParaSalvar(ParametroProdutoEsteiraPayloadDto objectDto){
        ParametroProdutoEsteira objectToSave = this.parametroProdutoEsteiraPayloadMapper
                .toParametroProdutoEsteira(objectDto);

        objectToSave.setIdParametroRegraEsteira(null);
        objectToSave.setDataCriacao(LocalDateTime.now());

        return objectToSave;
    }

    private ParametroProdutoEsteira preparaParametroProdutoEsteiraParaAtualizar(
            Integer idParametroProdutoEsteira,
            ParametroProdutoEsteiraPayloadDto objectDto){
        ParametroProdutoEsteira objectToSave = this.parametroProdutoEsteiraPayloadMapper
                .toParametroProdutoEsteira(objectDto);
        
        objectToSave.setIdParametroRegraEsteira(idParametroProdutoEsteira);
        objectToSave.setDataAtualizacao(LocalDateTime.now());
        objectToSave.setDataCriacao(this.findById(idParametroProdutoEsteira).getDataCriacao());

        return objectToSave;
    }
}
