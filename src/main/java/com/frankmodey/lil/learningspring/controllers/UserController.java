package com.frankmodey.lil.learningspring.controllers;

import com.frankmodey.lil.learningspring.dao.UserDao;
import com.frankmodey.lil.learningspring.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="api/usuarios", method = RequestMethod.POST)
    public void registrarUser(@RequestBody User user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);
        System.out.println(user);
        userDao.registrar(user);
    }

}
