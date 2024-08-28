package pe.jsaire.store.web.app.domain.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "sales_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class SaleDetail {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_sale_detail", nullable = false)
    private UUID idSaleDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_product", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_sale", nullable = false)
    private Sale sale;

    @Column( nullable = false)
    private Integer quantity;

    @Column(name = "sale_price" , nullable = false, precision = 11, scale = 2)
    private BigDecimal salePrice;

    @Column( nullable = false, precision = 11, scale = 2)
    private BigDecimal discount;
}
