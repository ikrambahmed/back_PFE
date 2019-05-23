package application.service;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

@Service
@Primary
public class UserReport {

 @Autowired
 private UserDaoImpl userDao;
 
 public JasperPrint exportPdfFile() throws SQLException, JRException, IOException {
  return userDao.exportPdfFile();
 }
}
