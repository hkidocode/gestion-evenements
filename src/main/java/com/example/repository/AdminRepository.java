package com.example.repository;

import com.example.entity.*;
//import com.example.events.entities.*;

import java.util.*;

public interface AdminRepository {
    Person getPerson(Long idPerson);
    Role getRole(short idRole);
    Promo getPromo(short idPromo);
    Classe getClasse(short idClasse);
    Specialite getSpecialite(short idSpeciality);
    void addPerson(Person person);
    void updatePerson(Long idPerson);
    void deletePerson(Long idPerson);
    List<Person> getAllPersons();
    List<Role> getAllRoles();
    List<Promo> getAllPromos();
    List<Specialite> getAllSpecialities();
    List<Classe> getAllClasses();
}
