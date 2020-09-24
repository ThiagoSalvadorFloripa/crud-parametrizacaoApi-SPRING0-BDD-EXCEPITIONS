package br.salvador.thiago.parametrizacao.controller;

import br.salvador.thiago.parametrizacao.dto.CheckListPayLoadDTO;
import br.salvador.thiago.parametrizacao.dto.CheckListPayLoadInsertDTO;
import br.salvador.thiago.parametrizacao.repositoy.CheckListRepository;
import br.salvador.thiago.parametrizacao.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.Serializable;

@RestController
@RequestMapping(value = "/v1/parametros/checklist-documentos")
public class CheckListPostController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CheckListService service;
    private CheckListRepository repository;

    @PostMapping
    public ResponseEntity<CheckListPayLoadDTO> post(@RequestBody @Valid CheckListPayLoadInsertDTO dto) {
        CheckListPayLoadDTO newDTO = service.insert(dto);
        return ResponseEntity.ok().body(newDTO);
    }
}
