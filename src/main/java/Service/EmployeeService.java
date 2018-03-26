package Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entity.Employee;

public class EmployeeService {
	
protected EntityManager em;
	
	public EmployeeService(EntityManager em) {
		this.em = em;
	}
   
	public Employee createEmployee(String id, String name, int salary) {
		Employee emp = new Employee(id);
		emp.setName(name);
		emp.setSalary(salary);
		em.persist(emp);
		return emp;
	}
	
	public void removeEmployee(String id) {
		Employee emp = findOne(id);
		if(emp != null)
			em.remove(emp);
	}
	
	public Employee raiseEmployee(String id, int raise) {
		Employee emp = findOne(id);
		if(emp != null)
			emp.setSalary(emp.getSalary() + raise);
		return emp;
	}
	
	public Employee findOne(String id) {
		return em.find(Employee.class, id);
	}
	
	public List<Employee> findAll() {
	    TypedQuery<Employee> query = em.createQuery("select * from employee", Employee.class);
	    List<Employee> list = query.getResultList();
	    return list;
	} 
}
