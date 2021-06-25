package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Utilisateur;
import com.ensah.core.dao.IUtilisateurDao;
import com.ensah.core.services.IPersonService;
import com.ensah.core.utils.ExcelExporter;

@Service
@Transactional
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private IUtilisateurDao personDao;

	public List<Utilisateur> getAllPersons() {

		return personDao.getAll();
	}

	public void deletePerson(Long id) {
		personDao.delete(id);

	}

	public Utilisateur getPersonById(Long id) {
		return personDao.findById(id);

	}

	public void addPerson(Utilisateur pPerson) {
		personDao.create(pPerson);

	}

	public void updatePerson(Utilisateur pPerson) {
		personDao.update(pPerson);

	}

	public ExcelExporter preparePersonExport(List<Utilisateur> persons) {
		String[] columnNames = new String[] { "Nom", "Prénom", "CIN", "Email", "Télé" };
		String[][] data = new String[persons.size()][5];

		int i = 0;
		for (Utilisateur u : persons) {
			data[i][0] = u.getNom();
			data[i][1] = u.getPrenom();
			data[i][2] = u.getCin();
			data[i][3] = u.getEmail();
			data[i][4] = u.getTelephone();
			i++;
		}

		return new ExcelExporter(columnNames, data, "persons");

	}

	public Utilisateur getPersonByCin(String cin) {
		List<Utilisateur> u = personDao.getEntityByColValue("Utilisateur", "cin", cin);
		if (u != null && u.size() != 0) {
			return personDao.getEntityByColValue("Utilisateur", "cin", cin).get(0);
		}

		return null;

	}

}
