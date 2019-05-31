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

import application.model.Mission;
import application.model.Missionnaire;
import application.model.OrdMis;
import application.repository.Ord_MissRepository;
import application.service.Missiondao;
import application.service.Ord_MissDao;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Ord_MissController  {

	@Autowired
	Ord_MissDao ordMissDao;
	@Autowired
	Ord_MissRepository repository;

	
	@GetMapping("/getAll")
	public List<OrdMis> getOrds() {
		return ordMissDao. findAll(); 
		
	}
	
	@PostMapping("/addordMiss")
	public OrdMis addOrdMiss(@RequestBody OrdMis ordMiss)
	{
		return  ordMissDao.ajouter(ordMiss);
	}
	
	@PutMapping("/updateordMiss")
	public OrdMis Modiford(@RequestBody OrdMis o) {
		 return ordMissDao.updateOrd(o);
		
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Boolean deleteord(@RequestBody OrdMis ord) {
	
			if (repository.delete(ord.getCode(),ord.getCin(),ord.getNumord(),ord.getNumMission())==1) {
				return true;
				
			}
		
		
			else

		
		return false;}

	
	@PostMapping(value="/getMissionnByMision")
	  public List<OrdMis> findMissionnaire(@RequestBody OrdMis ordmis)
	    {
		  return ordMissDao.getMissionnaireByMission(ordmis.getNumMission());
	    }
	
	 @RequestMapping(value ="/latestOrdreCode", method = RequestMethod.POST)
	  
	    public String findNumOrdre(@RequestBody OrdMis ord)
	    {
		  return ordMissDao.getLatestOrdreNum(ord.getCode() ,ord.getNumMission()); 
	   }
	 
	 @RequestMapping(value ="/getOrdreMission", method = RequestMethod.POST)
	  
	    public List<OrdMis> getOrdreMission(@RequestBody OrdMis ordmis)
	    {
		  return ordMissDao.getOrdre(ordmis.getCode());
	   }
	 
	 @RequestMapping(value="/searchMissionnaire",method=RequestMethod.POST)
	 public List<OrdMis> SearchMissionnaire(@RequestBody Missionnaire o )
	 {
		 return ordMissDao.searchOrdMiss(o.getCin(),o.getCode().getCode()); 
	 }
	 
	 @RequestMapping(value="/getAllOrdre",method=RequestMethod.POST)
	 public List<OrdMis> getOdreMisss(@RequestBody OrdMis o )
	 {
		 return ordMissDao.getAllOdre(o.getNumMission(), o.getCode()); 
	 }
	 
	 
	 @RequestMapping(value="/deleteOrdre",method=RequestMethod.POST)
	 public Boolean deleteOrdre(@RequestBody OrdMis o )
	 {
		
		 if (repository.deleteord(o.getNumord(), o.getNumMission(), o.getCode())==1) {
				return true;
				
			}
		
		
			else
		
		return false;
	 }
	 

	 
	 
	 @RequestMapping(value="/getOne",method=RequestMethod.POST)
	 public OrdMis getOne(@RequestBody Missionnaire o )
	 {
		 return ordMissDao.getOne(o.getCin(),o.getCode().getCode()); 
	 }
	 
	 
}
	
