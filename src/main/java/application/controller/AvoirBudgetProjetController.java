package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.model.AvoirBudget;
import application.model.AvoirBudgetProjet;
import application.model.DeptGen;
import application.model.Projet;
import application.service.AvoirBudgetDao;
import application.service.AvoirBudgetProjetDao;



@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AvoirBudgetProjetController {
	@Autowired
	private AvoirBudgetProjetDao avoirBudgetProjetDao ; 
	
	@GetMapping("/listeBudgetProjet")
	public List<AvoirBudgetProjet> getFrais() {
		return avoirBudgetProjetDao.findAll() ;  
	}
	 @RequestMapping(value = "/listBudgetProjetbydept", method = RequestMethod.POST)
	public List<AvoirBudgetProjet>findbugetPByyears(@RequestBody DeptGen codeDept){
		return avoirBudgetProjetDao.getbugetPBydept(codeDept.getCode());
		
	}
	
	 @PostMapping("/addBProjet")
		public AvoirBudgetProjet addBProjet(@RequestBody AvoirBudgetProjet p)
		{
			 return avoirBudgetProjetDao.addBudgetProjet(p);
		}

	  @PutMapping("updateBudgetProjet")
			public AvoirBudgetProjet updateBudget(@RequestBody AvoirBudgetProjet a)
			{
				return avoirBudgetProjetDao.updateBudgetProjet(a);
				
			}

}
