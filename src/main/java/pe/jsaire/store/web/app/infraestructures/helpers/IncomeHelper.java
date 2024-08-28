package pe.jsaire.store.web.app.infraestructures.helpers;


import lombok.AllArgsConstructor;

import org.springframework.stereotype.Component;

import pe.jsaire.store.web.app.domain.repositories.IncomeRepository;
import pe.jsaire.store.web.app.domain.repositories.ProductRepository;


@Component
@AllArgsConstructor
public class IncomeHelper {


    private final IncomeRepository incomeRepository;
    private final ProductRepository productRepository;



}
