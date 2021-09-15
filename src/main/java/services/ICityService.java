package services;

import models.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService extends IGeneralService<City>{
    Page<City> findAll(Pageable pageable);
    Iterable<City> findAllByName(String name);
    public Page<City> findAllByNameAPI(String name, Pageable pageable);
}
