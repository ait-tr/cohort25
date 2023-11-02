package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReminderHelper extends BaseHelper {

    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    public void enterTitle(String title) {
        type(By.id("reminder_title"), title);
    }

    public void tapOnDate() {
        tap(By.id("date"));
    }

    public void swipeToMonth(String period, String month, int number) {
        pause(1000);
        if (!getSelectedMonth().equals(month)) {
            for (int i = 0; i < number; i++) {
                if (period.equals("future")) {
                    swipe(0.7, 0.4);
                } else if (period.equals("past")) {
                    swipe(0.5, 0.8);
                }
            }
        }
    }

    private String getSelectedMonth() {
        return driver.findElement(By.id("date_picker_month")).getText();
    }

    public void selectDate(int index) {
        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();
    }

    public void tapOnYear() {
        // waitForElementAndTap(By.id("date_picker_year"),10);
        tap(By.id("date_picker_year"));
    }

    public void swipeToYear(String period2, String year,String text) {
        pause(1000);

        if (!getSelectedYear().equals(year)) {
            if (period2.equals("future")) {
                swipeUntilNeededYear(year,0.6,0.5);
            } else if (period2.equals("past")) {
                swipeUntilNeededYear(year,0.5,0.6);
            }
            tap(By.xpath("//android.widget.TextView[@text='"+text+"']"));
        }
    }

    private void swipeUntilNeededYear(String year,double startPoint, double stopPoint) {
        while (!getSelectedYear().equals(year)) {
            swipeInElement(By
                    .className("android.widget.ListView"),startPoint,stopPoint);
        }
    }

    public String getSelectedYear() {
        return driver.findElement(By.id("month_text_view")).getText();
    }

    public void tapOnOk() {
        tap(By.id("ok"));
    }

    public void tapOnTime() {
        tap(By.id("time"));
    }

    public void selectTime(String timeOfDay,int xHour,int yHour,int xMin,int yMin) {
        pause(1000);

        if (timeOfDay.equals("am")) {
            tapWithCoordinates(282,1329);
        } if (timeOfDay.equals("pm")) {
            tapWithCoordinates(802,1329);
        }
        tapWithCoordinates(xHour,yHour);
        tapWithCoordinates(xMin,yMin);
    }

    public void tapWithCoordinates(int x, int y) {
        new TouchAction(driver).tap(PointOption.point(x,y))
                .release().perform();
    }

    public void tapOnRepetitionInterval() {
        tap(By.id("RepeatNo"));
    }

    public void selectRepetition(String repetition) {
        type(By.xpath("//android.widget.EditText"),repetition);
        tap(By.xpath("//*[@text='OK']"));
    }

    public void tapOnTypeOfRepetitions() {
        tap(By.id("RepeatType"));
    }

    public void selectTypeOfRepetition(String typeRep) {
        tap(By.xpath("//*[@text='" + typeRep+ "']"));
    }

    public void saveReminder() {
        tap(By.id("save_reminder"));
    }
}
