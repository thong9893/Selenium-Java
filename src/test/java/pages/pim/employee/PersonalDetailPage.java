package pages.pim.employee;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageUIs.PersonalDetailPageUI;
import testData.pojoData.EmployeeInfo;
import io.qameta.allure.Step;
import org.testng.Assert;

public class PersonalDetailPage extends EmployeeTabs {
    public PersonalDetailPage(WebDriver driver){
        super(driver);
    }
    @Step("Click employee avatar image")
    public void clickToEmployeeAvatarImage() {
        waitForElementClickAble(PersonalDetailPageUI.EMPLOYEE_IMAGE);
        clickToElement(PersonalDetailPageUI.EMPLOYEE_IMAGE);
    }
    @Step("Get avatar size")
    public Dimension getAvatarSize() {
        waitForElementVisible(PersonalDetailPageUI.EMPLOYEE_IMAGE);
        return getElementSize(PersonalDetailPageUI.EMPLOYEE_IMAGE);
    }
    @Step("Save avatar changes")
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
    @Step("Verify avatar updated and success message displayed")
    public void verifyAvatarUpdated(Dimension beforeUpload) {
        Assert.assertTrue(isSuccessMessageDisplayed(), "Success message not displayed after saving avatar");
        Assert.assertTrue(isProfileAvatarUpdateSuccess(beforeUpload), "Avatar size did not change after upload");
    }

    @Step("Enter first name: {0}")
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(PersonalDetailPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(PersonalDetailPageUI.FIRSTNAME_TEXTBOX,firstName);
    }
    @Step("Enter last name: {0}")
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(PersonalDetailPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(PersonalDetailPageUI.LASTNAME_TEXTBOX,lastName);
    }
    @Step("Get employee ID")
    public String getEmployeeID() {
        waitForElementVisible(PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX,"value");
    }
    @Step("Enter driver license: {0}")
    public void enterToDriverLicenseTextbox(String driverLicenseNumber) {
        waitForElementVisible(PersonalDetailPageUI.DRIVER_LICENSE_TEXTBOX);
        sendKeyToElement(PersonalDetailPageUI.DRIVER_LICENSE_TEXTBOX,driverLicenseNumber);
    }
    @Step("Enter license expired date: {0}")
    public void enterToLicenseExpiredDateTextbox(String licenseExpiredDate) {
        waitForElementVisible(PersonalDetailPageUI.LICENSE_EXPIRED_DATE_TEXTBOX);
        sendKeyToElement(PersonalDetailPageUI.LICENSE_EXPIRED_DATE_TEXTBOX,licenseExpiredDate);
    }
    @Step("Select nationality: {0}")
    public void selectNationalityDropdown(String nationality) {
        waitForElementClickAble(PersonalDetailPageUI.NATIONALITY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(PersonalDetailPageUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailPageUI.NATIONALITY_DROPDOWN_CHILD,nationality);
    }
    @Step("Select marital status: {0}")
    public void selectMaritalStatusDropdown(String maritalStatus) {
        waitForElementClickAble(PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_PARENT);
        selectItemInCustomDropdown(PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_CHILD,maritalStatus);
    }
    @Step("Enter date of birth: {0}")
    public void enterToDateOfBirthTextbox(String dateOfBirth) {
        waitForElementVisible(PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX);
        sendKeyToElement(PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX,dateOfBirth);
    }
    @Step("Select gender: {0}")
    public void selectGenderRadioButton(String gender) {
        clickToElementByJS(PersonalDetailPageUI.GENDER_RADIO_BUTTON,gender);
    }
    @Step("Save personal detail changes")
    public void clickSaveButtonAtPersonalDetailContainer() {
        waitForElementClickAble(PersonalDetailPageUI.SAVE_BUTTON_AT_PERSONAL_DETAIL_CONTAINER);
        clickToElement(PersonalDetailPageUI.SAVE_BUTTON_AT_PERSONAL_DETAIL_CONTAINER);
    }
    @Step("Get first name textbox value")
    public String getFirstNameTextboxValue() {
        waitForElementVisible(PersonalDetailPageUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(PersonalDetailPageUI.FIRSTNAME_TEXTBOX,"value");
    }
    @Step("Get last name textbox value")
    public String getLastNameTextboxValue() {
        waitForElementVisible(PersonalDetailPageUI.LASTNAME_TEXTBOX);
        return getElementAttribute(PersonalDetailPageUI.LASTNAME_TEXTBOX,"value");
    }
    @Step("Get driver license textbox value")
    public String getDriverLicenseTextboxValue() {
        waitForElementVisible(PersonalDetailPageUI.DRIVER_LICENSE_TEXTBOX);
        return getElementAttribute(PersonalDetailPageUI.DRIVER_LICENSE_TEXTBOX,"value");
    }
    @Step("Get license expired date textbox value")
    public String getLicenseExpiredDateTextboxValue() {
        waitForElementVisible(PersonalDetailPageUI.LICENSE_EXPIRED_DATE_TEXTBOX);
        return getElementAttribute(PersonalDetailPageUI.LICENSE_EXPIRED_DATE_TEXTBOX,"value");
    }
    @Step("Get nationality dropdown value")
    public String getNationalityDropdownValue() {
        waitForElementVisible(PersonalDetailPageUI.NATIONALITY_DROPDOWN_ITEM_SELECTED);
        return getElementText(PersonalDetailPageUI.NATIONALITY_DROPDOWN_ITEM_SELECTED);
    }
    @Step("Get marital status dropdown value")
    public String getMaritalStatusDropdownValue() {
        waitForElementVisible(PersonalDetailPageUI.MARITAL_STATUS_ITEM_SELECTED);
        return getElementText(PersonalDetailPageUI.MARITAL_STATUS_ITEM_SELECTED);
    }
    @Step("Get date of birth textbox value")
    public String getDateOfBirthTextboxValue() {
        waitForElementVisible(PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX);
        return getElementAttribute(PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX,"value");
    }
    @Step("Is male gender radio selected: {0}")
    public boolean isMaleGenderRadioSelected(String gender) {
        waitForElementSelected(PersonalDetailPageUI.GENDER_RADIO_BUTTON,gender);
        return isElementSelected(PersonalDetailPageUI.GENDER_RADIO_BUTTON,gender);
    }
    @Step("Set personal details  data")
    public void setPersonalDetail(EmployeeInfo employeeInfo){
        enterToDriverLicenseTextbox(employeeInfo.getDriverLicenseNumber());
        enterToLicenseExpiredDateTextbox(employeeInfo.getLicenseExpiredDate());
        selectNationalityDropdown(employeeInfo.getNationality());
        selectMaritalStatusDropdown(employeeInfo.getMaritalStatus());
        enterToDateOfBirthTextbox(employeeInfo.getDateOfBirth());
        selectGenderRadioButton(employeeInfo.getGenderStatus());
    }
    @Step("Verify personal details match expected values")
    public void verifyPersonalDetails(EmployeeInfo expected) {
        waitAllLoadingIconInvisible();

        Assert.assertEquals(getFirstNameTextboxValue(), expected.getFirstName(), "First name mismatch");
        Assert.assertEquals(getLastNameTextboxValue(), expected.getLastName(), "Last name mismatch");
        Assert.assertEquals(getEmployeeID(), expected.getEmployeeId(), "Employee ID mismatch");
        Assert.assertEquals(getDriverLicenseTextboxValue(), expected.getDriverLicenseNumber(), "Driver license mismatch");
        Assert.assertEquals(getLicenseExpiredDateTextboxValue(), expected.getLicenseExpiredDate(), "License expired date mismatch");
        Assert.assertEquals(getNationalityDropdownValue(), expected.getNationality(), "Nationality mismatch");
        Assert.assertEquals(getMaritalStatusDropdownValue(), expected.getMaritalStatus(), "Marital status mismatch");
        Assert.assertEquals(getDateOfBirthTextboxValue(), expected.getDateOfBirth(), "Date of birth mismatch");
        Assert.assertTrue(isMaleGenderRadioSelected(expected.getGenderStatus()), "Gender selection mismatch");
    }
}
