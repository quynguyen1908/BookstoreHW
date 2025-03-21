package com.ejbproject.bookstore.service;

import com.ejbproject.bookstore.model.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class UserService {

    @PersistenceContext(unitName = "BookStorePU")
    private EntityManager em;

    public boolean registerUser(String email, String password) {
        try {
            User user = new User(email, password);
            em.persist(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User loginUser(String email, String password) {
        try {
            TypedQuery<User> query = em.createQuery(
                    "SELECT u FROM User u WHERE u.email = :email AND u.password = :password",
                    User.class
            );
            query.setParameter("email", email);
            query.setParameter("password", password);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
