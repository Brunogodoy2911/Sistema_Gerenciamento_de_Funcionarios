package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Employee.Employee;

public class Menu {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);

		ArrayList<Employee> employees = new ArrayList<>();

		Employee novoFuncionario = new Employee(2, "Bruno", "Desenvolvedor Júnior", 1200.90, "T.I");
		employees.add(novoFuncionario);

		int option;

		while (true) {
			System.out.println("\n====================================");
			System.out.println("         MENU FUNCIONÁRIOS          ");
			System.out.println("====================================");
			System.out.println("1 - Cadastrar Funcionário");
			System.out.println("2 - Remover Funcionário");
			System.out.println("3 - Listar Funcionários");
			System.out.println("4 - Atualizar Funcionário");
			System.out.println("5 - Aumentar Salário");
			System.out.println("6 - Sair");
			System.out.println("====================================");
			System.out.print("Escolha uma opção: \n");
			option = read.nextInt();

			switch (option) {
			case 1:
				System.out.println("Digite o ID do funcionário: ");
				int id = read.nextInt();

				if (!Employee.checkId(id, employees)) {
					break;
				}

				read.nextLine();

				System.out.println("Digite o NOME do funcionário: ");
				String name = read.nextLine().trim().toUpperCase();

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
				Employee.removeById(employees, read);
				break;
			case 3:
				if (employees.isEmpty()) {
					System.out.println("\n❗ Nenhum funcionário cadastrado.");
				} else {
					read.nextLine();

					System.out.println("\n====================================");
					System.out.println("         Deseja Listar         ");
					System.out.println("====================================");
					System.out.println("1 - Todos");
					System.out.println("2 - Por ID");
					System.out.println("3 - Por Nome");
					System.out.println("4 - Por Cargo");
					System.out.println("5 - Por Salário");
					System.out.println("6 - Por Departamento");
					System.out.println("7 - Sair");
					System.out.println("====================================");
					System.out.print("Escolha uma opção: \n");
					int filterOption = read.nextInt();
					read.nextLine();

					switch (filterOption) {
					case 1:
						Employee.listAllEmployees(employees);
						break;
					case 2:
						Employee.filterById(employees, read);
						break;
					case 3:
						Employee.filterByName(employees, read);
						break;
					case 4:
						Employee.filterByPosition(employees, read);
						break;
					case 5:
						Employee.filterBySalary(employees, read);
						break;
					case 6:
						Employee.filterByDepartment(employees, read);
						break;
					default:
						break;
					}

				}

				break;
			case 4:
				Employee.updateEmployeeById(employees, read);
				break;
			case 5:
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
