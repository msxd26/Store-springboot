package pe.jsaire.store.web.app.domain.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.Set;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class User {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "full_name", nullable = false, precision = 100)
    private String fullName;

    @Column(name = "type_document", nullable = false , precision = 10)
    private String typeDocument;

    @Column(name = "number_document", nullable = false , precision = 20)
    private String numberDocument;

    @Column(name = "address", nullable = false , precision = 50)
    private String address;

    @Column(name = "cellphone", nullable = false , precision = 50)
    private String cellPhone;

    @Column(name = "username", nullable = false )
    private String username;

    @Column(name = "password", nullable = false , precision = 100)
    private String password;
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable( name = "users_roles",
            joinColumns = @JoinColumn(name = "id_users"),
            inverseJoinColumns = @JoinColumn(name = "id_roles"))
    private Set<Rol> roles;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            mappedBy = "user"
    )
    private Set<Income> incomes;


    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            mappedBy = "user"
    )
    private Set<Sale> sales;
}
