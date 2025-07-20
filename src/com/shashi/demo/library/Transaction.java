package com.shashi.demo.library;

import java.util.Date;

/**
 * Transaction class representing book transactions
 * Tracks book issue and return operations
 */
public class Transaction {
    private int transactionId;
    private int bookId;
    private int memberId;
    private Date issueDate;
    private Date returnDate;
    private String status;
    
    /**
     * Constructor to create a new transaction
     * @param transactionId Unique transaction identifier
     * @param bookId ID of the book involved in transaction
     * @param memberId ID of the member involved in transaction
     * @param issueDate Date when book was issued
     * @param returnDate Date when book was returned (null if not returned)
     * @param status Status of the transaction (ISSUED/RETURNED)
     */
    public Transaction(int transactionId, int bookId, int memberId, Date issueDate, Date returnDate, String status) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
    }
    
    /**
     * Get transaction ID
     * @return transaction ID
     */
    public int getTransactionId() { 
        return transactionId; 
    }
    
    /**
     * Get book ID
     * @return book ID
     */
    public int getBookId() { 
        return bookId; 
    }
    
    /**
     * Get member ID
     * @return member ID
     */
    public int getMemberId() { 
        return memberId; 
    }
    
    /**
     * Get issue date
     * @return issue date
     */
    public Date getIssueDate() { 
        return issueDate; 
    }
    
    /**
     * Get return date
     * @return return date
     */
    public Date getReturnDate() { 
        return returnDate; 
    }
    
    /**
     * Set return date
     * @param returnDate return date
     */
    public void setReturnDate(Date returnDate) { 
        this.returnDate = returnDate; 
    }
    
    /**
     * Get transaction status
     * @return transaction status
     */
    public String getStatus() { 
        return status; 
    }
    
    /**
     * Set transaction status
     * @param status transaction status
     */
    public void setStatus(String status) { 
        this.status = status; 
    }
    
    /**
     * String representation of the transaction
     * @return formatted transaction details
     */
    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", bookId=" + bookId +
                ", memberId=" + memberId +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", status='" + status + '\'' +
                '}';
    }
}
