package br.salvador.thiago.parametrizacao.controller;

import br.salvador.thiago.parametrizacao.dto.CheckListPayLoadDTO;
import br.salvador.thiago.parametrizacao.model.CheckList;
import br.salvador.thiago.parametrizacao.repositoy.CheckListRepository;
import br.salvador.thiago.parametrizacao.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/parametros/checklist-documentos")
public class CheckListPutController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CheckListService service;
    private CheckListRepository repository;

    @PutMapping("/{id}")
    public ResponseEntity<CheckListPayLoadDTO> putId(@PathVariable @Valid Long id) {
        Optional<CheckList> list = repository.findById(id);
        if (list.isPresent()) {
            return ResponseEntity.ok(new CheckListPayLoadDTO(list.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
