package br.salvador.thiago.parametrizacao.controller;

import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraPayloadDto;
import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraResponseDto;
import br.salvador.thiago.parametrizacao.service.ParametroProdutoEsteiraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/parametro-regra-esteira")
public class ParametroProdutoEsteiraController {

    @Autowired
    private ParametroProdutoEsteiraService parametroProdutoEsteiraService;

    private Logger logger = LoggerFactory.getLogger(ParametroProdutoEsteiraController.class);

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ParametroProdutoEsteiraResponseDto> save(
            @Valid @RequestBody ParametroProdutoEsteiraPayloadDto parametroProdutoEsteiraPayloadDto) {
        this.logger.info("Request para inserir um novo parametro de produto na esteira. " +
                parametroProdutoEsteiraPayloadDto.toString());

        ParametroProdutoEsteiraResponseDto response =
                this.parametroProdutoEsteiraService.save(parametroProdutoEsteiraPayloadDto);

        this.logger.info("Serviço salvou o parametro de produto na esteira. " +
                response.toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @RequestMapping(value = "/{idParametroRegraEsteira}", method = RequestMethod.PUT)
    public ResponseEntity<ParametroProdutoEsteiraResponseDto> update(
            @PathVariable Integer idParametroRegraEsteira,
            @Valid @RequestBody ParametroProdutoEsteiraPayloadDto parametroProdutoEsteiraPayloadDto) {
        this.logger.info("Request para atualizar o parametro de produto na esteira de id " + idParametroRegraEsteira +
                ". " + parametroProdutoEsteiraPayloadDto.toString());

        ParametroProdutoEsteiraResponseDto response =
                this.parametroProdutoEsteiraService.update(idParametroRegraEsteira, parametroProdutoEsteiraPayloadDto);

        this.logger.info("Serviço atualizou o parametro de produto na esteirade id " + idParametroRegraEsteira +
                response.toString());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @RequestMapping(value = {"", "/{idParametroRegraEsteira}"}, method = RequestMethod.GET)
    public ResponseEntity<?> find(
            @PathVariable(required = false) Integer idParametroRegraEsteira) {

        Object response;

        if(idParametroRegraEsteira != null) {
            response = serviceFindById(idParametroRegraEsteira);
        } else {
            response = serviceFindAll();
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    private ParametroProdutoEsteiraResponseDto serviceFindById(Integer idParametroRegraEsteira) {
        this.logger.info("Request procurando o parametro de produto na esteira de id " + idParametroRegraEsteira);

        ParametroProdutoEsteiraResponseDto response =
                this.parametroProdutoEsteiraService.findById(idParametroRegraEsteira);

        this.logger.info("Parametro de produto na esteira de id " + idParametroRegraEsteira +
                " encontrado. " + response.toString());
        return response;
    }

    private List<ParametroProdutoEsteiraResponseDto> serviceFindAll() {
        this.logger.info("Request procurando todos os parametros de produtos na esteira.");

        List<ParametroProdutoEsteiraResponseDto> response =
                this.parametroProdutoEsteiraService.findAll();

        this.logger.info("Request procurando todos os parametros de produtos na esteira concluido.");
        return response;
    }
}
