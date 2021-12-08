package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
      public void getUserByCarModelAndSeries(String model, int series){
          TypedQuery<User> query = sessionFactory.openStatelessSession().
                  createQuery("from User WHERE car = ( From Car where model=:model and series=:series)");
          query.setParameter("model", model);
          query.setParameter("series", series);
         List<User> list =  query.getResultList();
          System.out.println(list);

      }
    }

