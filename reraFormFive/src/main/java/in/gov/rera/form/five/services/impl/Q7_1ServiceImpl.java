package in.gov.rera.form.five.services.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gov.rera.form.five.common.Util;
import in.gov.rera.form.five.dao.Q7_1Dao;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.model.FormFiveQ7_1Model;
import in.gov.rera.form.five.services.FormFiveService;
import in.gov.rera.form.five.services.Q7_1Service;

@Service
@Transactional
public class Q7_1ServiceImpl implements Q7_1Service { 
	
	@Autowired 
	Q7_1Dao q7_1Dao;

	@Autowired
	FormFiveService pService;
	
	@Override
	public FormFiveQ7_1Model findById(Long id) {
		return q7_1Dao.findById(id).get();
	}

	@Override
	public List<FormFiveQ7_1Model> findByFormFiveId(Long id) {
		return q7_1Dao.findByFormFiveId(id);
	}

	@Override
	public List<FormFiveQ7_1Model> validateWithdrawlDtlExl(XSSFSheet depositDtlExl,Long formFiveId) throws ResourceNotFoundException, ParseException {
		FormFiveModel pModel= pService.findById(formFiveId);
		Optional.ofNullable(pModel)
		.orElseThrow(() -> new ResourceNotFoundException("Form five id is not found"));
		int row=2;
		if(depositDtlExl.getPhysicalNumberOfRows()==1)
		{
			throw new ResourceNotFoundException("Empty excel file can not be uploaded");
		}
	List<FormFiveQ7_1Model> depositDtlList =new ArrayList<>();
		for (int i=1;i<depositDtlExl.getPhysicalNumberOfRows();i++) {
			FormFiveQ7_1Model model= new FormFiveQ7_1Model();
			Util.getCanvertDateFormat(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(0).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 1"),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 1");
			if(Util.dateBetweenFinancialYear(depositDtlExl.getRow(i).getCell(0).toString(),pModel.getCertFromDate(),pModel.getCertToDate(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 1")) {
			model.setPeriodFromDate(Util.getCanvertDateFormat(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(0).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 1"),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 1"));
			}
			Util.getCanvertDateFormat(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(1).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2"),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2");
			if(Util.dateBetweenFinancialYear(depositDtlExl.getRow(i).getCell(1).toString(),pModel.getCertFromDate(),pModel.getCertToDate(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2")) {
			model.setPeriodToDate(Util.getCanvertDateFormat(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(1).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2"),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2"));
			}
			model.setExcessWithdrawalAmt(Util.isNumeric(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(2).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 3"),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 3"));
			model.setFormFiveId(formFiveId);
			depositDtlList.add(model);
		row++;
		}
		return depositDtlList;
	}
	@Override
	public List<FormFiveQ7_1Model> saveWithdrawlsDtl(List<FormFiveQ7_1Model> caDtlList) {
		return  (List<FormFiveQ7_1Model>) q7_1Dao.saveAll(caDtlList);
	}

	@Override
	public void removeAll(Long formFiveId) {
		q7_1Dao.deleteByFormFiveId(formFiveId);
	}
}
