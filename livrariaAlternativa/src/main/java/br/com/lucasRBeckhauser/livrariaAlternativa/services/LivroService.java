package br.com.lucasRBeckhauser.livrariaAlternativa.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lucasRBeckhauser.livrariaAlternativa.dto.CriarLivroDTO;
import br.com.lucasRBeckhauser.livrariaAlternativa.model.Livro;
import br.com.lucasRBeckhauser.livrariaAlternativa.repositories.LivroRepository;

@Service
public class LivroService {

    @Autowired
   private LivroRepository livroRepository;

   public ResponseEntity<Livro> adicionarLivro(CriarLivroDTO criarLivroDTO) {
       Livro novoLivro = criarLivroDTO.toEntity();
       livroRepository.save(novoLivro);
       return ResponseEntity.ok(novoLivro);
   }

   public ResponseEntity<List<Livro>> obterLivros() {
    List<Livro> livros = livroRepository.findAll();
    return ResponseEntity.ok(livros);
}

public ResponseEntity<Livro> atualizarLivro(Long id, CriarLivroDTO criarLivroDTO) {
  Optional<Livro> livroExistente = livroRepository.findById(id);
  
  if (livroExistente.isPresent()) {
      Livro livro = livroExistente.get();
      livro.setTitulo(criarLivroDTO.titulo());
      livro.setDescricao(criarLivroDTO.descricao());
      livro.setAutor(criarLivroDTO.autor());
      livro.setGenero(criarLivroDTO.genero());
      livro.setAnoPublicacao(criarLivroDTO.anoPublicacao());
      livroRepository.save(livro);
      return ResponseEntity.ok(livro);
  } else {
      return ResponseEntity.notFound().build();
  }
}

public ResponseEntity<Void> deletarLivro(Long id) {
  Optional<Livro> optionalLivro = livroRepository.findById(id);

  if (optionalLivro.isPresent()) {
      livroRepository.delete(optionalLivro.get());
      return ResponseEntity.noContent().build();
  } else {
      return ResponseEntity.notFound().build();
  }
}



}
