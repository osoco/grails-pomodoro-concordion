package org.example.pomodoro.pages

import geb.Browser
import geb.Page


public class CreateTaskPage extends Page {

    static url = "http://localhost:8080/PomodoroApp/task/create"
    static at = { title == "Create Task" }
    static content = {
        // summary { $("input").summary.value() }
        // details { $("form").details.value() }
        // status { $("form").status.value() }
        // deadlineDay { $("form").deadline_day.value() }
        // deadlineMonth { $("form").deadline_month.value() }
        // deadlineYear { $("form").deadline_year.value() }
        // timeSpent { $("form").timespent.value() }
        // saveButton { $("input.save") }
    }

    static Page createTask(Map fieldsAndValues) {
	def browser = Browser.drive(CreateTaskPage) {
	    // fieldsAndValues.each {
	    // 	field, value ->
	    // 	println "${field} -> ${value}"
	    // 	page."${field}" = value
	    // }
	    // saveButton.click()
	}
	// browser.page
	null
    }

}