package br.salvador.thiago.parametrizacao.repository;

import br.salvador.thiago.parametrizacao.model.ParametroProdutoEsteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroProdutoEsteiraRepository
        extends JpaRepository<ParametroProdutoEsteira, Integer> {

}
