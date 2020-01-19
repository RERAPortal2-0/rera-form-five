package in.gov.rera.form.five.services.Impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gov.rera.form.five.common.Util;
import in.gov.rera.form.five.dao.Q11_1Dao;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveQ11_1Model;
import in.gov.rera.form.five.services.Q11_1Service;

@Service
@Transactional
public class Q11_1ServiceImpl implements Q11_1Service { 

	@Autowired 
	Q11_1Dao q11_1Dao;

	@Override
	public FormFiveQ11_1Model findById(Long id) {
		return q11_1Dao.findById(id).get();
	}

	@Override
	public List<FormFiveQ11_1Model> findByFormFiveId(Long id) {
		return q11_1Dao.findByFormFiveId(id);
	}

	@Override
	public List<FormFiveQ11_1Model> validateLoanDtlExl(XSSFSheet depositDtlExl,Long formFiveId) throws ResourceNotFoundException, ParseException {
	int row=2;
	List<FormFiveQ11_1Model> loanDtlList =new ArrayList<FormFiveQ11_1Model>();
		for (int i=1;i<depositDtlExl.getPhysicalNumberOfRows();i++) {
			FormFiveQ11_1Model model= new FormFiveQ11_1Model();
			  model.setFormTitle(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(0
			  ).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+
			  row+" ,Cell No : 1"));
			  model.setCertifyProfessionalForm(Util.checkNullSpace(depositDtlExl.
			  getRow(i).getCell(1).toString(),"SheetName: "+depositDtlExl.getSheetName()
			  +" Row No :"+ row+" ,Cell No : 2"));
			  model.setDateOfIssuanceForm(Util.getCanvertDateFormat(Util.
			  checkNullSpace(depositDtlExl.getRow(i).getCell(2).toString(),"SheetName: "
			  +depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 3")));
			  model.setDetlsOfDescrepanceForm(Util.checkNullSpace(depositDtlExl.
			  getRow(i).getCell(3).toString(),"SheetName: "+depositDtlExl.getSheetName()
			  +" Row No :"+ row+" ,Cell No : 4"));
			  model.setFormFiveId(formFiveId);
			  loanDtlList.add(model);
		row++;
		}
		return loanDtlList;
	}
	@Override
	public List<FormFiveQ11_1Model> saveLoanDtl(List<FormFiveQ11_1Model> loanDtlList) {
		return  (List<FormFiveQ11_1Model>) q11_1Dao.saveAll(loanDtlList);
	}

	@Override
	public void removeAll(Long formFiveId) {
		q11_1Dao.deleteByFormFiveId(formFiveId);
		
	}

	
	

}
