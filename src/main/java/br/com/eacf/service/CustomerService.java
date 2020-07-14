package br.com.eacf.service;

import br.com.eacf.entity.Customer;
import br.com.eacf.exception.ResourceNotFoundException;
import br.com.eacf.jpa.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public Customer update(Customer customer, long id) {
        Customer update = this.findById(id);
        update.setName(customer.getName());
        update.setAge(customer.getAge());
        update.setBirthdate(customer.getBirthdate());
        update.setCity(customer.getCity());
        update.setGender(customer.getGender());
        this.customerRepository.save(update);
        return update;
    }

    public Customer findById(Long id) throws ResourceNotFoundException {
        return this.customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(Long id) {
        this.customerRepository.deleteById(id);
    }

    public Iterable<Customer> findByName(String name){
        return customerRepository.findByName(name);
    }

    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }

}
