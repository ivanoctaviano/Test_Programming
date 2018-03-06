/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus X
 */
@Entity
@Table(name = "BOOKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b")
    , @NamedQuery(name = "Books.findById", query = "SELECT b FROM Books b WHERE b.id = :id")
    , @NamedQuery(name = "Books.findByTitle", query = "SELECT b FROM Books b WHERE b.title = :title")
    , @NamedQuery(name = "Books.findByAuthor", query = "SELECT b FROM Books b WHERE b.author = :author")
    , @NamedQuery(name = "Books.findByDatePublished", query = "SELECT b FROM Books b WHERE b.datePublished = :datePublished")
    , @NamedQuery(name = "Books.findByPages", query = "SELECT b FROM Books b WHERE b.pages = :pages")})
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "DATE_PUBLISHED")
    @Temporal(TemporalType.DATE)
    private Date datePublished;
    @Column(name = "PAGES")
    private Integer pages;
    @JoinColumn(name = "TYPE", referencedColumnName = "TYPE_ID")
    @ManyToOne
    private Types type;

    public Books() {
    }

    public Books(Integer id) {
        this.id = id;
    }

    public Books(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Books[ id=" + id + " ]";
    }
    
}
