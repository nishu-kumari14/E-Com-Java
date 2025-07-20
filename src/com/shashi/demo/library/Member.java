package com.shashi.demo.library;

/**
 * Member class representing a library member
 * Contains member details and contact information
 */
public class Member {
    private int memberId;
    private String name;
    private String email;
    private String phone;
    
    /**
     * Constructor to create a new library member
     * @param memberId Unique member identifier
     * @param name Name of the member
     * @param email Email address of the member
     * @param phone Phone number of the member
     */
    public Member(int memberId, String name, String email, String phone) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    /**
     * Get member ID
     * @return member ID
     */
    public int getMemberId() { 
        return memberId; 
    }
    
    /**
     * Get member name
     * @return member name
     */
    public String getName() { 
        return name; 
    }
    
    /**
     * Get member email
     * @return member email
     */
    public String getEmail() { 
        return email; 
    }
    
    /**
     * Get member phone
     * @return member phone
     */
    public String getPhone() { 
        return phone; 
    }
    
    /**
     * String representation of the member
     * @return formatted member details
     */
    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
