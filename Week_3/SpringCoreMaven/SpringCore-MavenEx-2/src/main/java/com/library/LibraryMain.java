package com.library;

import com.library.service.LibraryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        LibraryService service = (LibraryService) context.getBean("libraryService");
        service.addBook("Java for Professionals");

        ((ClassPathXmlApplicationContext) context).close();
    }
}
