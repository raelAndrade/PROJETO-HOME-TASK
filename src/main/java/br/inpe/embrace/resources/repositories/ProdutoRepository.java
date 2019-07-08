package br.inpe.embrace.resources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.inpe.embrace.resources.entities.Produto;

/**
 * 
 * @author Israel Andrade
 * 
 * Data de criação 7 de jul de 2019
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
