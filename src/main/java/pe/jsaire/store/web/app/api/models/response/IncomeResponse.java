package pe.jsaire.store.web.app.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeResponse implements Serializable {


    private Long id;
    private Long idSupplier;
    private Long idUser;
    private String typeInvoice;
    private String serialInvoice;
    private String numberInvoice;
    private LocalDateTime dateTime;
    private BigDecimal tax;
    private BigDecimal total;
    private Set<IncomeDetailResponse> incomeDetails;
    private boolean enabled;
}
