
package accomate360;

import static java.lang.System.out;
import javax.swing.JOptionPane;



public class Accomate360 {

    
    public static void main(String[] args) {
        
//        out.println("Enter 1 to register a new account.");
//        out.println("Enter 2 to register a new employee.");
//        out.println("Enter 3 to register a new query.");
//        out.println("Enter 4 to show all User Accounts.");
//        out.println("Enter 5 to show all Employee Accounts");
        
        int operationNo = Integer.parseInt(JOptionPane.showInputDialog("Enter 1 to register a new account.\nEnter 2 to register a new employee."
                + "\nEnter 3 to register a new query.\nEnter 4 to show all user accounts.\nEnter 5 to show all employee accounts."
                + "\nEnter 6 to show all queries.\nEnter 7 to search a pirticular user.\nEnter 8 to search a pirticular query."
                + "\nEnter 9 to search a pirticular Employeee.\nEnter 10 to delete a pirticular employee account."));
        
        switch(operationNo){
            case 1:
                UserRegister.registerUser();
                break;
            case 2:
                EmployeeRegister.registerEmployee();
                break;
            case 3:
                QueryRegister.registerQuery();
                break;
            case 4:
                UserRegister.showAll();
                break;
            case 5:
                EmployeeRegister.showAll();
                break;
            case 6:
                QueryRegister.showAll();
                break;
            case 7:
                UserRegister.showUser();
                break;
            case 8:
                QueryRegister.showQuery();
                break;
            case 9:
                EmployeeRegister.showEmployee();
                break;
            case 10:
                EmployeeRegister.deleteEmployee();
                break;
        }
    }   
}
