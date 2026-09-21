package com.solutionti.testetecnico.controller;

import com.solutionti.testetecnico.dto.UserDTO;
import com.solutionti.testetecnico.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService){

        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){

        UserDTO created  = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id){

        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDTO>> getAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers());

    }
}
