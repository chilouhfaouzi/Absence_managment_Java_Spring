package com.ensah.core.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.ensah.core.web.models.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ensah.core.bo.CadreAdministrateur;
import com.ensah.core.bo.Utilisateur;
import com.ensah.core.dao.IMessageDao;
import com.ensah.core.services.IAbsenceService;
import com.ensah.core.services.IPersonService;

@Controller
@RequestMapping("/studentt") 
public class StudentAbsenceController {

	
	 @Autowired 
	 private IAbsenceService absenceService;
	 
	 
	 @Autowired
	 private IPersonService personService;
	 
	 @Autowired
	private HttpSession httpSession;

	 
	 @Autowired 
	 private IMessageDao messagedao;


	
	@RequestMapping(value = "justifie/{idAbsence}", method = RequestMethod.GET)

	public String ShowPag(@PathVariable int idAbsence, Model model) {


		DocumentModel documentModel = new DocumentModel();


		model.addAttribute("DocumentModel", documentModel);
		model.addAttribute("absenceList", absenceService.getAbsenceByIns((long) 2) );
		  
		model.addAttribute("idAbcense", idAbsence);
		  
		  
		 
		/*
			 * model.addAttribute("personList", personService.getAllPersons());
			 */
			 
			
			/*
			 * return "student//justifieForm";
			 */
		return "student/justifieForm";
	}
	
	/*
	 * @RequestMapping(value = "/uploadFile", method = RequestMethod.POST) public
	 * String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
	 * modelMap.addAttribute("file", file); return "student/fileUploadView"; }
	 */
	
	@RequestMapping(value = "messagereclamation", method = RequestMethod.GET)
	public String  messageReclamation( Model model) {
		UserAndAccountInfos userInfo = (UserAndAccountInfos) httpSession.getAttribute("userInfo");

		MessageModel msgModel = new MessageModel(Long.valueOf(userInfo.getIdPersonne()));
		
		model.addAttribute("MessageModel", msgModel );

		model.addAttribute("messages", messagedao.getAll() );
		
		List<Utilisateur> persons = personService.getAllPersons();
		List<PersonModel> modelPersons = new ArrayList<PersonModel>();
		// On copie les données des personnes vers le modèle
		for (int i = 0; i < persons.size(); i++) {
			PersonModel pm = new PersonModel();
			if (persons.get(i) instanceof CadreAdministrateur) {
				BeanUtils.copyProperties((CadreAdministrateur) persons.get(i), pm);
				pm.setTypePerson(PersonModel.TYPE_CADRE_ADMIN);
				modelPersons.add(pm);
			}
		}

		// Mettre la liste des personnes dans le modèle de Spring MVC
		model.addAttribute("AdminList", modelPersons);

	    return "student/msgReclamation";
	}
	
}
