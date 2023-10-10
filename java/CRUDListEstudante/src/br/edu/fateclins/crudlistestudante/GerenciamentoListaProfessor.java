package br.edu.fateclins.crudlistestudante;

import br.edu.fateclins.crudlistestudante.model.Professor;
import java.util.LinkedList;
import java.util.Scanner;

public class GerenciamentoListaProfessor {

    LinkedList<Professor> listaProfessors;
    

    public GerenciamentoListaProfessor() {
        listaProfessors = new LinkedList<>();
    }
    
    public void add(Professor professor) {
        if(!find(professor.getRmProfessor())) {
            listaProfessors.add(professor);
        } else {
            System.out.println("Professor já cadastrado!!!");
        }
    }
    
    public boolean find(int raProfessor) {
        for (Professor e : listaProfessors) {            
            if (e.getRmProfessor() == raProfessor) {
                System.out.println("O professor foi encontrado: " + e);
                return true;
            }
        }        
        return false;
    }
    
    public void delete(int regRaProfessor) {
        Professor professorDel = null;

        for (Professor e2 : listaProfessors) { 
            if (e2.getRmProfessor() == regRaProfessor) {
                professorDel = e2;
            }        
        }
        
        if (professorDel == null) {
            System.out.println("O RA do professor é inválido!!!");
        } else {
            listaProfessors.remove(professorDel);
            
            System.out.println("O registro do professor"
                      + " foi removido da lista com sucesso!!!");            
        }
    }
    
    public Professor findProfessor(int raProfessor) {
        for (Professor e : listaProfessors) {
            if (e.getRmProfessor() == raProfessor) {
                return e;
            }
        }        
        return null;
    }  
    
    public void update(int ra, Scanner entrada){
        if (find(ra)){
            Professor novoProfessor = findProfessor(ra);
            
            System.out.println("Qual é o novo número de RA do professor? ");
            int raNumero = entrada.nextInt();
            
            System.out.println("Qual é o novo nome do professor?");
            String nome = entrada.next();             
            
            System.out.println("Qual é o novo telefone do professor?");
            String fone = entrada.next();            
            
            System.out.println("Qual é o novo email do professor?");
            String email = entrada.next();           
            
            novoProfessor.setRmProfessor(raNumero);
            novoProfessor.setNomeProfessor(nome);
            novoProfessor.setTelefoneProfessor(fone);
            novoProfessor.setEmailProfessor(email);
            
            System.out.println("Registro do Professor atualizado com sucesso!!!");           
        
        } else {
            System.out.println("Registro não foi encontrado na lista do professor");
        }
    }
    
    public void display() {
        if (listaProfessors.isEmpty()) {
            System.out.println("A lista de professors está vazia ou sem registros\n");        
        }
        for (Professor professor : listaProfessors) {
            String professorPrint = professor.toString();
            professorPrint = professorPrint.replace("Professor", "");
            professorPrint = professorPrint.replace("{", "");
            professorPrint = professorPrint.replace("}", "");
            professorPrint = professorPrint.replace(", ", "\n");

            System.out.println("--------------------");
            
            System.out.println(professorPrint);
            
            System.out.println("--------------------\n");
        }
    }    
}
