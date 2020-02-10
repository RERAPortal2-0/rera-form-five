package in.gov.rera.form.five.controller;

import java.io.InputStream;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.ResourceAccessException;
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.model.ProjectFormFiveModel;
import in.gov.rera.form.five.services.FormFiveService;
import in.gov.rera.form.five.services.ProjectFormFiveService;
import in.gov.rera.form.five.services.impl.GenerateFormFivePDF;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/form_five/pdf")
public class FormFivePdfRestController {
	private static final Logger logger = LogManager.getLogger(FormFivePdfRestController.class);

	@Autowired
	FormFiveService formFiveService;
	
	@Autowired
	ProjectFormFiveService projectformFiveService;
	
	@Autowired
	Environment env;
	
	@GetMapping("/form-five-pdf{formFiveId}")
	public void getFormFivePdfDtlById(@PathVariable("formFiveId")Long formFiveId,
			HttpServletResponse response)
			throws Exception {
		    System.out.println("Form Five PDF called id is " + formFiveId);
		    FormFiveModel  formFiveModel = formFiveService.findById(formFiveId);
		    ProjectFormFiveModel pModel= projectformFiveService.findByProjectId(formFiveModel.getProjectId(),"");
		    Long projectRegId= pModel.getProjectId();
		    InputStream caImage=GenerateFormFivePDF.class.getClassLoader().getResourceAsStream("static/images/calogo.jpg");
		    System.out.println("INput stream is::::::::::::::: "+caImage);
		    byte[] bt=new byte[caImage.available()];
		      caImage.read(bt);
		      caImage.close();
		    Optional.of(formFiveModel).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		   GenerateFormFivePDF util=new GenerateFormFivePDF(formFiveModel,projectRegId,env.getProperty("URL_PROJECT_REG"),env.getProperty("USER_REG_CA"),bt);
		    util.generateFormFive(response);
		/*
		 * Document document = new Document(); PdfWriter
		 * pw=PdfWriter.getInstance(document, response.getOutputStream());
		 * document.open(); util.generateFormFive(document, formFiveModel);
		 * document.close();
		 */
			//Document document = new Document();
	}
}
