package com.example.pusula.Repository;

import com.example.pusula.DTO.UserDTO;
import com.example.pusula.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager){
      this.entityManager=entityManager;
  }

    @Override
    public User findById(int id) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void setRole(User user) {
        entityManager.persist(user);
    }


    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);

    }

    @Override
    @Transactional
    public void delete(User user) {
       User dUser= entityManager.find(User.class,user);
       entityManager.remove(dUser);
    }


}
