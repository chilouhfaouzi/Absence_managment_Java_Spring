package com.ensah.core.web.controllers;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;  
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.Etudiant;
import com.ensah.core.bo.PieceJustificative;
import com.ensah.core.services.IAbsenceService;
import com.ensah.core.services.IDocumentService;
import com.ensah.core.web.models.AbsenceModel;
import com.ensah.core.web.models.PersonModel;

import antlr.collections.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ensah.core.web.models.DocumentModel;

@Controller
@RequestMapping("/studentfile")
public class FileUploadController {

//    private String saveDirectory =  "/resources/files/";
	@Autowired
	IDocumentService documentService;
	
	
	 @Autowired 
	 private IAbsenceService absenceService;
	 

	private String saveDirectory = "C:/Users/Fawzi/Downloads/Compressed/gs_absence_repo-master_2/gs_absence_repo-master/absence_management/src/main/webapp/resources/files/";

	
	@RequestMapping(value = "uploadfile", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model,
			@Valid @ModelAttribute("DocumentModel") DocumentModel document, BindingResult bindingResult,
			HttpServletRequest request) throws Exception {

		PieceJustificative myPieceJustificative = new PieceJustificative();

		ArrayList<Absence> list =  (ArrayList<Absence>) absenceService.getAbsenceByIns((long)1);
		
//		ArrayList<Absence> list = new ArrayList<Absence>();
		
				
			
		BeanUtils.copyProperties(document, myPieceJustificative);

		list.add(document.getAbsence().get(0));
		
		System.out.println(document.getAbsence().get(0));
		

		myPieceJustificative.setIntitule(document.getIntitule());
		myPieceJustificative.setEtat(0);
		myPieceJustificative.setAbsence(list);
		
		/* Format the date */
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss.SSSSSS");  
		Date date = new Date(); 
		
		//convert the string to date  
		Date myDate = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss.SSSSSS").parse(formatter.format(date));
		myPieceJustificative.setDateLivraison( myDate );
		
		

		if (bindingResult.hasErrors()) {

			return "student/updateAccount";

		}

//    	DocumentModel document = new DocumentModel();
//        AbsenceModel absenceModel = new AbsenceModel();

//
//  	ServletContext context = request.getServletContext();
//  	String myDir = context.getRealPath("/") ;
//
//  	System.out.println("contextPath : "+ myDir   );
//
//        System.out.println("description: " + request.getParameter("description"));

		System.out.println("Saving file: " + file.getOriginalFilename());

		if (!file.getOriginalFilename().equals("")) {
			/*
			 * File myfile = new File(saveDirectory + aFile.getOriginalFilename());
			 */
			File myfile = new File(saveDirectory + file.getOriginalFilename());
			String canonicFile = ""+ myfile.getCanonicalFile();
			canonicFile.replaceAll("\\\\", "/");
			
			System.out.println("path : " +canonicFile );

			myPieceJustificative.setCheminFichier(canonicFile);

			file.transferTo(myfile);

		}
		documentService.CreateDocument(myPieceJustificative);
		
		
		model.addAttribute("pieceList", documentService.getAllPiece() );

		// returns to the view "Result"
		return "student/fileUploadView";
	}
	
	
	@RequestMapping(value = "showpieces")
	public String showPieces( Model model) {
		model.addAttribute("pieceList", documentService.getAllPiece() );

		// returns to the view "Result"
		return "student/fileUploadView";
		
	}
 			
			
			

}
