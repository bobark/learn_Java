package edu.javacourse.studentorder.domain;

public class CountryArea {
    private String area_id;

    public CountryArea() {
    }

    public CountryArea(String area_id, String area_iname) {
        this.area_id = area_id;
        this.area_iname = area_iname;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getArea_iname() {
        return area_iname;
    }

    public void setArea_iname(String area_iname) {
        this.area_iname = area_iname;
    }

    private String area_iname;
}
