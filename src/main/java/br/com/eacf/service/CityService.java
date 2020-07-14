package br.com.eacf.service;

import br.com.eacf.entity.City;
import br.com.eacf.jpa.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public City save(City city) {
        return this.cityRepository.save(city);
    }

    public Iterable<City> findByName(String name){
        return cityRepository.findByName(name);
    }

    public Iterable<City> findByState(String state){
        return cityRepository.findByState(state);
    }

    public Iterable<City> findAll(){
        return cityRepository.findAll();
    }
}
