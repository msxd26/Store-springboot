package pe.jsaire.store.web.app.api.models.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse implements Serializable {

    private Long id;
    private String name;
    private String description;
    private boolean enabled;
}
