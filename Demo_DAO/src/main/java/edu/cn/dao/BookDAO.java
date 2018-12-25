package edu.cn.dao;

import edu.cn.Book;



public interface BookDAO {
    public Book findBookById(String isbn);

    public int modify(Book book);
    public int deleteBookById(String isbn);
    public int add(Book book);

}
