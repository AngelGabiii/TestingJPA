/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrymanager;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Angelis
 */
@Entity
@Table(name = "adminusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adminusers.findAll", query = "SELECT a FROM Adminusers a")
    , @NamedQuery(name = "Adminusers.findById", query = "SELECT a FROM Adminusers a WHERE a.id = :id")
, @NamedQuery(name = "Adminusers.findByUserName", query = "SELECT a FROM Adminusers a WHERE a.userName = :userName")
    , @NamedQuery(name = "Adminusers.findByPassword", query = "SELECT a FROM Adminusers a WHERE a.password = :password")
    , @NamedQuery(name = "Adminusers.findByDate", query = "SELECT a FROM Adminusers a WHERE a.date = :date")})
public class Adminusers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Lob
    @Column(name = "fingerPrint")
    private byte[] fingerPrint;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Adminusers() {
    }

    public Adminusers(Integer id) {
        this.id = id;
    }

    public Adminusers(Integer id, String userName, String password, Date date) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(byte[] fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        if (!(object instanceof Adminusers)) {
            return false;
        }
        Adminusers other = (Adminusers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entrymanager.Adminusers[ id=" + id + " ]";
    }
    
}
