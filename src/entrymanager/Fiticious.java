/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrymanager;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Angelis
 */
@Entity
@Table(name = "fiticious")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fiticious.findAll", query = "SELECT f FROM Fiticious f")
    , @NamedQuery(name = "Fiticious.findById", query = "SELECT f FROM Fiticious f WHERE f.id = :id")
    , @NamedQuery(name = "Fiticious.findByEmail", query = "SELECT f FROM Fiticious f WHERE f.email = :email")
    , @NamedQuery(name = "Fiticious.findByUsername", query = "SELECT f FROM Fiticious f WHERE f.username = :username")
    , @NamedQuery(name = "Fiticious.findByPassword", query = "SELECT f FROM Fiticious f WHERE f.password = :password")})
public class Fiticious implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public Fiticious() {
    }

    public Fiticious(Integer id) {
        this.id = id;
    }

    public Fiticious(Integer id, String email, String username) {
        this.id = id;
        this.email = email;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Fiticious)) {
            return false;
        }
        Fiticious other = (Fiticious) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entrymanager.Fiticious[ id=" + id + " ]";
    }
    
}
