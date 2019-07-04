package br.inpe.embrace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.inpe.embrace.domain.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {

}
