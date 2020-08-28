package com.lambdaschool.backend.repositories;

import com.lambdaschool.backend.models.Strain;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StrainRepo extends CrudRepository<Strain, Long> {
    List<Strain> findByStrainnameContainingIgnoringCase(String likename);
}
