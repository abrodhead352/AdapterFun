package com.example.adapterviewfun;
public class Book {
    // OOP
    // class: a collection of state and behavior that completely describes something
    // state: fields (AKA attributes)
    // behavior: methods

    // object: an instance of a class
    // class as a blueprint and an object a realization of the blueprint

    // Book describes a book in real life (simplified)

    // fields
    private String title;
    private String author;
    private int numPages;

    // constructors
    // for free, we get a default value constructor (DVC)
    // we can start making books!

    // once we define a constructor, we lose our free DVC
    // explicit value constructor (EVC)
    public Book(String title, String paramAuthor, int paramNumPages) {
        // title, author, numPages are fields of the new object being created
        // this object is referenced using this
        this.title = title; // shadowing... title the parameter shadows title the field
        author = paramAuthor;
        numPages = paramNumPages;
    }

    public Book() {
        title = "BLANK TITLE";
        author = "BLANK AUTHOR";
        numPages = -1;
    }

    // toString()
    // every class directly or indirectly inherits from Object
    // we can override toString(), and any other method inherited from Object

    // ANNOTATIONS
    // metadata metainformation about your code used by the compiler and the IDEA
    // @Override @SuppressWarnings @Deprecated
    @Override
    public String toString() {
        // returns a string representation of the invoking object (this)
        String bookStr = "";
        bookStr += title + " by " + author;
        return bookStr;
    }

    // recall access modifiers
    // 1. public (accessible anywhere)
    // 2. package-private (accessible anywhere in this package)
    // 3. protected (package-private plus accessible from any subclass,
    // even outside this package)
    // 4. private (accessible only in this class)

    // getters and setters
    // expose functionality as needed
    // getter (AKA accessor)
    public String getTitle() {
        return title;
    }

    // task 1: add a getter for author and numPages

    // setter (AKA mutator)
    public void setTitle(String newTitle) {
        // this refers to the invoking object
        // example: BookTester main() bookOne.setTitle("hello");
        // then this refers to the same object that bookOne refers to
        // _____._____()
        this.title = newTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    // task 2: still in this project...
    // create a Point class and a PointTester class
    // Point represents a point in 2D space (x, y)
    // toString() example: (0, 0) for origin
    // PointTester exercises some constructors and methods of Point
}