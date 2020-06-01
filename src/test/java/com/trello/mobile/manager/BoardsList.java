package com.trello.mobile.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BoardsList extends HelperBase {
    public BoardsList(AppiumDriver driver) {
        super(driver);
    }

    public void getBoardsList() {
     List<WebElement> boards = driver.findElements(By.xpath("//*[@resource-id='com.trello:id/board_name']"));
        for (WebElement board : boards) {
            String name = board.getText();
            System.out.println(name);
        }
    }
}

