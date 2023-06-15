package ca.levio.interview.services;

import ca.levio.interview.db.repositories.InterviewRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InterviewServiceTest {
   @Autowired
    InterviewRepository repository;

    @Autowired
    InterviewService service;
    @BeforeEach
    void setUp(){
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getApplicantById() {
    }

    @Test
    void createOrUpdate() {
    }

    @Test
    void delete() {
       System.out.println(repository.findAll());
    }

}