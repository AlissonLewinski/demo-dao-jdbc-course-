package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		boolean stop = false;
		
		while(stop == false) {
			
			System.out.println();
			System.out.println("=====Options=====");
			System.out.println("1 - Insert");
			System.out.println("2 - Update");
			System.out.println("3 - Delete By Id");
			System.out.println("4 - Find By Id");
			System.out.println("5 - Find All");
			System.out.println("6 - End Application");
			System.out.print(":: ");
			int option = sc.nextInt();
			
			switch(option){
			
			case 1: 
				System.out.print("Enter department name: ");
				String depName = sc.next();
				
				depDao.insert(new Department(null, depName));
				System.out.println("New department inserted: " + depName);
				break;
			
			case 2:
				System.out.print("|Update|Enter id: ");
				int updateId = sc.nextInt();
				
				Department dep = depDao.findById(updateId);
				String oldName = dep.getName();
				
				System.out.print("Enter new name: ");
				String newName = sc.next();
				dep.setName(newName);
				
				depDao.update(dep);
				System.out.println("Old name: " + oldName + "| New name: " + newName);
				break;
				
			case 3:
				System.out.print("|Delete|Enter id: ");
				int deleteId = sc.nextInt();
				
				depDao.deleteById(deleteId);
				System.out.println("Deleted id: " + deleteId);
				break;
				
			case 4:
				System.out.print("|Find|Enter id: ");
				int findId = sc.nextInt();
				
				Department findDep = depDao.findById(findId);
				if(findDep != null) {
					System.out.println("Department: " + findDep);
				}
				else {
					System.out.println("No department found in id: " + findId);
				}
				break;
				
			case 5:
				List<Department> list = depDao.findAll();
				
				System.out.println("All departments: ");
				list.forEach(System.out::println);
				break;
				
			case 6:
				stop = true;
				break;
			}
			
		}
		System.out.println();
		System.out.println("Application ended");
		sc.close();
	}
}
