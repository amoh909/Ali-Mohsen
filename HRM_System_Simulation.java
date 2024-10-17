import java.util.Scanner;

class Employee {
    private int employee_ID;
    private String name;
    private String email;
    private String department;
    private double salary;

    public Employee(int employee_ID, String name, String email, String department, double salary) {
        this.employee_ID = employee_ID;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    public int getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(int eID) {
        employee_ID = eID;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String m) {
        email = m;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String d) {
        department = d;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double s) {
        salary = s;
    }

    public double calculateBonus() {
        return salary;
    }

    public String toString() {
        return String.format("ID: %d\nName: %s\nEmail: %s\nDepartment: %s\nSalary: %f", getEmployee_ID(), getName(),
                getEmail(), getDepartment(), getSalary());
    }
}

class Mananger extends Employee {
    private String department_head;

    public Mananger(int employee_ID, String name, String email, String department, double salary,
            String department_head) {
        super(employee_ID, name, email, department, salary);
        this.department_head = department_head;
    }

    public String getDepartment_head() {
        return department_head;
    }

    public void setDepartment_head(String dh) {
        department_head = dh;
    }

    public double calculateBonus() {
        return getSalary() * 3;
    }

    public String toString() {
        return String.format("ID: %d\nName: %s\nEmail: %s\nDepartment: %s\nSalary: %.0f\nDepartment Head: %s",
                getEmployee_ID(), getName(),
                getEmail(), getDepartment(), getSalary(), getDepartment_head());
    }
}

class Engineer extends Employee {
    public Engineer(int employee_ID, String name, String email, String department, double salary, String skills) {
        super(employee_ID, name, email, department, salary);
        this.skills = skills;
    }

    private String skills;

    public String getSkills() {
        return skills;
    }

    public void setSkills(String sk) {
        skills = sk;
    }

    public double calculateBonus() {
        return getSalary() * 2.5;
    }

    public String toString() {
        return String.format("ID: %d\nName: %s\nEmail: %s\nDepartment: %s\nSalary: %.0f\nSkill: %s", getEmployee_ID(),
                getName(),
                getEmail(), getDepartment(), getSalary(), getSkills());
    }
}

class Salespersons extends Employee {
    private double sales_target;

    public Salespersons(int employee_ID, String name, String email, String department, double salary,
            double sales_target) {
        super(employee_ID, name, email, department, salary);
        this.sales_target = sales_target;
    }

    public double getSales_target() {
        return sales_target;
    }

    public void setSales_target(double st) {
        sales_target = st;
    }

    public double calculateBonus() {
        return getSalary() * 2;
    }

    public String toString() {
        return String.format("ID: %d\nName: %s\nEmail: %s\nDepartment: %s\nSalary: %.0f\nSales Targer: %.0f",
                getEmployee_ID(), getName(),
                getEmail(), getDepartment(), getSalary(), getSales_target());
    }
}

class HRM {
    Employee[] employees;
    int index;
    int nbeng;
    int nbsps;
    int nbmngr;

    public HRM(int size) {
        index = 0;
        employees = new Employee[size];
        nbeng = 0;
        nbsps = 0;
        nbmngr = 0;
    }

    public void AddEmployee(Employee e) {
        if (index < employees.length)
            employees[index++] = e;
        else
            System.out.println("full.");
    }

    public void EmployeeInfo(int eID) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployee_ID() == eID) {
                System.out.println(employees[i]);
            }
        }
    }

    public void UpdateDetails(Scanner input) {
        int eid = 0;
        System.out.println("what id?");
        eid = input.nextInt();
        input.nextLine();
        for (int i = 0; i < employees.length; i++)
            if (employees[i].getEmployee_ID() == eid) {
                System.out.println("What do you want to edit?");
                String k = input.nextLine();
                if (k.equals("Department")) {
                    System.out.println("What is the new department?");
                    String dedit = input.next();
                    employees[i].setDepartment(dedit);
                } else if (k.equals("Salary")) {
                    System.out.println("What is the new salary?");
                    double sedit = input.nextDouble();
                    employees[i].setSalary(sedit);
                } else if (k.equals("Job Title")) {
                    if (employees[i] instanceof Engineer) {
                        System.out.println("What do you want to make him?");
                        String km = input.nextLine();
                        if (km.equals("Mananger")) {
                            System.out.println("What is his Department Head?");
                            String sdh = input.nextLine();
                            Mananger newmng = new Mananger(eid, employees[i].getName(), employees[i].getEmail(),
                                    employees[i].getDepartment(),
                                    employees[i].getSalary(), sdh);
                            employees[i] = newmng;
                        } else if (km.equals("Salesperson")) {
                            System.out.println("What is his Sales Target?");
                            double sst = input.nextDouble();
                            Salespersons newsps = new Salespersons(eid, employees[eid].getName(),
                                    employees[i].getEmail(),
                                    employees[i].getDepartment(),
                                    employees[eid].getSalary(), sst);
                            employees[eid] = newsps;
                        }
                    } else if (employees[i] instanceof Mananger) {
                        System.out.println("What do you want to make him?");
                        String km = input.nextLine();
                        if (km.equals("Engineer")) {
                            System.out.println("What are his skills?");
                            String sk = input.nextLine();
                            Engineer neweng = new Engineer(eid, employees[i].getName(), employees[i].getEmail(),
                                    employees[i].getDepartment(),
                                    employees[i].getSalary(), sk);
                            employees[i] = neweng;
                        } else if (km.equals("Salesperson")) {
                            System.out.println("What is his Sales Target?");
                            double sst = input.nextDouble();
                            Salespersons newsps = new Salespersons(eid, employees[eid].getName(),
                                    employees[eid].getEmail(),
                                    employees[eid].getDepartment(),
                                    employees[eid].getSalary(), sst);
                            employees[eid] = newsps;
                        }
                    } else if (employees[i] instanceof Salespersons) {
                        System.out.println("What do you want to make him?");
                        String km = input.nextLine();
                        if (km.equals("Engineer")) {
                            System.out.println("What are his skills?");
                            String sk = input.nextLine();
                            Engineer neweng = new Engineer(eid, employees[eid].getName(), employees[eid].getEmail(),
                                    employees[eid].getDepartment(),
                                    employees[eid].getSalary(), sk);
                            employees[eid] = neweng;
                        } else if (km.equals("Mananger")) {
                            System.out.println("What is his Department Head?");
                            String sdh = input.nextLine();
                            Mananger newmng = new Mananger(eid, employees[eid].getName(), employees[eid].getEmail(),
                                    employees[eid].getDepartment(),
                                    employees[eid].getSalary(), sdh);
                            employees[eid] = newmng;
                        }
                    }
                }
            }
    }

    public void filter(Scanner input) {
        Employee[] newarr = new Employee[employees.length];
        int index = 0;
        System.out.println("What is the crieteria?");
        String cr = input.nextLine();
        if (cr.equals("Job Title")) {
            System.out.println("What is the Job Title?");
            String jt = input.nextLine();
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null && index < newarr.length) {
                    if ((jt.equals("Engineer") && employees[i] instanceof Engineer) ||
                            (jt.equals("Mananger") && employees[i] instanceof Mananger) ||
                            (jt.equals("Salesperson") && employees[i] instanceof Salespersons)) {
                        newarr[index++] = employees[i];
                    }
                }
            }
        } else if (cr.equals("Skill")) {
            System.out.println("What is the skill?");
            String sk = input.nextLine();
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] instanceof Engineer) {
                    Engineer engineer = (Engineer) employees[i];
                    if (engineer.getSkills().equals(sk)) {
                        newarr[index++] = employees[i];
                    }
                }
            }
        }
        for (Employee e : newarr) {
            System.out.println(e);
            System.out.println();
        }
    }

    public void calculateBonus() {
        for (Employee e : employees) {
            if (e instanceof Mananger) {
                e.setSalary(((Mananger) e).calculateBonus());
                EmployeeInfo(e.getEmployee_ID());
                System.out.println();
            } else if (e instanceof Engineer) {
                e.setSalary(((Engineer) e).calculateBonus());
                EmployeeInfo(e.getEmployee_ID());
                System.out.println();
            } else if (e instanceof Salespersons) {
                e.setSalary(((Salespersons) e).calculateBonus());
                EmployeeInfo(e.getEmployee_ID());
                System.out.println();
            }

        }

    }

    public String EmployeeType() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] instanceof Engineer) {
                ++nbeng;
            } else if (employees[i] instanceof Mananger) {
                ++nbmngr;
            } else if (employees[i] instanceof Salespersons) {
                ++nbsps;
            }
        }
        return "The number of Manangers is " + nbmngr + "\nThe number of Engineers is " + nbeng
                + "\nThe number of Salesperson is " + nbsps;
    }

    public static void Sort(Employee[] employees) {
        for (int i = 0; i < employees.length; ++i)
            for (int j = 0; j < employees.length - 1; ++j)

                if (employees[j].getSalary() > employees[j + 1].getSalary()) {
                    Employee temp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = temp;
                }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}

public class HRM_System_Simulation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HRM hrm = new HRM(6);
        Mananger m1 = new Mananger(999999, "Ali Mohsen", "ALIMOH@mail.com", "Main Department", 999999999, "CEO");
        Mananger m2 = new Mananger(372042, "Ryan", "Ryan@mail.com", "Financial Department", 80000, "ChairPerson");
        Engineer e1 = new Engineer(362940, "Ibrahim", "Ibrahim@mail.com", "Technology Department", 60000,
                "java");
        Engineer e2 = new Engineer(402502, "Saleem", "Saleem@mail.com", "Technology Department", 50000, "python");
        Salespersons s1 = new Salespersons(204820, "mohammad", "mohammad@mail.com", "Sales Department", 40000, 80000);
        Salespersons s2 = new Salespersons(728374, "ahmad", "ahmad@mail.com", "Sales Department", 30000, 60000);
        hrm.AddEmployee(m1);
        hrm.AddEmployee(m2);
        hrm.AddEmployee(e1);
        hrm.AddEmployee(e2);
        hrm.AddEmployee(s1);
        hrm.AddEmployee(s2);
        hrm.EmployeeInfo(999999);
        System.out.println();
        hrm.EmployeeInfo(362940);
        System.out.println();
        hrm.EmployeeInfo(204820);
        System.out.println();
        hrm.UpdateDetails(input);
        System.out.println();
        hrm.EmployeeInfo(999999);
        System.out.println();
        hrm.UpdateDetails(input);
        System.out.println();
        hrm.EmployeeInfo(999999);
        System.out.println();
        hrm.UpdateDetails(input);
        System.out.println();
        hrm.EmployeeInfo(999999);
        System.out.println();
        hrm.filter(input);
        hrm.calculateBonus();
        hrm.EmployeeInfo(999999);
        System.out.println();
        hrm.EmployeeInfo(362940);
        System.out.println();
        hrm.EmployeeInfo(204820);
        System.out.println();
        hrm.filter(input);
        System.out.println(hrm.EmployeeType());
        System.out.println();
        hrm.Sort(hrm.employees);
        System.out.println();
        hrm.calculateBonus();
        System.out.println();
    }
}