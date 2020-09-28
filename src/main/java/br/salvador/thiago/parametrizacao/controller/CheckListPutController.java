package br.salvador.thiago.parametrizacao.controller;

import br.salvador.thiago.parametrizacao.dto.CheckListPayLoadDTO;
import br.salvador.thiago.parametrizacao.dto.mapper.CheckListPayLoadMapper;
import br.salvador.thiago.parametrizacao.model.CheckList;
import br.salvador.thiago.parametrizacao.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping(value = "/v1/parametros/checklist-documentos")
public class CheckListPutController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CheckListService service;

     /*
    TODO: colocar o mapper para vc coverter
    @Autowired
    private CheckListPayLoadMapper mapper;
     */

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody CheckListPayLoadDTO objDto, @PathVariable Long id) {
        CheckList obj = service.fromDTO(objDto); // mudar para CheckList resutDto = mapper.toDto(service.update(mapper.toEntity(objDto)));
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
}