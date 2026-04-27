package com.project.email_sender.runner;

import com.project.email_sender.dto.EmailRequest;
import com.project.email_sender.service.EmailService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Runner que executa automaticamente ao iniciar a aplicação.
 *
 * Responsabilidade: interagir com o usuário via console, coletar os dados
 * do e-mail e acionar o serviço de envio.
 *
 * CommandLineRunner → interface do Spring Boot que executa o método run()
 *                     logo após o contexto da aplicação ser carregado.
 *
 * @Component → registra esta classe como um bean gerenciado pelo Spring.
 */
@Component
public class ConsoleRunner implements CommandLineRunner {

    private final EmailService emailService;

    // Injeção do serviço via construtor
    public ConsoleRunner(EmailService emailService) {
        this.emailService = emailService;
    }

    /**
     * Método executado automaticamente na inicialização.
     * Lê os dados do usuário e dispara o envio do e-mail.
     */
    @Override
    public void run(String... args) {

        // Scanner lê entradas do console (System.in)
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------ENVIADOR DE E-MAILS--------------");
        System.out.println();

        // ── Coleta os dados do usuário ──────────────────────────────

        System.out.print("E-mail do destinatário: ");
        String destinatario = scanner.nextLine().trim();

        System.out.print("Assunto: ");
        String assunto = scanner.nextLine().trim();

        System.out.println("Corpo da mensagem (pressione ENTER duas vezes para finalizar):");
        StringBuilder corpo = new StringBuilder();
        String linha;

        // Lê o corpo até o usuário pressionar Enter duas vezes (linha vazia)
        while (!(linha = scanner.nextLine()).isEmpty()) {
            corpo.append(linha).append("\n");
        }

        // ── Valida campos obrigatórios ──────────────────────────────

        if (destinatario.isEmpty() || assunto.isEmpty() || corpo.isEmpty()) {
            System.out.println("\nErro: todos os campos são obrigatórios.");
            return;
        }

        // ── Monta o objeto de requisição ────────────────────────────

        EmailRequest request = new EmailRequest(destinatario, assunto, corpo.toString().trim());

        // ── Confirmação antes de enviar ─────────────────────────────

        System.out.println("\n──────────────────────────────────");
        System.out.println(" -- Resumo do e-mail --");
        System.out.println("   Para:    " + request.getDestinatario());
        System.out.println("   Assunto: " + request.getAssunto());
        System.out.println("   Corpo:   " + request.getCorpo());
        System.out.println("──────────────────────────────────");
        System.out.print("Confirmar envio? (s/n): ");

        String confirmacao = scanner.nextLine().trim().toLowerCase();
        if (!confirmacao.equals("s")) {
            System.out.println("Envio cancelado pelo usuário.");
            return;
        }

        // ── Tenta enviar e trata erros específicos ──────────────────

        System.out.println("\nEnviando e-mail...");

        try {
            emailService.enviarEmail(request);
            System.out.println("E-mail enviado com sucesso para: " + destinatario);

        } catch (MailAuthenticationException e) {
            // Credenciais incorretas no application.properties
            System.out.println("Erro de autenticação: verifique username e password no application.properties.");
            System.out.println("Detalhe: " + e.getMessage());

        } catch (MailSendException e) {
            // Problema ao conectar ou enviar (host errado, porta bloqueada, etc.)
            System.out.println("Erro ao enviar o e-mail: verifique sua conexão e as configurações SMTP.");
            System.out.println("Detalhe: " + e.getMessage());

        } catch (Exception e) {
            // Qualquer outro erro inesperado
            System.out.println("Erro inesperado: " + e.getMessage());
        }

        scanner.close();
    }
}