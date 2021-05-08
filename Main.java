import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<Account> accounts = new ArrayList<>();

		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"));
		Menu accountMenu = new Menu("Conta", Arrays.asList("Abrir conta"));

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
			}
		}
		System.out.println("Fim");
	}

}
