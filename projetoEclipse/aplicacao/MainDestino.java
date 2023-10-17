package aplicacao;

import java.util.Scanner;
import dao.DestinosDAO;
import model.Destinos;

public class MainDestino {
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		DestinosDAO destinosDAO = new DestinosDAO();
		
		int opcao = 0, id = 0; 
		
		String data_Destino = "", nome_Destino = "";
		float  valor_Destino;
		
		do {
			
			System.out.println("\n============================== Destino =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite a data do destino:");
				data_Destino = s.nextLine();
				System.out.println("Digite o nome do destino:");
				nome_Destino = s.nextLine();
				System.out.println("Digite o valor:");
				valor_Destino = s.nextFloat();
				
				
			Destinos destinos1 = new Destinos(data_Destino, nome_Destino, valor_Destino);
				
				destinosDAO.create(destinos1);
				break;
			case 2:
				
				for (Destinos u : destinosDAO.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				
				System.out.println("Digite id do destino:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data destino:");
				data_Destino = s.nextLine();
				System.out.println("Digite o nome do destino:");
				nome_Destino = s.nextLine();
				System.out.println("Digite o valor do destino:");
			    valor_Destino = s.nextFloat();
			    s.nextLine();
				
				Destinos destinos2 = new Destinos(id, data_Destino, nome_Destino , valor_Destino);
				
				destinosDAO.update(destinos2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				destinosDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Destinos destinos3 = destinosDAO.readById(id);
				
				System.out.println(destinos3.toString());
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

	}



