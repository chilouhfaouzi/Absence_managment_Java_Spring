package com.ensah.core.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ensah.core.bo.Auteur;
import com.ensah.core.bo.Emprunt;
import com.ensah.core.bo.Livre;
import com.ensah.core.bo.Utilisateur;
import com.ensah.core.services.IGsLivresServices;
import com.ensah.core.services.IPersonService;
import com.ensah.genericdao.EntityNotFoundException;

@Controller
@RequestMapping("/biblio")
public class GsLivreController {

	@Autowired
	private IGsLivresServices gsLivreServices;
	
	@Autowired
	private  IPersonService personServices;

	@RequestMapping(value = "empruntForm", method = RequestMethod.GET)
	public String empruntForm(Model model) {

		Emprunt emp = new Emprunt();
		model.addAttribute("empruntModel", emp);

		return "biblio/empruntForm";
	}

	@PostMapping("/realiserEmprunt")
	public String realiserEmprunt(@ModelAttribute("empruntModel") Emprunt emprunt, Model model) {
		try {
			gsLivreServices.addEmprunt(emprunt.getLivre().getCodeLivre(), emprunt.getUtilisateur().getCin());
			// Enregistrer un message de succes
			model.addAttribute("msg", "Emprunt enregistrée avec succès");
			return "biblio/empruntForm";
		} catch (EntityNotFoundException e) {
			// Enregistrer un message d'erreur
			model.addAttribute("error", e.getMessage());
		}
		return "biblio/empruntForm";
	}

	@RequestMapping(value = "getAllAuthors", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Auteur> getAllAuthors(Model model) {

		List<Auteur> auteurs = gsLivreServices.getAllAuthors();
		for (Auteur it : auteurs) {
			System.out.println(it);
		}
		return auteurs;
	}
	
	
	@RequestMapping(value = "getBookByCodeJson", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Livre getBookByCodeJson(@RequestParam String code) {

		Livre l = gsLivreServices.getLivreByCode(code);
	
		return l;
	}
	
	@RequestMapping(value = "getUserByCinJson", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Utilisateur getUserByCinJson(@RequestParam String cin) {

		Utilisateur persons = personServices.getPersonByCin(cin);
	
		return persons;
	}

}
