package com.lambdaschool.backend.repositories;

import com.lambdaschool.backend.models.Strain;
import org.springframework.data.repository.CrudRepository;

public interface StrainRepo extends CrudRepository<Strain, Long> {
}
