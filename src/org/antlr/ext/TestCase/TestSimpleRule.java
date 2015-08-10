package org.antlr.ext.TestCase;

import static org.junit.Assert.*;

import org.antlr.ext.TestCase.UtilTools;

import gov.customs.rule.data.BhlHead;
import gov.customs.rule.data.BhlList;
import gov.customs.rule.data.PreBhlHead;
import gov.customs.rule.data.PreBhlList;
import gov.customs.rule.data.RuleData;
import gov.customs.rule.data.RuleLogData;
import gov.customs.rule.expression.proxy.ExpressionHelperProxy;
import gov.customs.rule.expression.proxy.ExpressionHelperProxy.LogType;

import java.math.BigDecimal;
import java.text.Bidi;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javassist.expr.NewArray;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.antlr.ext.ConditionExpression.*;
import org.antlr.ext.ConditionExpression.Generated.ExpressionParser.boolLiteral_return;
import org.antlr.ext.ConditionExpression.Utility.DateHelper;
import org.antlr.ext.ConditionExpression.Utility.IGetValue;
import org.antlr.ext.ConditionExpression.Visitor.TypeExpression;

import ExpressionHelper.EntryHelper;

public class TestSimpleRule {
	
	private static Object _data;
	
	@BeforeClass
	public static void propareData(){
		_data = UtilTools.propareTestData();
	}

	@Test
	public void testBigdecimal(){
		BigDecimal i = BigDecimal.valueOf(10);
		if (i.equals(10)) {
			assertEquals(true, true);
		}else
			assertEquals(true, false);
	}
	
	@Ignore
	public void testFunctionOfDate() {
		String exprCond = "Date()";
		Object result = testExpression(exprCond);
		String longDateString = "";
		try {
			longDateString = DateHelper.convertLongDateString((Date)result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(longDateString);
		assertEquals(result, false);
	}
	
	
	@Ignore
	public void testSimple1() {
		String exprCond = "isnull($preBhlHead.getBhlNo())";
		Object result = testExpression(exprCond);
		assertEquals(result, false);
	}
	
	@Ignore
	public void testSimple2() {
		String exprCond = "($preBhlHead.getExDeclareDate()+1) > NOW()";
		Object result = testExpression(exprCond);
		assertEquals(result, false);
	}
	
	@Ignore
	public void testFilter() {
		String exprCond = "filter($preBhlListCol,\"preBhlList\",\"$preBhlList.getId().getGNo()=2\")";
		//$preBhlList.gNo
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(result != null , true);
	}
	
	@Ignore
	public void test57() {
		String exprCond = "\"This is a small world!\"==\"This is a small world!\"";
		//$preBhlList.gNo
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	
	@Ignore
	public void test58() {
		String exprCond = "\"This is a small world!\"==\"This is a small world!\"";
		//$preBhlList.gNo
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	
	@Ignore
	public void testDayDiff() {
		String exprCond = "DATEDIFF(NOW(),\"2015-7-7\")==1";
		//$preBhlList.gNo
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	
	@Ignore
	public void testLike() {
		String exprCond = "LIKE(\"java\",\"java\")";
		//$preBhlList.gNo
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	
	@Ignore
	public void testTrim() {
		String exprCond = "TRIM(\" This is a small world! \")==\"This is a small world!\"";
		//$preBhlList.gNo
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	@Ignore
	public void testDayofWeek() {
		String exprCond = "DAYOFWEEK()==3";
		//$preBhlList.gNo
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	
	@Ignore
	public void testDateDiff() {
		String exprCond = "DATEDIFF(NOW(),\"2015-7-7\")==1";
		//$preBhlList.gNo
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	
	@Ignore
	public void testIN() {
		String exprCond = "IN($preBhlHead.getDeclareType(),\"0\",\"1\",\"2\",\"3\",\"7\",\"11\")";
		//$preBhlList.gNo
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	
	@Ignore
	public void testMin1() {
		String exprCond = "MIN($preBhlListCol,\"preBhlList\",\"$preBhlList.getId().getGNo()\")==1";
		//$preBhlList.gNo
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	
	@Ignore
	public void testMin2() {
		String exprCond = "MIN($preBhlListCol,\"preBhlList\",\"$preBhlList.getId().getGNo()==1\"";
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
//$preBhlList.getId().getGType()=\"I\"
	
	@Ignore
	public void testM() {
		//MIN($preBhlListCol,"preBhlList","$preBhlList.getId().getGType()=\"I\"","$preBhlList.getId().getGNo()")==1
		//String exprCond = "MIN($preBhlListCol,\"preBhlList\",\"$preBhlList.getId().getGNo()=1\",\"$preBhlList.getId().getGNo()\")==1";
		String exprCond = "MIN($preBhlListCol,\"preBhlList\",\"$preBhlList.getId().getGType()='I'\",\"$preBhlList.getId().getGNo()\")==1";
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	

	@Ignore
	public void testFilter2() {
		//MIN($preBhlListCol,"preBhlList","$preBhlList.getId().getGType()=\"I\"","$preBhlList.getId().getGNo()")==1
		//String exprCond = "MIN($preBhlListCol,\"preBhlList\",\"$preBhlList.getId().getGNo()=1\",\"$preBhlList.getId().getGNo()\")==1";
		String exprCond = "FILTER($preBhlListCol,\"preBhlList\",\"$preBhlList.getId().getGType()='I'\")";
		Object result = null;
		ArrayList<?> list = null;
		
		try {
			result = testExpression(exprCond);
			list = (ArrayList<?>)result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(list.size()>0, true);
	}
	
	@Ignore
	public void testMax() {
		String exprCond = "MAX($preBhlListCol,\"preBhlList\",\"$preBhlList.getId().getGNo()\")==2";
		Object result = null;
		ArrayList<?> list = null;
		
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	
	@Ignore
	public void testSum() {
		String exprCond = "SUM($preBhlListCol,\"preBhlList\",\"$preBhlList.getId().getGNo()\")==4";
		Object result = null;
		ArrayList<?> list = null;
		
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	
	@Ignore
	public void testDiv() {
		String exprCond = "AVG($preBhlListCol,\"preBhlList\",\"$preBhlList.getId().getGNo()\")";
		Object result = null;
		ArrayList<?> list = null;
		
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(result, BigDecimal.valueOf(1.3333333333));
	}
	
	
	@Ignore
	public void testExistKey() {
		String exprCond = "ExistKey(\"preBhlHead\")";
		Object result = null;
		ArrayList<?> list = null;
		
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	
	@Ignore
	public void testNotBhlImEmsHead() {
		String exprCond = "NOT($bhlImEmsHead.getOwnerCode()==$preBhlHead.getImTradeCode())";
		Object result = null;
		ArrayList<?> list = null;
		int i = 0;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(result, false);
	}
	@Ignore
	public void testNotEmsAlc() {
		String exprCond = "$emsAlcWork.getId().getStepId()==\"BHL00101\" OR $emsAlcWork.getId().getStepId()==\"BHL00111\" OR $emsAlcWork.getId().getStepId()==\"BHL00103\" OR $emsAlcWork.getId().getStepId()==\"BHL00113\"";
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(result, true);
	}
	
	@Ignore
	public void testNotBhl() {
		//String exprCond = "COUNT($preBhlListCol,\"preBhlImList\",\"$preBhlList.getGType()='E' && $preBhlImList.getId().getGNo()=$preBhlList.getId().getGNo()")==0";
		//String exprCond = "GetValueByCondition($preBhlListCol, 0, \"UNIT\")";
		String exprCond = "GetValueByCondition(FILTER($preBhlListCol,\"preBhlList\",\"$preBhlList.getId().getGType()=\\\"E\\\"\"), 0, \"UNIT\")";
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		assertEquals(result, "001");
	}
	
	//NOT(bhlHead.getExeMark()=="1" OR bhlHead.getExeMark()=="2")
	//$emsAlcWork.getStepId()=="BHL00101" OR $emsAlcWork.getStepId()=="BHL00111" OR $emsAlcWork.getStepId()=="BHL00103" OR $emsAlcWork.getStepId()=="BHL00113")
	
	
	@Ignore
	public void testLog4j() {
		String exprCond = "Date()";
		Object result = testExpression(exprCond);
		String longDateString = "";
		try {
			longDateString = DateHelper.convertLongDateString((Date)result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(longDateString);
		assertEquals(result instanceof Date, true);
	}
	
	@Ignore
	public void testGetFieldValue() {
		String exprCond = "GetColValue($preBhlHead, \"BHL_NO\")";
		Object result = null;
		ArrayList<?> list = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(String.valueOf(result), "S80121400006");
	}
	
	@Ignore
	public void testPrintLog() {
		
		try {
			new ExpressionHelperProxy().printLog("test", LogType.Error);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(true, true);
	}
	
	@Ignore
	public void testExecWithPrintLog() {
		RuleData ruleData = getRuleDatas(BigDecimal.valueOf(23));
		RuleLogData logData = new RuleLogData();
		Object result = null;
		if (ruleData != null) {
			logData.setRuleId(ruleData.getRuleId());
			logData.setRuleName(ruleData.getRuleName());
			logData.setRuleCond(ruleData.getRuleCond());
			logData.setRuleType(ruleData.getRuleType());
			logData.setIsEstimate(ruleData.getIsEstimate());
			logData.setIsLog(ruleData.getIsLog());
		}
		try {
			result = new ExpressionHelperProxy().ExecuteExpression(logData, _data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals((Boolean)result, true);
	}
	
	@Ignore
	public void testExecWithPrintLogByRuleid(){
		Object result = new ExpressionHelperProxy().ExecuteExpression(BigDecimal.valueOf(23), _data);
		assertEquals(result, true);
	}
	
	@Ignore
	public void testGetRuleMapping(){
		Object result = new ExpressionHelperProxy().ExecuteExpression(BigDecimal.valueOf(22), _data);
		assertEquals(result, true);
	}
	
	private RuleData getRuleDatas(BigDecimal ruleId) {
		String sql = String.format("select * from RULE_DATA where RULE_ID = %d", ruleId.intValue());
		Query query = UtilTools.getSessionFactory().createSQLQuery(sql).addEntity(RuleData.class);
		return (RuleData) query.list().get(0);
	}
	
	private Object testExpression(String exprCond) {
		//bject data = UtilTools.propareTestData();
		Object result = new ExpressionHelperProxy().ExecuteExpression(
				exprCond, _data);

		return result;
	}

	

}