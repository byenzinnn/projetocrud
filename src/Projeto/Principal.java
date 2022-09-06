package Projeto;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Conector conecta = new Conector();
		boolean continua = true;
		char maisoper = 's'; 
		int op, idCar, anoCar = 0;
		String marca = null, modelo = null;
		conecta.Dbconnect();
		Carro carro = new Carro(1, "ford", "delrey", 98);
		conecta.inseriCarro(carro);
		
		Scanner sc = new Scanner(System.in);		
		System.out.print("=========== Cadastro de Carros =========== \n" );
	
		while(continua) {
			System.out.print("Escolha uma das Op��es: \n");
			System.out.println("1 Exibir Carros " );
			System.out.println("2 Excluir Carros " );
			System.out.println("3 Atualizar Carros " );
			System.out.println("4 Inserir Carros " );
			System.out.println("5 Abandonar a Opera��o \n" );
			
			op = sc.nextInt(); 
			if(op >= 5) {
				continua = false;
				sc.close();
			} else {
				  switch(op) {			
						case 1:
							conecta.selecionaCarro();
							System.out.print("\n Deseja continuar: s/n ");
							maisoper = sc.next().charAt(0);
							if (maisoper != 's') {
								continua = false;
							}
							break;
						case 2:
							System.out.println("Informe o id do Carro para Excluir: ");
              conecta.excluiCarro(sc.nextInt()); 
              				System.out.println("\n Deseja continuar: s/n ");
              				maisoper = sc.next().charAt(0);
              				if (maisoper != 's') {
              					continua = false;
              				}
              				break;
						case 3: 
							System.out.println("Informe o id do Carro para Alterar: ");
							idCar = sc.nextInt();
							System.out.println("Informe a Alteração a marca do Carro: ");
							marca = sc.next();
							System.out.println("Informe a Alteração ao modelo do carro");
							modelo = sc.next();
							System.out.println("Informe a Alteração do ano do carro");
							anoCar = sc.nextInt();
							conecta.atualizaCarro(idCar, marca, modelo, anoCar); 							
							System.out.println("\n Deseja continuar: s/n ");
							maisoper = sc.next().charAt(0);
							if (maisoper != 's') {
								continua = false;
							}
						case 4:
							System.out.println("Informe o id do Carro para Alterar: ");
							idCar = sc.nextInt();
							System.out.println("Informe a Alteração a marca do Carro: ");
							marca = sc.next();
							System.out.println("Informe a Alteração ao modelo do carro");
							modelo = sc.next();
							System.out.println("Informe a Alteração do ano do carro");
							anoCar = sc.nextInt();
							String marcaCarro = sc.nextLine();
							Carro c = new Carro(idCar, marca, modelo, anoCar);
							conecta.inseriCarro(c);
							System.out.println("\n Deseja continuar: s/n ");
							maisoper = sc.next().charAt(0);
							if (maisoper != 's') {
								continua = false;
							}
						default: 				  
				 }		
			}				
		}					
	}
}
