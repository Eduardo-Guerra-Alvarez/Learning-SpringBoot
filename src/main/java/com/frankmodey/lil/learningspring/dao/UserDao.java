package com.frankmodey.lil.learningspring.dao;

import com.frankmodey.lil.learningspring.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void eliminar(Long id);

    void registrar(User user);

    boolean verificarCredenciales(User user);
}
