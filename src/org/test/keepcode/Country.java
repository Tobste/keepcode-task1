package org.test.keepcode;

public class Country {

    private String name;
    private Integer code;

    public Country(String code, String name) {
        this.code = Integer.parseInt(code);
        this.name = name;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
