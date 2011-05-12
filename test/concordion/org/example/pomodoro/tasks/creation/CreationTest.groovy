package org.example.pomodoro.tasks.creation;


import geb.Page

import org.concordion.ext.ScreenshotExtension;
import org.concordion.ext.TimestampFormatterExtension;
import org.concordion.integration.junit4.ConcordionRunner;

import org.example.pomodoro.pages.CreateTaskPage
import org.example.pomodoro.pages.TaskListPage

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(ConcordionRunner.class)
public class CreationTest {

    def resultingPage

    @Before
    public void loadExtensions() {
        System.setProperty(
            "concordion.extensions", 
            "org.concordion.ext.ScreenshotExtension, org.concordion.ext.TimestampFormatterExtension")
    }
    
    public void createTask(
            String summary, 
	    String details,
	    String status,
	    String deadlineDay,
	    String deadlineMonth,
	    String deadlineYear,
	    String timeSpent) {

	resultingPage = CreateTaskPage.createTask(
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
        println "summaries: ${TaskListPage.taskSummaries()}"
	TaskListPage.taskSummaries().any { it == summary }
    }

}
