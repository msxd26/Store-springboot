package pe.jsaire.store.web.app.api.models.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.jsaire.store.web.app.api.models.response.IncomeResponse;
import pe.jsaire.store.web.app.api.models.response.ProductResponse;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDetailRequest implements Serializable {

    private IncomeResponse income;
    private ProductResponse product;
    private Integer quantity;
    private BigDecimal price;

}
