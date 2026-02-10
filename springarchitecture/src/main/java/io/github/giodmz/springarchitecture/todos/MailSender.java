package io.github.giodmz.springarchitecture.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void enviar(String msg) {
        System.out.println("Email enviado: " + msg);
    }
}
