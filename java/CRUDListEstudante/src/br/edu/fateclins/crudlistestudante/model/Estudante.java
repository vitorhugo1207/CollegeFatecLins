package br.edu.fateclins.crudlistestudante.model;

public class Estudante {
    
    // Atributos da Classe Estudante
    private int raEstudante;
    private String nomeEstudante;
    private String telefoneEstudante;
    private String emailEstudante;
    
    // Construtor Padrão (Default)
    public Estudante() {
    }
    
    // Construtor com parâmetros inicializados.
    public Estudante(int raEstudante, String nomeEstudante, String telefoneEstudante, String emailEstudante) {
        this.raEstudante = raEstudante;
        this.nomeEstudante = nomeEstudante;
        this.telefoneEstudante = telefoneEstudante;
        this.emailEstudante = emailEstudante;
    }
    
    // Métodos Getters and Setters 
    public int getRaEstudante() {
        return raEstudante;
    }

    public void setRaEstudante(int raEstudante) {
        this.raEstudante = raEstudante;        
    }

    public String getNomeEstudante() {
        return nomeEstudante;
    }

    public void setNomeEstudante(String nomeEstudante) {
        this.nomeEstudante = nomeEstudante;
    }

    public String getTelefoneEstudante() {
        return telefoneEstudante;
    }

    public void setTelefoneEstudante(String telefoneEstudante) {
        this.telefoneEstudante = telefoneEstudante;
    }

    public String getEmailEstudante() {
        return emailEstudante;
    }

    public void setEmailEstudante(String emailEstudante) {
        this.emailEstudante = emailEstudante;
    }
            
    // Método toString() (com StringBuilder)    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("toString2:\n");
        sb.append("Estudante { ");
        sb.append("raEstudante = ").append(raEstudante);
        sb.append(", nomeEstudante = ").append(nomeEstudante);
        sb.append(", telefoneEstudante = ").append(telefoneEstudante);
        sb.append(", emailEstudante = ").append(emailEstudante);
        sb.append('}');
        return sb.toString();
    }  
    
}
