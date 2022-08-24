package tests;

import PageObjects.CreateTaskPage;
import PageObjects.Tasks_ListPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class ToDo_Android extends TestBase {
    CreateTaskPage createTaskPage;
    Tasks_ListPage tasksListPage;

    @DataProvider(name="tasks data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONData
                (System.getProperty("user.dir")+"/data/TasksData.json"
                        ,"Tasks Data", 2);
    }
    @Test(dataProvider = "tasks data")
    public void test_add_task(String taskName, String taskDesc) throws MalformedURLException, InterruptedException {
        Android_setUp();
        tasksListPage = new Tasks_ListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);
        driver.hideKeyboard();
        createTaskPage.clickSaveBtn();
        tearDown();
    }

}
