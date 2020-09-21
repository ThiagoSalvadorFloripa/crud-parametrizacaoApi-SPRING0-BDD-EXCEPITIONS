package br.salvador.thiago.parametrizacao.controller;


import br.salvador.thiago.parametrizacao.dto.CheckListPayLoadDTO;
import br.salvador.thiago.parametrizacao.dto.CheckListPayLoadInsertDTO;
import br.salvador.thiago.parametrizacao.model.CheckList;
import br.salvador.thiago.parametrizacao.repositoy.CheckListRepository;
import br.salvador.thiago.parametrizacao.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/parametros/checklist-documentos")
public class CheckListController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CheckListService service;

    private CheckListRepository repository;


    @GetMapping
    public ResponseEntity<List<CheckListPayLoadDTO>> findAll() {
        List<CheckListPayLoadDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }


    @PostMapping
    public ResponseEntity<CheckListPayLoadDTO> insert(@RequestBody @Valid CheckListPayLoadInsertDTO dto) {
        CheckListPayLoadDTO newDTO = service.insert(dto);
        return ResponseEntity.ok().body(newDTO);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CheckListPayLoadDTO> pesquisarId(@PathVariable Long id) {
        Optional<CheckList> list = repository.findById(id);
        if (list.isPresent()) {
            return ResponseEntity.ok(new CheckListPayLoadDTO(list.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
