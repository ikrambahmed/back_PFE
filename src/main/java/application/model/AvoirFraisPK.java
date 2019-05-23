package application.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Embeddable
public class AvoirFraisPK implements Serializable {


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	@Column(name="code")
	private String code ; 
	
    @Column(name = "NUM_MISSION")
    private String numMission;
    @Column(name = "NUMORD")
    private short numord;
    @Column(name = "TYP_FRAIS")
    private String typFrais;
    @Column(name = "COD_PAYS")
    private String codPays;
    @Column(name="CIN")
    private String cin ; 
  

	public AvoirFraisPK() {
    }


	public String getNumMission() {
		return numMission;
	}

	public void setNumMission(String numMission) {
		this.numMission = numMission;
	}

	public short getNumord() {
		return numord;
	}

	public void setNumord(short numord) {
		this.numord = numord;
	}

	public String getTypFrais() {
		return typFrais;
	}

	public void setTypFrais(String typFrais) {
		this.typFrais = typFrais;
	}

	public String getCodPays() {
		return codPays;
	}

	public void setCodPays(String codPays) {
		this.codPays = codPays;
	}


	public AvoirFraisPK(String code, String numMission, short numord, String typFrais, String codPays) {
		super();
		this.code = code;
		this.numMission = numMission;
		this.numord = numord;
		this.typFrais = typFrais;
		this.codPays = codPays;
	}




	
}
