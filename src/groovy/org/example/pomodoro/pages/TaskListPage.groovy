package org.example.pomodoro.pages

import geb.Browser
import geb.Page


public class TaskListPage extends Page {

    static url = "http://localhost:8080/PomodoroApp/task/list"
    static at = { title == "Task List" }
    static content = {
        tasks { $("table tbody tr") }
        taskSummary { tasks[it].find("td", 1).text() }
    }

    static def taskSummaries() {
        def browser = new Browser()
        browser.to(TaskListPage)
        int index = 0
        def taskSummaries = browser.tasks?.collect { browser.taskSummary(index++) }
    }

}