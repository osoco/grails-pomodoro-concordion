package org.example.pomodoro.tasks.creation;

import geb.Page

import org.concordion.integration.junit3.ConcordionTestCase;
import org.example.pomodoro.pages.CreateTaskPage


public class CreationTest extends ConcordionTestCase {

    Page resultingPage

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
	null
    }

    public boolean taskSummariesContains(String summary) {
	true
    }

}
