package org.ait.demoqa.tests.form;

import org.ait.demoqa.data.StudentData;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.forms.PracticeFormPage;
import org.ait.demoqa.tests.TestBase;
import org.ait.demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideIframes();
    }

    @Test
    public void fillStudentFormTest() {
        new PracticeFormPage(driver).enterPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME,
                        StudentData.EMAIL, StudentData.PHONE_NUMBER)
                .selectGender(StudentData.GENDER)
                //  .enterDate(StudentData.DATE)
                .selectDate("May", "2001", "15")
                .selectSubjects(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH)
                .enterAddress(StudentData.ADDRESS)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .submit()
                .assertSubmit("Thanks for submitting the form");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "studentDataFromCSVFile")
    public void fillStudentFormUsingDataProviderTest(String name, String lastname,
                                                     String email, String phone,
                                                     String dateOfBirth, String path,
                                                     String address) {
        new PracticeFormPage(driver).enterPersonalData(name,lastname,email,phone)
                .selectGender(StudentData.GENDER)
                .enterDate(dateOfBirth)
                .selectSubjects(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBIES)
                .uploadFile(path)
                .enterAddress(address)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .submit()
                .assertSubmit("Thanks for submitting the form");
    }
}
