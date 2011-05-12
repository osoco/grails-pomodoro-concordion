package org.example.pomodoro.pages

import geb.Browser
import geb.Page


public class CreateTaskPage extends Page {

    static url = "http://localhost:8080/PomodoroApp/task/create"
    static at = { title == "Create Task" }
    static content = {       
        summary { $("input", name: "summary") }
        details { $("textarea", name: "details") }
        status { $("select", name: "status") }
        deadlineDay { $("select", name: "deadline_day") }
        deadlineMonth { $("select", name: "deadline_month") }
        deadlineYear { $("select", name: "deadline_year") }
        timeSpent { $("input", name: "timeSpent") }
        saveButton { $("input", name: "create") }
        creationErrors(required: false) { $("div.errors") }
    }

    static Page createTask(Map fieldsAndValues) {
	def browser = new Browser(CreateTaskPage) 
        browser.with {
	    fieldsAndValues.each {
	    	fieldName, fieldValue ->
	    	page."$fieldName".value(fieldValue)
	    }
	    saveButton.click(CreateTaskPage)
	}
	browser.page
    }

}