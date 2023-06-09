package udb.mod2.spingmvc;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@ComponentScan("udb.mod2")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableWebMvc
public class ConfiguradorSpring implements WebMvcConfigurer, ApplicationContextAware {
	private ApplicationContext contexto;
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	return new PersistenceExceptionTranslationPostProcessor();
	}
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	JpaTransactionManager transactionManager = new JpaTransactionManager();
	transactionManager.setEntityManagerFactory(emf);
	return transactionManager;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	LocalContainerEntityManagerFactoryBean em = new
	LocalContainerEntityManagerFactoryBean();
	JpaVendorAdapter adaptador = new HibernateJpaVendorAdapter();
	em.setJpaVendorAdapter(adaptador);
	// mapeo a la unidad de persistencia
	em.setPersistenceUnitName("estudiantes");
	return em;
	}
	
	@Bean
	public ViewResolver viewResolver() {
	ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	resolver.setTemplateEngine(templateEngine());
	resolver.setCharacterEncoding("UTF-8");
	return resolver;
	}
	@Bean
	public ISpringTemplateEngine templateEngine() {
	SpringTemplateEngine engine = new SpringTemplateEngine();
	engine.setEnableSpringELCompiler(true);
	engine.setTemplateResolver(templateResolver());
	return engine;
	}
	// la carpeta donde se van a ubicar los ficheros html
	private ITemplateResolver templateResolver() {
	// que resolutor de plantillas uso
	SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
	// contexto con todos los objetos de spring
	resolver.setApplicationContext(contexto);
	resolver.setPrefix("/WEB-INF/vistas/");
	resolver.setSuffix(".html");
	resolver.setCacheable(false);
	resolver.setTemplateMode(TemplateMode.HTML);
	return resolver;
	}
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/resources/**").addResourceLocations(
	"/WEB-INF/resources/*");
	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	registry.addResourceHandler("/webjars/**").addResourceLocations(
	"classpath:/META-INF/resources/webjars/");
	}
	public void setApplicationContext(ApplicationContext contexto) throws BeansException {
	this.contexto = contexto;
	}
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
	}
	}

