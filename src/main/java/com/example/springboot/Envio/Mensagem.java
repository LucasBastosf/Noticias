package com.example.springboot.Envio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Mensagem {
    private String remetente;

    private List<String> destinatarios;

    private String assunto;

    private String corpo;
}
