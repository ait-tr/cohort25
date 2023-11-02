package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReminderTests extends TestBase {

    @Test
    public void addReminderPositiveTest() {
        //tap on add reminder
        app.getMainScreen().tapOnAddReminder();
        //enter title - id - reminder_title
        app.getReminder().enterTitle("Holiday");
        //tap on data - id - date
        app.getReminder().tapOnDate();
        //swipe to month
        app.getReminder().swipeToMonth("future", "JAN", 3);
        //select date
        app.getReminder().selectDate(0);
        //tap on year
        app.getReminder().tapOnYear();
        //swipe to and tap on sertan year
        app.getReminder().swipeToYear("future", "2025", "2025");
        //tap on ok
        app.getReminder().tapOnOk();
        //tap on time
        app.getReminder().tapOnTime();
        //select time
        app.getReminder().selectTime("am", 403, 1163, 538, 1193);
        //tap on ok
        app.getReminder().tapOnOk();
        //tap on repetition interval
        app.getReminder().tapOnRepetitionInterval();
        //select repetition
        app.getReminder().selectRepetition("2");
        //swipe up
        app.getReminder().swipe(0.7, 0.4);
        //tap on type of repetitions
        app.getReminder().tapOnTypeOfRepetitions();
        //select type of repetition
        app.getReminder().selectTypeOfRepetition("Week");
        //save reminder
        app.getReminder().saveReminder();
        //assert bu title
        Assert.assertTrue(app.getMainScreen().isReminderTitlePresent().contains("Holiday"));
    }
}
