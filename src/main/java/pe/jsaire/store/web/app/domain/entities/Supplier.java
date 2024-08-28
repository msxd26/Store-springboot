package pe.jsaire.store.web.app.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Supplier {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier" , nullable = false)
    private Long idSupplier;

    @Column(name = "company_name", nullable = false, precision = 100)
    private String companyName;

    @Column(name = "type_document", nullable = false, precision = 10)
    private String typeDocument;

    @Column(name = "number_document", nullable = false, precision = 20)
    private String numberDocument;

    @Column(name = "address", nullable = false, precision = 150)
    private String address;

    @Column(name = "name_contact", nullable = false, precision = 50)
    private String nameContact;

    @Column(name = "email_contact", nullable = false, precision = 100)
    private String emailContact;

    @Column(name = "cellphone_contact", nullable = false, precision = 10)
    private String cellPhoneContact;

    private boolean enabled;


    @OneToMany( cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "supplier")
    private Set<Income> income;
}
