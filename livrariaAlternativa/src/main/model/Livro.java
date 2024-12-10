import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "livros")
@Entity
public class Livro extends EntityId{


    private String titulo;

    private String descricao;

    private String autor;

    private String genero;

    private LocalDate anoPublicacao;


}
