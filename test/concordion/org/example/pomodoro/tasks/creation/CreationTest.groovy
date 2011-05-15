package org.example.pomodoro.tasks.creation;


import org.concordion.api.ExpectedToFail
import org.concordion.ext.selenium.ScreenshotExtensionFactory

import org.example.pomodoro.pages.CreateTaskPage
import org.example.pomodoro.pages.TaskListPage

import org.junit.Before

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver


@ExpectedToFail
public class CreationTest {


    def resultingPage


    public void createTask(
            String summary, 
	    String details,
	    String status,
	    String deadlineDay,
	    String deadlineMonth,
	    String deadlineYear,
	    String timeSpent) {

        def webDriver = new FirefoxDriver()
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
        def webDriver = new FirefoxDriver()
	def taskListPage = new TaskListPage(webDriver)
        taskListPage.taskSummaries().any { it == summary }
    }


}
