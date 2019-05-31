package application.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import application.model.Missionnaire;
import application.model.OrdMis;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Transactional
@Repository
public class UserDaoImpl {

 @Autowired
 @Qualifier("jdbcTemplate")
 private JdbcTemplate jdbcTemplate;

 @Autowired
 private ResourceLoader resourceLoader;
 
 private Ord_MissDao ord ;

 public JasperPrint exportPdfFile(OrdMis ord2) throws SQLException, JRException, IOException {
  //Connection conn = jdbcTemplate.getDataSource().getConnection();

  /*String path = resourceLoader.getResource("classpath:report.jrxml").getURI().getPath();

  JasperReport jasperReport = JasperCompileManager.compileReport(path);*/
	//List<OrdMis> l = ord.searchOrdMiss(missionnaire.getCin(), missionnaire.getCode().getCode()) ; 
	 JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\ikram ben ahmed\\Desktop\\back-master\\src\\main\\resources\\report.jrxml");
  JRDataSource datasource = new JREmptyDataSource();

  // Parameters for report
  Map<String, Object> parameters = new HashMap<String, Object>();

  
    parameters.put("nom", ord2.getMissionnaire().getNomL());
	parameters.put("prenom",ord2.getMissionnaire().getPrenomL());
	parameters.put("matricule",ord2.getMissionnaire().getMatricule());
	parameters.put("CIN",ord2.getMissionnaire().getCin());
	parameters.put("code", ord2.getMissionnaire().getCode());
	parameters.put("duree", ord2.getDuree()) ; 
	//parameters.put("date_debut", ord2.getDatarrP()) ; 
	//parameters.put("date_retour", ord2.getDatarrR()) ; 
	parameters.put("numord", ord2.getNumord()+"") ; 
	parameters.put("nummission", ord2.getNumMission()) ; 
	parameters.put("objetA", ord2.getMission().getObjetl()) ; 
	parameters.put("codedept", ord2.getMissionnaire().getCode().getLibL()) ; 





	
	
	
	
	
  JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, datasource);
	JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\ikram ben ahmed\\Desktop\\files\\report_pdf.pdf");
	
  return print;
 }
}
