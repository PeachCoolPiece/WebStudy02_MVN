package kr.or.ddit.time;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TemporalCaseExample {



	@Test
	public void test() {
		Date date = new Date(); // epoach time 기준 시 
		System.out.printf("Date : %s\n",date);
		Calendar calendar =  Calendar.getInstance();
		System.out.printf("Calendar : %tc\n",calendar);
		LocalDate today =  LocalDate.now();
		System.out.printf("LocalDate : %s\n",today);
		Temporal current =  LocalTime.now();
		System.out.printf("LocalTime : %s\n",current);
		Temporal now = LocalDateTime.now();
		System.out.printf("LocalDateTime : %s\n",now);
		
		Temporal thisMonth =  YearMonth.now();
		System.out.printf("YearMonth : %s\n", thisMonth);
		
		LocalDate dateAdd7 =  today.plusDays(7);
		System.out.printf("dateAdd7 : %s\n",dateAdd7);
		
		
		System.out.printf("dateAdd7 : %s\n",dateAdd7);
		
		System.out.printf("미래인가? : %s\n",today.isBefore(dateAdd7));
	}

}
