package dto;

import java.time.LocalDate;

public record CriarLivroDTO(

    String titulo,

    String descricao,

    String autor,

    String genero,

    LocalDate anoPublicacao

) {

    public static CriarLivroDTO fromEntity(Livro livros) {
        return new CriarLivroDTO(
            livros.genero(),
            livros.getMensagem(),
            livros.get
        );
    }

    public Livro toEntity() {
        return new Livro(
                this.anoPublicacao,
                this.autor,
                this.descricao,
                this.genero,
                this.titulo
                
                );

    }

} 