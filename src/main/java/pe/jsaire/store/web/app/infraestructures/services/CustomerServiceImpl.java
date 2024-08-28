package pe.jsaire.store.web.app.infraestructures.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.jsaire.store.web.app.api.models.request.CustomerRequest;
import pe.jsaire.store.web.app.api.models.response.CustomerResponse;
import pe.jsaire.store.web.app.domain.entities.Customer;
import pe.jsaire.store.web.app.domain.repositories.CustomerRepository;
import pe.jsaire.store.web.app.infraestructures.abstract_services.CustomerService;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    @Override
    public CustomerResponse findById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        return entityToResponse(customer);
    }

    @Override
    public CustomerResponse save(CustomerRequest customerRequest) {
        Customer customerSave = Customer.builder()
                .companyName(customerRequest.getCompanyName())
                .typeDocument(customerRequest.getTypeDocument())
                .numberDocument(customerRequest.getNumberDocument())
                .address(customerRequest.getAddress())
                .nameContact(customerRequest.getNameContact())
                .emailContact(customerRequest.getEmailContact())
                .cellPhoneContact(customerRequest.getCellPhoneContact())
                .enabled(customerRequest.isEnabled())
                .build();
        Customer savedCustomer = customerRepository.save(customerSave);
        return entityToResponse(savedCustomer);
    }

    @Override
    public CustomerResponse update(CustomerRequest customerRequest, Long id) {
        Customer customerUpdate = customerRepository.findById(id).orElseThrow();

        customerUpdate.setCompanyName(customerRequest.getCompanyName());
        customerUpdate.setTypeDocument(customerRequest.getTypeDocument());
        customerUpdate.setNumberDocument(customerRequest.getNumberDocument());
        customerUpdate.setAddress(customerRequest.getAddress());
        customerUpdate.setNameContact(customerRequest.getNameContact());
        customerUpdate.setEmailContact(customerRequest.getEmailContact());
        customerUpdate.setCellPhoneContact(customerRequest.getCellPhoneContact());
        customerUpdate.setEnabled(customerRequest.isEnabled());
        Customer customerToUpdate = customerRepository.save(customerUpdate);
        return entityToResponse(customerToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customer);
    }

    private CustomerResponse entityToResponse(Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        BeanUtils.copyProperties(customer, customerResponse);
        customerResponse.setId(customer.getIdCustomer());
        return customerResponse;
    }

}
