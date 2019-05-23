package application.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.model.AvoirBudget;
import application.model.AvoirFrais;
import application.model.Missionnaire;
import application.model.Projet;
import application.service.AvoirBudgetDao;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AvoirBudgetController {
	@Autowired
	private AvoirBudgetDao avoirBudgetDao ; 
	
	
	@GetMapping("/listeBudget")
	public List<AvoirBudget> getFrais() {
		return avoirBudgetDao.findAll() ;  
	}
	
	
	
	 @RequestMapping(value = "/listbyDept", method = RequestMethod.POST)
	public List<AvoirBudget> findbugetByyearsBydept(@RequestBody AvoirBudget avoirbudget){
	
		return avoirBudgetDao.getbugetByyearsBydept(avoirbudget.getCode());
		
	}
	
	  @PostMapping("/addBudget")
		public AvoirBudget addbudget(@RequestBody AvoirBudget p)
		{
			 return avoirBudgetDao.addBudget(p);
		}
	  @PutMapping("updateBudget")
		public AvoirBudget updateBudget(@RequestBody AvoirBudget a)
		{
			return avoirBudgetDao.updateBudget(a);
			
		}
	

	 @RequestMapping(value = "/budgetbytype", method = RequestMethod.POST)
	public List<AvoirBudget> findBudget(@RequestBody AvoirBudget avoirbudget){
		return avoirBudgetDao.getBudgetByType(avoirbudget.getType_budget());
	}
	
	
	@RequestMapping(value = "/budgetbydate", method = RequestMethod.POST)
	public List<AvoirBudget> getbudgetbyDate(@RequestBody AvoirBudget avoirbudget){
		return avoirBudgetDao.getBugetByDate(avoirbudget.getDate_val());
	}
	
}
