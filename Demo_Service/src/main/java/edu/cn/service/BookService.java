package edu.cn.service;

import edu.cn.Book;

public interface BookService {
    public Book findBookByIsbn(String isbn);
    public int modify(Book book);
    public int deleteBookById(String isbn);
    public boolean add(Book book);



}
