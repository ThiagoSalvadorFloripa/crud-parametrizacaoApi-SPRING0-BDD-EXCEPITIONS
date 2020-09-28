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
    /*
    TODO: colocar o mapper para vc coverter
    @Autowired
    private CheckListPayLoadMapper mapper;
     */

 @PostMapping
    public ResponseEntity<CheckList> post(@RequestBody CheckList objDto) {
     /*
     TODO:
     Nunca enviar a entidade para o controller, questão de segurança e não boa pratica:
     ResponseEntity<CheckList> mudar para --> ResponseEntity<CheckListDto>
     @RequestBody CheckList objDto mudar para --> @RequestBody CheckListDto pyload
     service.insert(objDto) mudar para --> service.insert(mapper.toEntity(pyload))
     CheckList newDTO = service.insert(objDto); mudar para --> CheckListDto resultDto = mapper.toDto(service.insert(mapper.toEntity(pyload)))
     ResponseEntity.ok().body(newDTO) mudar para --> ResponseEntity.ok().body(resultDto)
      */
        CheckList newDTO = service.insert(objDto);

        return ResponseEntity.ok().body(newDTO);
    }

}
