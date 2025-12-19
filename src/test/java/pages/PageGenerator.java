package pages;

import pages.pim.employee.*;
public class PageGenerator {
    public static LoginPage getLoginPage(){
        return new LoginPage();
    }
    public static DashboardPage getDashboardPage(){
        return new DashboardPage();
    }
    public static AddNewEmployeePage getAddNewEmployeePage(){
        return new AddNewEmployeePage();
    }
    public static EmployeeListPage getEmployeeListPage(){
        return new EmployeeListPage();
    }
    public static PersonalDetailPage getPersonalDetailPage(){
        return new PersonalDetailPage();
    }
    public static ContactDetailPage getContactDetailPage(){
        return new ContactDetailPage();
    }
    public static EmergencyContactPage getEmergencyContactPage(){
        return new EmergencyContactPage();
    }

}
