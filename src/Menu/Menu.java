package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Employee.Employee;

public class Menu {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);

		ArrayList<Employee> employees = new ArrayList<>();
		int option;

		while (true) {
			System.out.println("\n====================================");
			System.out.println("         MENU FUNCIONÁRIOS          ");
			System.out.println("====================================");
			System.out.println("1 - Cadastrar Funcionário");
			System.out.println("2 - Listar Funcionários");
			System.out.println("3 - Aumentar Salário");
			System.out.println("4 - Sair");
			System.out.println("====================================");
			System.out.print("Escolha uma opção: \n");
			option = read.nextInt();

			switch (option) {
			case 1:
				System.out.println("Digite o ID do funcionário: ");
				int id = read.nextInt();

				read.nextLine();

				System.out.println("Digite o NOME do funcionário: ");
				String name = read.nextLine().toUpperCase();

				System.out.println("Digite o CARGO do funcionário: ");
				String position = read.nextLine().toUpperCase();

				System.out.println("Digite o SALÁRIO do funcionário: ");
				double salary = read.nextDouble();
				read.nextLine();

				System.out.println("Digite o DEPARTAMENTO do funcionário: ");
				String department = read.nextLine().toUpperCase();

				Employee newEmployee = new Employee(id, name, position, salary, department);
				employees.add(newEmployee);
				System.out.println("\n✅ Funcionário cadastrado com sucesso!");
				break;
			case 2:

				if (employees.isEmpty()) {
					System.out.println("\n❗ Nenhum funcionário cadastrado.");
				} else {
					System.out.println("\n📋 Lista de Funcionários:");
					for (Employee employee : employees) {
						employee.displayInformation();
					}
				}

				break;
			case 3:
				System.out.println("Digite o ID do funcionário que quer aumentar o salário: ");
				int idSearched = read.nextInt();
				read.nextLine();

				Employee found = null;
				for (Employee f : employees) {
					if (f.getId() == idSearched) {
						found = f;
						break;
					}
				}

				if (found != null) {
					System.out.println("Digite o percentual de aumento (%): ");
					double percentage = read.nextDouble();
					found.increaseSalary(percentage);
					System.out.println("\n💸 Salário atualizado com sucesso!");
				} else {
					System.out.println("\n❌ Funcionário não encontrado!");
				}
				break;
			default:
				about();
				read.close();
				System.exit(0);
			}
		}

	}

	public static void about() {
		System.out.println("\n*********************************************************");
		System.out.println("👋 Saindo do sistema... Até logo!\n");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Bruno Godoy - brunogodoy29@hotmail.com");
		System.out.println("https://github.com/Brunogodoy2911");
		System.out.println("*********************************************************");
	}

}
