import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CabService {

    //Initialising Empty List
    static List<Employee> employeeList = new ArrayList<>();
    static List<Trip> tripList = new ArrayList<>();


    static Cab normalCab = new Cab("Normal",25);
    static Cab acCab = new Cab("AC",40);
    static Cab luxuryCab = new Cab("Luxury",100);

    static long noOfTrips = 0;



    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        employeeList.add(new Employee("Z01","Udhayakumar","Avinashi, Tiruppur",22,"Fresher"));
        employeeList.add(new Employee("Z02","name2","palladam, Tiruppur",5,"Fresher"));
        employeeList.add(new Employee("Z03","name3","Avinashi, Tiruppur",20,"Experienced"));
        employeeList.add(new Employee("Z04","Vinothkumar","karumathampatti",15,"Experienced"));
        employeeList.add(new Employee("Z05","name5","Kunnathur",40,"Experienced"));
        employeeList.add(new Employee("Z06","Karthik","Kunnathur",40,"Expert"));
        employeeList.add(new Employee("Z07","name7","sulur",25,"Expert"));
        employeeList.add(new Employee("Z08","name8","kaniyur",23,"Expert"));
        addTrip("Z01","27/08/2023");
        addTrip("Z06","06/07/2023");
        addTrip("Z01","04/07/2023");
        addTrip("Z01","05/07/2023");
        addTrip("Z01","06/07/2023");


        addTrip("Z04","06/07/2023");
        boolean run = true;
        while (run){
            System.out.print("\nChoose a option\n1.Add Employee\n2.Add Trip\n3.Trip By Employee\n4.Trips By Month\n5.Total Cost for Month\n6.Total Cost for Employee\n7.Total Cost for Employee in Month\n8.Total Cost for fresher\n9.Total Cost for Experienced\n10.Total Cost for Expert\n11.Exit\n\nEnter: ");
            int selected = scan.nextInt();
            switch (selected){
                case 1:
                    addEmployee();
                    break;
                case 2:
                    System.out.println("Enter Trip Details");
                    System.out.print("EmpID: ");String empID = scan.next();
                    System.out.print("Date(dd/mm/yyyy): ");String date = scan.next();

                    addTrip(empID,date);
                    break;
                case 3:
                    System.out.print("\nEnter EmpID: ");
                    String empIDForTrip = scan.next();
                    showEmployeTrips(empIDForTrip);
                    break;
                case 4:
                    System.out.print("\nEnter month and year(mm/yyyy): ");
                    String dateAndMonth = scan.next();
                    showTripsForMonth(dateAndMonth);
                    break;
                case 5:
                    System.out.print("\nEnter month and year(mm/yyyy): ");
                    String dateAndMonth1 = scan.next();
                    showTotalCostForMonth(dateAndMonth1);
                    break;
                case 6:
                    System.out.print("\nEnter EmpID: ");
                    String empIDForTrip2 = scan.next();
                    showTotalCostForEmployee(empIDForTrip2);
                    break;
                case 7:
                    System.out.print("\nEnter EmpID: ");
                    String empIDForTrip1 = scan.next();
                    System.out.print("\nEnter month and year(mm/yyyy): ");
                    String dateAndMonth2 = scan.next();
                    showTotalCostForEmployeeInMonth(dateAndMonth2,empIDForTrip1);
                    break;
                case 8:
                    showTotalCostForFresher();
                    break;
                case 9:
                    showTotalCostForExperienced();
                    break;
                case 10:
                    showTotalCostForExpert();
                    break;
                case 11:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }

    }

    public static void addEmployee(){
        System.out.println("Enter Employee Details");
        System.out.print("EmpID: ");String empId = scan.next();
        System.out.print("Name: ");String name = scan.next();
        System.out.print("Address: ");String address = scan.next();
        System.out.print("Distance(in Km): "); int distance = scan.nextInt();
        System.out.print("Designation: ");String designation = scan.next();

        Employee newEmployee = new Employee(empId,name,address,distance,designation);
        employeeList.add(newEmployee);

        System.out.println("Employee Added");
    }

    public static void addTrip(String empID,String date){
        int day = Integer.parseInt(date.substring(0,2));
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));
        Date formatedDate = new Date(2023,month-1,day);
        Employee curr = null;
        for(int i=0;i< employeeList.size();i++){
            if (employeeList.get(i).getEmpId().equals(empID)){
                curr = employeeList.get(i);
            }
        }
        if(curr != null){
            Cab currCab=null;
            switch (curr.getDesignation()) {
                case "Fresher":
                    currCab = normalCab;
                    break;
                case "Experienced":
                    currCab = acCab;
                    break;
                case "Expert":
                    currCab = luxuryCab;
                    break;
            }
            if(currCab !=null){
                double cost = curr.getDistance() * currCab.getCostPerKm();
                long tripId = noOfTrips+1;
                Trip newTrip = new Trip(String.valueOf(tripId),curr,cost,currCab,formatedDate);
                tripList.add(newTrip);
                noOfTrips += 1;
                System.out.println("Trip Added");
            }
        }else {
            System.out.println("Employee Not Found.");
        }
    }

    public static void showEmployeTrips(String empID){
        int cont = 0;
        for (int i=0;i<tripList.size();i++){
            if(tripList.get(i).getEmployee().getEmpId().equals(empID)){
                Trip temp = tripList.get(i);
                System.out.println(++cont+". TripID:"+temp.getTripId()+"  EmpID: "+temp.getEmployee().getEmpId()+"  Name: "+temp.getEmployee().getName()+"  ToAddress: "+temp.getEmployee().getAddress()+"  Distance: "+temp.getEmployee().getDistance()+"  Cab: "+temp.getCab().getType()+"  Cost: "+temp.getCost()+"   Date: "+temp.getDateTime());
            }
        }
    }

    public static void showTripsForMonth(String monthForTrip){
        int month = Integer.parseInt(monthForTrip.substring(0,2));
        int year = Integer.parseInt(monthForTrip.substring(3,7));
        int cont = 0;
        double totalCost = 0;
        for (int i=0;i<tripList.size();i++){
            if(tripList.get(i).getDateTime().getMonth()==month-1 && tripList.get(i).getDateTime().getYear()==year){
                Trip temp = tripList.get(i);
                System.out.println(++cont+". TripID:"+temp.getTripId()+"  EmpID: "+temp.getEmployee().getEmpId()+"  Name: "+temp.getEmployee().getName()+"  ToAddress: "+temp.getEmployee().getAddress()+"  Distance: "+temp.getEmployee().getDistance()+"  Cab: "+temp.getCab().getType()+"  Cost: "+temp.getCost()+"   Date: "+temp.getDateTime());

                totalCost += temp.getCost();
            }
        }
        System.out.println("\nTotal Cost for "+monthForTrip+" is: "+totalCost);
    }

    public static void showTotalCostForMonth(String monthForTrip){
        int month = Integer.parseInt(monthForTrip.substring(0,2));
        int year = Integer.parseInt(monthForTrip.substring(3,7));
        double totalCost = 0;
        for (int i=0;i<tripList.size();i++){
            if(tripList.get(i).getDateTime().getMonth()==month-1 && tripList.get(i).getDateTime().getYear()==year){
                Trip temp = tripList.get(i);
                totalCost += temp.getCost();
            }
        }
        System.out.println("\nTotal Cost for "+monthForTrip+" is: "+totalCost);
    }

    public static void showTotalCostForEmployee(String empID){
        double totalCost = 0;
        for (int i=0;i<tripList.size();i++){
            if(tripList.get(i).getEmployee().getEmpId().equals(empID)){
                Trip temp = tripList.get(i);
                totalCost += temp.getCost();
            }
        }
        System.out.println("\nTotal Cost for "+empID+" is: "+totalCost);
    }

    public static void showTotalCostForFresher(){
        double totalCost = 0;
        for (int i=0;i<tripList.size();i++){
            if(tripList.get(i).getEmployee().getDesignation().equals("Fresher")){
                Trip temp = tripList.get(i);
                totalCost += temp.getCost();
            }
        }
        System.out.println("\nTotal Cost for Fresher"+" is: "+totalCost);
    }

    public static void showTotalCostForExperienced(){
        double totalCost = 0;
        for (int i=0;i<tripList.size();i++){
            if(tripList.get(i).getEmployee().getDesignation().equals("Experienced")){
                Trip temp = tripList.get(i);
                totalCost += temp.getCost();
            }
        }
        System.out.println("\nTotal Cost for Experienced"+" is: "+totalCost);
    }

    public static void showTotalCostForExpert(){
        double totalCost = 0;
        for (int i=0;i<tripList.size();i++){
            if(tripList.get(i).getEmployee().getDesignation().equals("Expert")){
                Trip temp = tripList.get(i);
                totalCost += temp.getCost();
            }
        }
        System.out.println("\nTotal Cost for Expert"+" is: "+totalCost);
    }

    public static void showTotalCostForEmployeeInMonth(String monthForTrip,String empID){
        int month = Integer.parseInt(monthForTrip.substring(0,2));
        int year = Integer.parseInt(monthForTrip.substring(3,7));
        double totalCost = 0;
        for (int i=0;i<tripList.size();i++){
            if(tripList.get(i).getEmployee().getEmpId().equals(empID)){
                if(tripList.get(i).getDateTime().getMonth()==month-1 && tripList.get(i).getDateTime().getYear()==year){
                    Trip temp = tripList.get(i);
                    totalCost += temp.getCost();
                }
            }

        }
        System.out.println("\nTotal Cost for "+monthForTrip+" is: "+totalCost);
    }
}
