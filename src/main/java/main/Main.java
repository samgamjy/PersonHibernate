package main;

import dao.BookDao;
import dao.exceptions.DaoException;
import entity.Book;
//import en.Book;

//import java.awt.print.Book;

/**
 * Created by sam on 17.06.2015.
 */
public class Main {

    public static void main(String[] args) {
        createBook();
//        loadBook();
//        flushBook();
    }

    private static void createBook() {
        Book book = new Book("bookName", "authorName", "1991");
        BookDao bookDao = new BookDao();


        try {
            bookDao.save(book);
            System.out.println("saved book.id = " + book.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    private static void getBook() {
        Book book = new Book();
        BookDao bookDao = new BookDao();
        try {
            book = bookDao.get(1);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        System.out.println(book);
    }

    private static void loadBook() {
        Book book = new Book();
        BookDao bookDao = new BookDao();
        try {
            book = bookDao.load(1);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        System.out.println(book);
    }

    private static void flushBook() {
        Book book = new Book();
        BookDao bookDao = new BookDao();
        try {
            bookDao.flush(1, "newName");
            book = bookDao.get(1);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        System.out.println(book);
    }
}
