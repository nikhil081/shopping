package com.example.nikma.shopping;


public class food {

    private String name;
    private String desc;
    private String image;

    public food() {
        super();
    }

    public food(String name, String desc, String image) {
        this.name = name;
        this.desc = desc;
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getImage() {

        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
