package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM User WHERE username = :username", User.class)
                .setParameter("username", username)
                .uniqueResult();
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }
}
