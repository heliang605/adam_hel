package com.adam_hel.test;

import com.adam_hel.dao.BookDao;
import com.adam_hel.dao.impl.BookDaoImpl;
import com.adam_hel.pojo.Book;
import com.adam_hel.pojo.Page;
import com.sun.source.tree.NewArrayTree;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * ClassName:BookDaoTest
 * Package:com.adam_hel.test
 * Description:
 *
 * @Date:2020/9/26 11:21
 * @Author:adam_hel@163.com
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"中国经济","中",new BigDecimal(69.69),11,100,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookDao.addBook(new Book(21,"中国", "中国", new
                BigDecimal(99),11,0,null
        ));

    }

    @Test
    public void queryBookById() {
        System.out.println( bookDao.queryBookById(23) );
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }
    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Book book:bookDao.queryForPageItems(8,4)){
            System.out.println(book);
        }
    }
    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println( bookDao.queryForPageTotalCountByPrice(10, 50) );
    }
    @Test
    public void queryForPageItemsByPrice() {
        for (Book book : bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,10,50)) {
            System.out.println(book);
        }
    }


}