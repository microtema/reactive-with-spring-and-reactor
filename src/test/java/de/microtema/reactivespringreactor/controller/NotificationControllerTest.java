package de.microtema.reactivespringreactor.controller;

import de.microtema.reactivespringreactor.ReactiveSpringReactorApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReactiveSpringReactorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NotificationControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void exampleTest() throws InterruptedException {

        Boolean result = restTemplate.getForObject("/notify/10", Boolean.class);

        assertTrue(result);

        // Note: Wait for graceful termination
        Thread.sleep(5000);
    }
}
