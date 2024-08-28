package pe.jsaire.store.web.app.infraestructures.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;
import pe.jsaire.store.web.app.api.models.request.IncomeRequest;
import pe.jsaire.store.web.app.api.models.response.IncomeResponse;
import pe.jsaire.store.web.app.domain.entities.Income;

import pe.jsaire.store.web.app.domain.entities.Supplier;
import pe.jsaire.store.web.app.domain.entities.User;
import pe.jsaire.store.web.app.domain.repositories.IncomeRepository;
import pe.jsaire.store.web.app.domain.repositories.SupplierRepository;
import pe.jsaire.store.web.app.domain.repositories.UserRepository;
import pe.jsaire.store.web.app.infraestructures.abstract_services.IncomeService;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;
    private final SupplierRepository supplierRepository;
    private final UserRepository userRepository;

    @Override
    public IncomeResponse findById(Long id) {
        Income income = incomeRepository.findById(id).orElseThrow();
        return entityToResponse(income);
    }

    @Override
    public IncomeResponse save(IncomeRequest incomeRequest) {
        Supplier supplier = supplierRepository.findById(incomeRequest.getIdSupplier()).orElseThrow();
        User user = userRepository.findById(incomeRequest.getIdUser()).orElseThrow();
        Income incomePersist = Income.builder()
                .supplier(supplier)
                .user(user)
                .typeInvoice(incomeRequest.getTypeInvoice())
                .serialInvoice(incomeRequest.getSerialInvoice())
                .numberInvoice(incomeRequest.getNumberInvoice())
                .dateTime(LocalDateTime.now())
                .tax(incomeRequest.getTax())
                .total(incomeRequest.getTotal())
                .enabled(incomeRequest.isEnabled())
                .build();
        var incomeToPersist = incomeRepository.save(incomePersist);
        return entityToResponse(incomeToPersist);
    }

    @Override
    public IncomeResponse update(IncomeRequest incomeRequest, Long id) {

        Income incomeUpdate = incomeRepository.findById(id).orElseThrow();

        incomeUpdate.setSupplier(supplierRepository.findById(incomeRequest.getIdSupplier()).orElseThrow());
        incomeUpdate.setUser(userRepository.findById(incomeRequest.getIdUser()).orElseThrow());
        incomeUpdate.setTypeInvoice(incomeRequest.getTypeInvoice());
        incomeUpdate.setSerialInvoice(incomeRequest.getSerialInvoice());
        incomeUpdate.setNumberInvoice(incomeRequest.getNumberInvoice());
        incomeUpdate.setTax(incomeRequest.getTax());
        incomeUpdate.setTotal(incomeRequest.getTotal());
        incomeUpdate.setEnabled(incomeRequest.isEnabled());

        var incomeToPersist = incomeRepository.save(incomeUpdate);

        return entityToResponse(incomeToPersist);
    }

    @Override
    public void deleteById(Long id) {
        incomeRepository.deleteById(id);

    }

    private IncomeResponse entityToResponse(Income income) {
        IncomeResponse incomeResponse = new IncomeResponse();
        BeanUtils.copyProperties(income, incomeResponse);
        incomeResponse.setId(income.getIdIncome());
        incomeResponse.setIdUser(income.getUser().getIdUser());
        incomeResponse.setIdSupplier(income.getSupplier().getIdSupplier());
        return incomeResponse;
    }
}
