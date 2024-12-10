import jakarta.persistence.IdClass;

@Getter
@MappedSuperclass
public class EntityId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
}