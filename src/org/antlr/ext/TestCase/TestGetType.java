package org.antlr.ext.TestCase;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.antlr.ext.ConditionExpression.*;
import org.antlr.ext.ConditionExpression.Visitor.TypeExpression;
import org.junit.Ignore;
import org.junit.Test;

public class TestGetType {

	@Test
	public void testString() {
		String expr = "\"test\"";
		Class<?> result = getType(expr);
		assertEquals(result, String.class);
	}

	@Ignore
	public void testData() {
		String expr = "$Dog";
		Class<?> result = getType(expr);
		assertEquals(result, Dog.class);
	}

	@Test
	public void testDollor() {
		TypeExpression exp = new TypeExpression(null);
		try {
			Class<?> class1 = (Class<?>)exp.keyDollar("Dog");
			assertEquals(class1.equals(Dog.class), true);
			
		} catch (ClassNotFoundException | RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDollorByData() {
		TypeExpression exp = new TypeExpression(null);
		HashMap<String, Object> hmdata = new HashMap<String, Object>();
		HashMap<String, Object> hmlocal = new HashMap<String, Object>();
		hmdata.put("Dog", Dog.class);
		try {
			Class<?> class1 = (Class<?>)exp.keyDollar("Dog", hmdata, hmlocal);
			Method[] methods = class1.getDeclaredMethods();
			assertEquals(class1.equals(Dog.class), true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private Class<?> getType(String expr) {
		Expression expObj = new Expression();
		Class<?> result = (Class<?>) expObj.getType(expr);
		return result;
	}
}
