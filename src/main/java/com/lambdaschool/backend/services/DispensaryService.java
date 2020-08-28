package com.lambdaschool.backend.services;

import com.lambdaschool.backend.models.Dispensary;

public interface DispensaryService {
    Dispensary findByDispensaryCode(long id);
    Dispensary save(Dispensary dispensary);
}
