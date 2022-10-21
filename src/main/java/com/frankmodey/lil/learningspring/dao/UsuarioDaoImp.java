package com.frankmodey.lil.learningspring.dao;

import com.frankmodey.lil.learningspring.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class UsuarioDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void registrar(User user) {
        entityManager.merge(user);
    }

    @Override
    public boolean verificarCredenciales(User user) {
        String query = "FROM User WHERE email = :email";
        List<User> list = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();
        if(list.isEmpty()) return false;
        String passwordHashed = list.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.verify(passwordHashed, user.getPassword());
    }


}
