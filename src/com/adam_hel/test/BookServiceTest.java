package com.adam_hel.test;

import com.adam_hel.pojo.Book;
import com.adam_hel.pojo.Page;
import com.adam_hel.service.BookService;
import com.adam_hel.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * ClassName:BookServiceTest
 * Package:com.adam_hel.test
 * Description:
 *
 * @Date:2020/9/26 19:31
 * @Author:adam_hel@163.com
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"经济法", "出版社", new BigDecimal(100),
                100, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(27);

    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"会计法", "出版社", new BigDecimal(99),
                10, 110, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }
    @Test
    public void page() {
        System.out.println(bookService.page(1, Page.PAGE_SIZE));

    }
    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50 ));
    }

}