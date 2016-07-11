package org.com.kata.compte.metier.services;


import java.util.List;

import org.com.kata.compte.entities.Operation;
import org.com.kata.compte.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Youssef CHAHID
 *
 */
@RestController
@RequestMapping("/api/operations")
public class OperationRestService {
	
	@Autowired
	private OperationMetier operationMetier;

	
	@RequestMapping(value="{idClient}/comptes/{codeCompte}/versement/{montant}",method=RequestMethod.PUT)
	@Transactional
	public boolean versement(@PathVariable Long idClient,@PathVariable String codeCompte,@PathVariable double montant) {
		
		return operationMetier.versement(codeCompte, montant);
	}
	
	@RequestMapping(value="{idClient}/comptes/{codeCompte}/retrait/{montant}",method=RequestMethod.PUT)
	@Transactional
	public boolean retrait(@PathVariable Long idClient,@PathVariable String codeCompte,@PathVariable double montant) {
		return operationMetier.retrait(codeCompte, montant);
	}
	
	@RequestMapping(value="{code}",method=RequestMethod.GET)
	public List<Operation> getCompte(@PathVariable String code) {
		return operationMetier.getOperationByCodeCompte(code);
	}
	
	@RequestMapping(value="/operations",method=RequestMethod.GET)
	public List<Operation> listOperation() {
		return operationMetier.listOperations();
	}
	
}