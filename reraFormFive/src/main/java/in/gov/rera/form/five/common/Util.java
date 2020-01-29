package in.gov.rera.form.five.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import in.gov.rera.form.five.exception.ResourceNotFoundException;

public class Util {

	private static final int    FIRST_FISCAL_MONTH  = Calendar.MARCH;

    private Calendar calendarDate;

    public Util(Calendar calendarDate) {
        this.calendarDate = calendarDate;
    }

    
    public static String getCanvertDateFormat(String strDate) throws ResourceNotFoundException {
		  String newDate="";
	      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	      try {
	          Date varDate=dateFormat.parse(strDate);
	          dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	          newDate= dateFormat.format(varDate);
	      }catch (Exception e) {
	      }
		return newDate;
	}
	
	
    public static boolean dateBetweenFinancialYear(String exlDate,String fromDate,String toDate,String msg) throws ResourceNotFoundException, ParseException
    {
    	  boolean flag=true;
		  exlDate = getCanvertDateFormat(exlDate); 
		  fromDate = getCanvertDateFormatString(fromDate);
		  toDate = getCanvertDateFormatString(toDate); 
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  Date d1 = sdf.parse(exlDate); 
		  Date d2 = sdf.parse(fromDate);
		  Date d3 = sdf.parse(toDate);
		  if(d1.compareTo(d2)<0 || d1.compareTo(d3)>0) {
			  flag=false;
			  throw new  ResourceNotFoundException("Date should be between financial year start date and end date in "+msg);
		  }
    	return flag;
    }
    
	public static String getCanvertDateFormatString(String strDate) throws ResourceNotFoundException {
		  String newDate="";
	      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
	      try {
	          Date varDate=dateFormat.parse(strDate);
	          dateFormat=new SimpleDateFormat("yyyy-mm-dd");
	          newDate= dateFormat.format(varDate);
	      }catch (Exception e) {
	      }
		return newDate;
	}
    
    
	public static String checkNullSpace(String val, String msg) throws ResourceNotFoundException {
		if ("" != val.trim() && val != null ) {
			return val;
		} else {
			throw new ResourceNotFoundException( msg + " value is Required");
		}
	}
    
	public static String getDateString(Calendar cal){
		if(cal!=null){
//		SimpleDateFormat dat=new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dat=new SimpleDateFormat("dd/MM/yyyy");
		return dat.format(cal.getTime());
		}
		
		return " Date Not exist ";
	}
	
	public static String getCanvertDateFormat(String strDate,String msg) throws ResourceNotFoundException {
		  String newDate="";
	      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	      try {
	          Date varDate=dateFormat.parse(strDate);
	          dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	          newDate= dateFormat.format(varDate);
	      }catch (Exception e) {
	    	  throw new  ResourceNotFoundException("Please enter right format in Date,Please Use the format:'DD-MMM-YYYY' in "+msg);
	      }
		return newDate;
	    
	}
    
	public static String isAlpha(String s) throws ResourceNotFoundException {
		boolean check= s != null && s.matches("^[a-zA-Z ]*$");
		if(check)
		{
			return s;
		}
		else
		{
			 throw new  ResourceNotFoundException("Alphanumeric are allowed");
		}
	}

	public static String isCharacter(String s, String msg) throws ResourceNotFoundException {
		boolean check= s != null && s.matches("^[a-zA-Z ]*$");
		if(check)
		{
			return s;
		}
		else
		{
			throw new  ResourceNotFoundException("Only Characters are allowed in "+msg);
		}
	}
	
	public static String isNumeric(String str, String msg)throws ResourceNotFoundException { 
		  try {  
		    Double.parseDouble(str);  
		    str=str.substring(0, str.length() - 2);
		    return str;
		  } catch(Exception e){  
			  throw new  ResourceNotFoundException("Please enter only numbers in "+ msg);
		  }  
		}
	
	public static String isCALength(String str, String msg)throws ResourceNotFoundException { 
		
		//str=str.substring(0, str.length() - 2);
		System.out.println("CA number length is "+str.length());
		    if(str.length()!=6)
		    	{
		    	throw new  ResourceNotFoundException("CA Number length should be 6 digit in "+ msg);
		    	}
		    else {
		    	return str;
		    }
		}
    
    public Util(Date date) {
        this.calendarDate = Calendar.getInstance();
        this.calendarDate.setTime(date);
    }

    public int getFiscalMonth() {
        int month = calendarDate.get(Calendar.MONTH);
        int result = ((month - FIRST_FISCAL_MONTH - 1) % 12) + 1;
        if (result < 0) {
            result += 12;
        }
        return result;
    }

    public int getFiscalYear() {
        int month = calendarDate.get(Calendar.MONTH);
        int year = calendarDate.get(Calendar.YEAR);
        return (month >= FIRST_FISCAL_MONTH) ? year : year - 1;
    }

    public int getCalendarMonth() {
        return calendarDate.get(Calendar.MONTH);
    }

    public int getCalendarYear() {
        return calendarDate.get(Calendar.YEAR);
    }

	
    
    
    
    
    
    
	/*
	 * public static void main(String[] args) {
	 * //displayFinancialDate(Calendar.getInstance());
	 * //displayFinancialDate(setDate(2013, 1, 1));
	 * //displayFinancialDate(setDate(2012, 6, 25)); }
	 */
	 

    
    public static long yearBetween(Calendar startDate, Calendar endDate) {
        long end = endDate.YEAR;
        long start = startDate.YEAR;
        return (end - start);
    }
    
    
    
    
    
    
    private static Calendar setDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar;
    }

	public static List<String> getFinancialYear(Calendar startDate, Calendar endDate, Date formFiveStartDate)
	{
		List<String> list = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
    	cal.setTime(formFiveStartDate);
    	int startYear = cal.get(Calendar.YEAR);
    	int startMonth = cal.get(Calendar.MONTH);
    	int startDay = cal.get(Calendar.DAY_OF_MONTH);
    	int yearStart = startDate.get(startDate.YEAR);
    	if(startMonth<3)
    	{
    		--yearStart;
    	}
		
		int dayEnd = endDate.get(endDate.DAY_OF_MONTH);
		int monthEnd = endDate.get(endDate.MONTH);
		int yearEnd = endDate.get(endDate.YEAR);
		if(monthEnd<=10 && dayEnd<=30) {
			yearEnd=yearEnd-2;;
		}
		for(int i=yearStart;i<=yearEnd;i++)
		{
			String fYear=i + "-" + (i + 1);
			list.add(fYear);
		}
		return list;
		
	}
    
	  private static void displayFinancialDate(Calendar calendar) {
	  Util fiscalDate = new Util(calendar); 
	  int year = fiscalDate.getFiscalYear();
	  System.out.println("Current Date : " + calendar.getTime().toString());
	  System.out.println("Fiscal Years : " + year + "-" + (year + 1));
	  System.out.println("Fiscal Month : " + fiscalDate.getFiscalMonth());
	  System.out.println(" "); }
	 

}
