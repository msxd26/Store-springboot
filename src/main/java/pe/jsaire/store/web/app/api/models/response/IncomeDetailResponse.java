package pe.jsaire.store.web.app.api.models.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDetailResponse implements Serializable {

    private IncomeResponse income;
    private ProductResponse product;
    private Integer quantity;
    private BigDecimal price;

}
