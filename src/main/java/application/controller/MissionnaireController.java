package application.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
import org.springframework.web.servlet.ModelAndView;

import application.model.DeptGen;
import application.model.Missionnaire;
import application.repository.MissionnaireRepository;
import application.service.MissionnaireService;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MissionnaireController {
	
	@Autowired
	private MissionnaireService missionaireService ; 
	@Autowired
	private ApplicationContext appContext ;

	
	@RequestMapping(value = "/getOneMiss", method = RequestMethod.POST)
	  public Optional<Missionnaire> getMiss(@RequestBody Missionnaire mis)
	    {
		  return missionaireService.getMissionnaire(mis.getCin() , mis.getCode().getCode()) ; 
	    }
		
	@GetMapping("/missionaire")
	public List<Missionnaire> getMissionaires() {
		return missionaireService.getMissionnaires() ; 
		
	}
	
	@PostMapping("/add")
	public Missionnaire addMissionaire(@RequestBody Missionnaire missionaire)
	{
		 return missionaireService.addMissionaire(missionaire);
	}
	
	@PutMapping
	public void updateMissionaire(@RequestBody Missionnaire missionaire)
	{
		missionaireService.updateMissionaire(missionaire);
		
	}
	@DeleteMapping("/{cin}")
	public void deleteMissionaire(@PathVariable String cin)
	{
		missionaireService.deleteteMissionaire(cin);
	}
	
	


	@RequestMapping(value = "/listeMissionnaireByDept", method = RequestMethod.POST)
	  public List<Missionnaire> FindMissionnaire(@RequestBody DeptGen deptgen)
	    {
		  return missionaireService.findMissionnaire(deptgen.getCode());
	   }
	@Autowired
	private MissionnaireRepository missionnairerep;

	@PostMapping(value="/listMissDept")
	public List<Missionnaire> findOnMissionnaireDept(@RequestBody DeptGen deptgen) {
	
	return missionaireService.findOneMissionnaireDept(deptgen.getCode()) ; 
	}
	 @RequestMapping(value = "/deleteMissionnaire", method = RequestMethod.POST)
		public Boolean deleteMissionnaire(@RequestBody Missionnaire m) {
		
				if (missionnairerep.delete(m.getCin())==1) {
					return true;
					
				}
			
			 
				else return false;}
	 
	/* @RequestMapping(value = "/getReport", method = RequestMethod.GET)
	 public ModelAndView report1()	{
		/*  JasperReportsPdfView view = new JasperReportsPdfView() ; 
		  view.setUrl("classpath:/ressources/Blank_A4.jrxml") ; 
		  view.setApplicationContext(appContext);
		  Map<String ,Object> params= new HashMap<String ,Object>() ; 
		  params.put("datasource",missionaireService.report()) ; 
		  return new ModelAndView(view,params); 
		  
	  }*/
}
