package edu.cn.controller;

import edu.cn.Book;
import edu.cn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookServiceImpl;

    @RequestMapping(value="/Book/{isbn}",method = RequestMethod.GET)
    @ResponseBody
    public Book getBookByIsbn(@PathVariable("isbn") String isbn){
        return bookServiceImpl.findBookByIsbn(isbn);
    }
    //修改书籍
    @RequestMapping(value="/Book/{isbn}",method = RequestMethod.PUT)
    @ResponseBody
    public Book modifyBook(@PathVariable String isbn, @RequestParam String title, @RequestParam String type,@RequestParam double price){
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setType(type);
        book.setPrice(price);
        System.out.println(book);
        int temp = bookServiceImpl.modify(book);
        System.out.println(temp+"");
        return book;
    }

    //删除用户
    @RequestMapping(value="/Book/{isbn}",method = RequestMethod.DELETE)
    @ResponseBody
    public String  deleteUser(@PathVariable("isbn") String isbn ){
        int temp = bookServiceImpl.deleteBookById(isbn);
        System.out.println(temp);
        if (temp==1){
            return "删除书籍成功";
        }else{
            return "删除书籍失败";
        }
    }

    @RequestMapping(value="/addBook",params = { "isbn","title" })
    @ResponseBody
    public String  addUser(Book book){
        boolean temp = bookServiceImpl.add(book);
        System.out.println(temp);
        if (temp==true){
            return "增加书籍成功";
        }else{
            return "增加书籍失败";
        }
    }
}
