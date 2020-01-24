package in.gov.rera.form.five.services.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gov.rera.form.five.common.Util;
import in.gov.rera.form.five.dao.Q9_1Dao;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveQ9_1Model;
import in.gov.rera.form.five.services.Q9_1Service;

@Service
@Transactional
public class Q9_1ServiceImpl implements Q9_1Service { 
	
	@Autowired 
	Q9_1Dao q9_1Dao;

	@Override
	public FormFiveQ9_1Model findById(Long id) {
		return q9_1Dao.findById(id).get();
	}

	@Override
	public List<FormFiveQ9_1Model> findByFormFiveId(Long id) {
		return q9_1Dao.findByFormFiveId(id);
	}

	@Override
	public List<FormFiveQ9_1Model> validateReceivedAmtDtlExl(XSSFSheet depositDtlExl,Long formFiveId) throws ResourceNotFoundException, ParseException {
	int row=2;
	List<FormFiveQ9_1Model> depositDtlList =new ArrayList<FormFiveQ9_1Model>();
		for (int i=1;i<depositDtlExl.getPhysicalNumberOfRows();i++) {
			FormFiveQ9_1Model model= new FormFiveQ9_1Model();
			model.setUnitNumber(Util.isNumeric(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(0).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 1"),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 1"));
			model.setTotalConsideration(Util.isNumeric(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(1).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2"),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2"));
			model.setAmtReceivedInExcess(Util.isNumeric(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(2).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 3"),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 3"));
			model.setFormFiveId(formFiveId);
			depositDtlList.add(model);
		row++;
		}
		return depositDtlList;
	}
	@Override
	public List<FormFiveQ9_1Model> saveWithdrawlsDtl(List<FormFiveQ9_1Model> caDtlList) {
		return  (List<FormFiveQ9_1Model>) q9_1Dao.saveAll(caDtlList);
	}

	@Override
	public void removeAll(Long formFiveId) {
		q9_1Dao.deleteByFormFiveId(formFiveId);
	}

	
	

}
