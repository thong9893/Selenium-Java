package pages;

import pages.pim.employee.*;
public class PageGenerator {
    public static LoginPO getLoginPage(){
        return new LoginPO();
    }
    public static DashboardPO getDashboardPage(){
        return new DashboardPO();
    }
    public static AddNewEmployeePO getAddNewEmployeePage(){
        return new AddNewEmployeePO();
    }
    public static EmployeeListPO getEmployeeListPage(){
        return new EmployeeListPO();
    }
    public static PersonalDetailPO getPersonalDetailPage(){
        return new PersonalDetailPO();
    }
    public static ContactDetailPO getContactDetailPage(){
        return new ContactDetailPO();
    }
    public static EmergencyContactPO getEmergencyContactPage(){
        return new EmergencyContactPO();
    }

}
