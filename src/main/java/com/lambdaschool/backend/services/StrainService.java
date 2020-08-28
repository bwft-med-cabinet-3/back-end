package com.lambdaschool.backend.services;

import com.lambdaschool.backend.models.Strain;

import java.util.List;




public interface StrainService {

    List<Strain> listAllStrains();

    Strain findStrainsByCode(long id);

    List<Strain> findStrainsByNameLike(String custn);

    void delete(long id);
    Strain save(Strain strain);
    Strain update(Strain strain, long id);
}
