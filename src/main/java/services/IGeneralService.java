package services;

import java.util.Optional;

public interface IGeneralService <T>{
    Iterable<T> findAll();
    Optional<T> findById(Integer id);
    void save(T t);
    void delete(T t);
}
