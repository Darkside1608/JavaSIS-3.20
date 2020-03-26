package pro.sisit.adapter;

import static org.junit.Assert.assertEquals;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pro.sisit.adapter.impl.CSVAdapter;
import pro.sisit.adapter.impl.CSVAdapterAuthor;
import pro.sisit.adapter.impl.CSVAdapterBook;
import pro.sisit.model.Author;
import pro.sisit.model.Book;



public class CSVAdapterTest {

    @Before

    public void  createFile() throws IOException {

        File newFileBook;
        newFileBook = new File("test-book-files.csv");
        newFileBook.createNewFile();
        Files.write(Paths.get("test-book-files.csv"), Arrays.asList("Убик;Филип Дик;Научная Фантастика;978-5-699-97309-5\n"+"Будущее;Глуховский;Научная Фантастика;978-5-17-118366-0\n"));
        File newFileAuthor = new File("test-author-files.csv");
        newFileAuthor.createNewFile();

        Files.write(Paths.get("test-author-files.csv"),Arrays.asList("Филип Дик;1845\n"+"Глуховский;1975\n"));





    }

    @After
    public void deleteFile() {
        File newFileBook = new File("test-book-files.csv");
        newFileBook.delete();
        File newFileAuthor=new File("test-author-files.csv");
        newFileAuthor.delete();

    }

    @Test
    public void testRead() throws IOException {

        Path bookFilePath = Paths.get("test-book-files.csv");

        BufferedReader bookReader = new BufferedReader(
                new FileReader(bookFilePath.toFile()),500);

        BufferedWriter bookWriter = new BufferedWriter(
                new FileWriter(bookFilePath.toFile(), true),500);

        CSVAdapter<Book> bookCsvAdapter =
                new CSVAdapterBook(Book.class, bookReader, bookWriter);


        Book book1 = bookCsvAdapter.read(1);
        assertEquals("Глуховский", book1.getAuthor());
        assertEquals("Будущее", book1.getName());
        assertEquals("978-5-17-118366-0", book1.getIsbn());
        assertEquals("Научная Фантастика", book1.getGenre());

        Book expectedBook0 = new Book(
                "Убик",
                "Филип Дик",
                "Научная Фантастика",
                "978-5-699-97309-5");
        Book actualBook0 = bookCsvAdapter.read(0);
        assertEquals(expectedBook0, actualBook0);




        Path authorFilePath = Paths.get("test-author-files.csv");

        BufferedReader  authorReader = new BufferedReader(
                new FileReader(authorFilePath.toFile()),400);

        BufferedWriter authorWriter = new BufferedWriter(
                new FileWriter(authorFilePath.toFile(), true),400);
        CSVAdapter<Author> authorCsvAdapter =
                new CSVAdapterAuthor(Author.class, authorReader, authorWriter);



        Author author1 = authorCsvAdapter.read(1);
        assertEquals("1975", author1.getBirthPlace());
        assertEquals("Глуховский", author1.getName());

        Author expectedAuthor = new Author (
                "Филип Дик",
                "1845"
        );
        Author actualAuthor0 = authorCsvAdapter.read(0);
        assertEquals(expectedAuthor, actualAuthor0);

        authorWriter.close();
        authorReader.close();
        bookReader.close();
        bookWriter.close();


    }

    @Test
    public void testAppend() throws IOException {

        Path bookFilePath = Paths.get("test-book-file.csv");

        BufferedReader bookReader = new BufferedReader(
                new FileReader(bookFilePath.toFile()));

        BufferedWriter bookWriter = new BufferedWriter(
                new FileWriter(bookFilePath.toFile(), true));

        CSVAdapter<Book> bookCsvAdapter =
                new CSVAdapterBook(Book.class, bookReader, bookWriter);

        Book newBook = new Book(
                "Чертоги разума. Убей в себе идиота!",
                "Андрей Курпатов",
                "Психология",
                "978-5-906902-91-7");
        bookReader.mark(6000);
        int bookIndex = bookCsvAdapter.append(newBook);
        bookReader.reset();


        Book bookAtIndex = bookCsvAdapter.read(bookIndex);
        assertEquals(newBook, bookAtIndex);
        bookReader.close();
        bookWriter.close();

    }



}