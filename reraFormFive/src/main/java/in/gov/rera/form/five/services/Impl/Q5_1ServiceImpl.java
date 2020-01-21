package in.gov.rera.form.five.services.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gov.rera.form.five.common.Util;
import in.gov.rera.form.five.dao.Q5_1Dao;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveQ4_1Model;
import in.gov.rera.form.five.model.FormFiveQ5_1Model;
import in.gov.rera.form.five.services.Q5_1Service;

@Service
@Transactional
public class Q5_1ServiceImpl implements Q5_1Service { 
	
	@Autowired 
	Q5_1Dao q5_1Dao;

	@Override
	public FormFiveQ5_1Model findById(Long id) {
		return q5_1Dao.findById(id).get();
	}

	@Override
	public List<FormFiveQ5_1Model> findByFormFiveId(Long id) {
		return q5_1Dao.findByFormFiveId(id);
	}

	@Override
	public List<FormFiveQ5_1Model> validateDepositDtlExl(XSSFSheet depositDtlExl,Long formFiveId) throws ResourceNotFoundException, ParseException {
	System.out.println("validateDepositDtlExl called");
	System.out.println("physical row i s "+depositDtlExl.getPhysicalNumberOfRows());
		int row=2;
	List<FormFiveQ5_1Model> depositDtlList =new ArrayList<FormFiveQ5_1Model>();
		for (int i=1;i<depositDtlExl.getPhysicalNumberOfRows()-1;i++) {
			FormFiveQ5_1Model model= new FormFiveQ5_1Model();
			model.setPeriodFromDate(Util.getCanvertDateFormat(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(0).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 1"),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 1"));
			model.setPeriodToDate(Util.getCanvertDateFormat(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(1).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2"),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 2"));
			model.setAmountNotDeposited(Util.isNumeric(Util.checkNullSpace(depositDtlExl.getRow(i).getCell(2).toString(),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 3"),"SheetName: "+depositDtlExl.getSheetName() +" Row No :"+ row+" ,Cell No : 3"));
			model.setFormFiveId(formFiveId);
			depositDtlList.add(model);
		row++;
		}
		return depositDtlList;
	}
	@Override
	public List<FormFiveQ5_1Model> saveDepositDtl(List<FormFiveQ5_1Model> caDtlList) {
		return  (List<FormFiveQ5_1Model>) q5_1Dao.saveAll(caDtlList);
	}


	@Override
	public void removeAll(Long formFiveId) {
		q5_1Dao.deleteByFormFiveId(formFiveId);
	}

	
	

}
