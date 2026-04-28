package com.openclassrooms.bobapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
class BobappApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void shouldLoadApplicationContext() {
        assertNotNull("Le contexte Spring ne doit pas être null", context);
    }
}