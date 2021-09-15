package services;

import models.AppUser;

import java.util.ArrayList;

public interface IUserService {
    ArrayList<AppUser> findAll();
    AppUser findById(long id);
}
