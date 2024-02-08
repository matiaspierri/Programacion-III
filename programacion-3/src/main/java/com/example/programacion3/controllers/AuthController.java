package com.example.programacion3.controllers;

import com.example.programacion3.dto.Login.LoginDTO;
import com.example.programacion3.dto.Login.ResponseLoginDTO;
import com.example.programacion3.dto.Register.RegisterDTO;
import com.example.programacion3.models.User;
import com.example.programacion3.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {

    @Autowired
    private IUserService userService;

    @PostMapping(path = "/login")
    public ResponseLoginDTO authenticate(@RequestBody LoginDTO loginDTO) {
        return new ResponseLoginDTO(this.userService.authenticate(loginDTO.getUsername(), loginDTO.getPassword()));
    }
    @PostMapping(path = "/register")
    public ResponseLoginDTO register(@RequestBody RegisterDTO registerDTO) {
        return new ResponseLoginDTO(this.userService.register(registerDTO.getUsername(), registerDTO.getPassword(), registerDTO.getEmail()));
    }
}

