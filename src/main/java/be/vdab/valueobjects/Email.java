package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Email implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String REG_EXPR = "^.+@.+\\.[a-z]+$";
	private final String adres;

	public Email(){//default constructor voor JPA
		this.adres = null;
	}
	
	public Email(String adres){
		if (!adres.matches(REG_EXPR)){
			throw new IllegalArgumentException("verkeerd e-mailadres");
		}
		this.adres = adres;
	}

	public String getAdres() {
		return adres;
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Email)) {
			return false;
		}
		return ((Email) obj).adres.equalsIgnoreCase(this.adres);
	}
	
	@Override
	public int hashCode(){
		return adres.toUpperCase().hashCode();
	}
	
	@Override
	public String toString(){
		return adres;
	}
}
