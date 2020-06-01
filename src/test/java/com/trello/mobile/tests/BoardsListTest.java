package com.trello.mobile.tests;


import org.testng.annotations.Test;

public class BoardsListTest extends TestBase {

    @Test
    public void listOfBoards() throws InterruptedException {
        app.getSession().login("krinskaya@gmail.com", "Krina123");
        Thread.sleep(6000);
        app.getBoards().getBoardsList();

    }


}
