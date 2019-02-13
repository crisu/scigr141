package ro.sci;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {

    private List<Book> listOfBooks;

    public Library(){
        listOfBooks = new ArrayList<>();
    }

    public List<Book> getListOfBooks() {
        return this.listOfBooks;
    }

    public void setListOfBooks(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public void addBook(Book carte){
        listOfBooks.add(carte);
    }

    public void removeAllBooksWithName(String numeCarte){
        Iterator<Book> it = listOfBooks.iterator();
        Book book;
        while(it.hasNext()){
            book = it.next();
            if(book.getNume().equals(numeCarte)){
                it.remove();
            }
        }
    }

    public void remove(Book book){
        listOfBooks.remove(book);
    }

}
