/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Message;
import com.example.demo.Servicio.MessageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author omarg
 */
@RestController
@RequestMapping("/api/Message")
public class MessageController {
    
    @Autowired // mepermite traer metodos desde otros paquetees 
    private MessageService messagetService;

    @GetMapping("/all")//leee la tabla completa
    public List<Message> getAll() {
        return messagetService.getAll();
    }

    @GetMapping("/{id}")// nos resive un id y devulve los s datos d ese id
    public Optional<Message> getMessage(@PathVariable("id") int id) {
        return messagetService.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {
        return messagetService.save(message);
    }
    
}
