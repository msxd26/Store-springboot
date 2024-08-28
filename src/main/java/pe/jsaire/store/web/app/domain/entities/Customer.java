package pe.jsaire.store.web.app.domain.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Entity(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Customer {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_customer", nullable = false)
    private Long idCustomer;

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

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            mappedBy = "customer"
    )
    private Set<Sale> sales;



}
