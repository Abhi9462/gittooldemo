import java.io.*;
import java.util.*;

class Employee{
	static String path="d:\\java\\Employees.txt";
	static ArrayList<Object> al=new ArrayList<Object>();
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) throws Exception{

		while(true)
		{
			System.out.println("\nPress 1 to add\nPress 2 to show\nPress 3 to update Salary\nPress 4 to update Name\n"+
				"Press 5 to Remove\nPress 6 to exit\n");

			int num=sc.nextInt();

       switch(num)
       {
		case 1:
			addDetail();
			break;

		case 2:
		    showDetail();
		    break;

		case 3:
		    updateSalary();
		    break;

		case 4:
		    updateName();
		    break;

		case 5:
		    deleteData();
		    break;

		case 6:
			System.exit(0);
		 }
		}	
	}

	static void addDetail(){
		System.out.println("Please enter Name, ID and Salary :");
		sc.nextLine();
		String name=sc.nextLine();
		String id=sc.nextLine();
		String salary=sc.nextLine();

		EmployeeData e1=new EmployeeData(name,id,salary);
		al.add(e1);
		writeObject(al);
	}


	static void writeObject(Object obj)

		{
			try{
				FileOutputStream fos=new FileOutputStream(path);
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(obj);
				oos.close();
			}

			catch(Exception e){
				System.out.println("Exception caught");
			}
		}
		

		static void showDetail(){
			System.out.println("Employee Data\n");

			for(Object e:al)
			{
				System.out.println(e);
			}

	    }


	    static void updateName(){
	    	try{
	    		System.out.println("Please enter your ID\n");
	    		int id=sc.nextInt();
	    		EmployeeData e1=(EmployeeData)al.get(id-1);
	    		System.out.println("Please enter name");
	    		sc.nextLine();
	    		String name=sc.nextLine();
	    		e1.setName(name);
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("No data available");
	    	}
	    	}

	    	 static void updateSalary(){
	    	try{
	    		System.out.println("Please enter your ID\n");
	    		int id=sc.nextInt();
	    		EmployeeData e1=(EmployeeData)al.get(id-1);
	    		System.out.println("Please enter salary");
	    		sc.nextLine();
	    		String salary=sc.nextLine();
	    		e1.setSalary(salary);
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("No data available");
	    	}
	    	}


	    	static void deleteData(){
	    	
	    		System.out.println("Please enter index\n");
	    		int id=sc.nextInt();
	    		al.remove(id-1);
	    		}
	    	  }


class EmployeeData implements Serializable{
	String name;
	String id;
	String salary;

	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return "EmployeeData [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}

	public EmployeeData(String name, String id, String salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
 }