import java.util.ArrayList;
import java.util.List;

abstract class Employee
{
    private String name;
    private int Id;
    public String data;

    public Employee(String name,int Id)
    {
        this.name=name;//instance variable=local variable
        this.Id=Id;//help to input
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return Id;
    }
     public abstract double calculateSalary();

    @Override
    public String toString()//we are overriding the toString method inorder to give a pattern to print in hte retun statemnt
    {
       return "Employee [name= "+name+",id= "+Id+",salary= "+calculateSalary()+"]";
    }

}
class FullTimeEmployee extends Employee
{
    private double monthlySalary;

    public FullTimeEmployee(String name, int Id, double monthlySalary) {
        super(name, Id);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double calculateSalary()
    {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee
{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate)
    {
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }
    @Override
    public double calculateSalary()
    {
        return hoursWorked*hourlyRate;
    }
}
class PayrollSystem
{
   private ArrayList<Employee> employeeList;
   public PayrollSystem()
   {
       employeeList=new ArrayList<>();
   }
   public void addEmployee(Employee employee)
    {
        employeeList.add(employee);

    }

    public void removeEmployee(int id)
    {
        Employee employeeToRemove=null;
        for(Employee employee:employeeList)
        {
            if(employee.getId()==id)
            {
                employeeToRemove=employee;
                break;
            }
        }
        if (employeeToRemove !=null)
        {
            employeeList.remove(employeeToRemove);
        }
    }

    public void DisplayEmployee()
    {
        for(Employee employee:employeeList)
        {
            System.out.println(employee);
        }

    }
}
public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollsystem=new PayrollSystem();

        FullTimeEmployee emp1=new FullTimeEmployee("vikas",1,234566);
        PartTimeEmployee emp2=new PartTimeEmployee("Raja",2,50,100);
        payrollsystem.addEmployee(emp1);
        payrollsystem.addEmployee(emp2);
        System.out.println("Initial Employees Details");
        payrollsystem.DisplayEmployee();
        System.out.println("Removing Employees");
        payrollsystem.removeEmployee(2);
        System.out.println("Remaining employee Details");
        payrollsystem.DisplayEmployee();
    }
}
