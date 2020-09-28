package br.salvador.thiago.parametrizacao.service;

import br.salvador.thiago.parametrizacao.dto.CheckListPayLoadDTO;
import br.salvador.thiago.parametrizacao.model.CheckList;
import br.salvador.thiago.parametrizacao.repository.CheckListRepository;
import br.salvador.thiago.parametrizacao.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class CheckListService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CheckListRepository repository;

    public List<CheckList> findAll() {

        return repository.findAll();
    }

    public CheckList findById(@Valid Long id) {
        Optional<CheckList> list = repository.findById(Long.valueOf(id));
        return list.orElseThrow(() -> new NotFoundException("Objeto não encontrado"));
    }

    public CheckList insert(CheckList obj) {

        return repository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public CheckList update(CheckList obj) {
        CheckList newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(CheckList newObj, CheckList obj) {
        newObj.setProduto(obj.getProduto());
        newObj.setNome_documento(obj.getNome_documento());
        newObj.setEtapa_jornada_venda(obj.getEtapa_jornada_venda());
        newObj.setObrigatoriedade(obj.getObrigatoriedade());
        newObj.setData_vigencia(obj.getData_vigencia());
        newObj.setData_criacao(obj.getData_criacao());
        newObj.setUsuario(obj.getUsuario());
        newObj.setHabilitado(obj.getHabilitado());
    }

    public CheckList fromDTO(CheckListPayLoadDTO objDto) {
        return new CheckList(objDto.getId(), objDto.getProduto(), objDto.getNome_documento(),
                objDto.getObrigatoriedade(), objDto.getData_vigencia(), objDto.getData_criacao(), objDto.getUsuario(), objDto.getHabilitado());
    }

}