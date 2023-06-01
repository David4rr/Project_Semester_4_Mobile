package com.example.smartlab;

public class DataBarang {

    private String title;
    private String slug;
    private String content;
    private String stok;
    private String id;

    public DataBarang(String title, String slug, String content, String stok, String id) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.stok = stok;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }
}
