package com.lambdaschool.backend.services;

import com.lambdaschool.backend.models.Dispensary;
import com.lambdaschool.backend.repositories.DispensaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "dispensaryServices")
public class DispensaryServiceImpl implements DispensaryService {
    @Autowired
    DispensaryRepo dispensaryRepo;

    @Override
    public Dispensary findByDispensaryCode(long id) {
        return dispensaryRepo.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Dispensary " + id + " Not Found"));
    }

    @Override
    public Dispensary save(Dispensary dispensary) {
        return dispensaryRepo.save(dispensary);
    }
}
