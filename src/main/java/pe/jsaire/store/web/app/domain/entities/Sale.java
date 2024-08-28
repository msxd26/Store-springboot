package pe.jsaire.store.web.app.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idSale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "type_invoice", nullable = false, precision = 20)
    private String typeInvoice;

    @Column(name = "serial_invoice", nullable = false, precision = 7)
    private String serialInvoice;

    @Column(name = "number_invoice", nullable = false, precision = 20)
    private String numberInvoice;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column( nullable = false, precision = 4, scale = 2)
    private BigDecimal tax;

    @Column( nullable = false, precision = 11, scale = 2)
    private BigDecimal total;

    private boolean enabled;


    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            mappedBy = "sale"
    )
    private Set<SaleDetail> saleDetails;
}

