package org.test.keepcode;


public class Phone {

    private String number;
    private String update;
    private String dateHumans;
    private String phoneNumber;
    private String maxDate;
    private boolean status;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    private Country country;

    public Phone(String number, String update, String dateHumans, String phoneNumber, String maxDate, boolean status, Country country) {
        this.number = number;
        this.update = update;
        this.dateHumans = dateHumans;
        this.phoneNumber = phoneNumber;
        this.maxDate = maxDate;
        this.status = status;
        this.country = country;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getDateHumans() {
        return dateHumans;
    }

    public void setDateHumans(String dateHumans) {
        this.dateHumans = dateHumans;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
