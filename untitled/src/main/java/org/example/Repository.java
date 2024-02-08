package org.example;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    private List<Book> bookList;
    private List<String> suggestions;

    public Repository() {
        suggestions = new ArrayList<>();
        bookList = new ArrayList<>();
        bookList.add(new Book("t1", "a1"));
        this.bookList.add(new Book("t12", "a1"));
        this.bookList.add(new Book("t2", "a2"));
    }

    public List<Book> find(String word){
        List<Book> found = new ArrayList<>();
        for (Book book: bookList){
            if (book.author.equals(word) || book.name.equals(word)){
                found.add(book);
            }
        }
        return found;
    }

    public void saveSuggestion(String word){
        suggestions.add(word);
    }

    public Book findByName(String bookName){
        for (Book book: bookList){
            if (book.name.equals(bookName)){
                return book;
            }
        }
        return null;
    }
}