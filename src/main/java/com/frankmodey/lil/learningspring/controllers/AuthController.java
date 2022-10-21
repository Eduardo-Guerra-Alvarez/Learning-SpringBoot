package com.frankmodey.lil.learningspring.controllers;

import com.frankmodey.lil.learningspring.dao.UserDao;
import com.frankmodey.lil.learningspring.models.User;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public JSONObject login(@RequestBody User user) {
        JSONObject json = new JSONObject();
        if(userDao.verificarCredenciales(user)) {
            json.put("message", "successfull");
            return json;
        }
        json.put("message", "failed");
        return json;
    }
}
