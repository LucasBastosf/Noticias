package com.example.springboot.controller;

import com.example.springboot.DTOs.NoticiaDTO;
import com.example.springboot.Envio.Mailer;
import com.example.springboot.Envio.Mensagem;
import com.example.springboot.models.Cliente;
import com.example.springboot.models.Noticia;
import com.example.springboot.services.ClienteServices;
import com.example.springboot.services.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("noticias")
public class NoticiaController{
    @Autowired
    private Mailer mailer;
   @Autowired
    private ClienteServices clienteServices;
    @Value("${mail.smtp.username}")
    private String username;

    @Autowired
    private NoticiaService noticiaService;
    @PostMapping
    public ResponseEntity<NoticiaDTO> enviarnoticia(@RequestBody NoticiaDTO dto) {
        return ResponseEntity.ok(new NoticiaDTO(noticiaService.Salvar(dto)));
    }
    @Scheduled(cron = "0 0 8 * * *")
    public void EnviarNoticia(){
        StringBuilder noticias= new StringBuilder();
        noticiaService.listarnocianaoprocessada(false).forEach((e)->{
            noticias.append( "\n "+ e.getTitulo());
            noticias.append("\n"+ e.getDescricao());
            noticias.append("\n" + e.getLink());
            noticias.append("\n-------");
            e.setProcessado(true);
            noticiaService.update(e);

        });
        List<Cliente> destinatarios = clienteServices.listarCliente();
        destinatarios.forEach((destinatario) ->{
            StringBuilder corpo= new StringBuilder();
            corpo.append("Bom dia "+ destinatario.getNome());
            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDate birthdayDate = destinatario.getNascimento().toLocalDate();
            if (currentDateTime.getMonthValue() == birthdayDate.getMonthValue() &&
                    currentDateTime.getDayOfMonth() == birthdayDate.getDayOfMonth()) {
                corpo.append("\n Feliz Aniversario ");
            }
            corpo.append("Segue as noticias de hoje");
            corpo.append(noticias);
            mailer.enviar(new Mensagem("Noticias <"+username + ">", Arrays.asList(destinatario.getNome()+" <"+destinatario.getEmail() + ">"), "noticias do dia", corpo.toString()));
        });
    }
}
