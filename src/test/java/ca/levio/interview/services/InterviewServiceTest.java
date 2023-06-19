package ca.levio.interview.services;

import ca.levio.interview.InterviewApplication;
import ca.levio.interview.db.repositories.InterviewRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/*@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = InterviewApplication.class)*/
public class InterviewServiceTest {
  /*@Autowired
   private InterviewRepository repository;
private String test="JUnit is Working";
    //@Autowired
    //private InterviewService service;
    @BeforeEach
    void setUp(){
     System.out.println("test reussi");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll() {
     assertEquals("JUnit is Working",test);
    }

    @Test
    void getApplicantById() {
     assertEquals("JUnit is Working",test);
    }

    @Test
    void createOrUpdate() {
     assertEquals("JUnit is Working",test);
    }

    @Test
    void delete() {
       System.out.println(repository.findAll());
     assertEquals("JUnit is Working",test);
    }
*/
}