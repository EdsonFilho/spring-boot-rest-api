package br.com.eacf.endpoint;

import br.com.eacf.entity.City;
import br.com.eacf.entity.Customer;
import br.com.eacf.exception.ResourceNotFoundException;
import br.com.eacf.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/")
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.save(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> save(@PathVariable long id, @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.update(customer, id));
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Iterable<Customer>> findByName(@PathVariable String name){
        return ResponseEntity.ok(customerService.findByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id){
        try {
            Customer movie = customerService.findById(id);
            customerService.deleteById(id);
            return ResponseEntity.ok(movie);  // return 200, with json body
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // return 404, with null body
        }
    }
}
