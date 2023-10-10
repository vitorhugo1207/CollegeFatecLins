package br.edu.fateclins.crudlistestudante.model;

public class Professor {
    
    // Atributos da Classe Professor
    private int rmProfessor;
    private String nomeProfessor;
    private String telefoneProfessor;
    private String emailProfessor;
    
    // Construtor Padrão (Default)
    public Professor() {
    }
    
    // Construtor com parâmetros inicializados.
    public Professor(int rmProfessor, String nomeProfessor, String telefoneProfessor, String emailProfessor) {
        this.rmProfessor = rmProfessor;
        this.nomeProfessor = nomeProfessor;
        this.telefoneProfessor = telefoneProfessor;
        this.emailProfessor = emailProfessor;
    }
    
    // Métodos Getters and Setters 
    public int getRmProfessor() {
        return rmProfessor;
    }

    public void setRmProfessor(int rmProfessor) {
        this.rmProfessor = rmProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getTelefoneProfessor() {
        return telefoneProfessor;
    }

    public void setTelefoneProfessor(String telefoneProfessor) {
        this.telefoneProfessor = telefoneProfessor;
    }

    public String getEmailProfessor() {
        return emailProfessor;
    }

    public void setEmailProfessor(String emailProfessor) {
        this.emailProfessor = emailProfessor;
    }
    
    // Método toString() (com StringBuilder)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Professor {\n");
        sb.append("rmProfessor = ").append(rmProfessor);
        sb.append(", nomeProfessor = ").append(nomeProfessor);
        sb.append(", telefoneProfessor = ").append(telefoneProfessor);
        sb.append(", emailProfessor = ").append(emailProfessor);
        sb.append("\n}");
        return sb.toString();
    }
}
