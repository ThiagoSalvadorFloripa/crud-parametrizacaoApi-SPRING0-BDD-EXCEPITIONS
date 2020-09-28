package br.salvador.thiago.parametrizacao.controller;

import br.salvador.thiago.parametrizacao.model.CheckList;
import br.salvador.thiago.parametrizacao.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping(value = "/v1/parametros/checklist-documentos")
public class CheckListPostController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CheckListService service;

    @PostMapping
    public ResponseEntity<CheckList> post(@RequestBody CheckList objDto) {
        CheckList newDTO = service.insert(objDto);
        return ResponseEntity.ok().body(newDTO);
    }

}
