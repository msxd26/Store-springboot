package pe.jsaire.store.web.app.api.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeRequest implements Serializable {

    private Long id;
    private Long idSupplier;
    private Long idUser;
    private String typeInvoice;
    private String serialInvoice;
    private String numberInvoice;
    private BigDecimal tax;
    private BigDecimal total;
    private boolean enabled;

}
