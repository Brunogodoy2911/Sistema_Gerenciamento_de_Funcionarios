package Employee;

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
		System.out.println("\n***************************************************");
		System.out.println("                   FUNCIONARIO                  ");
		System.out.println("***************************************************");
		System.out.printf("Id: %d\n", getId());
		System.out.printf("Nome: %s\n", getName());
		System.out.printf("Cargo: %s\n", getPosition());
		System.out.printf("Salário: R$ %.2f\n", getSalary());
		System.out.printf("Departamento: %s\n", getDepartment());
		System.out.println("***************************************************");
	}
}
