package com.ensah.core.services.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Auteur;
import com.ensah.core.bo.Emprunt;
import com.ensah.core.bo.Livre;
import com.ensah.core.bo.Utilisateur;
import com.ensah.core.dao.IAuteurDao;
import com.ensah.core.dao.IEmpruntDao;
import com.ensah.core.dao.ILivreDao;
import com.ensah.core.dao.IUtilisateurDao;
import com.ensah.core.services.IGsLivresServices;
import com.ensah.genericdao.EntityNotFoundException;

@Service
@Transactional
public class GsLivresServicesImpl implements IGsLivresServices {

	private final Logger LOGGER = Logger.getLogger(getClass());

	@Autowired
	private ILivreDao livreDao;
	
	@Autowired
	private IAuteurDao authorDao;

	@Autowired
	private IEmpruntDao empruntDao;

	@Autowired
	private IUtilisateurDao userDao;

	public Livre getLivreById(Long idLivre) {
		return livreDao.findById(idLivre);
	}

	public Livre getLivreByCode(String codeLivre) throws EntityNotFoundException {
		List<Livre> listLivres = livreDao.getEntityByColValue("Livre", "codeLivre", codeLivre);
		if (listLivres.isEmpty()) {
			throw new EntityNotFoundException("Le livre avec le code " + codeLivre + " est introuvable");
		}
		return listLivres.get(0);
	}

	@Override
	public void addEmprunt(String codeLivre, String cin) {
		Livre l = null;
		Utilisateur u = null;
		// Vérifier que le livre existe
		try {
			l = getLivreByCode(codeLivre);
		} catch (EntityNotFoundException e) {

			LOGGER.debug("book with codeLivre = " + codeLivre + "is not found. ");
			throw new EntityNotFoundException("The book with code :" + codeLivre + " is not found", e);
		}

		List<Utilisateur> users = userDao.getEntityByColValue("Utilisateur", "cin", cin);
		if (users.isEmpty()) {
			LOGGER.debug("No user found in database with id : " + cin);
			throw new EntityNotFoundException("No user found in database with cin : " + cin);
		}

		// Si les deux existe alors on execute la transaction
		Emprunt emprunt = new Emprunt();
		emprunt.setLivre(l);
		emprunt.setUtilisateur(u);
		emprunt.setDateEmprunt(new Date());
		empruntDao.create(emprunt);

	}

	@Override
	public List<Auteur> getAllAuthors() {
		
		return authorDao.getAll();
	}

}
