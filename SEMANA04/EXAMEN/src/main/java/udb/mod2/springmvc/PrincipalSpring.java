package udb.mod2.springmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



public class PrincipalSpring implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		try {
			AnnotationConfigWebApplicationContext contexto = new AnnotationConfigWebApplicationContext();
			   // registra los beans de spring
			   contexto.register(ConfiguradorSpring.class);
			   
			   // esta nos liga el contexto o la aplicacion web al configurador		   
			   contexto.setServletContext(servletContext);
			   
			   // carga dinamicamente el servlet de Spring Framework
			   // que es el servlet controlador con el cual manejamos la aplicacion
			   // por completo
			   ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(contexto));
				servlet.setLoadOnStartup(1);
				servlet.addMapping("/");
		}
	catch(Exception e) {
		e.printStackTrace();
	}
		
	}

}
