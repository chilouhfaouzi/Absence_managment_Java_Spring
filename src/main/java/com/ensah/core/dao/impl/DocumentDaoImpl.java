package com.ensah.core.dao.impl;

import com.ensah.core.bo.PieceJustificative;
import com.ensah.core.dao.IAuteurDao;
import com.ensah.core.dao.IDocumentDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;
import org.springframework.stereotype.Repository;


@Repository
public class DocumentDaoImpl extends HibernateSpringGenericDaoImpl<PieceJustificative, Long> implements IDocumentDao {
    
    public DocumentDaoImpl() {
        super(PieceJustificative.class);
    }

}