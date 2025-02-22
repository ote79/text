package Project.library;

//src/Project/library/libraryData

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Library {
    static final String path = "src/Project/library/libraryData";
    static String dividingLine = "-----------------------------------------";

    public static void main(String[] age) {
        Scanner input = new Scanner(System.in);
        flush();
        while (true){
            System.out.print("\n\n1:Add a book\n2:Delete the book\n3:Delete all books\n4:Change your book information\n5:exit\n\n");
            System.out.print("Please select the action you want to take:");
            switch (input.nextInt()){
                case 1:add();break;
                case 2:delete();break;
                case 3:deleteAll();break;
                case 4:reSet();break;
                case 5:System.exit(114514);
            }
        }
    }

    public static void flush() {
        File list = new File(path);
        if (Objects.requireNonNull(list.listFiles()).length == 0) {
            System.out.println(dividingLine);
            System.out.println("      NO BOOK!!!");
            System.out.println(dividingLine);
        } else {
            int count = 1;
            System.out.println(dividingLine);
            for (File file : Objects.requireNonNull(list.listFiles())) {
                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                    Book book = (Book) inputStream.readObject();
                    System.out.println("|" + count + "|" + book.toString());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                count++;
            }
            System.out.println(dividingLine);
        }
    }

    public static void add() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter a name for the book:");
        String name = input.nextLine();
        System.out.print("\nEnter the author of the book:");
        String author = input.nextLine();
        System.out.print("\nEnter the publication date of the book:");
        String date = input.nextLine();
        add(new Book(name, author, date));
        flush();
    }

    public static void add(Book book) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path + File.separator + book.getName()))) {
            outputStream.writeObject(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAll() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n\nAre you sure you want to do that?  ( 1 -> yes / 0 -> no)");
        if (input.nextInt() == 1){
            File[] files = new File(path).listFiles();
            if (files != null) {
                for (File file : files)
                    file.delete();
            }
        }
        else System.out.println("\nThe operation has been canceled");
        flush();
    }

    public static void delete() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the book number you want to delete:");
        delete(input.nextInt());
        flush();
    }

    public static void delete(int inter) {
        File[] books = new File(path).listFiles();
        if (books != null && (inter < 1 || inter > books.length)) {
            System.out.println("\n\nThe target book does not exist!!!");
            return;
        }
        if (books != null) {
            books[inter - 1].delete();
        }
    }

    public static void reSet() {
        Book book = null;
        File[] fileList = new File(path).listFiles();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of the book you want to change:");
        int inter = input.nextInt();
        if (fileList != null && (inter < 1 || inter - 1 > fileList.length)) {
            System.out.println("\n\nThe target book does not exist!!!");
            return;
        }
        System.out.println("\n1:name\n2:author\n3:publicationDate\n");
        System.out.print("Enter the item for the book you want to change:");
        int type = input.nextInt();
        System.out.print("Enter the changed content:");
        input.nextLine();
        String next = input.nextLine();
        if (fileList != null) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileList[inter - 1]))) {
                book = (Book) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        switch (type) {
            case 1:
                book.setName(next);
                delete(inter);
                add(book);
                break;
            case 2:
                book.setAuthor(next);
                delete(inter);
                add(book);
                break;
            case 3:
                book.setDate(next);
                delete(inter);
                add(book);
                break;
        }
        flush();
    }

    public static void reSet(Book book, int inter) {
        delete(inter);
        add(book);
    }
}
