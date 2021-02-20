package com.company;

public class Information {
    private String email;//initialize email with private modifier
    private String contacts;//initialize contacts with private modifier
    private String address;//initialize address with private modifier

    public Information() {//empty constructor to set default values
        this.email = "magauiyainc@magauiya.com";
        this.contacts = "87719870019";
        this.address = "Nur-Sultan,Bekarys 33";
    }

    public Information(String email, String contacts, String address) {//constructor if you want to change the values
        this.email = email;
        this.contacts = contacts;
        this.address = address;
    }

    public String getEmail() {//to get email
        return email;
    }

    public void setEmail(String email) {//to set email
        this.email = email;
    }

    public String getContacts() {//to get contacts
        return contacts;
    }

    public void setContacts(String contacts) {//to set contacts
        this.contacts = contacts;
    }

    public String getAddress() {//to get address
        return address;
    }

    public void setAddress(String address) {//to set address
        this.address = address;
    }
    public void Contacts(){//method for output information(contacts)
        System.out.println("Our address:"+this.address+"\n"
                +"Our phonenumber:"+this.address+"\n"+"Our email:"+this.email);
    }

}
