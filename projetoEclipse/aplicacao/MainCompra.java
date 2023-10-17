package aplicacao;

import java.util.Scanner;
import dao.ClienteDAO;
import dao.CompraDAO;
import dao.DestinosDAO;
import model.Cliente;
import model.Compra;
import model.Destinos;

public class MainCompra {
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		CompraDAO compraDAO = new CompraDAO();
		DestinosDAO destinosDAO = new DestinosDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		int opcao = 0, id = 0; 
		
		String  data_Compra = "";
	   float total_Compra;
	   
		
		
		do {
			
			System.out.println("\n============================== Compra =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				
				System.out.println("Digite a data da compra:");
				data_Compra = s.nextLine();
				System.out.println("Digite o total da compra:");
				total_Compra = s.nextFloat();
				s.nextLine();
				System.out.println("Digite o id do cliente:");
				int id_cliente = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do destino:");
				int id_destino = s.nextInt();
				s.nextLine();
				
				Cliente cliente1 = clienteDAO.readById(id_cliente);
				Destinos destinos1 = destinosDAO.readById(id_destino);
				
				Compra compra1 = new Compra(data_Compra, total_Compra, cliente1, destinos1);
				
			compraDAO.create(compra1);
				break;
			case 2:
				
				for (Compra u : compraDAO.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id da compra:");
				int id_compra = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data da compra:");
				data_Compra = s.nextLine();
				System.out.println("Digite o total da compra:");
				total_Compra = s.nextFloat();
				s.nextLine();
				System.out.println("Digite o id do cliente:");
				int id_cliente1 = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do destino:");
				int id_destino1 = s.nextInt();
				s.nextLine();
				
				Cliente cliente2 = clienteDAO.readById(id_cliente1);
				Destinos destinos2 = destinosDAO.readById(id_destino1);
				
				Compra compra2 = new Compra(id_compra, data_Compra, total_Compra, cliente2, destinos2);
				
				compraDAO.update(compra2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				compraDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Compra compra3 = compraDAO.readById(id);
				
				System.out.println(compra3.toString());
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

	}


