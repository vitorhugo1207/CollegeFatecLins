package br.edu.fateclins.crudlistestudante;

import br.edu.fateclins.crudlistestudante.model.Estudante;
import br.edu.fateclins.crudlistestudante.model.Professor;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {        
           
        GerenciamentoListaEstudante ge = new GerenciamentoListaEstudante();
        GerenciamentoListaProfessor gp = new GerenciamentoListaProfessor();
        
        Estudante estudante = new Estudante();
        Professor professor = new Professor();
        
        // Adicionar os valores aos atributos do objeto estudante.        
        estudante.setRaEstudante(2);
        estudante.setNomeEstudante("Carlos Oliveira");
        estudante.setTelefoneEstudante("(014)99123-4567");
        estudante.setEmailEstudante("carlos.oliveira@fatec.sp.gov.br");
        
        // Adicionar os valores aos atributos do objeto professor.
        professor.setRmProfessor(1);
        professor.setNomeProfessor("Alex Batista");
        professor.setTelefoneProfessor("(016)99012-3456");
        professor.setEmailProfessor("alex@fatec.sp.gov.br");
        
        // Adicionar o estudante na listaEstudante.
        ge.add(estudante);
        gp.add(professor);
        
        // Criação do objeto Scanner para ler a entrada de dados.
        Scanner input = new Scanner(System.in);
        
        // Criação da variável inteira de opção.
        int option = 0;
        
        // Laço do-while para iteração da opção.
        do {
            menu();
            option = input.nextInt();
            System.out.println("\n"); 
            
            switch (option) {
                    case 1: 
                        menuEstudante();
                        option = input.nextInt();
                        System.out.println("\n"); 
                                    
                        // Switch case - Estudante
                        switch (option) {
                            case 1:
                                System.out.print("Entre com a RA do Estudante: ");
                                int raEst = input.nextInt();
                                input.nextLine();

                                System.out.print("Entre com o nome do Estudante: ");
                                String nomeEst = input.nextLine();                
                                                
                                System.out.print("Entre com o telefone do Estudante: ");
                                String foneEst = input.nextLine();                
                                
                                System.out.print("Entre com o email do Estudante: ");
                                String emailEst = input.nextLine(); 
                                
                                estudante = new Estudante(raEst, nomeEst, foneEst, emailEst);
                                
                                ge.add(estudante);
                                
                                System.out.println(estudante.toString());
                            break;

                            case 2:
                                System.out.print("Informe o RA do Estudante que será excluído: ");
                                int raId = input.nextInt();

                                ge.delete(raId);

                            break;

                            case 3:
                                System.out.print( "Informe o RA do Estudante que será alterado: ");

                                int raIdNo = input.nextInt();
                                
                                ge.update(raIdNo, input);

                            break;

                            case 4:
                                System.out.print("Qual é o RA do Estudante: ");
                                int raIdEst = input.nextInt();
                                
                                if (!ge.find(raIdEst)) {
                                    System.out.println("RA do Estudante não encontrado ou não existe!!!\n");
                                }

                            break;

                            case 5:
                                ge.display();
                            break;

                            case 11:
                                System.out.println("\nRetorna Ao Menu Principal.\n");
                            break;

                            default:
                                System.out.println("\nEntrada Inválida\n");
                            break;
                        }       
                    break;

                case 2: 
                    menuProfessor();          
                    option = input.nextInt();
                    System.out.println("\n"); 
                    
                    switch (option) {
                        case 1:
                            System.out.print("Entre com a RA do Professor: ");
                            int rmProf = input.nextInt();
                            input.nextLine();

                            System.out.print("Entre com o nome do Professor: ");
                            String nomeProf = input.nextLine();                
                                            
                            System.out.print("Entre com o telefone do Professor: ");
                            String foneProf = input.nextLine();                
                            
                            System.out.print("Entre com o email do Professor: ");
                            String emailProf = input.nextLine(); 
                            
                            professor = new Professor(rmProf, nomeProf, foneProf, emailProf);
                            
                            gp.add(professor);
                            
                            System.out.println(professor.toString());

                        break;

                        case 2:
                            System.out.print("Informe o RM do Professor que será excluído: ");
                            int rmId = input.nextInt();

                            gp.delete(rmId);

                        break;

                        case 3:
                            System.out.print( "Informe o RA do Estudante que será alterado: ");

                            int rmIdNo = input.nextInt();
                            
                            gp.update(rmIdNo, input);

                        break;

                        case 4:
                            System.out.print("Qual é o RA do Estudante: ");
                            int raIdEst = input.nextInt();
                            
                            if (!gp.find(raIdEst)) {
                                    System.out.println("RA do Estudante não encontrado ou não existe!!!\n");
                            }

                        break;
                        
                        case 5:    
                            gp.display();
                        break;

                        case 11:
                            System.out.println("\nRetorna Ao Menu Principal.\n");
                        break;
                        
                        default:
                            // Imprime a mensagem.
                            System.out.println("\nEntrada Inválida\n");
                        break; 
                    }
                break; 

                case 0:
                    System.out.println("\nObrigado por usar o programa. Até mais!\n");
                    System.exit(0);
                break;
            }
        }
        while (option != 0);
        System.out.println("\n");
    }
    
    // Método 2
    // Menu - Menu estático para exibir opções.
    public static void menu()
    {
            // Imprimir instruções para exibir o menu no console
            System.out.println("-=-=-=-=-=-=-=-=-=-= MENU PRINCIPAL =-=-=-=-=-=-=-=-=-=-");
            System.out.println("1: Estudante");
            System.out.println("2: Professor");            
            System.out.println("0: Sair do Programa");
            System.out.print("Escolha uma opção : ");           
    }
    
    // Método 3
    // Menu - Menu estático para exibir opções.
    public static void menuEstudante()
    {
            // Imprimir instruções para exibir o menu no console
            System.out.println("-=-=-=-=-=-=-=-=-=-= MENU ESTUDANTE =-=-=-=-=-=-=-=-=-=-");
            System.out.println("1: Adicionar Estudante");
            System.out.println("2: Remover Estudante");
            System.out.println("3: Editar Estudante");
            System.out.println("4: Pesquisar Estudante");
            System.out.println("5: Mostrar Estudante");
            System.out.println("11: Voltar");
            System.out.print("Escolha uma opção : ");         
    }      
    
    // Método 4
    // Menu - Menu estático para exibir opções.
    public static void menuProfessor()
    {
            // Imprimir instruções para exibir o menu no console
            System.out.println("-=-=-=-=-=-=-=-=-=-= MENU PROFESSOR =-=-=-=-=-=-=-=-=-=-");
            System.out.println("1: Adicionar Professor");
            System.out.println("2: Remover Professor");
            System.out.println("3: Editar Professor");
            System.out.println("4: Pesquisar Professor");
            System.out.println("5: Mostrar Professor");
            System.out.println("11: Voltar");
            System.out.print("Escolha uma opção : ");            
    }
}
