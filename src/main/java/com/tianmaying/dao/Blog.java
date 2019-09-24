package com.tianmaying.dao;

@Entity
public class Blog {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;

    private String title;
    private String content;

    @Column(
            unique = true
    )
    private long author;

    public Blog(String title, String content, long author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public Blog(){

    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public long getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(long author) {
        this.author = author;
    }
}
