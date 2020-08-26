package com.lambdaschool.backend;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.lambdaschool.backend.models.*;
import com.lambdaschool.backend.repositories.AllStrainRepo;
import com.lambdaschool.backend.repositories.DispensaryRepo;
import com.lambdaschool.backend.repositories.StrainRepo;
import com.lambdaschool.backend.services.RoleService;
import com.lambdaschool.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

/**
 * SeedData puts both known and random data into the database. It implements CommandLineRunner.
 * <p>
 * CoomandLineRunner: Spring Boot automatically runs the run method once and only once
 * after the application context has been loaded.
 */
@Transactional
 @Component
public class SeedData
        implements CommandLineRunner
{
    /**
     * Connects the Role Service to this process
     */
    @Autowired
    RoleService roleService;

    /**
     * Connects the user service to this process
     */
    @Autowired
    UserService userService;

    @Autowired
    AllStrainRepo allStrainRepo;

    @Autowired
    DispensaryRepo dispensaryRepo;

    @Autowired
    StrainRepo strainRepo;

    /**
     * Generates test, seed data for our application
     * First a set of known data is seeded into our database.
     * Second a random set of data using Java Faker is seeded into our database.
     * Note this process does not remove data from the database. So if data exists in the database
     * prior to running this process, that data remains in the database.
     *
     * @param args The parameter is required by the parent interface but is not used in this process.
     */
    @Transactional
    @Override
    public void run(String[] args) throws
            Exception {
        userService.deleteAll();
        roleService.deleteAll();
        Role r1 = new Role("admin");
        Role r2 = new Role("user");


        r1 = roleService.save(r1);
        r2 = roleService.save(r2);


        // admin, data, user
        User u1 = new User("admin",
                "password",
                "admin@lambdaschool.local");
        u1.getRoles()
                .add(new UserRoles(u1, r1));
        u1.getRoles()
                .add(new UserRoles(u1, r2));
        u1.getUseremails()
                .add(new Useremail(u1,
                        "admin@email.local"));
        u1.getUseremails()
                .add(new Useremail(u1,
                        "admin@mymail.local"));

        userService.save(u1);

        // data, user
        User u2 = new User("cinnamon",
                "password",
                "cinnamon@lambdaschool.local");
        u2.getRoles()
                .add(new UserRoles(u2, r2));
        u2.getUseremails()
                .add(new Useremail(u2,
                        "cinnamon@mymail.local"));
        u2.getUseremails()
                .add(new Useremail(u2,
                        "hops@mymail.local"));
        u2.getUseremails()
                .add(new Useremail(u2,
                        "bunny@email.local"));
        userService.save(u2);

        // user
        User u3 = new User("barnbarn",
                "password",
                "barnbarn@lambdaschool.local");
        u3.getRoles()
                .add(new UserRoles(u3, r2));
        u3.getUseremails()
                .add(new Useremail(u3,
                        "barnbarn@email.local"));
        userService.save(u3);

        User u4 = new User("puttat",
                "password",
                "puttat@school.lambda");
        u4.getRoles()
                .add(new UserRoles(u4, r2));
        userService.save(u4);

        User u5 = new User("misskitty",
                "password",
                "misskitty@school.lambda");
        u5.getRoles()
                .add(new UserRoles(u5, r2));
        userService.save(u5);

        //dispensary name, city, state, zipcode
        Dispensary d1 = new Dispensary("Phenos", "Modesto", "CA", "95350");
        Dispensary d2 = new Dispensary("Barbary Coast","San Francisco","CA","94105");
        Dispensary d3 = new Dispensary("Urban Pharm", "Portland","OR","97203");



        //saving
         dispensaryRepo.save(d1);
         dispensaryRepo.save(d2);
         dispensaryRepo.save(d3);


      //popular strains by mood, name,description,from d1
      Strain s1 = new Strain("Happy","BlackBerry Haze","Blackberry Haze offers clear, unencumbered relief that will typically leave your motivation intact.",d1);
      Strain s2 = new Strain("Relax", "Pink Champagne", "Elevating the mind while helping sooth aches and pains throughout the body.",d1);
      Strain s3 = new Strain("Focus","Sour Patch Kiss","Offers a melting euphoria that settles in the limbs as low-level sedation",d1);

      //popular strains by mood, name,description,from d2
      Strain s4 = new Strain("Happy","Og Jay","Gives the user a happy and relax state of mind", d2);
      Strain s5 = new Strain("Relax","Blue Cookies","Relaxes your sore muscles and mind", d2);
      Strain s6 = new Strain("Focus","Night Sky Og","Makes you feel alert and clear thinking",d2);

      //popular strains by mood, name,description,from d3
      Strain s7 = new Strain("Happy","James Og","Makes you laugh and enjoy life",d3);
      Strain s8 = new Strain("Relax","Pink Og","Calms nerves and body", d3);
      Strain s9 = new Strain("Focus","Donut Shake","Gives you the sugar focus", d3);

    //saving

        strainRepo.save(s1);
        strainRepo.save(s2);
        strainRepo.save(s3);
        strainRepo.save(s4);
        strainRepo.save(s5);
        strainRepo.save(s6);
        strainRepo.save(s7);
        strainRepo.save(s8);
        strainRepo.save(s9);
        
      //all strain data
      AllStrain a1 = new AllStrain("Frog Og");
      AllStrain a2 = new AllStrain("Dark Cookie");
      AllStrain a3 = new AllStrain("Light Sky Og");
      AllStrain a4 = new AllStrain("Cookie Monster");
      AllStrain a5 = new AllStrain("Python Og");

      //saving
        a1 = allStrainRepo.save(a1);
        a2 = allStrainRepo.save(a2);
        a3 = allStrainRepo.save(a3);
        a4 = allStrainRepo.save(a4);
        a5 = allStrainRepo.save(a5);

    }

}
