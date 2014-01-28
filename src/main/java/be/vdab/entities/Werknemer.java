package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import be.vdab.valueobjects.Email;

@Entity @Table(name = "werknemers" )
public class Werknemer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private long id;
	
	@NotNull
	@Size(min = 1, max=50, message="{Size.tekst}")
	private String familienaam;
	
	@NotNull
	@Size(min = 1, max=50, message="{Size.tekst}")
	private String voornaam;
	
	@Valid
	@Size(max=50)
	@Embedded
	private Email email;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name = "jobtitelId")
	private Jobtitel jobtitel;// TODO!!!

	public Jobtitel getJobtitel() {
		return jobtitel;
	}

	public void setJobtitel(Jobtitel jobtitel) {
		this.jobtitel = jobtitel;
	}	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chefid")
	private Werknemer chef;

	public Werknemer getChef() {
		return chef;
	}

	public void setChef(Werknemer werknemer) {
		if (this.chef != null && this.chef.getWerknemers().contains(this)) {
			this.chef.removeWerknemer(this);
		}
		this.chef = werknemer;
		if (werknemer != null && !werknemer.getWerknemers().contains(this)) {
			werknemer.addWerknemer(this);
		}
	}	

	@OneToMany(mappedBy = "chef")
	private Set<Werknemer> werknemers;

	public Set<Werknemer> getWerknemers() {
		return werknemers;
	}

	public void setWerknemers(Set<Werknemer> werknemers) {
		this.werknemers = werknemers;
	}

	public void addWerknemer(Werknemer werknemer) {
		werknemers.add(werknemer);
		if (werknemer.getChef() != this) {
			werknemer.setChef(this);
		}
	}

	public void removeWerknemer(Werknemer werknemer) {
		werknemers.remove(werknemer);
		if (werknemer.getChef() == this) {
			werknemer.setChef(null);
		}
	}

	
	@NotNull
	@DecimalMin("0")
	@Digits(integer = 10, fraction = 2)
	@NumberFormat(pattern="#,##")
	private BigDecimal salaris;
	
	public Werknemer() {
		email = new Email();
		jobtitel = new Jobtitel();
		werknemers = new HashSet<Werknemer>();
	}

	public Werknemer(String familienaam, String voornaam, Email email, BigDecimal salaris) {
		setFamilienaam(familienaam);
		setVoornaam(voornaam);
		setEmail(email);
		setSalaris(salaris);		
	}
	
	public Werknemer(Long id, String familienaam, String voornaam, Email email,
						BigDecimal salaris) {
		this(familienaam, voornaam, email, salaris);
		setId(id);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public BigDecimal getSalaris() {
		return salaris;
	}

	public void setSalaris(BigDecimal salaris) {
		this.salaris = salaris;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Werknemer other = (Werknemer) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Werknemer [id=" + id + ", familienaam=" + familienaam
				+ ", voornaam=" + voornaam + ", email=" + email + ", jobtitel="
				+ jobtitel + ", chef=" + chef + ", werknemers=" + werknemers
				+ ", salaris=" + salaris + "]";
	}

}
