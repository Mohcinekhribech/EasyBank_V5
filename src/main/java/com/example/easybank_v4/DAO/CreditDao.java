package com.example.easybank_v4.DAO;

import com.example.easybank_v4.DTO.Account;
import com.example.easybank_v4.DTO.Credit;
import com.example.easybank_v4.Helpers.HibernateUtil;
import com.example.easybank_v4.Interfaces.CreditInterface;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class CreditDao implements CreditInterface {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session;
    Transaction transaction;
    @Override
    public Optional<Credit> save(Credit credit) {
        try {
            session=sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(credit);
            transaction.commit();
            if(session.contains(credit))
                return Optional.of(credit);

        }catch (HibernateException e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
            transaction = null;
        }
        return Optional.empty();
    }

    @Override
    public int delete(Credit credit) {
        try {
            session=sessionFactory.openSession();
            transaction = session.beginTransaction();
            if(credit != null) {
                session.delete(credit);
                transaction.commit();
                return 1;
            }
        }catch (HibernateException e)
        {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return 0;
    }

    @Override
    public Optional<Credit> update(Credit credit) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(credit);
            transaction.commit();
            if(session.contains(credit))
                return Optional.of(credit);
        }catch(HibernateException e)
        {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Credit> findById(String id) {
        try{
            session = sessionFactory.openSession();
            Credit credit = session.get(Credit.class, id);
            return Optional.of(credit);
        }catch(HibernateException e)
        {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return Optional.empty();
    }

    @Override
    public List<Credit> showAll() {
        try {
            session = sessionFactory.openSession();
            Query<Credit> query = session.createQuery("From Credit ", Credit.class);
            return query.list();
        }catch(HibernateException e)
        {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}