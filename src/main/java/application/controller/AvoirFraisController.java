package application.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import application.model.Mission;
import application.model.Missionnaire;
import application.repository.AvoirFraisRepository;
import application.service.AvoirFraisDao;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AvoirFraisController {

	@Autowired
	private AvoirFraisDao avoirFrais ; 
	@Autowired
	private AvoirFraisRepository avoirrep ; 

	@GetMapping("/listeFrais")
	public List<AvoirFrais> getFrais() {
		return avoirFrais.getFrais() ;  
	}
	
	
	@PostMapping("/addFrais")
	public AvoirFrais addFrais(@RequestBody AvoirFrais frais) {
		return avoirFrais.addFrais(frais);
	}
	
	
	@PutMapping("/updateFrais")
	public void updateFrais(@RequestBody AvoirFrais frais) {
		avoirFrais.updateFrais(frais);
		
	}
	
	@DeleteMapping("/delete")
    public void deleteFrais(@RequestBody AvoirFrais frais) {		
	}
	

	
	@RequestMapping(value = "/avoirfraisbymission", method = RequestMethod.POST)
	public List<AvoirFrais> AvoirFraisMiss(@RequestBody AvoirFrais avoirfrais)
	    {
		  return avoirFrais.AvoirFraisByMission(avoirfrais.getNumMission());
	    }

	
    @RequestMapping(value = "/getFraisMission", method = RequestMethod.POST)
	  public List<AvoirFrais> search(@RequestBody AvoirFrais avoirfrais)
	    {
		  return avoirFrais.getFraisMission(avoirfrais.getCode(),avoirfrais.getNumMission(),avoirfrais.getCin(),avoirfrais.getNumord()); 
	   }
    
    @RequestMapping(value = "/getFrais", method = RequestMethod.POST)
	  public List<AvoirFrais> findMission(@RequestBody AvoirFrais a)
	    {
		  return avoirFrais.getFraisMission(a.getCode(),a.getNumMission(),a.getCin(),a.getNumord()) ;
	   }
  
  @RequestMapping(value = "/getSommeFrais", method = RequestMethod.POST)
	  public Integer  getSommeFrais(@RequestBody AvoirFrais a)
	    {
		  return avoirFrais.getSommeValue(a.getCode(),a.getNumMission(),a.getCin(),a.getNumord(),a.getTypFrais()) ;
	    }

  @RequestMapping(value = "/deleteFrais", method = RequestMethod.POST)
	public Boolean delete(@RequestBody AvoirFrais a) {
	
  if( avoirrep.deletefrais(a.getNumord(), a.getNumMission(), a.getCode(), a.getCin())==1) {
  	
		
		 return true ; }
  
  else 
  	
  	return false ; 
  }
}
  

    

