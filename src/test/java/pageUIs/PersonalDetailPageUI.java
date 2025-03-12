package pageUIs;

public class PersonalDetailPageUI {
    public static final String EMPLOYEE_IMAGE = "xpath=//div[@class='orangehrm-edit-employee-navigation']//img[@class='employee-image']";
    public static final String SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER = "xpath=//h6[text()='Change Profile Picture']/following-sibling::form//button[contains(string(),'Save')]";
    public static final String FIRSTNAME_TEXTBOX = "xpath=//input[@name='firstName']";
    public static final String LASTNAME_TEXTBOX = "xpath=//input[@name='lastName']";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div//following-sibling::div//input";
    public static final String DRIVER_LICENSE_TEXTBOX = "xpath=//label[text()=\"Driver's License Number\"]/parent::div//following-sibling::div//input";
    public static final String LICENSE_EXPIRED_DATE_TEXTBOX = "xpath=//label[text()='License Expiry Date']/parent::div//following-sibling::div//input";
    public static final String NATIONALITY_DROPDOWN_PARENT = "xpath=//label[text()='Nationality']/parent::div//following-sibling::div/div/div//i";
    public static final String NATIONALITY_DROPDOWN_CHILD = "xpath=//label[text()='Nationality']/parent::div//following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
    public static final String NATIONALITY_DROPDOWN_ITEM_SELECTED = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text-input')]";
    public static final String MARITAL_STATUS_DROPDOWN_PARENT = "xpath=//label[text()='Marital Status']/parent::div//following-sibling::div/div/div//i";
    public static final String MARITAL_STATUS_DROPDOWN_CHILD = "xpath=//label[text()='Marital Status']/parent::div//following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
    public static final String MARITAL_STATUS_ITEM_SELECTED = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text-input')]";
    public static final String DATE_OF_BIRTH_TEXTBOX = "xpath=//label[text()='Date of Birth']/parent::div//following-sibling::div//input";
    public static final String GENDER_RADIO_BUTTON = "xpath=//label[text()='Gender']/parent::div//following-sibling::div//label[contains(string(),'%s')]/input";
    public static final String SAVE_BUTTON_AT_PERSONAL_DETAIL_CONTAINER = "xpath=//h6[text()='Personal Details']/following-sibling::form//button[contains(string(),'Save')]";

}
