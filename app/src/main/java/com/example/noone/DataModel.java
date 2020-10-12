package com.example.noone;

public class DataModel {
    String raddress, remail, rname, rphone, rtime, rtype;
    String fcategory, fname, fportion_size, fprice, ftype;

    public DataModel() {}

    public DataModel(String raddress, String remail, String rname, String rphone, String rtime, String rtype) {
        this.raddress = raddress;
        this.remail = remail;
        this.rname = rname;
        this.rphone = rphone;
        this.rtime = rtime;
        this.rtype = rtype;
    }

    public DataModel(String fcategory, String fname, String fportion_size, String fprice, String ftype) {
        this.fcategory = fcategory;
        this.fname = fname;
        this.fportion_size = fportion_size;
        this.fprice = fprice;
        this.ftype = ftype;
    }

    public String getRaddress() {
        return raddress;
    }

    public void setRaddress(String raddress) {
        this.raddress = raddress;
    }

    public String getRemail() {
        return remail;
    }

    public void setRemail(String remail) {
        this.remail = remail;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRphone() {
        return rphone;
    }

    public void setRphone(String rphone) {
        this.rphone = rphone;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }


    //GETTER SETTER for FOOD ITEMS

    public String getFcategory() {
        return fcategory;
    }

    public void setFcategory(String fcategory) {
        this.fcategory = fcategory;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFportion_size() {
        return fportion_size;
    }

    public void setFportion_size(String fportion_size) {
        this.fportion_size = fportion_size;
    }

    public String getFprice() {
        return fprice;
    }

    public void setFprice(String fprice) {
        this.fprice = fprice;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }
}
