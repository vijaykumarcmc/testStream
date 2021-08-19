package test.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		Employee e1 = new Employee(1, "test");
		Employee e2 = new Employee(2, "xyz");
		Employee e3 = new Employee(3, "pqr");
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);

		Map<Integer, String> hashMap = empList.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
		System.out.println(hashMap);

		Map<String, Employee> hashMap2 = empList.stream()
				.collect(Collectors.toMap(Employee::getName, Function.identity()));
		System.out.println(hashMap2);

	}

}

class Employee {
	private int id;
	private String name;

	public Employee() {

	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
