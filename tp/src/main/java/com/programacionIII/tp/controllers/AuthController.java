package com.programacionIII.tp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.programacionIII.tp.dto.LoginDTO;
import com.programacionIII.tp.dto.ResponseLoginDTO;
import com.programacionIII.tp.services.IUserService;


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
}
