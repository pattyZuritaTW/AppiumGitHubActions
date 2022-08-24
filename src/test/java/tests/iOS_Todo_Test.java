package tests;

import PageObjects.CreateTaskPage;
import PageObjects.Tasks_ListPage;
import io.appium.java_client.MobileBy;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class iOS_Todo_Test extends TestBase{
    CreateTaskPage createTaskPage;
    Tasks_ListPage tasksListPage;

    private static By saveBtn = MobileBy.AccessibilityId("Save");

    @DataProvider(name="tasks data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONData
                (System.getProperty("user.dir")+"/data/TasksData.json"
                        ,"Tasks Data", 2);
    }

    @Test(dataProvider = "tasks data")
    public void test_add_task(String taskName, String taskDesc) throws MalformedURLException, InterruptedException {
        iOS_setUp("10000","iPhone 13 mini","15.5"
                ,"4C9EE21B-E1EF-42F8-972E-305F837ABF7B","8200");
        tasksListPage = new Tasks_ListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn)).click();
        //createTaskPage.clickSaveBtn();
        tearDown();
    }

    @Test(dataProvider = "tasks data")
    public void test_add_task2(String taskName, String taskDesc) throws MalformedURLException, InterruptedException {
        iOS_setUp("10001","iPhone 13 Pro Max","15.5"
                ,"43691A82-27C0-49B1-B793-B737197020A4","8100");
        tasksListPage = new Tasks_ListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn)).click();
        //createTaskPage.clickSaveBtn();
        tearDown();
    }
}
