package com.project.email_sender.service;

import com.project.email_sender.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável por enviar e-mails.
 *
 * Responsabilidade: toda a lógica de envio de e-mail fica aqui.
 * Usa o JavaMailSender do Spring, que é configurado automaticamente
 * pelas propriedades do application.properties.
 *
 * @Service → indica ao Spring que esta classe é um componente de serviço
 *            e deve ser gerenciada pelo container (injeção de dependência).
 */
@Service
public class EmailService {

    /**
     * JavaMailSender é a interface do Spring para envio de e-mails.
     * O Spring Boot a configura automaticamente com base no application.properties.
     * A injeção ocorre pelo construtor (melhor prática).
     */
    private final JavaMailSender mailSender;

    /**
     * @Value → injeta o valor da propriedade do application.properties
     * Assim o remetente é lido automaticamente das configurações.
     */
    @Value("${spring.mail.username}")
    private String remetente;

    // Injeção de dependência via construtor (mais testável e explícita)
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Envia um e-mail simples (texto puro, sem HTML).
     *
     * @param request objeto com destinatário, assunto e corpo do e-mail
     * @throws MailException se ocorrer qualquer erro no envio (sem conexão, credenciais erradas, etc.)
     */
    public void enviarEmail(EmailRequest request) throws MailException {

        // SimpleMailMessage representa um e-mail de texto simples
        SimpleMailMessage mensagem = new SimpleMailMessage();

        // Define os campos do e-mail
        mensagem.setFrom(remetente);                    // Remetente (lido do properties)
        mensagem.setTo(request.getDestinatario());      // Destinatário inserido pelo usuário
        mensagem.setSubject(request.getAssunto());      // Assunto inserido pelo usuário
        mensagem.setText(request.getCorpo());           // Corpo inserido pelo usuário

        // Realiza o envio — pode lançar MailException em caso de falha
        mailSender.send(mensagem);
    }
}