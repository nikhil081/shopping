package com.example.nikma.shopping;


public class food {

    private String name;

    private String photourl;
    private String desc;

    public food() {

    }

    public food(String name, String photourl, String desc) {
        this.name = name;
        this.photourl = photourl;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
