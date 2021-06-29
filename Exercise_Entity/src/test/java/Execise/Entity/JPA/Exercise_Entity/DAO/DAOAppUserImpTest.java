package Execise.Entity.JPA.Exercise_Entity.DAO;

import Execise.Entity.JPA.Exercise_Entity.Models.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@DirtiesContext
class DAOAppUserImpTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private DAOAppUserImp testObject;

    public List<AppUser> appUser(){

        return Arrays.asList(
                new AppUser("Carl"," Karl", " Nilsson", LocalDate.of(1978, 6,15),true, "HejOchHå"),
                new AppUser("Nisse"," Nisse", " Nilsson", LocalDate.of(1985, 5,12),true, "Hejdå"),
                new AppUser("Ann"," Ann", " Nilsson", LocalDate.of(1990, 7,17),true, "OchHå"),
                new AppUser("Jan"," Jan", " Nilsson", LocalDate.of(1999, 11,19),true, "HejOch")
        );
    }

    private List<AppUser> persistedAppUser;

    @BeforeEach
    void setUp(){

        persistedAppUser = appUser().stream()
                .map(em::persist)
                .collect(Collectors.toList());


    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void save() {

        AppUser appUser = new AppUser("Anna","Anna", " Larsson", LocalDate.of(1980, 2,4),true, "HejOchDå");

        AppUser result = testObject.save(appUser);
        assertNotNull(result);
        assertNotNull(result.getUserId());

        System.out.println(result);

    }

    @Test
    void delete() {
    }
}