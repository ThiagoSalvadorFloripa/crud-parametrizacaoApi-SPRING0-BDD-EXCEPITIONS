package br.salvador.thiago.parametrizacao.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.salvador.thiago.parametrizacao.dto.CheckListDTO;
import br.salvador.thiago.parametrizacao.dto.CheckListInsertDTO;
import br.salvador.thiago.parametrizacao.service.CheckListService;

@RestController
@RequestMapping(value = "/v1/parametros/checklist-documentos")
public class CheckListController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CheckListService service;

	@GetMapping
	public ResponseEntity<List<CheckListDTO>> findAll() {
		List<CheckListDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<CheckListDTO> insert(@RequestBody CheckListInsertDTO dto) {
		CheckListDTO newDTO = service.insert(dto);
		return ResponseEntity.ok().body(newDTO);
	}

}
