package com.example.mohsin.feedbackapp;


public class UserDetailsTable {
    String customerName,customerNic,customerCell,customerFeedback,branch;

    public UserDetailsTable(String customerName, String customerNic, String customerCell,
                            String customerFeedback,String branch) {
        super();
        this.customerName = customerName;
        this.customerNic = customerNic;
        this.customerCell = customerCell;
        this.customerFeedback = customerFeedback;
        this.branch = branch;
    }

    public UserDetailsTable() {
        super();
        this.customerName = null;
        this.customerNic = null;
        this.customerCell = null;
        this.customerFeedback = null;
        this.branch = null;
    }



    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNic() {
        return customerNic;
    }

    public void setCustomerNic(String customerNic) {
        this.customerNic = customerNic;
    }

    public String getCustomerCell() {
        return customerCell;
    }

    public void setCustomerCell(String customerCell) {
        this.customerCell = customerCell;
    }

    public String getCustomerFeedback() {
        return customerFeedback;
    }

    public void setCustomerFeedback(String customerFeedback) {
        this.customerFeedback = customerFeedback;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
