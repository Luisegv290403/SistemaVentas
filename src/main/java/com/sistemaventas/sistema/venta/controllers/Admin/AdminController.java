package com.sistemaventas.sistema.venta.controllers.Admin;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaventas.sistema.venta.DTO.UserDto.UserDto;
import com.sistemaventas.sistema.venta.DTO.UserDto.UserResponseDto;
import com.sistemaventas.sistema.venta.Services.UserServices.UserService;
import com.sistemaventas.sistema.venta.entities.User.User;

@RequestMapping("/admin")
@RestController
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserResponseDto> hola(){
        return userService.getAllUser();
    }

    @PostMapping("/adminAdd")
    public User addUser(@RequestBody UserDto userDto){    
        return userService.addUser(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editUser(@PathVariable Long id, @RequestBody UserDto userDto){
        return userService.updateUser(id, userDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delate(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
