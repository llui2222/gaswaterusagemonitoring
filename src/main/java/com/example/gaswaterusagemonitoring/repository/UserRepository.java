package com.example.gaswaterusagemonitoring.repository;



import com.example.gaswaterusagemonitoring.entity.UserDb;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserDb,Long> {
    List<UserDb> findByUserIdOrderByIdDesc(Long userId);
}
