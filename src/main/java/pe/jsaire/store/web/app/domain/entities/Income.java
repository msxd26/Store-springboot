package pe.jsaire.store.web.app.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity(name = "incomes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Income {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_income", nullable = false)
    private Long idIncome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id_supplier")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
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
            mappedBy = "income"
    )
    private Set<IncomeDetail> incomeDetails;

    @PrePersist
    @PreRemove
    public void updateFk(){
        this.incomeDetails.forEach(incomeDetail -> incomeDetail.setIncome(this));
    }


    public void addIncomeDetail(IncomeDetail incomeDetail) {
        if(Objects.isNull(incomeDetails)) {
            this.incomeDetails = new HashSet<>();
        }
        this.incomeDetails.add(incomeDetail);
        this.incomeDetails.forEach(incomeDetail1 -> incomeDetail1.setIncome(this));
    }

    public void removeIncomeDetail(UUID id) {
        this.incomeDetails.forEach(incomeDetail -> {
            if (incomeDetail.getIdIncomeDetails().equals(id)) {
                incomeDetail.setIncome(null);}
            }
        );
    }


}
