package application.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

 public JasperPrint exportPdfFile() throws SQLException, JRException, IOException {
  //Connection conn = jdbcTemplate.getDataSource().getConnection();

  /*String path = resourceLoader.getResource("classpath:report.jrxml").getURI().getPath();

  JasperReport jasperReport = JasperCompileManager.compileReport(path);*/
	 JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\ikram ben ahmed\\Desktop\\back-master\\src\\main\\resources\\report.jrxml");
  JRDataSource datasource = new JREmptyDataSource();

  // Parameters for report
  Map<String, Object> parameters = new HashMap<String, Object>();

  parameters.put("nom", "dorra");
	parameters.put("prenom", "kerro");
	parameters.put("matricule", "1");
	parameters.put("CIN", "14300668");
	
  JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, datasource);
	JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\ikram ben ahmed\\Desktop\\back-master\\src\\main\\resources\\report_pdf.pdf");
	
  return print;
 }
}
