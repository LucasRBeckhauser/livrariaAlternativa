package br.com.lucasRBeckhauser.livrariaAlternativa.dto;

import java.time.LocalDate;

import br.com.lucasRBeckhauser.livrariaAlternativa.model.Livro;

public record CriarLivroDTO(

    String titulo,

    String descricao,

    String autor,

    String genero,

    LocalDate anoPublicacao

) {

    public static CriarLivroDTO fromEntity(Livro livros) {

        return new CriarLivroDTO(
            livros.getTitulo(),
            livros.getAutor(),
            livros.getGenero(),
            livros.getDescricao(),
            livros.getAnoPublicacao()
        
        );
    }

    public Livro toEntity() {
        return new Livro(
                this.titulo,
                this.autor,
                this.genero,
                this.descricao,
                this.anoPublicacao
                
        );

    }

} 