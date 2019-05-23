package application.controller;



import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import application.service.UserReport;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
@RequestMapping("/api")
public class reportController {

 @Autowired
 private UserReport userService;

 @RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
 public ModelAndView home() {
  ModelAndView model = new ModelAndView();

  model.setViewName("home");
  return model;
 }

 @RequestMapping(value = "/export", method = RequestMethod.POST)
 public void export(ModelAndView model, HttpServletResponse response) throws IOException, JRException, SQLException {
  JasperPrint jasperPrint = null;

  response.setContentType("application/x-download");
  response.setHeader("Content-Disposition", String.format("attachment; filename=\"report.pdf\""));

  OutputStream out = response.getOutputStream();
  jasperPrint = userService.exportPdfFile();
  JasperExportManager.exportReportToPdfStream(jasperPrint, out);
 }
}
