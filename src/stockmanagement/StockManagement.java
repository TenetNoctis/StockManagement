/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmanagement;
import java.util.Scanner;
/**
 *
 * @author Abdullah Nibah
 */
public class StockManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int quantity, employeeNumber = 1, itemNumber = 1, choice, exit, repeat, numberOfEmployees = 0;
        String departmentNameReport;
        String[] employeeName, itemName, departmentName, dateBorrowed, dateReceived, itemBorrowed;
        int[] employeeContact, currentStock, itemBorrowedQuantity;
        employeeName = new String[1000];
        employeeContact = new int[1000];
        itemBorrowedQuantity = new int[1000];
        departmentName = new String[1000];
        itemName = new String[1000];
        itemBorrowed = new String [1000];
        currentStock = new int[1000];
        dateBorrowed = new String[1000];
        dateReceived = new String[1000];
        exit = 2;
        repeat = 1;
        while (exit == 2) {
            System.out.println("Select a choice:");
            System.out.println("1) Employee Registration 2) Recieve Inventory 3) Borrow Item");
            System.out.println("4) Employee List         5) Item List         6) Generate Department Report");
            System.out.println("7) Exit");
            choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        while (repeat == 1) {
                            System.out.println("Enter employee's first name:");
                            employeeName[employeeNumber] = scan.next();
                            System.out.println("Enter employee contact number:");
                            employeeContact[employeeNumber] = scan.nextInt();
                            System.out.println("Enter department name:");
                            departmentName[employeeNumber] = scan.next();
                            System.out.println("Congratulations. You are now registered. Your employee number is "+employeeNumber);
                            ++employeeNumber;
                            ++numberOfEmployees;
                            System.out.println("Would you like to register another employee?");
                            System.out.println("Enter 1 for yes and 2 for no");
                            repeat = scan.nextInt();
                    }           
                        repeat = 1;
                        break;
                    case 2:
                        while (repeat == 1) {
                            System.out.println("Enter item name:");
                            itemName[itemNumber] = scan.next();
                            System.out.println("Enter quantity of item being recieved:");
                            currentStock[itemNumber] = scan.nextInt();
                            System.out.println("Enter today's date in DD/MM/YYYY format:");
                            dateReceived[itemNumber] = scan.next();
                            System.out.println("The item has now been registered. the item number is "+itemNumber);
                            ++itemNumber;
                            System.out.println("Would you like to register another item");
                            System.out.println("Enter 1 for yes and 2 for no");
                            repeat = scan.nextInt();
                    }       
                        repeat = 1;
                        break;
                    case 3:
                        System.out.println("WARNING: Employees are only allowed to borrow one type of item at a time!");
                        System.out.println("Enter employee number");
                        employeeNumber = scan.nextInt();
                        System.out.println("Enter item number");
                        itemNumber = scan.nextInt();
                        System.out.println("Enter quantity of item required");
                        quantity = scan.nextInt();
                        System.out.println("Enter today's date in DD/MM/YYYY format");
                        dateBorrowed[employeeNumber] = scan.next();
                        if (currentStock[itemNumber]<(quantity-1)) {
                            System.out.println("The required quantity of the item requested is not available right now.");
                    }
                        else {
                            System.out.println("-----------------------------------------");
                            System.out.println("-----------------BIN CARD----------------");
                            System.out.println("-----------------------------------------");
                            System.out.println("| Employee Name: "+employeeName[employeeNumber]);
                            System.out.println("| Employee Contact Number: "+employeeContact[employeeNumber]);
                            System.out.println("| Employee Department: "+departmentName[employeeNumber]);
                            System.out.println("| Item Name: "+itemName[itemNumber]);
                            itemBorrowed[employeeNumber] = itemName[itemNumber];
                            System.out.println("| Number of items being taken: "+quantity);
                            itemBorrowedQuantity[employeeNumber] = quantity;
                            System.out.println("| Date borrowed: "+dateBorrowed[employeeNumber]);
                            System.out.println("| Current Stock of item: "+currentStock[itemNumber]);
                            currentStock[itemNumber] = currentStock[itemNumber] - quantity;
                            System.out.println("| Stock after the item is borrowed: "+currentStock[itemNumber]);
                            System.out.println("-----------------------------------------");
                            System.out.println("-----------------------------------------");
                    }       
                        break;
                    case 4:
                        System.out.println("------------------------------------------------------------------");
                        System.out.println("The employee list is shown according to the employee number:");
                        System.out.println("------------------------------------------------------------------");
                        employeeNumber = 1;
                        while (employeeName[employeeNumber] != null) {
                            System.out.println("Employee Number: "+employeeNumber);
                            System.out.println("Employee Name: "+employeeName[employeeNumber]);
                            System.out.println("Employee Contact Number: "+employeeContact[employeeNumber]);
                            System.out.println("Employee Department: "+departmentName[employeeNumber]);
                            System.out.println("-----------------------------------------");
                            ++employeeNumber;
                        }
                        break;
                    case 5:
                        System.out.println("------------------------------------------------------------------");
                        System.out.println("The item list is shown according to the item number:");
                        System.out.println("------------------------------------------------------------------");
                        itemNumber = 1;
                        while (itemName[itemNumber] != null) {
                            System.out.println("Item Number: "+itemNumber);
                            System.out.println("Item Name: "+itemName[itemNumber]);
                            System.out.println("Item's Current Stock: "+currentStock[itemNumber]);
                            System.out.println("Date item was last stocked: "+dateReceived[itemNumber]);
                            System.out.println("-----------------------------------------");
                            ++itemNumber;
                        }
                        break;
                    case 6:
                        System.out.println("Write the name of the department you would like to generate a report for!");
                        departmentNameReport = scan.next();
                        employeeNumber = 0;
                        System.out.println("Employees in "+departmentNameReport);
                        while (employeeNumber < numberOfEmployees) {
                            if (departmentNameReport.equals(departmentName[employeeNumber])) {
                                System.out.print(employeeNumber);
                                System.out.println(") "+employeeName[employeeNumber]);
                                System.out.println("Item Borrowed:");
                                System.out.println("- "+itemBorrowed[employeeNumber]);
                                System.out.println("Quantity of item borrowed: ");
                                System.out.println("- "+itemBorrowedQuantity[employeeNumber]);
                                ++employeeNumber;
                            }
                            else {
                                ++employeeNumber;
                            }
                        }
                        break;
                    case 7:
                        exit = 0;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
            }
        }
    }
}
    
