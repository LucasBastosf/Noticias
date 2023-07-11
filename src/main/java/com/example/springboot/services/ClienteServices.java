package com.example.springboot.services;

import com.example.springboot.DTOs.ClienteDTO;
import com.example.springboot.models.Cliente;
import com.example.springboot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServices {
    @Autowired
    private ClienteRepository repository;
    public Cliente salvarCliente(ClienteDTO dto){
        return repository.save(new Cliente(dto));
    }
    public List<Cliente> listarCliente(){
       return repository.findAll();
    }

}


