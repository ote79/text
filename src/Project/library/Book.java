package Project.library;

import java.io.Serializable;

public class Book implements Serializable {
    private String name = "";
    private String author = "";
    private String Date = "";
    private String preview = "";

    public Book(){

    }

    public Book(String name,String author,String Date){
        this.name = name;
        this.author = author;
        this.Date = Date;
    }
    public String toString(){
        return String.format("%-15s|%-10s|%-10s|",name,author, Date);
    }
    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
