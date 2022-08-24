package steps;

import PageObjects.CreateTaskPage;
import PageObjects.Tasks_ListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import tests.TestBase;

import java.net.MalformedURLException;

public class CreateNewTaskWithData extends TestBase {

    CreateTaskPage createTaskPage;
    Tasks_ListPage tasksListPage;

    @Given("Click add new Task")
    public void clickAddNewTask() throws MalformedURLException {
        Android_setUp();
        tasksListPage = new Tasks_ListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
    }

    @Given("Enter {string} and {string}")
    public void enterAnd(String taskName, String taskDesc) {
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);
    }

    @Then("Task Added successfully")
    public void taskAddedSuccessfully() {
        driver.hideKeyboard();
        tearDown();
    }

}
