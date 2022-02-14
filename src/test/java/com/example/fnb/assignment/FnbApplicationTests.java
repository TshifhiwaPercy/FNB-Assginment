package com.example.fnb.assignment;

import com.example.fnb.assignment.controller.MainController;
import com.example.fnb.assignment.logic.Change;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
class FnbApplicationTests {
    @Autowired
    private MainController mainController;

    @Test
    void contextLoads() {
    }
    @Test //Test to check whether coin dispenser calculator is return the correct values
    void test_whether_coinDispenser_returning_ExpectedValue(){
        Integer[] values = {1,2,5,10};
        Change ch = new Change(values,112);
        String coinDispValue = ch.getChange();
        String answer ="R10x11,R2x1,";
        assertEquals(answer,coinDispValue);
    }
    @Test //Test whether server is correctly running
    void test_whether_serverIsRunning(){
        assertSame(mainController.echo(),true);
    }
    @Test //Test to check if unCalculatedChange method is returning the correct value
    void test_whether_uncalculatedChange_isCorrect(){
        Integer[] values = {1,2,5,10};
        Change ch = new Change(values,112);
        assertEquals(ch.getAmount(),112);
    }

}
