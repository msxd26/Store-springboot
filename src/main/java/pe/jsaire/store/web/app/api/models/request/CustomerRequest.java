package pe.jsaire.store.web.app.api.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest implements Serializable {


    private Long id;
    private String companyName;
    private String typeDocument;
    private String numberDocument;
    private String address;
    private String nameContact;
    private String emailContact;
    private String cellPhoneContact;
    private boolean enabled;


}
