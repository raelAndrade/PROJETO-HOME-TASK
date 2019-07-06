package br.inpe.embrace.resources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.inpe.embrace.resources.entities.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {

}
