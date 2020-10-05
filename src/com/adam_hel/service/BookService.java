package com.adam_hel.service;

import com.adam_hel.pojo.Book;
import com.adam_hel.pojo.Page;

import java.util.List;

/**
 * ClassName:BookService
 * Package:com.adam_hel.service
 * Description:
 *
 * @Date:2020/9/28 13:47
 * @Author:adam_hel@163.com
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}

