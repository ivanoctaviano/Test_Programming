/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus X
 */
@Entity
@Table(name = "TYPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Types.findAll", query = "SELECT t FROM Types t")
    , @NamedQuery(name = "Types.findByTypeId", query = "SELECT t FROM Types t WHERE t.typeId = :typeId")
    , @NamedQuery(name = "Types.findByType", query = "SELECT t FROM Types t WHERE t.type = :type")})
public class Types implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TYPE_ID")
    private Integer typeId;
    @Size(max = 250)
    @Column(name = "TYPE")
    private String type;
    @OneToMany(mappedBy = "type")
    private Collection<Books> booksCollection;

    public Types() {
    }

    public Types(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<Books> getBooksCollection() {
        return booksCollection;
    }

    public void setBooksCollection(Collection<Books> booksCollection) {
        this.booksCollection = booksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeId != null ? typeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Types)) {
            return false;
        }
        Types other = (Types) object;
        if ((this.typeId == null && other.typeId != null) || (this.typeId != null && !this.typeId.equals(other.typeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "jpa.entities.Types[ typeId=" + typeId + " ]";
        return type;
    }
    
}
