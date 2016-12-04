/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanj
 */
@Entity
@Table(name = "juanjoa_partidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JuanjoaPartidas.findAll", query = "SELECT j FROM JuanjoaPartidas j"),
    @NamedQuery(name = "JuanjoaPartidas.findByIdpartida", query = "SELECT j FROM JuanjoaPartidas j WHERE j.idpartida = :idpartida"),
    @NamedQuery(name = "JuanjoaPartidas.findByFechainicio", query = "SELECT j FROM JuanjoaPartidas j WHERE j.fechainicio = :fechainicio"),
    @NamedQuery(name = "JuanjoaPartidas.findByFechafin", query = "SELECT j FROM JuanjoaPartidas j WHERE j.fechafin = :fechafin"),
    @NamedQuery(name = "JuanjoaPartidas.findByPuntuacion", query = "SELECT j FROM JuanjoaPartidas j WHERE j.puntuacion = :puntuacion")})
public class JuanjoaPartidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpartida")
    private Integer idpartida;
    @Column(name = "fechainicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    @Column(name = "fechafin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafin;
    @Column(name = "puntuacion")
    private BigInteger puntuacion;
    @JoinColumn(name = "id_u", referencedColumnName = "id")
    @ManyToOne
    private JuanjoaUsuarios idU;

    public JuanjoaPartidas() {
    }

    public JuanjoaPartidas(Integer idpartida) {
        this.idpartida = idpartida;
    }

    public Integer getIdpartida() {
        return idpartida;
    }

    public void setIdpartida(Integer idpartida) {
        this.idpartida = idpartida;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public BigInteger getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(BigInteger puntuacion) {
        this.puntuacion = puntuacion;
    }

    public JuanjoaUsuarios getIdU() {
        return idU;
    }

    public void setIdU(JuanjoaUsuarios idU) {
        this.idU = idU;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpartida != null ? idpartida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JuanjoaPartidas)) {
            return false;
        }
        JuanjoaPartidas other = (JuanjoaPartidas) object;
        if ((this.idpartida == null && other.idpartida != null) || (this.idpartida != null && !this.idpartida.equals(other.idpartida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.JuanjoaPartidas[ idpartida=" + idpartida + " ]";
    }
    
}
