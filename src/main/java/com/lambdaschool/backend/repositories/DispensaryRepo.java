package com.lambdaschool.backend.repositories;

import com.lambdaschool.backend.models.Dispensary;
import org.springframework.data.repository.CrudRepository;

public interface DispensaryRepo extends CrudRepository<Dispensary, Long> {
}
