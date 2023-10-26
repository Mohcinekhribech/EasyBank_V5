package com.example.easybank_v4.DAO;

import com.example.easybank_v4.DTO.Client;
import com.example.easybank_v4.Interfaces.ClientInterface;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ClientDao implements ClientInterface {
   SessionFactory sessionFactory;
   Session session;
   Transaction transaction;
   public ClientDao(SessionFactory sessionFactory)
   {
       this.sessionFactory = sessionFactory;
   }
    @Override
    public Optional<Client> save(Client client) {
       try {
           if(!session.isOpen())
               session=sessionFactory.openSession();
           transaction = session.beginTransaction();
           session.save(client);
           transaction.commit();
        if(session.contains(client))
           return Optional.of(client);

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
    public int delete(Client client) {
       try {
           session=sessionFactory.openSession();
           transaction = session.beginTransaction();
           if(client != null) {
               session.delete(client);
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
    public Optional<Client> update(Client client) {
       try {
           session = sessionFactory.openSession();
           transaction = session.beginTransaction();
           session.update(client);
           transaction.commit();
           if(session.contains(client))
               return Optional.of(client);
       }catch(HibernateException e)
       {
           e.printStackTrace();
       }finally {
           session.close();
       }
       return Optional.empty();
    }

    @Override
    public Optional<Client> findById(String id) {
        session=sessionFactory.openSession();
        Client client = session.get(Client.class,id);
        return client != null?Optional.of(client):Optional.empty();
    }

    @Override
    public List<Client> showAll() {
        session=sessionFactory.openSession();
        Query<Client> query =  session.createQuery("from Client",Client.class);
        return query.list();
    }
    @Override
    public List<Client> searchByAttribute(String attribute)
    {
        session=sessionFactory.openSession();
        Query query = session.createQuery("FROM Client WHERE prenom LIKE :attribute OR nom LIKE :attribute OR telephone LIKE :attribute OR adresse LIKE :attribute");
        query.setParameter("attribute", "%" + attribute + "%");
        return query.list();
    }
}
