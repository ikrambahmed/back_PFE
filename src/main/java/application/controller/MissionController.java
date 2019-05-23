package application.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import application.model.Missionnaire;
import application.model.DeptGen;
import application.model.Mission;
import application.model.MissionPK;
import application.service.Missiondao;


@RestController
@RequestMapping("/api/mission")
@CrossOrigin("*")
public class MissionController {
	
	@Autowired
	Missiondao missiondao;
	
	
	@GetMapping("/listmission")
	public List<Mission> getMission() {
		return missiondao.getMissions() ; 
		
	}
	
	@GetMapping(value="/getOneMission")
	  public Optional<Mission> getMiss(@RequestBody Mission mission)
	    {
		  return missiondao.getMissionById(mission.getNumMission(),mission.getCode()) ; 
	    }
	
	@PostMapping("/add")
	public Mission addMission(@RequestBody Mission Mission)
	{
		return missiondao.addMission(Mission);
	}
	
	@PutMapping("/update")
	public Mission updateMission(@RequestBody Mission missiona)
	{
		 return missiondao.updateMission(missiona);
		
	}
	@DeleteMapping("/{code}")
	public void deleteMission(@PathVariable Long code)
	{
		 missiondao.deleteMission(code);
	}
    @RequestMapping(value = "/listeMissionByDept", method = RequestMethod.POST)
	  public List<Mission> Findmission(@RequestBody Mission mission)
	    {
    	return missiondao.findMission(mission.getCode());
		
	   }
    
    
    @RequestMapping(value = "/missionValidation", method = RequestMethod.POST)
	  public Mission findMission(@RequestBody Mission mission)
	    {
		  return missiondao.getMissionValidation(mission.getCode(),mission.getNumMission()) ; 
	   }
	
	
	@PostMapping(value="/findById")
	  public Optional<Mission> getMissionById(@RequestBody Mission mission)
	    {
		  return missiondao.getMissionById(mission.getCode() , mission.getNumMission()) ; 
	    }

    @RequestMapping(value = "/latestCode", method = RequestMethod.POST)
	public String findCode(@RequestBody DeptGen  codeDept) {
		return missiondao.findCode(codeDept.getCode());
	}
	
	
    @RequestMapping(value="/CountMission", method = RequestMethod.GET)
	public Integer getCountMission(@RequestParam(name="annee",defaultValue="")String annee) {
		return missiondao.getCountMission(annee) ; 
	}
	
}