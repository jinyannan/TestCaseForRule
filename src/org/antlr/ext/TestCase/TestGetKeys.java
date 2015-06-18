package org.antlr.ext.TestCase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.junit.Ignore;
import org.junit.Test;
import org.antlr.ext.ConditionExpression.*;
import org.antlr.ext.ConditionExpression.Generated.ExpressionParser.boolLiteral_return;
import org.antlr.ext.ConditionExpression.Utility.IGetValue;
import org.antlr.ext.ConditionExpression.Visitor.TypeExpression;

import ExpressionHelper.EntryHelper;

public class TestGetKeys {

	@Test
	public void testGetKeys() {
		Expression expObj = new Expression();
		String expr = "$rlHead.gno=$rlList.gno";
		Object[] result = (Object[]) expObj.GetKeys(expr);
		int i = 0;
		for (Object str : result) {
			if (String.valueOf(str).equalsIgnoreCase("rlHead")) {
				i += 1;
			}
			if (String.valueOf(str).equalsIgnoreCase("rllist")) {
				i += 2;
			}
		}
		assertEquals("运算错误", i, 3);
	}

	@Test
	public void testGetKeysIncludeFunction(){
		Expression expObj = new Expression();
		String expr = "FILTER($EMS_LIST,\"EMS_LIST\",\"$EMS_LIST.QTY > 0\")";
		Object[] resultObjs = (Object[]) expObj.GetKeys(expr);
		int i = 0;
		for (Object resultObj : resultObjs) {
			switch (String.valueOf(resultObj)) {
			case "EMS_LIST":
				i += 1;
			default:
				break;
			}
		}
		assertEquals("运算错误", i, 1);
	}
	
	private Object[] getkeys(String expr){
		Expression expObj = new Expression();
		return (Object[]) expObj.GetKeys(expr);
	}
	
}
