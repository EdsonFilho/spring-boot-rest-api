package br.com.eacf.endpoint;

import br.com.eacf.entity.City;
import br.com.eacf.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("city")
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @PostMapping("/")
    public ResponseEntity<City> findById(@RequestBody City city){
        return ResponseEntity.ok(cityService.save(city));
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<City>> findAll(){
        return ResponseEntity.ok(cityService.findAll());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Iterable<City>> findByName(@PathVariable String name){
        return ResponseEntity.ok(cityService.findByName(name));
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<Iterable<City>> findByState(@PathVariable String state){
        return ResponseEntity.ok(cityService.findByState(state));
    }

}
