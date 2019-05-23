package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.itextpdf.text.pdf.codec.Base64.OutputStream;

import application.model.Missionnaire;
import application.model.Role;
import application.model.Utilisateur;
import application.repository.RoleRepository;
import application.repository.UserRepository;
import application.service.UserService;
import application.util.RoleEnum;



import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;









@SpringBootApplication
@EntityScan("application.*")
public class MissCniApplication {

	public static void main(String[] args) /* throws JRException */{
		
		
		ConfigurableApplicationContext ctx=SpringApplication.run(MissCniApplication.class, args);
     	RoleRepository roleRepository = ctx.getBean(RoleRepository.class);
     	UserService userService = ctx.getBean(UserService.class) ; 
		

   		
        Role roleOrd = new Role(RoleEnum.ROLE_ORD)  ; 
		Role roleUser = new Role(RoleEnum.ROLE_USER);
		Role roleAdmin = new Role(RoleEnum.ROLE_ADMIN);
		Role roleControl = new Role(RoleEnum.ROLE_CONTROL);
		Role rolePayeur = new Role(RoleEnum.ROLE_PAYEUR) ; 
		Role roleMinstr = new Role(RoleEnum.ROLE_MINSTR) ; 
		
		
		roleRepository.save(roleOrd) ; 
		roleRepository.save(roleControl) ;
		roleRepository.save(rolePayeur) ; 
		roleRepository.save(roleMinstr) ; 
		roleRepository.save(roleUser);
		roleRepository.save(roleAdmin);
		
		UserRepository userRepository = ctx.getBean(UserRepository.class);
        String pass=userService.hashPassword("password1") ; 

		Utilisateur user = new Utilisateur("user",pass, true);
		user.setRoles(Arrays.asList(roleUser));
		userRepository.save(user);
        String pas=userService.hashPassword("pass3") ; 
		Utilisateur use = new Utilisateur("98765432","الورغمي","نجاة",pas, true);
		use.setRoles(Arrays.asList(roleUser, roleControl));
		userRepository.save(use);

		
        String pass2=userService.hashPassword("password2") ; 
		Utilisateur admin = new Utilisateur("12345678","Sghaier","Jamila", pass2, true);
		admin.setRoles(Arrays.asList(roleUser));
		userRepository.save(admin);
        
		
		String pass1=userService.hashPassword("ikram") ; 
		Utilisateur user1 = new Utilisateur("11406260","الرياحي","الهام",pass1, true);
		user1.setRoles(Arrays.asList(roleOrd,roleUser));
		userRepository.save(user1);
		
		
		String pass11=userService.hashPassword("souha") ; 
		Utilisateur user11 = new Utilisateur("07481756","سبوعي","سهى",pass11, true);
		user11.setRoles(Arrays.asList(roleOrd,roleUser));
		userRepository.save(user11);
		
		
		
try {
			
			JasperReport jasper = JasperCompileManager.compileReport("C:\\Users\\ikram ben ahmed\\Desktop\\back-master\\src\\main\\resources\\report.jrxml");
			JRDataSource datasource = new JREmptyDataSource();
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("nom", "dorra");
			parameters.put("prenom", "kerro");
			parameters.put("matricule", "1");
			parameters.put("CIN", "14300668");
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parameters,datasource );
			JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\ikram ben ahmed\\Desktop\\back-master\\src\\main\\resources\\report_pdf.pdf");
			
			
			
			
			
		}catch(Exception e) {e.printStackTrace();}
		
		
		
		
		
		
		
		

	}

}
