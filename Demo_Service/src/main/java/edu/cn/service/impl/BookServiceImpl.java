package edu.cn.service.impl;

import edu.cn.Book;
import edu.cn.dao.BookDAO;
import edu.cn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;
    @Override
    public Book findBookByIsbn(String isbn) {
        return bookDAO.findBookById(isbn);
    }

    @Override
    public int deleteBookById(String isbn) {
        return bookDAO.deleteBookById(isbn);
    }


    @Override
    public int modify(Book book) {
        return bookDAO.modify(book);
    }
    @Override
    public boolean add(Book book) {
        int result = bookDAO.add(book);
        boolean flag = false;
        if (result == 1){
            flag = true;
        }
        return flag;
    }
}
