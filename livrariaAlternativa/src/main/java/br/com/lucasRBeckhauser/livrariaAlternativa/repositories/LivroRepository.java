package br.com.lucasRBeckhauser.livrariaAlternativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucasRBeckhauser.livrariaAlternativa.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository <Livro, Long>{

}
