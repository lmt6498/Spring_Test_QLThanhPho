package repository;

import models.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICountryRepo extends PagingAndSortingRepository<Country,Integer> {
}
