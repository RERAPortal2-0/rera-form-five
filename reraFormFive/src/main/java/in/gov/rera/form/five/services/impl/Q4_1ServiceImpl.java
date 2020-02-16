package in.gov.rera.form.five.services.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gov.rera.form.five.common.RestTamplateUtility;
import in.gov.rera.form.five.common.Util;
import in.gov.rera.form.five.dao.FormFiveDao;
import in.gov.rera.form.five.dao.Q4_1Dao;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.CAModel;
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.model.FormFiveQ4_1Model;
import in.gov.rera.form.five.services.FormFiveService;
import in.gov.rera.form.five.services.Q4_1Service;

@Service
@Transactional
public class Q4_1ServiceImpl implements Q4_1Service { 
	
	@Autowired 
	Q4_1Dao q4_1Dao;

	@Override
	public FormFiveQ4_1Model findById(Long id) {
		return q4_1Dao.findById(id).get();
	}

	@Override
	public List<FormFiveQ4_1Model> findByFormFiveId(Long id) {
		return q4_1Dao.findByFormFiveId(id);
	}
	@Override
	public List<FormFiveQ4_1Model> validateCaDtlExl(XSSFSheet caDtlExl,FormFiveModel pModel,String caUrl) throws ResourceNotFoundException, ParseException {

	    
	    
		int row=2;
		if(caDtlExl.getPhysicalNumberOfRows()==1)
		{
			throw new ResourceNotFoundException("Empty excel file can not be uploaded");
		}
	List<FormFiveQ4_1Model> caDtlList =new ArrayList<>();
		for (int i=1;i<caDtlExl.getPhysicalNumberOfRows();i++) {
		FormFiveQ4_1Model caModel= new FormFiveQ4_1Model();
		caModel.setCaName(Util.isCharacter(Util.checkNullSpace(caDtlExl.getRow(i).getCell(0).toString(),"SheetName: "+caDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 1"),"SheetName: "+caDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 1"));
		caModel.setCaNumber(isCAExists(Util.isCALength(Util.isNumeric(Util.checkNullSpace(caDtlExl.getRow(i).getCell(1).toString(),"SheetName: "+caDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2"),"SheetName: "+caDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2"),"SheetName: "+caDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2"),"SheetName: "+caDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2",caUrl));
		caModel.setDateCertificate(Util.checkNullSpace(caDtlExl.getRow(i).getCell(2).toString(),"SheetName: "+caDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 3"));
		caModel.setFormFiveId(pModel.getFormFiveId());
		caDtlList.add(caModel);
		row++;
		}
		return caDtlList;
	}

	public static String isCAExists(String caNumber, String msg,String caUrl)throws ResourceNotFoundException { 
		
		CAModel model = RestTamplateUtility.caDtl(caNumber,caUrl );
		    if(null==model)
		    	{
		    	throw new  ResourceNotFoundException("CA Number not registered in "+ msg);
		    	}
		    else {
		    	return caNumber;
		    }
		}
	
	@Override
	public List<FormFiveQ4_1Model> saveCADtl(List<FormFiveQ4_1Model> caDtlList) {
		return  (List<FormFiveQ4_1Model>) q4_1Dao.saveAll(caDtlList);
	}
	@Override
	public Integer removeAll(Long formFiveId) {
		System.out.println("Inside Deleted:::::::::::::::::::");
		System.out.println("formFiveId:"+formFiveId);
		Integer  b=q4_1Dao.deleteByFormFiveId(formFiveId);
		System.out.println("result:"+b);
		return b;
	}
	

}
