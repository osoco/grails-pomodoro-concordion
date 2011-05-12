package org.example.pomodoro.tasks.creation;


import geb.Page

import org.concordion.integration.junit3.ConcordionTestCase;

import org.example.pomodoro.pages.CreateTaskPage
import org.example.pomodoro.pages.TaskListPage


public class CreationTest extends ConcordionTestCase {

    def resultingPage

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
