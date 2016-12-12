/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanj
 */
@Entity
@Table(name = "juanjoa_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JuanjoaUsuarios.findAll", query = "SELECT j FROM JuanjoaUsuarios j"),
    @NamedQuery(name = "JuanjoaUsuarios.findById", query = "SELECT j FROM JuanjoaUsuarios j WHERE j.id = :id"),
    @NamedQuery(name = "JuanjoaUsuarios.findByEmail", query = "SELECT j FROM JuanjoaUsuarios j WHERE j.email = :email"),
    @NamedQuery(name = "JuanjoaUsuarios.findByNick", query = "SELECT j FROM JuanjoaUsuarios j WHERE j.nick = :nick"),
    @NamedQuery(name = "JuanjoaUsuarios.findByPassword", query = "SELECT j FROM JuanjoaUsuarios j WHERE j.password = :password")})
public class JuanjoaUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "nick")
    private String nick;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "idU")
    private Collection<JuanjoaPartidas> juanjoaPartidasCollection;

    public JuanjoaUsuarios() {
    }

    public JuanjoaUsuarios(Integer id) {
        this.id = id;
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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<JuanjoaPartidas> getJuanjoaPartidasCollection() {
        return juanjoaPartidasCollection;
    }

    public void setJuanjoaPartidasCollection(Collection<JuanjoaPartidas> juanjoaPartidasCollection) {
        this.juanjoaPartidasCollection = juanjoaPartidasCollection;
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
        if (!(object instanceof JuanjoaUsuarios)) {
            return false;
        }
        JuanjoaUsuarios other = (JuanjoaUsuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.JuanjoaUsuarios[ id=" + id + " ]";
    }
    
}
