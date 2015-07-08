package org.antlr.ext.TestCase;

import static org.junit.Assert.*;

import org.antlr.ext.TestCase.UtilTools;

import gov.customs.jm.data.BhlHead;
import gov.customs.jm.data.BhlList;
import gov.customs.jm.data.PreBhlHead;
import gov.customs.jm.data.PreBhlList;
import gov.customs.rule.expression.proxy.ExpressionHelperProxy;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import org.junit.Ignore;
import org.junit.Test;
import org.antlr.ext.ConditionExpression.*;
import org.antlr.ext.ConditionExpression.Generated.ExpressionParser.boolLiteral_return;
import org.antlr.ext.ConditionExpression.Utility.IGetValue;
import org.antlr.ext.ConditionExpression.Visitor.TypeExpression;

import ExpressionHelper.EntryHelper;

public class TestSimpleRule {

	@Ignore
	public void testSimple1() {
//		String exprCond = "ISNULL($preBhlHead.getBhlNo())";
		String exprCond = "isnull($preBhlHead.getBhlNo())";
		Object result = testExpression(exprCond);
		assertEquals(result, false);
	}
	
	@Test
	public void testSimple2() {
//		String exprCond = "ISNULL($preBhlHead.getBhlNo())";
		String exprCond = "($preBhlHead.getExDeclareDate()+1) > NOW()";
		Object result = testExpression(exprCond);
		assertEquals(result, false);
	}
	
	@Test
	public void testFilter() {
		String exprCond = "filter($preBhlListCol,preBhlList,\"$preBhlList.getId().getGNo()=2\")";
		//$preBhlList.gNo
		Object result = null;
		try {
			result = testExpression(exprCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(result != null , true);
	}
	
	@Test
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
	
	@Test
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
	//"This is a small world!"=="This is a small world!"
//	$preBhlHead.getExDeclareDate()+1>NOW()

	private Object testExpression(String exprCond) {
		Object data = UtilTools.propareTestData();
		Object result = new ExpressionHelperProxy().ExecuteExpression(
				exprCond, data);

		return result;
	}

	

}