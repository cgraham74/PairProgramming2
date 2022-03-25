package com.techelevator;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    /**
     * The main entry point in the application
     * @param args
     */
    private List<Department> departments;
    private List<Employee> employees;
    private Map<String, Project> projects = new HashMap<>();
    LocalDate today = LocalDate.now();

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!
        employees.get(1).setSalary(employees.get(1).raiseSalary(10));


        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        departments = new ArrayList<>();
        departments.add(new Department(1, "Marketing"));
        departments.add(new Department(2, "Sales"));
        departments.add(new Department(3, "Engineering"));

    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for(Department name: departments){
            System.out.println(name.getName());
        }

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {

        employees = new ArrayList<>();
        Employee dean = new Employee();
        dean.setEmployeeId(2);
        dean.setFirstname("Dean");
        dean.setLastname("Johnson");
        dean.setEmail("djohnson@teams.com");
        dean.setSalary(60000);
        dean.setHireDate(today);
        dean.setDepartment(departments.get(2));
        employees.add(dean);
        employees.add(new Employee(2, "Angie", "Smith", "asmith@teams.com", departments.get(2), LocalDate.now()));
        employees.add(new Employee(3,"Margaret", "Thompson", "mthompson@teams.com", departments.get(0), LocalDate.now()));
    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        for (Employee name: employees){
            System.out.println(name.getFullName() + " " + " (" + currency.format(name.getSalary()) + ") " + name.getDepartment().getName());
        }

    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        Project project = new Project("TEams", "Projects Management Software", today , today.plusDays(30));
        project.setTeamMembers(employees.stream().filter(employee -> employee.getDepartment().getName().equalsIgnoreCase("Engineering")).collect(Collectors.toList()));
        projects.put(project.getName(),project);

    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project project = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing",today.plusDays(31), today.plusDays(38));
        project.setTeamMembers(employees.stream().filter(employee -> employee.getDepartment().getName().equalsIgnoreCase("Marketing")).collect(Collectors.toList()));
        projects.put(project.getName(),project);

    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for(String name: projects.keySet()){
            System.out.println(name + ": " + projects.get(name).getTeamMembers().size());
        }

    }

}
