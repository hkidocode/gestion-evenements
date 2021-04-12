package com.example.repository;

import com.example.HibernateUtil;
import com.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class LoginRepositoryImpl implements LoginRepository {
    Session session = null;
    Transaction transaction = null;

    @Override
    public Person isMember(String email, String password) {
        Person person = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Query<Person> query = session.createQuery("SELECT p FROM Person p WHERE p.email= ?1 AND p.password= ?2", Person.class);
            query.setParameter(1, email);
            query.setParameter(2, password);
            person = query.getSingleResult();
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
        return person;
    }
}
