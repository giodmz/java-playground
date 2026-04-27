package com.project.email_sender.dto;

/**
 * DTO (Data Transfer Object) que representa os dados de um e-mail.
 *
 * Responsabilidade: apenas carregar os dados inseridos pelo usuário.
 * Não contém lógica de negócio — só armazena informações.
 */
public class EmailRequest {

    private String destinatario;
    private String assunto;
    private String corpo;

    // Construtor vazio (necessário para instanciar antes de popular os campos)
    public EmailRequest() {}

    // Construtor completo (útil para criar o objeto já preenchido)
    public EmailRequest(String destinatario, String assunto, String corpo) {
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.corpo = corpo;
    }

    // ===== GETTERS E SETTERS =====

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "destinatario='" + destinatario + '\'' +
                ", assunto='" + assunto + '\'' +
                ", corpo='" + corpo + '\'' +
                '}';
    }
}