package in.gov.rera.form.five.services.Impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gov.rera.form.five.common.Util;
import in.gov.rera.form.five.dao.Q10_1Dao;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveQ10_1Model;
import in.gov.rera.form.five.services.Q10_1Service;

@Service
@Transactional
public class Q10_1ServiceImpl implements Q10_1Service { 
	
	@Autowired 
	Q10_1Dao q10_1Dao;

	@Override
	public FormFiveQ10_1Model findById(Long id) {
		return q10_1Dao.findById(id).get();
	}

	@Override
	public List<FormFiveQ10_1Model> findByFormFiveId(Long id) {
		return q10_1Dao.findByFormFiveId(id);
	}

	@Override
	public List<FormFiveQ10_1Model> validateLoanDtlExl(XSSFSheet depositDtlExl,Long formFiveId) throws ResourceNotFoundException, ParseException {
	int row=2;
	List<FormFiveQ10_1Model> loanDtlList =new ArrayList<FormFiveQ10_1Model>();
		for (int i=1;i<depositDtlExl.getPhysicalNumberOfRows();i++) {
			FormFiveQ10_1Model model= new FormFiveQ10_1Model();
			model.setLanderNameType(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(0).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 1"));
			model.setSanctionLoanAmt(Util.isNumeric(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(1).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2"),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2"));
			model.setSanctionDate(Util.getCanvertDateFormat(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(2).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 3"),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 3"));
			model.setOutStandingLoan(Util.isNumeric(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(3).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 4"),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 4"));
			model.setCollateralMortgateDls(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(4).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 5"));
			model.setFormFiveId(formFiveId);
			loanDtlList.add(model);
		row++;
		}
		return loanDtlList;
	}
	@Override
	public List<FormFiveQ10_1Model> saveLoanDtl(List<FormFiveQ10_1Model> loanDtlList) {
		return  (List<FormFiveQ10_1Model>) q10_1Dao.saveAll(loanDtlList);
	}

	@Override
	public void removeAll(Long formFiveId) {
		q10_1Dao.deleteByFormFiveId(formFiveId);
	}

	
	

}
