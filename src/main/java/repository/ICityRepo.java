package repository;

import models.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ICityRepo extends PagingAndSortingRepository<City,Integer> {
    @Query(value = "select c from City c where c.name like concat('%',:name,'%')")
    Iterable<City> findAllByName(@Param("name") String name);
    Page<City> findAllByNameContaining(String name, Pageable pageable);
}
