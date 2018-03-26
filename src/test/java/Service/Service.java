package Service;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entity.Employee;

public class Service {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeService");
	    EntityManager em = factory.createEntityManager();
	    EmployeeService service = new EmployeeService(em);
	    em.getTransaction().begin();
	    Employee emp = service.createEmployee(UUID.randomUUID().toString(), "jhon", 3500);
	    em.getTransaction().commit();
	    System.out.println("persisted" + emp);
	    List<Employee> list = service.findAll();
	    for(Employee partner : list) {
	    	System.out.println(partner);
	    }
	    em.getTransaction().begin();
	    Employee ee = service.raiseEmployee("158", 2500);
	    em.getTransaction().commit();
	    System.out.println("update" + ee);
	    em.getTransaction().begin();
	    service.removeEmployee("158");
	    em.getTransaction().commit();
	    System.out.println("remove employee that's id equal 158 !");
	    em.close();
	    factory.close();
	}

}
