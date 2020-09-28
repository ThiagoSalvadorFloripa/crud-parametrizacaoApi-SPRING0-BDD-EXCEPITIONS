package br.salvador.thiago.parametrizacao.controller;


import br.salvador.thiago.parametrizacao.dto.CheckListPayLoadDTO;
import br.salvador.thiago.parametrizacao.model.CheckList;
import br.salvador.thiago.parametrizacao.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/parametros/checklist-documentos")
public class CheckListGetController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CheckListService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CheckListPayLoadDTO>> findAll() {
        List<CheckList> list = service.findAll();
        List<CheckListPayLoadDTO> listDTO = list.stream().map(x -> new CheckListPayLoadDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CheckListPayLoadDTO> findById(@PathVariable @Valid Long id) {
        CheckList list = service.findById(id);
        return ResponseEntity.ok().body(new CheckListPayLoadDTO(list));
    }
}
