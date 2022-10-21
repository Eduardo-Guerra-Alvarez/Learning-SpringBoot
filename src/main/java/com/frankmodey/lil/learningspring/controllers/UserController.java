package com.frankmodey.lil.learningspring.controllers;

import com.frankmodey.lil.learningspring.dao.UserDao;
import com.frankmodey.lil.learningspring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="api/usuario/{id}")
    public User getUser(@PathVariable Long id) {
        User usuario = new User();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("Moy@gmail.com");
        usuario.setTelefono("3323232323");
        return usuario;
    }

    @RequestMapping(value="api/usuarios")
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @RequestMapping(value="editar")
    public User editUser() {
        User usuario = new User();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("Moy@gmail.com");
        usuario.setTelefono("3323232323");
        return usuario;
    }

    @RequestMapping(value="api/usuarios/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        userDao.eliminar(id);
    }

    @RequestMapping(value="api/buscar")
    public User searchUser() {
        User usuario = new User();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("Moy@gmail.com");
        usuario.setTelefono("3323232323");
        return usuario;
    }

}
