package com.app.travel.service.user.repository;

import com.app.travel.service.user.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
