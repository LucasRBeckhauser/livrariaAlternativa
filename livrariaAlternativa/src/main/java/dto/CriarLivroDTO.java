package dto;

import java.time.LocalDate;

public record CriarLivroDTO(

    String titulo,

    String descricao,

    String autor,

    String genero,

    LocalDate anoPublicacao

) {} 