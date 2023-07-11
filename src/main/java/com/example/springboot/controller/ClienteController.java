package com.example.springboot.controller;

import com.example.springboot.DTOs.ClienteDTO;
import com.example.springboot.services.ClienteServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteServices service;
    @PostMapping
    public ResponseEntity<ClienteDTO> salvarCliente(@RequestBody ClienteDTO dto){
        return ResponseEntity.ok(new ClienteDTO(service.salvarCliente(dto)));
    }
}
