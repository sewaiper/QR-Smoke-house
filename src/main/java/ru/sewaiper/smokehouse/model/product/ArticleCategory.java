package ru.sewaiper.smokehouse.model.product;

import javax.persistence.*;

@Entity
@Table(name = "article_category")
public class ArticleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "name")
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "parent")
    protected ArticleCategory parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArticleCategory getParent() {
        return parent;
    }

    public void setParent(ArticleCategory parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "ArticleCategory{" +
                "name='" + name + '\'' +
                '}';
    }
}
