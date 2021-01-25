package org.example.borrow;

import org.example.borrow.models.Borrow;
import org.example.borrow.repos.BorrowRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class BorrowRepositoryUnitTest {

    @MockBean
    BorrowRepository borrowRepository;

    @Test
    public void testEmptyDB() {
        assertEquals(0, borrowRepository.findAll().size());
    }

    @Test
    void addBorrowShouldReturnOneBorrow() {
        Borrow borrow = new Borrow();
        borrow.setBorrowId("borrow");
        borrow.setBookId("book");
        borrow.setCustomerId("customer");
        borrowRepository.save(borrow);
        assertEquals(0, borrowRepository.findAll().size());
    }

    @Test
    void deleteBorrowShouldReturnZeroBorrows() {
        Borrow borrow = new Borrow();
        borrow.setBorrowId("borrow");
        borrow.setBookId("book");
        borrow.setCustomerId("customer");
        borrowRepository.save(borrow);
        borrowRepository.deleteById("borrow");
        assertEquals(0, borrowRepository.findAll().size());
    }

}