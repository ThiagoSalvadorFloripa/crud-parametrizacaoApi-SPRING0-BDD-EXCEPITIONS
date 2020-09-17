package br.salvador.thiago.parametrizacao.service;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.salvador.thiago.parametrizacao.dto.CheckListDTO;
import br.salvador.thiago.parametrizacao.dto.CheckListInsertDTO;
import br.salvador.thiago.parametrizacao.model.CheckList;
import br.salvador.thiago.parametrizacao.repositoy.CheckListRepository;

@Service
public class CheckListService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CheckListRepository repository;

	@Transactional(readOnly = true)
	public List<CheckListDTO> findAll() {
		List<CheckList> list = repository.findAll();
		return list.stream().map(x -> new CheckListDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public CheckListDTO insert(CheckListInsertDTO dto) {
		CheckList model = new CheckList();
		model.setProduto(dto.getProduto());
		model.setNome_documento(dto.getNome_documento());
		model.setEtapa_jornada_venda(dto.getEtapa_jornada_venda());
		model.setObrigatoriedade(dto.getObrigatoriedade());
		model.setData_urgencia(Instant.now());
		model.setData_criacao(Instant.now());
		model.setUsuario(dto.getUsuario());
		model.setHabilitado(dto.getHabilitado());

		model = repository.save(model);
		return new CheckListDTO(model);

	}

}
