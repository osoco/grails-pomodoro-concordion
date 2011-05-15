package org.example.pomodoro.pages


import geb.Browser
import geb.Page

import org.openqa.selenium.WebDriver


public class TaskListPage extends Page {

    def webDriver

    static url = "http://localhost:8080/PomodoroApp/task/list"
    static at = { title == "Task List" }
    static content = {
        tasks { $("table tbody tr") }
        taskSummary { tasks[it].find("td", 1).text() }
    }

    public TaskListPage(WebDriver driver) {
        webDriver = driver
    }

    def taskSummaries() {
        def browser = new Browser(webDriver)
        browser.to(TaskListPage)
        int index = 0
        def taskSummaries = browser.tasks?.collect { browser.taskSummary(index++) }
    }

}