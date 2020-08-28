package com.lambdaschool.backend.services;

import com.lambdaschool.backend.models.Dispensary;
import com.lambdaschool.backend.models.Strain;
import com.lambdaschool.backend.repositories.DispensaryRepo;
import com.lambdaschool.backend.repositories.StrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "strainServices")
public class StrainServiceImpl implements StrainService{
    @Autowired
    StrainRepo strainRepo;

    @Autowired
    DispensaryRepo dispensaryRepo;

    @Override
    public List<Strain> listAllStrains() {
        List<Strain> list = new ArrayList<>();
        strainRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Strain findStrainsByCode(long id) {
        return strainRepo.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Strain " + id + " Not Found"));
    }

    @Override
    public List<Strain> findStrainsByNameLike(String custn) {
        return strainRepo.findByStrainnameContainingIgnoringCase(custn);
    }


    @Override
    public void delete(long id) {
        if (strainRepo.findById(id).isPresent()) // did it find id in our list
        {
            strainRepo.deleteById(id);
        } else {
            throw new EntityNotFoundException("Customer " + id + " Not Found");
        }
    }


    @Override
    public Strain save(Strain strain) {
       Strain newStrain = new Strain();

       if(strain.getStrainid() !=0 ){
           strainRepo.findById(strain.getStrainid())
                   .orElseThrow(()->new EntityNotFoundException("Strain " + strain.getStrainid() + " not found"));

           newStrain.setStrainid(strain.getStrainid());
       }

       newStrain.setStrainname(strain.getStrainname());
       newStrain.setMood(strain.getMood());
       newStrain.setDescription(strain.getDescription());
       newStrain.setDispensary(strain.getDispensary());

       //setting up many to many dispensary
        Dispensary newDispensary = dispensaryRepo.findById(newStrain.getDispensary().getDispensarycode())
                .orElseThrow(()-> new EntityNotFoundException("Dispensary "+ newStrain.getDispensary().getDispensarycode() + " Not Found"));
        newStrain.setDispensary(newDispensary);

       return strainRepo.save(newStrain);
    }

    @Override
    public Strain update(Strain strain, long id) {
        Strain currentStrain = strainRepo.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Strain " + id + " Not Found"));

        if(strain.getStrainname() != null){
            currentStrain.setStrainname(strain.getStrainname());
        }

        if (strain.getMood() != null){
            currentStrain.setMood(strain.getMood());
        }

        if (strain.getDescription() != null){
            currentStrain.setDescription(strain.getDescription());
        }
        if (strain.getDispensary() != null){
            currentStrain.setDispensary(strain.getDispensary());
        }

        Dispensary newDispensary = dispensaryRepo.findById(currentStrain.getStrainid())
                .orElseThrow(()-> new EntityNotFoundException("Dispensary "+ currentStrain.getDispensary().getDispensarycode() + " not found"));

        currentStrain.setDispensary(newDispensary);


        return strainRepo.save(currentStrain);
    }
}
