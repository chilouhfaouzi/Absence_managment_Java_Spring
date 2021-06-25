package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.PieceJustificative;

public interface IDocumentService {

    public void CreateDocument(PieceJustificative dc);
    
	
	public  List<PieceJustificative> getAllPiece() ;
}
