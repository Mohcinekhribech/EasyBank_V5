package com.example.easybank_v4.DAO;

import com.example.easybank_v4.DTO.Historical ;
import com.example.easybank_v4.Helpers.HibernateUtil;
import com.example.easybank_v4.Interfaces.HistoricalInterface;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class HistoricalDao implements HistoricalInterface {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session;
    Transaction transaction;
    @Override
    public Optional<Historical > save(Historical historical) {
        try {
            session=sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(historical);
            transaction.commit();
            if(session.contains(historical))
                return Optional.of(historical);
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
    public int delete(Historical historical) {
        try {
            session=sessionFactory.openSession();
            transaction = session.beginTransaction();
            if(historical != null) {
                session.delete(historical);
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
    public Optional<Historical > update(Historical historical) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(historical);
            transaction.commit();
            if(session.contains(historical))
                return Optional.of(historical);
        }catch(HibernateException e)
        {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Historical > findById(Integer id) {
        session=sessionFactory.openSession();
        Historical historical = session.get(Historical .class,id);
        return historical != null?Optional.of(historical):Optional.empty();
    }
    public List<Historical> getHistoricalByNumber(int numero)
    {
        try {
            session = sessionFactory.openSession();
            Query<Historical> query = session.createQuery("from Historical h where h.credit.numero = :numero", Historical.class);
            query.setParameter("numero", numero);
            return query.list();
        }catch(HibernateException e)
        {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
    @Override
    public List<Historical > showAll() {
        try {
            session = sessionFactory.openSession();
            Query<Historical> query = session.createQuery("from Historical ", Historical.class);
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