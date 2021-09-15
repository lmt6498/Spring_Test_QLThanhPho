package services;

import models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ICountryRepo;

import java.util.Optional;

@Service
public class CountryService implements ICountryService {
    @Autowired
    private ICountryRepo classesRepo;

    @Override
    public Iterable<Country> findAll() {
        return classesRepo.findAll();
    }

    @Override
    public Optional<Country> findById(Integer id) {
        return classesRepo.findById(id);
    }

    @Override
    public void save(Country country) {
        classesRepo.save(country);

    }

    @Override
    public void delete(Country country) {
        classesRepo.delete(country);
    }
}
