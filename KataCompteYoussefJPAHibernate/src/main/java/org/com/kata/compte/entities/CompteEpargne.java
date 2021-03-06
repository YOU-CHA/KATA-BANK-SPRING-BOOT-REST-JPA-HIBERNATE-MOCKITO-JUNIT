package org.com.kata.compte.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;
/**
 * 
 * @author Youssef CHAHID
 *
 */
@Entity
@DiscriminatorValue("CE")

@XmlType(name="CE")
public class CompteEpargne extends Compte {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public CompteEpargne(String codeCompte, Date dateCreation, double solde,
			double taux) {
		super(codeCompte, dateCreation, solde);
		this.taux = taux;
	}

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
