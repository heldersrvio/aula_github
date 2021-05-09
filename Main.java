import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<Account> accounts = new ArrayList<>();

		while (true) {
			Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"));
			Menu accountMenu = new Menu("Conta", Arrays.asList("Abrir conta", "Deletar conta", "Realizar saque"));

			int firstSelection = mainMenu.getSelection();
			System.out.println(firstSelection + " foi selecionada");
			if (firstSelection == 1) {
				int secondSelection = accountMenu.getSelection();
				if (secondSelection == 1) {
					System.out.println("Informe o id do dono da conta: ");
					Scanner s = new Scanner(System.in);
					String str = s.nextLine();
					Account newAccount = new Account(str);

					accounts.add(newAccount);
					System.out.println("Nova conta foi adicionada.");
				} else if (secondSelection == 2) {
					System.out.println("Informe o id do dono da conta: ");
					Scanner s = new Scanner(System.in);
					String str = s.nextLine();

					boolean found = false;
					for (int i = 0; i < accounts.size(); i++) {
						if (accounts.get(i).getClientId().equals(str)) {
							found = true;
							accounts.remove(i);
							break;
						}
					}
					if (!found) {
						System.out.println("A conta não foi encontrada.");
					} else {
						System.out.println("Conta deletada com sucesso.");
					}
				}
			}else if(firstSelection == 3){
				int secondSelection = accountMenu.getSelection();
				if(secondSelection == 3){
					System.out.println("Informe o id do dono da conta: ");
					Scanner s = new Scanner(System.in);
					String str = s.nextLine();

					int conta = 0;
					boolean found = false;
					for (int i = 0; i < accounts.size(); i++) {
						if (accounts.get(i).getClientId().equals(str)) {
							conta = i;
							found = true;
							break;
						}
					}
					if (!found) {
						System.out.println("A conta não foi encontrada.");
					} else {
						System.out.println("Informe o valor do saque: ");
						Scanner v = new Scanner(System.in);
						double value = v.nextDouble();
						if(accounts.get(conta).getSaldo() < value){
							System.out.println("Saldo insuficiente.");
						}else{
							accounts.get(conta).deposit(value*(-1));
							System.out.println("Foram retirados " + value + " créditos.");
						}
					}
				}else if(secondSelection == 4){
					System.out.println("Informe o id do dono da conta: ");
					Scanner s = new Scanner(System.in);
					String str = s.nextLine();

					int conta = 0;
					boolean found = false;
					for (int i = 0; i < accounts.size(); i++) {
						if (accounts.get(i).getClientId().equals(str)) {
							conta = i;
							found = true;
							break;
						}
					}
					if (!found) {
						System.out.println("A conta não foi encontrada.");
					} else {
						System.out.println("Seu saldo é de " + accounts.get(conta).getSaldo() + " créditos.");
					}
				}
			}
		}
	}

}
