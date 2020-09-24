package br.salvador.thiago.parametrizacao.service;

import br.salvador.thiago.parametrizacao.dto.CheckListPayLoadDTO;
import br.salvador.thiago.parametrizacao.dto.CheckListPayLoadInsertDTO;
import br.salvador.thiago.parametrizacao.model.CheckList;
import br.salvador.thiago.parametrizacao.repositoy.CheckListRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckListService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CheckListRepository repository;

    @Transactional(readOnly = true)
    public List<CheckListPayLoadDTO> findAll() {
        List<CheckList> list = repository.findAll();
        return list.stream().map(x -> new CheckListPayLoadDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public CheckListPayLoadDTO insert(CheckListPayLoadInsertDTO dto) {
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
        return new CheckListPayLoadDTO(model);

    }


}