import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		List<Account> accounts = new ArrayList<>();
		List<Client> client = new ArrayList<>();

		while (true) {
			Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"));
			Menu accountMenu = new Menu("Conta", Arrays.asList("Abrir conta", "Deletar conta"));
			Menu clientMenu = new Menu("Cliente", Arrays.asList("Cadastrar Cliente", "Deletar Cliente"));

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
			}
//-------------------------------------------------------------------------------------------------------
			else if (firstSelection == 2) {
				int secondSelection = clientMenu.getSelection();
				if (secondSelection == 1) {
					System.out.println("Informe o id do cliente: ");
					Scanner s = new Scanner(System.in);
					String str = s.nextLine();

					boolean found = false;
					for (int i = 0; i < accounts.size(); i++) {
						if (accounts.get(i).getClientId().equals(str)) {
							found = true;
							break;
						}
					}

					if (found) {
						System.out.println("Conta encontrada !");
						System.out.println("Digite o nome do cliente: ");
						String name = s.nextLine();
						System.out.println("Digite a senha do cliente: ");
						String password = s.nextLine();
						Client newClient = new Client(name, password);
						
						client.add(newClient);
						System.out.println("Novo cliente adicionado !");
					}

					if (!found) {
						System.out.println("Conta não encontrada !");
					}

				} else if (secondSelection == 2) {
					System.out.println("Ainda não implementado");
				}
			}
		}
	}
}
