package by.example.simpleportlet.dao.domain;

import javax.persistence.*;

@Entity
@Table(name = "by_example_link")
public class Link {

    public Link() {
    }

    public Link(long categoryId, String title) {
        this.categoryId = categoryId;
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long categoryId;

    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}