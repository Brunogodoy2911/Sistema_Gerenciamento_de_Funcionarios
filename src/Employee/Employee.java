package Employee;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Employee {

	private int id;
	private String name;
	private String position;
	private double salary;
	private String department;

	public Employee(int id, String name, String position, double salary, String department) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void increaseSalary(double porcentage) {
		double currentSalary = getSalary();
		double newSalary = currentSalary + (currentSalary * porcentage / 100);

		setSalary(newSalary);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void displayInformation() {
		NumberFormat nfCoin = NumberFormat.getCurrencyInstance();

		System.out.println("\n***************************************************");
		System.out.println("                   FUNCIONARIO                  ");
		System.out.println("***************************************************");
		System.out.printf("Id: %d\n", getId());
		System.out.printf("Nome: %s\n", getName());
		System.out.printf("Cargo: %s\n", getPosition());
		System.out.printf("Salário: %s%n\n", nfCoin.format(getSalary()));
		System.out.printf("Departamento: %s\n", getDepartment());
		System.out.println("***************************************************");
	}

	public static boolean checkId(int id, ArrayList<Employee> employees) {

		for (Employee employee : employees) {
			if (employee.getId() == id) {
				System.out.println("\n⚠️ Funcionário com ID \"" + id + "\" já existe.");
				return false;
			}
		}

		return true;

	}

	public static void removeById(ArrayList<Employee> employees, Scanner read) {
		System.out.println("Digite o ID do funcionário que deseja remover: ");

		try {
			int idRemove = read.nextInt();
			read.nextLine();

			boolean found = false;
			Iterator<Employee> iterator = employees.iterator();

			while (iterator.hasNext()) {
				Employee employee = iterator.next();
				if (employee.getId() == idRemove) {
					if (confirmAction(read)) {
						iterator.remove();
						System.out.println("\n✅ Funcionário com ID \"" + idRemove + "\" removido com sucesso.");
						found = true;
						break;
					} else {
						found = true;
						System.out.println("\n❌ A exclusão não foi prosseguida!");
						break;
					}

				}
			}

			if (!found) {
				System.out.println("\n❌ Funcionário com ID \"" + idRemove + "\" não encontrado.");
			}
		} catch (InputMismatchException e) {
			System.out.println("⚠️ ID inválido. Certifique-se de digitar um número inteiro.");
			read.nextLine();
		}

	}

	public static void updateEmployeeById(ArrayList<Employee> employees, Scanner read) {
		System.out.println("Digite o ID do funcionário que deseja atualizar: ");

		try {
			int idToUpdate = read.nextInt();
			read.nextLine();

			boolean found = false;

			for (Employee employee : employees) {
				if (employee.getId() == idToUpdate) {
					found = true;

					System.out.println("\n👤 Funcionário encontrado:");
					System.out.println("Nome atual: " + employee.getName());
					System.out.println("\nDeseja alterar o nome? (S - sim | N - não): ");
					if (read.nextLine().trim().equalsIgnoreCase("s")) {
						System.out.println("Novo nome: ");
						employee.setName(read.nextLine());
					}

					System.out.println("Cargo atual: " + employee.getPosition());
					System.out.println("Deseja alterar o cargo? (S - sim | N - não): ");
					if (read.nextLine().trim().equalsIgnoreCase("s")) {
						System.out.print("Novo cargo: ");
						employee.setPosition(read.nextLine());
					}

					System.out.println("Salário atual: R$" + employee.getSalary());
					System.out.println("Deseja alterar o salário? (S - sim | N - não): ");
					if (read.nextLine().trim().equalsIgnoreCase("s")) {
						System.out.print("Novo salário: ");
						double newSalary = read.nextDouble();
						employee.setSalary(newSalary);
						read.nextLine();
					}

					System.out.println("\n✅ Funcionário atualizado com sucesso!");
					break;
				}
			}

			if (!found) {
				System.out.println("\n❌ Funcionário com ID \"" + idToUpdate + "\" não encontrado.");
			}

		} catch (InputMismatchException e) {
			System.out.println("⚠️ Entrada inválida. Certifique-se de digitar os valores corretamente.");
			read.nextLine();
		}
	}

	public static void listAllEmployees(ArrayList<Employee> employees) {
		System.out.println("\n📋 Lista de todos os Funcionários:");
		for (Employee employee : employees) {
			employee.displayInformation();
		}
	}

	public static void filterById(ArrayList<Employee> employees, Scanner read) {
		System.out.println("Digite o id do funcionário: ");

		try {
			int idSearched = read.nextInt();
			read.nextLine();

			boolean found = false;
			for (Employee employee : employees) {
				if (employee.getId() == idSearched) {
					employee.displayInformation();
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("\n❌ Funcionário com ID \"" + idSearched + "\" não encontrado.");
			}
		} catch (InputMismatchException e) {
			System.out.println("⚠️ ID inválido. Certifique-se de digitar um número inteiro.");
			read.nextLine();
		}

	}

	public static void filterByName(ArrayList<Employee> employees, Scanner read) {
		System.out.println("Digite o nome do funcionário: ");
		String nameSearched = read.nextLine().trim().toUpperCase();

		boolean found = false;
		for (Employee employee : employees) {
			if (employee.getName().equals(nameSearched)) {
				employee.displayInformation();
				found = true;
			}
		}

		if (!found) {
			System.out.println("\n❌ Funcionário com NOME \"" + nameSearched + "\" não encontrado.");
		}

	}

	public static void filterByPosition(ArrayList<Employee> employees, Scanner read) {
		System.out.println("Digite o cargo do funcionário: ");
		String positionSearched = read.nextLine().trim().toUpperCase();

		boolean found = false;
		for (Employee employee : employees) {
			if (employee.getPosition().equals(positionSearched)) {
				employee.displayInformation();
				found = true;
			}
		}

		if (!found) {
			System.out.println("\n❌ Funcionário com CARGO \"" + positionSearched + "\" não encontrado.");
		}
	}

	public static void filterBySalary(ArrayList<Employee> employees, Scanner read) {
		System.out.println("Digite o salário do funcionário: ");

		try {
			double salarySearched = read.nextDouble();
			read.nextLine();

			boolean found = false;
			for (Employee employee : employees) {
				if (Double.compare(employee.getSalary(), salarySearched) == 0) {
					employee.displayInformation();
					found = true;
				}
			}

			if (!found) {
				NumberFormat nfCoin = NumberFormat.getCurrencyInstance();
				System.out.println(
						"\n❌ Funcionário com SALÁRIO \"" + nfCoin.format(salarySearched) + "\" não encontrado.");
			}
		} catch (InputMismatchException e) {
			System.out.println("⚠️ SALÁRIO inválido. Certifique-se de digitar o salário corretamente.");
			read.nextLine();
		}

	}

	public static void filterByDepartment(ArrayList<Employee> employees, Scanner read) {
		System.out.println("Digite o departamento do funcionário: ");

		try {
			String departmentSearched = read.nextLine().trim().toUpperCase();

			boolean found = false;
			for (Employee employee : employees) {
				if (employee.getDepartment().equals(departmentSearched)) {
					employee.displayInformation();
					found = true;
				}
			}

			if (!found) {
				System.out.println("\n❌ Funcionário com DEPARTAMENTO \"" + departmentSearched + "\" não encontrado.");
			}
		} catch (InputMismatchException e) {
			System.out.println("⚠️ DEPARTAMENTO inválido. Certifique-se de digitar o departamento corretamente.");
		}

	}

	public static boolean confirmAction(Scanner read) {

		System.out.println("Deseja realmente proseguir com esta ação? (S - sim | N - não)");
		String selectedChoice = read.nextLine().trim();

		return selectedChoice.equalsIgnoreCase("s");

	}

}
