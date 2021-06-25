package com.ensah.core.services.impl;

import com.ensah.core.bo.PieceJustificative;
import com.ensah.core.dao.IDocumentDao;
import com.ensah.core.services.IDocumentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DocumentServiceImpl  implements IDocumentService {

    @Autowired
    private IDocumentDao docmdao;

    @Override
    public void CreateDocument(PieceJustificative dc) {
     
    	
    	System.out.println("from doc service");
    	
    	docmdao.create(dc);
    }

	@Override
	public List<PieceJustificative> getAllPiece() {
		// TODO Auto-generated method stub
		return docmdao.getAll();
	}
}
