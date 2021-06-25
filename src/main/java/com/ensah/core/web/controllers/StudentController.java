package com.ensah.core.web.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensah.core.bo.Etudiant;
import com.ensah.core.bo.Utilisateur;
import com.ensah.core.services.IAbsenceService;
import com.ensah.core.services.ICompteService;
import com.ensah.core.services.IPersonService;
import com.ensah.core.web.models.FicheAbsenseModel;
import com.ensah.core.web.models.PersonModel;
import com.ensah.core.web.models.UserAndAccountInfos;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	 @Autowired 
	 private IAbsenceService absenceService;
	 
	 @Autowired
 	 private IPersonService personService;
	 
	 @Autowired
		private HttpSession httpSession;

//	@Autowired
//	private ICompteService userService; 
//
//	@Autowired
//	private IPersonService personService; 

	// @GetMapping("/showtest")
	@RequestMapping(value = "/showtest", method = RequestMethod.GET)

	public String ShowPage(@ModelAttribute("FicheAbsenseModel") FicheAbsenseModel personModel, Model model) {

		
		  model.addAttribute("absenceList", absenceService.getAbsenceByIns((long)1) );
		 
		/*
			 * model.addAttribute("personList", personService.getAllPersons());
			 */
		return "student/test";
	}
	
	@RequestMapping(value = "updatePersonForm/", method = RequestMethod.GET)
	public String updateStudentForm(Model model) {

		
		UserAndAccountInfos userInfo = (UserAndAccountInfos) httpSession.getAttribute("userInfo");
		

		// On reoit comme paramètre l'id de la personne à mettre à jour
		Utilisateur utl = personService.getPersonById(Long.valueOf(userInfo.getIdPersonne()));
		

		// On construit le modèle
		PersonModel pm = new PersonModel();
		
		BeanUtils.copyProperties((Etudiant) utl, pm);
		pm.setTypePerson(PersonModel.TYPE_STUDENT);
		
		model.addAttribute("personModel", pm);

		
		return "student/updateAccount";
	}
	
	
	@RequestMapping("updateStudent")
	public String updatePerson(@Valid @ModelAttribute("personModel") PersonModel person, BindingResult bindingResult,
			Model model) {

		// En cas d'erreur
		if (bindingResult.hasErrors()) {

			return "student/updateAccount";
		}
		
		Etudiant etd = new Etudiant();
		BeanUtils.copyProperties(person, etd);

		personService.updatePerson(etd);
		
		// Mettre le message de succès dans le modèle
		model.addAttribute("msg", "Opération effectuée avec succès");
     	return "student/updateAccount";

	}
	
	
	@RequestMapping(value = "justifie", method = RequestMethod.GET)

	public String ShowPag(@ModelAttribute("FicheAbsenseModel") FicheAbsenseModel personModel, Model model) {

		
		  model.addAttribute("absenceList", absenceService.getAbsenceByIns((long)1) );
		 
		/*
			 * model.addAttribute("personList", personService.getAllPersons());
			 */
			 
			
			/*
			 * return "student//justifieForm";
			 */
		return "student/test";
	}
	
	

}
