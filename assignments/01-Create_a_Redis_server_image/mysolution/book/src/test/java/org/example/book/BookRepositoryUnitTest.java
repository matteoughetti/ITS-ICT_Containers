package org.example.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.example.book.models.Book;
import org.example.book.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
//@TestPropertySource(locations="classpath:application-test.properties")
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryUnitTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testEmptyDB(){
        assertEquals(0,bookRepository.findAll().size());
    }

    @Test
    public void testAddOneBook(){
        Book book = new Book();
        book.setBookId(1L);
        book.setAuthor("Franz Kafka");
        book.setTitle("La metamorfosi");
        book.setGenre("Racconto");
        book.setYear(1995);
        bookRepository.save(book);
        assertEquals(1,bookRepository.findAll().size());
    }

    @Test
    public void testDeleteAllBook(){
        Book book = new Book();
        book.setBookId(1L);
        book.setAuthor("Franz Kafka");
        book.setTitle("La metamorfosi");
        book.setGenre("Racconto");
        book.setYear(1995);
        bookRepository.save(book);

        Book book1 = new Book();
        book1.setBookId(2L);
        book1.setAuthor("Franz Kafka");
        book1.setTitle("La metamorfosi");
        book1.setGenre("Racconto");
        book1.setYear(1995);
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setBookId(3L);
        book2.setAuthor("Franz Kafka");
        book2.setTitle("La metamorfosi");
        book2.setGenre("Racconto");
        book2.setYear(1995);
        bookRepository.save(book2);


        bookRepository.deleteAll();
        assertEquals(0,bookRepository.findAll().size()  );
    }

    //delete one
    @Test
    public void testDeleteOneBook(){
        Book book = new Book();
        book.setBookId(1L);
        book.setAuthor("Franz Kafka");
        book.setTitle("La metamorfosi");
        book.setGenre("Racconto");
        book.setYear(1995);
        bookRepository.save(book);

        Book book1 = new Book();
        book1.setBookId(2L);
        book1.setAuthor("Franz Kafka");
        book1.setTitle("La metamorfosi");
        book1.setGenre("Racconto");
        book1.setYear(1995);
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setBookId(3L);
        book2.setAuthor("Franz Kafka");
        book2.setTitle("La metamorfosi");
        book2.setGenre("Racconto");
        book2.setYear(1995);
        bookRepository.save(book2);

        bookRepository.deleteById(1L);
        assertEquals(2,bookRepository.findAll().size()  );
    }


}