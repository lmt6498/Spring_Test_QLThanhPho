package services;

import models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.ICityRepo;

import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
    private ICityRepo studentRepo;

    @Override
    public Iterable<City> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<City> findById(Integer id) {
        return studentRepo.findById(id);
    }

    @Override
    public void save(City city) {
        studentRepo.save(city);
    }

    @Override
    public void delete(City city) {
        studentRepo.delete(city);
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        return studentRepo.findAll(pageable);
    }

    @Override
    public Iterable<City> findAllByName(String name) {
        return studentRepo.findAllByName(name);
    }

    @Override
    public Page<City> findAllByNameAPI(String name, Pageable pageable) {
        return studentRepo.findAllByNameContaining(name,pageable);
    }
}
