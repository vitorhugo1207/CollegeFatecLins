/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fateclins.crudlistestudante;

import br.edu.fateclins.crudlistestudante.model.Estudante;
import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.Scanner;

public class GerenciamentoListaEstudante {
    
    // Criar uma lista(LinkedList) de estudante vazia.
    LinkedList<Estudante> listaEstudantes; // estudantes
    
    // Criar o método construtor da lista.
    public GerenciamentoListaEstudante() {
        listaEstudantes = new LinkedList<>();
    }
    
    // Adicionar um estudante.
    public void add(Estudante estudante) {
        
        // Verificando se um registro já existe,
        // senão adicionar à lista de registros,
        // caso contrário mensagem de exibição de erro.
        if(!find(estudante.getRaEstudante())) {
            listaEstudantes.add(estudante);
        } else {
            // Imprime a mensagem.
            System.out.println("Estudante já cadastrado!!!");
        }
    }
    
    // Procurando um estudante.
    public boolean find(int raEstudante) {
        // Iteração na lista de estudante(listaEstudantes)
        for (Estudante e : listaEstudantes) {            
            // Verificando o registro pelo raEstudante
            if (e.getRaEstudante() == raEstudante) {
                // Se o estudante foi encontrado, imprime a mensagem.
                System.out.println("O estudante foi encontrado: " + e);
                return true;
            }
        }        
        return false;
    }
    
    // Deletar um estudante.
    public void delete(int regRaEstudante) {
        Estudante estudanteDel = null;
        
        // Iteração na lista de estudante(listaEstudantes)
        for (Estudante e2 : listaEstudantes) { 
            // Procurando pelo estudante que será deletado pelo raEstudante.
            if (e2.getRaEstudante() == regRaEstudante) {
                estudanteDel = e2;
            }        
        }
        
        // Se o estudanteDel é nulo, então mostre uma mensagem de erro,
        // caso contrário, remove o registro do estudante da listaEstudantes.
        if (estudanteDel == null) {
            // Mostrando que o estudante não foi encontrado.
            System.out.println("O RA do estudante é inválido!!!");
        } else {
            listaEstudantes.remove(estudanteDel);
            
            // Motrando mensagem de exclusão do registro
            // do estudante realizada com sucesso.
            System.out.println("O registro do estudante"
                      + " foi removido da lista com sucesso!!!");            
        }
    }
    
    // Procurando por um estudante em particular.
    public Estudante findEstudante(int raEstudante) {
        // Iteração na listaEstudantes para encontrar
        // o estudante em particular.
        for (Estudante e : listaEstudantes) {
            //Verificando o estudante pelo seu raEstudante.
            if (e.getRaEstudante() == raEstudante) {
                return e;
            }
        }        
        return null;
    }  
    
    // Atualizar um registro de estudante.
    public void update(int ra, Scanner entrada){
        if (find(ra)){
            Estudante novoEstudante = findEstudante(ra);
            
            //Mostrar uma mensagem.
            System.out.println("Qual é o novo número de RA do estudante? ");
            int raNumero = entrada.nextInt();
            
            //Mostrar uma mensagem.
            System.out.println("Qual é o novo nome do estudante?");
            String nome = entrada.next();             
            
            //Mostrar uma mensagem.
            System.out.println("Qual é o novo telefone do estudante?");
            String fone = entrada.next();            
            
            //Mostrar uma mensagem.
            System.out.println("Qual é o novo email do estudante?");
            String email = entrada.next();           
            
            // Salvar os dados do novo estudante.
            novoEstudante.setRaEstudante(raNumero);
            novoEstudante.setNomeEstudante(nome);
            novoEstudante.setTelefoneEstudante(fone);
            novoEstudante.setEmailEstudante(email);
            
            // Mensagem de sucesso.
            System.out.println("Registro do Estudante atualizado com sucesso!!!");           
        
        } else {
            // Mensagem de erro.
            System.out.println("Registro não foi encontrado na lista do estudante");
        }
    }
    
    // Listar todos os registros de estudante.
    public void display() {
        // Se a lista de estudante está vazia,
        // imprime uma mensagem de vazio. 
        if (listaEstudantes.isEmpty()) {
            System.out.println("A lista de estudantes está vazia ou sem registros\n");        
        }
        // Iteração na listaEstudante
        // com uso de um loop for
        for (Estudante estudante : listaEstudantes) {
            // Imprime cada estudante que está na listaEstudantes.

            String estudantePrint = estudante.toString();
            estudantePrint = estudantePrint.replace("Estudante", "");
            estudantePrint = estudantePrint.replace("{ ", "");
            estudantePrint = estudantePrint.replace("}", "");
            estudantePrint = estudantePrint.replace(", ", "\n");

            System.out.println("--------------------");
            
            System.out.println(estudantePrint);
            
            System.out.println("--------------------\n");
        }
    }       
}
