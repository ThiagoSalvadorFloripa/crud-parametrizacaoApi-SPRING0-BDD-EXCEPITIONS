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
        this.logger.info("Iniciando validação de dados para salvar ParametroProdutoEsteira {}", objectDto);

        validaObjetoParametroProdutoEsteiraPayloadDto(objectDto);

        this.logger.info("Validação de dados para salvar ParametroProdutoEsteira concluída {}", objectDto);

        this.preparaParametroProdutoEsteiraParaSalvar(objectDto);

        return this.parametroProdutoEsteiraResponseMapper
                .toParametroProdutoEsteiraResponseDto(this.parametroProdutoEsteiraRepository
                        .save(preparaParametroProdutoEsteiraParaSalvar(objectDto)));
    }


    public ParametroProdutoEsteiraResponseDto findById(Integer idParametroRegraEsteira) {
        this.logger.info("Iniciando validação de dados para encontrar ParametroProdutoEsteira de id " +
                idParametroRegraEsteira);

        Rule isNull = new IsNullOrExceptRule(idParametroRegraEsteira);
        isNull.doLogic("iidParametroRegraEsteira");

        this.logger.info("Validação de dados para encontrar ParametroProdutoEsteira de id " +
                idParametroRegraEsteira + " concluída");

        ParametroProdutoEsteira responseEntity = this.parametroProdutoEsteiraRepository
                .findById(idParametroRegraEsteira)
                .orElseThrow(() -> new ObjectNotFoundException(idParametroRegraEsteira, "Parametro de Produto Esteira"));

        ParametroProdutoEsteiraResponseDto responseDto = this.parametroProdutoEsteiraResponseMapper
                .toParametroProdutoEsteiraResponseDto(responseEntity);

         return responseDto;
    }

    public List<ParametroProdutoEsteiraResponseDto> findAll() {
        List<ParametroProdutoEsteira> responseEntityList =
                this.parametroProdutoEsteiraRepository.findAll();
        List<ParametroProdutoEsteiraResponseDto> responseDtoList =
                this.parametroProdutoEsteiraResponseMapper
                        .toParametroProdutoEsteiraResponseDtos(responseEntityList);

        return responseDtoList;
    }

    private void validaObjetoParametroProdutoEsteiraPayloadDto(ParametroProdutoEsteiraPayloadDto objectDto) {
        ObjectValidation validation = new ParametroProdutoEsteiraPayloadValidation(objectDto);
        validation.execute();
    }

    private ParametroProdutoEsteira preparaParametroProdutoEsteiraParaSalvar(ParametroProdutoEsteiraPayloadDto objectDto){
        ParametroProdutoEsteira objectToSave = this.parametroProdutoEsteiraPayloadMapper
                .toParametroProdutoEsteira(objectDto);

        objectToSave.setIdParametroRegraEsteira(null);
        objectToSave.setDataCriacao(LocalDateTime.now());

        return objectToSave;
    }
}
