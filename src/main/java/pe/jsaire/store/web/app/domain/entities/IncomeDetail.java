package pe.jsaire.store.web.app.domain.entities;

import jakarta.persistence.*;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@Entity(name = "income_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class IncomeDetail {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_income_details" , nullable = false)
    private UUID idIncomeDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_income", nullable = false)
    private Income income;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

    private Integer quantity;

    @Column(precision = 11, scale = 2)
    private BigDecimal price;
}
