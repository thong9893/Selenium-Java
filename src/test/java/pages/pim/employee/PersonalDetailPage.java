package pages.pim.employee;

import org.openqa.selenium.Dimension;
import pageUIs.PersonalDetailPageUI;
import pojoData.EmployeeInfo;

import static support.BasePage.*;

public class PersonalDetailPage extends EmployeeTabs {
    public void clickToEmployeeAvatarImage() {
        waitForElementClickAble(PersonalDetailPageUI.EMPLOYEE_IMAGE);
        clickToElement(PersonalDetailPageUI.EMPLOYEE_IMAGE);
    }
    public Dimension getAvatarSize() {
        waitForElementVisible(PersonalDetailPageUI.EMPLOYEE_IMAGE);
        return getElementSize(PersonalDetailPageUI.EMPLOYEE_IMAGE);
    }
    public void clickToSaveButtonAtProfileContainer() {
        waitForElementClickAble(PersonalDetailPageUI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
        clickToElement(PersonalDetailPageUI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
    }
    public boolean isProfileAvatarUpdateSuccess(Dimension beforeUpload) {
        waitAllLoadingIconInvisible();
        sleepInSecond(1);
        Dimension afterUpload = getAvatarSize();
        return !(beforeUpload.equals(afterUpload));
    }
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(PersonalDetailPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(PersonalDetailPageUI.FIRSTNAME_TEXTBOX,firstName);
    }
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(PersonalDetailPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(PersonalDetailPageUI.LASTNAME_TEXTBOX,lastName);
    }
    public String getEmployeeID() {
        waitForElementVisible(PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX,"value");
    }
    public void enterToDriverLicenseTextbox(String driverLicenseNumber) {
        waitForElementVisible(PersonalDetailPageUI.DRIVER_LICENSE_TEXTBOX);
        sendKeyToElement(PersonalDetailPageUI.DRIVER_LICENSE_TEXTBOX,driverLicenseNumber);
    }
    public void enterToLicenseExpiredDateTextbox(String licenseExpiredDate) {
        waitForElementVisible(PersonalDetailPageUI.LICENSE_EXPIRED_DATE_TEXTBOX);
        sendKeyToElement(PersonalDetailPageUI.LICENSE_EXPIRED_DATE_TEXTBOX,licenseExpiredDate);
    }
    public void selectNationalityDropdown(String nationality) {
        waitForElementClickAble(PersonalDetailPageUI.NATIONALITY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(PersonalDetailPageUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailPageUI.NATIONALITY_DROPDOWN_CHILD,nationality);
    }
    public void selectMaritalStatusDropdown(String maritalStatus) {
        waitForElementClickAble(PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_PARENT);
        selectItemInCustomDropdown(PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_CHILD,maritalStatus);
    }
    public void enterToDateOfBirthTextbox(String dateOfBirth) {
        waitForElementVisible(PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX);
        sendKeyToElement(PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX,dateOfBirth);
    }
    public void selectGenderRadioButton(String gender) {
        clickToElementByJS(PersonalDetailPageUI.GENDER_RADIO_BUTTON,gender);
        //waitForElementClickAble(PersonalDetailPageUI.GENDER_RADIO_BUTTON,gender);
        //checkToCheckBoxRadio(PersonalDetailPageUI.GENDER_RADIO_BUTTON,gender);
    }
    public void clickSaveButtonAtPersonalDetailContainer() {
        waitForElementClickAble(PersonalDetailPageUI.SAVE_BUTTON_AT_PERSONAL_DETAIL_CONTAINER);
        clickToElement(PersonalDetailPageUI.SAVE_BUTTON_AT_PERSONAL_DETAIL_CONTAINER);
    }
    public String getFirstNameTextboxValue() {
        waitForElementVisible(PersonalDetailPageUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(PersonalDetailPageUI.FIRSTNAME_TEXTBOX,"value");
    }
    public String getLastNameTextboxValue() {
        waitForElementVisible(PersonalDetailPageUI.LASTNAME_TEXTBOX);
        return getElementAttribute(PersonalDetailPageUI.LASTNAME_TEXTBOX,"value");
    }
    public String getDriverLicenseTextboxValue() {
        waitForElementVisible(PersonalDetailPageUI.DRIVER_LICENSE_TEXTBOX);
        return getElementAttribute(PersonalDetailPageUI.DRIVER_LICENSE_TEXTBOX,"value");
    }
    public String getLicenseExpiredDateTextboxValue() {
        waitForElementVisible(PersonalDetailPageUI.LICENSE_EXPIRED_DATE_TEXTBOX);
        return getElementAttribute(PersonalDetailPageUI.LICENSE_EXPIRED_DATE_TEXTBOX,"value");
    }
    public String getNationalityDropdownValue() {
        waitForElementVisible(PersonalDetailPageUI.NATIONALITY_DROPDOWN_ITEM_SELECTED);
        return getElementText(PersonalDetailPageUI.NATIONALITY_DROPDOWN_ITEM_SELECTED);
    }
    public String getMaritalStatusDropdownValue() {
        waitForElementVisible(PersonalDetailPageUI.MARITAL_STATUS_ITEM_SELECTED);
        return getElementText(PersonalDetailPageUI.MARITAL_STATUS_ITEM_SELECTED);
    }
    public String getDateOfBirthTextboxValue() {
        waitForElementVisible(PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX);
        return getElementAttribute(PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX,"value");
    }
    public boolean isMaleGenderRadioSelected(String gender) {
        waitForElementSelected(PersonalDetailPageUI.GENDER_RADIO_BUTTON,gender);
        return isElementSelected(PersonalDetailPageUI.GENDER_RADIO_BUTTON,gender);
    }
    public void setPersonalDetail(EmployeeInfo employeeInfo){
        enterToDriverLicenseTextbox(employeeInfo.getDriverLicenseNumber());
        enterToLicenseExpiredDateTextbox(employeeInfo.getLicenseExpiredDate());
        selectNationalityDropdown(employeeInfo.getNationality());
        selectMaritalStatusDropdown(employeeInfo.getMaritalStatus());
        enterToDateOfBirthTextbox(employeeInfo.getDateOfBirth());
        selectGenderRadioButton(employeeInfo.getGenderStatus());
    }
}
