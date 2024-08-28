package pe.jsaire.store.web.app.infraestructures.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.jsaire.store.web.app.api.models.request.SupplierRequest;
import pe.jsaire.store.web.app.api.models.response.SupplierResponse;
import pe.jsaire.store.web.app.domain.entities.Supplier;
import pe.jsaire.store.web.app.domain.repositories.SupplierRepository;
import pe.jsaire.store.web.app.infraestructures.abstract_services.SupplierService;



@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Override
    public SupplierResponse findById(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow();
        return entityToResponse(supplier);
    }

    @Override
    public SupplierResponse save(SupplierRequest supplierRequest) {

        Supplier supplierPersist = Supplier.builder()
                .companyName(supplierRequest.getCompanyName())
                .typeDocument(supplierRequest.getTypeDocument())
                .numberDocument(supplierRequest.getNumberDocument())
                .address(supplierRequest.getAddress())
                .nameContact(supplierRequest.getNameContact())
                .emailContact(supplierRequest.getEmailContact())
                .cellPhoneContact(supplierRequest.getCellPhoneContact())
                .enabled(supplierRequest.isEnabled())
                .build();

        Supplier supplierSaved = supplierRepository.save(supplierPersist);
        return entityToResponse(supplierSaved);
    }

    @Override
    public SupplierResponse update(SupplierRequest supplierRequest, Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow();

        supplier.setCompanyName(supplierRequest.getCompanyName());
        supplier.setTypeDocument(supplierRequest.getTypeDocument());
        supplier.setNumberDocument(supplierRequest.getNumberDocument());
        supplier.setAddress(supplierRequest.getAddress());
        supplier.setNameContact(supplierRequest.getNameContact());
        supplier.setEmailContact(supplierRequest.getEmailContact());
        supplier.setCellPhoneContact(supplierRequest.getCellPhoneContact());
        supplier.setEnabled(supplierRequest.isEnabled());
        Supplier supplierUpdated = supplierRepository.save(supplier);
        return entityToResponse(supplierUpdated);
    }

    @Override
    public void deleteById(Long id) {
        supplierRepository.deleteById(id);
    }


    private SupplierResponse entityToResponse(Supplier supplier) {
        SupplierResponse supplierResponse = new SupplierResponse();
        BeanUtils.copyProperties(supplier, supplierResponse);
        supplierResponse.setId(supplier.getIdSupplier());
        return supplierResponse;
    }


}
