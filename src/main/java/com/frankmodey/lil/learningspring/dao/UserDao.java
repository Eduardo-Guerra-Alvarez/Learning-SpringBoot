package com.frankmodey.lil.learningspring.dao;

import com.frankmodey.lil.learningspring.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void eliminar(Long id);
}
