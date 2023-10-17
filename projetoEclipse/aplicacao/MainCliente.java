package aplicacao;

import java.util.Scanner;
import dao.ClienteDAO;
import model.Cliente;


public class MainCliente {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ClienteDAO clienteDAO = new ClienteDAO();
		
		int opcao = 0, id = 0; 
		
		String nome = "", email = "", senha = "", telefone = "";
		
		
		do {
			
			System.out.println("\n============================== Cliente =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite a senha:");
				senha = s.nextLine();
				System.out.println("Digite o telefone:");
				telefone = s.nextLine();
				
				
				Cliente cliente1 = new Cliente(email, nome, senha, telefone);
				
				clienteDAO.create(cliente1);
				break;
			case 2:
				
				for (Cliente u : clienteDAO.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite o id:");
				id = s.nextInt();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite a senha:");
				senha = s.nextLine();
				System.out.println("Digite a telefone:");
				telefone = s.nextLine();
				
				
				Cliente cliente2 = new Cliente(id, email, nome, senha, telefone);
				
				clienteDAO.update(cliente2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				clienteDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Cliente cliente3 = clienteDAO.readById(id);
				
				System.out.println(cliente3.toString());
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

	}
