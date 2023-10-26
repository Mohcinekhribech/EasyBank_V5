package com.example.easybank_v4.DAO;

import com.example.easybank_v4.DTO.Employe;
import com.example.easybank_v4.Interfaces.EmployeInterface;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class EmployeDao implements EmployeInterface {
    SessionFactory sessionFactory;
    Session session;
    Transaction transaction;
    public EmployeDao(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Optional<Employe> save(Employe employe) {
        try {
            if(!session.isOpen())
                session=sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(employe);
            transaction.commit();
            if(session.contains(employe))
                return Optional.of(employe);

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
    public int delete(Employe employe) {
        try {
            session=sessionFactory.openSession();
            transaction = session.beginTransaction();
            if(employe != null) {
                session.delete(employe);
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
    public Optional<Employe> update(Employe employe) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(employe);
            transaction.commit();
            if(session.contains(employe))
                return Optional.of(employe);
        }catch(HibernateException e)
        {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Employe> findById(String id) {
        session=sessionFactory.openSession();
        return Optional.of(session.get(Employe.class,id));
    }
    @Override
    public Optional<Employe> findByEmail(String email) {
        session = sessionFactory.openSession();
        try {
            Query<Employe> query = session.createQuery("FROM Employe WHERE adresseemail LIKE :email", Employe.class);
            query.setParameter("email", email);
            Employe employee = query.uniqueResult();
            return Optional.ofNullable(employee);
        } catch (HibernateException e) {
            // Handle the exception appropriately
            e.printStackTrace();
            return Optional.empty();
        } finally {
            session.close();
        }
    }




    @Override
    public List<Employe> showAll() {
        session=sessionFactory.openSession();
        Query<Employe> query =  session.createQuery("from Employe",Employe.class);
        return query.list();
    }
    @Override
    public List<Employe> searchByAttribute(String attribute)
    {
        session=sessionFactory.openSession();
        Query query = session.createQuery("FROM Employe WHERE prenom LIKE :attribute OR nom LIKE :attribute OR telephone LIKE :attribute OR adresse LIKE :attribute");
        query.setParameter("attribute", "%" + attribute + "%");
        return query.list();
    }
}
