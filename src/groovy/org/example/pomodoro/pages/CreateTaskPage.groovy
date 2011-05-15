package org.example.pomodoro.pages


import geb.Browser
import geb.Page

import org.openqa.selenium.WebDriver


public class CreateTaskPage extends Page {

    def webDriver

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

    public CreateTaskPage(WebDriver driver) {
        webDriver = driver
    }

    Page createTask(Map fieldsAndValues) {
	def browser = new Browser(webDriver) 
        browser.with {
            to(CreateTaskPage)
	    fieldsAndValues.each {
	    	fieldName, fieldValue ->
	    	page."$fieldName".value(fieldValue)
	    }
	    saveButton.click(CreateTaskPage)
	}
	browser.page
    }

}