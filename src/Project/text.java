package Project;

import Project.library.Book;
import Project.library.Library;

public class text {
    public static void main(String[] age){
        Library.flush();
        Book book = new Book("fuck","dame","suKaBuLie");
        Book text = new Book("dame","114514","dddd");
        Library.add(book);
        Library.add(text);
        Library.flush();
    }
}
