package com.example.ecommerce.Model;

public class NewArrivals {

    private int Id;
    private int Image;
    private String title;

    public NewArrivals(int id, int image, String title) {
        Id = id;
        Image = image;
        this.title = title;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "NewArrivals{" +
                "Id=" + Id +
                ", Image=" + Image +
                ", title='" + title + '\'' +
                '}';
    }
}
