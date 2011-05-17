package org.example.pomodoro.tasks.creation


import org.concordion.api.ExpectedToFail
import org.concordion.ext.selenium.ScreenshotExtensionFactory
import org.concordion.ext.selenium.SeleniumEventLogger;

import org.example.pomodoro.pages.CreateTaskPage
import org.example.pomodoro.pages.TaskListPage

import org.junit.Before

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.events.EventFiringWebDriver;


@ExpectedToFail
public class CreationTest {


    def webDriver
    def resultingPage


    public CreationTest() {
        EventFiringWebDriver efwd = new EventFiringWebDriver(new FirefoxDriver())
        efwd.register(new SeleniumEventLogger())
        webDriver = efwd
    }

    public void createTask(
            String summary, 
	    String details,
	    String status,
	    String deadlineDay,
	    String deadlineMonth,
	    String deadlineYear,
	    String timeSpent) {

        def createTaskPage = new CreateTaskPage(webDriver)
	resultingPage = createTaskPage.createTask(
	    [summary: summary,
	     details: details,
	     status: status,
	     deadlineDay: deadlineDay,
	     deadlineMonth: deadlineMonth,
	     deadlineYear: deadlineYear,
	     timeSpent: timeSpent])

    }


    public boolean existsTaskCreationErrorMessage() {
        resultingPage?.creationErrors
    }


    public boolean taskSummariesContains(String summary) {
	def taskListPage = new TaskListPage(webDriver)
        taskListPage.taskSummaries().any { it == summary }
    }


}
