package pe.jsaire.store.web.app.api.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest implements Serializable {

    private Long id;
    private Long idCategory;
    private String code;
    private String name;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private boolean enabled;

}
