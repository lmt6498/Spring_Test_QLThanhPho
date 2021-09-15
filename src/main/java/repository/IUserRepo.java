package repository;

import models.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepo extends CrudRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
