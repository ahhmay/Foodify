package com.example.noone;

public class RestaurantAdapter {
    private String rname;
    private String raddress;
    private String rphone;
    private String remail;
    private String rtime;
    private String rspeciality;
    private String rtype;
    private String rfood;
    private String rprice;

    public RestaurantAdapter() {}

    public RestaurantAdapter(String rname, String raddress, String rphone, String remail) {
        this.rname = rname;
        this.raddress = raddress;
        this.rphone = rphone;
        this.remail = remail;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRaddress() {
        return raddress;
    }

    public void setRaddress(String raddress) {
        this.raddress = raddress;
    }

    public String getRphone() {
        return rphone;
    }

    public void setRphone(String rphone) {
        this.rphone = rphone;
    }

    public String getRemail() {
        return remail;
    }

    public void setRemail(String remail) {
        this.remail = remail;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public String getRspeciality() {
        return rspeciality;
    }

    public void setRspeciality(String rspeciality) {
        this.rspeciality = rspeciality;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getRfood() {
        return rfood;
    }

    public void setRfood(String rfood) {
        this.rfood = rfood;
    }

    public String getRprice() {
        return rprice;
    }

    public void setRprice(String rprice) {
        this.rprice = rprice;
    }

    public String toString(){
        return this.rname+"\n"+raddress+"\n"+remail;
    }
}
