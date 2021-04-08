package com.example.repository;

import com.example.HibernateUtil;
import com.example.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

public class AdminRepositoryImpl implements AdminRepository{

     Session session = null;
     Transaction transaction = null;
     Person person = null;

    @Override
    public Person getPerson(Long idPerson) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            person = session.get(Person.class, idPerson);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        return person;
    }

    @Override
    public Role getRole(short idRole) {
        Role role = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            role = session.get(Role.class, idRole);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return role;
    }

    @Override
    public Promo getPromo(short idPromo) {
        Promo promo = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            promo = session.get(Promo.class, idPromo);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return promo;
    }

    @Override
    public Classe getClasse(short idClasse) {
        Classe classe = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            classe = session.get(Classe.class, idClasse);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return classe;
    }

    @Override
    public Specialite getSpecialite(short idSpeciality) {
        Specialite specialite = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            specialite = session.get(Specialite.class, idSpeciality);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return specialite;
    }


    @Override
    public void addPerson(Person person) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.persist(person);
            System.out.println("person added");
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void updatePerson(Long idPerson) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            // Non persistent object
            Person existentPerson = getPerson(idPerson);
            existentPerson.setFirstName(person.getFirstName());
            existentPerson.setLastName(person.getLastName());
            existentPerson.setEmail(person.getEmail());
            existentPerson.setPassword(person.getPassword());
            existentPerson.setPhoneNumber(person.getPhoneNumber());
            // Persistent object
            session.merge(existentPerson);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deletePerson(Long idPerson) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            // Non persistent object
            Person existentPerson = getPerson(idPerson);
            // Persistent object
            session.delete(existentPerson);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> personList = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            personList = session.createQuery("SELECT p FROM Person p", Person.class).getResultList();
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return personList;
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roleList = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            roleList = session.createQuery("SELECT r FROM Role r", Role.class).getResultList();
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return roleList;
    }

    @Override
    public List<Promo> getAllPromos() {
        List<Promo> promoList = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            promoList = session.createQuery("SELECT p FROM Promo p", Promo.class).getResultList();
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return promoList;
    }

    @Override
    public List<Specialite> getAllSpecialities() {
        List<Specialite> specialiteList = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            specialiteList = session.createQuery("SELECT p FROM Specialite p", Specialite.class).getResultList();
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return specialiteList;
    }

    @Override
    public List<Classe> getAllClasses() {
        List<Classe> classeList = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            classeList = session.createQuery("SELECT c FROM Classe c", Classe.class).getResultList();
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return classeList;
    }
}
