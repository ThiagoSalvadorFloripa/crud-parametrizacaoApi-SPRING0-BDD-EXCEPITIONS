package br.salvador.thiago.parametrizacao.controller;

import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraPostDto;
import br.salvador.thiago.parametrizacao.dto.ParametroProdutoEsteiraResponseDto;
import br.salvador.thiago.parametrizacao.service.ParametroProdutoEsteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/parametro-regra-esteira")
public class ParametroProdutoEsteiraController {

    @Autowired
    private ParametroProdutoEsteiraService parametroProdutoEsteiraService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ParametroProdutoEsteiraResponseDto> save(
            @Valid @RequestBody ParametroProdutoEsteiraPostDto parametroProdutoEsteiraPostDto) {
        ParametroProdutoEsteiraResponseDto response =
                this.parametroProdutoEsteiraService.save(parametroProdutoEsteiraPostDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
