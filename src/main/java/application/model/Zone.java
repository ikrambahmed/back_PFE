package application.model;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "ZONE")
public class Zone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "COD_ZONE")
    private String codZone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "LIB_ZONEA")
    private String libZonea;
    @Size(max = 60)
    @Column(name = "LIB_ZONEL")
    private String libZonel;
   
    @OneToMany(mappedBy = "codZone")
    @JsonIgnore
    private Collection<Pays> paysCollection;

    public Zone() {
    }

    public Zone(String codZone) {
        this.codZone = codZone;
    }

    public Zone(String codZone, String libZonea) {
        this.codZone = codZone;
        this.libZonea = libZonea;
    }

    public String getCodZone() {
        return codZone;
    }

    public void setCodZone(String codZone) {
        this.codZone = codZone;
    }

    public String getLibZonea() {
        return libZonea;
    }

    public void setLibZonea(String libZonea) {
        this.libZonea = libZonea;
    }

    public String getLibZonel() {
        return libZonel;
    }

    public void setLibZonel(String libZonel) {
        this.libZonel = libZonel;
    }

   /* @XmlTransient
    public Collection<Pays> getPaysCollection() {
        return paysCollection;
    }

    public void setPaysCollection(Collection<Pays> paysCollection) {
        this.paysCollection = paysCollection;
    }*/

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codZone == null) ? 0 : codZone.hashCode());
		result = prime * result + ((libZonea == null) ? 0 : libZonea.hashCode());
		result = prime * result + ((libZonel == null) ? 0 : libZonel.hashCode());
		result = prime * result + ((paysCollection == null) ? 0 : paysCollection.hashCode());
		return result;
	}

    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zone other = (Zone) obj;
		if (codZone == null) {
			if (other.codZone != null)
				return false;
		} else if (!codZone.equals(other.codZone))
			return false;
		if (libZonea == null) {
			if (other.libZonea != null)
				return false;
		} else if (!libZonea.equals(other.libZonea))
			return false;
		if (libZonel == null) {
			if (other.libZonel != null)
				return false;
		} else if (!libZonel.equals(other.libZonel))
			return false;
		if (paysCollection == null) {
			if (other.paysCollection != null)
				return false;
		} else if (!paysCollection.equals(other.paysCollection))
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "entities.Zone[ codZone=" + codZone + " ]";
    }
    @JsonIgnore
	public Collection<Pays> getPaysCollection() {
		return paysCollection;
	}

	public void setPaysCollection(Collection<Pays> paysCollection) {
		this.paysCollection = paysCollection;
	}

	public Zone(@NotNull @Size(min = 1, max = 2) String codZone, @NotNull @Size(min = 1, max = 60) String libZonea,
			@Size(max = 60) String libZonel, Collection<Pays> paysCollection) {
		super();
		this.codZone = codZone;
		this.libZonea = libZonea;
		this.libZonel = libZonel;
		this.paysCollection = paysCollection;
	}
    
	
}
