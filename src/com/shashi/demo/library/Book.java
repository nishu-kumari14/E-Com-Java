package com.shashi.demo.library;

/**
 * Book class representing a library book
 * Contains book details and availability status
 */
public class Book {
    private int bookId;
    private String title;
    private String author;
    private String category;
    private boolean available;
    
    /**
     * Constructor to create a new book
     * @param bookId Unique book identifier
     * @param title Title of the book
     * @param author Author of the book
     * @param category Category/genre of the book
     * @param available Availability status
     */
    public Book(int bookId, String title, String author, String category, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = available;
    }
    
    /**
     * Get book ID
     * @return book ID
     */
    public int getBookId() { 
        return bookId; 
    }
    
    /**
     * Get book title
     * @return book title
     */
    public String getTitle() { 
        return title; 
    }
    
    /**
     * Get book author
     * @return book author
     */
    public String getAuthor() { 
        return author; 
    }
    
    /**
     * Get book category
     * @return book category
     */
    public String getCategory() { 
        return category; 
    }
    
    /**
     * Check if book is available
     * @return true if available, false otherwise
     */
    public boolean isAvailable() { 
        return available; 
    }
    
    /**
     * Set book availability status
     * @param available availability status
     */
    public void setAvailable(boolean available) { 
        this.available = available; 
    }
    
    /**
     * String representation of the book
     * @return formatted book details
     */
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", available=" + available +
                '}';
    }
}
