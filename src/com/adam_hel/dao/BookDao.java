package com.adam_hel.dao;

import com.adam_hel.pojo.Book;

import java.util.List;

/**
 * ClassName:BookDao
 * Package:com.adam_hel.dao.impl
 * Description:BookDao接口
 *图书模块的增删改查方法创建
 * @Date:2020/9/26 10:46
 * @Author:adam_hel@163.com
 */
public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
