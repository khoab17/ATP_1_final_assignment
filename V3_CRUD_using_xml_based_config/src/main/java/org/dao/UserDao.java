package org.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.model.User;


import java.util.List;

public class UserDao{

    private SessionFactory sessionFactory;

    public UserDao()
    {
         sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();
    }

    public List<User> getAll () {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User").getResultList();
        session.getTransaction().commit();
        sessionFactory.close();
        return users;
    }
    public User get(int id)
    {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user =session.get(User.class,id);
        session.getTransaction().commit();
        sessionFactory.close();
        return user;
    }
     public void Update (User user){
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        sessionFactory.close();
     }
     public void delete(int id){
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user=session.byId(User.class).load(id);
        session.delete(user);
        session.getTransaction().commit();
        sessionFactory.close();
     }

}
