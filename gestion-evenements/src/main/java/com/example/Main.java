//package com.example;
//
//import com.example.entities.*;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class Main {
//    public static void main(String[] args) {
//        Session session = null;
//        Transaction transaction = null;
//
////        try {
////            entityManagerFactory = Persistence.createEntityManagerFactory("UP_POSTGRES");
////            entityManager = entityManagerFactory.createEntityManager();
////            Role personne = entityManager.find(Role.class, 1);
////            List<Role> personnes = entityManager.createQuery("select r from Role r").getResultList();
////            for (Role p: personnes) {
////                System.out.println(p.getName());
////            }
////            EntityTransaction entityTransaction = entityManager.getTransaction();
////            entityTransaction.begin();
////            entityManager.persist(new Role("Admin"));
////            entityManager.persist(new Role("Teacher"));
////            entityManager.persist(new Role("Student"));
////            entityManager.persist(new Classe("Class 1"));
////            entityManager.persist(new Classe("Class 2"));
////            entityManager.persist(new Classe("Class 3"));
////            entityManager.persist(new Classe("Class 4"));
////            entityManager.persist(new Classe("Class 5"));
////            entityManager.persist(new Classe("Class 6"));
////            entityManager.persist(new Classe("Class 7"));
////            entityManager.persist(new Classe("Class 8"));
////            entityManager.persist(new Specialite("Web Dev (1ere)"));
////            entityManager.persist(new Specialite("JEE (2eme)"));
////            entityManager.persist(new Specialite("C# (2eme)"));
////            entityManager.persist(new Specialite("FEBE (2eme)"));
////            entityManager.persist(new Promo("2019-2021"));
////            entityManager.persist(new Promo("2020-2022"));
////            entityManager.persist(new ActivityType("Event", "#3EEDED"));
////            entityManager.persist(new ActivityType("Competitions", "#25ADFD"));
////            entityManager.persist(new ActivityType("Hackathon", "#778DDB"));
////            entityManager.persist(new ActivityType("Club", "#FF8749"));
////////            entityManager.persist(personne);
////            entityTransaction.commit();
////
////        } catch (Throwable throwable) {
////            throwable.printStackTrace();
////        }
////        finally {
////            if (entityManager != null) entityManager.close();
////            if (entityManagerFactory != null) entityManagerFactory.close();
////        }
//
//        try {
//            session = HibernateUtil.getSessionFactory().getCurrentSession();
//            transaction = session.beginTransaction();
//            session.persist(new Role("Admin"));
//            session.persist(new Role("Teacher"));
//            session.persist(new Role("Student"));
//            session.persist(new Classe("Class 1"));
//            session.persist(new Classe("Class 2"));
//            session.persist(new Classe("Class 3"));
//            session.persist(new Classe("Class 4"));
//            session.persist(new Classe("Class 5"));
//            session.persist(new Classe("Class 6"));
//            session.persist(new Classe("Class 7"));
//            session.persist(new Classe("Class 8"));
//            session.persist(new Specialite("Web Dev (1ere)"));
//            session.persist(new Specialite("JEE (2eme)"));
//            session.persist(new Specialite("C# (2eme)"));
//            session.persist(new Specialite("FEBE (2eme)"));
//            session.persist(new Promo("2019-2021"));
//            session.persist(new Promo("2020-2022"));
//            session.persist(new ActivityType("Event", "#3EEDED"));
//            session.persist(new ActivityType("Competitions", "#25ADFD"));
//            session.persist(new ActivityType("Hackathon", "#778DDB"));
//            session.persist(new ActivityType("Club", "#FF8749"));
//            transaction.commit();
//        } catch (Exception throwable) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            throwable.printStackTrace();
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//
//    }
//}
