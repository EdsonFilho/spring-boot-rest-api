package br.com.eacf.jpa;

import br.com.eacf.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {

    List<City> findByName(String name);

    List<City> findByState(String state);

}
