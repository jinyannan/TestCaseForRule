package org.antlr.ext.TestCase;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

import javax.swing.tree.ExpandVetoException;

import org.antlr.codegen.ObjCTarget;
import org.antlr.ext.ConditionExpression.*;
import org.antlr.ext.ConditionExpression.Visitor.TypeFunctionExpression;
import org.antlr.ext.ConditionExpression.Visitor.TypeExpression;

import gov.customs.rule.expression.proxy.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestGetType {
	private HashMap<String, Object> _hmdata;
	private HashMap<String, Object> _hmlocal;
	
	@Before
	public void initData(){
		_hmdata = new HashMap<String, Object>();
		_hmlocal = new HashMap<String, Object>();
		_hmdata.put("Dog", Dog.class);
	}

	@Test
	public void testString() {
		String expr = "\"test\"";
		Class<?> result = getType(expr);
		assertEquals(result, String.class);
	}

	@Test
	public void testData() {
		String expr = "$Dog";
		Class<?> result = getType(expr);
		assertEquals(result, Dog.class);
	}

	/**
	 * 
	 */
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
	
	/**
	 * 通过data传递class类型数据
	 */
	@Test
	public void testDollorByData() {
		TypeExpression exp = new TypeExpression(null);
		//HashMap<String, Object> hmdata = new HashMap<String, Object>();
		//HashMap<String, Object> hmlocal = new HashMap<String, Object>();
		//hmdata.put("Dog", Dog.class);
		try {
			Class<?> class1 = (Class<?>)exp.keyDollar("Dog", _hmdata, _hmlocal);
			//Method[] methods = class1.getDeclaredMethods();
			assertEquals(class1.equals(Dog.class), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFilter() {
		String expr = "filter($Dog,\"name\",\"1=1\")";
		Class<?> result = getType(expr);
		assertEquals(result, Dog.class);
	}
	
	@Test
	public void testFilterWithMethod() {
		String expr = "filter($Dog.getName(),\"name\",\"1=1\")";
		Class<?> result = getType(expr);
		assertEquals(result, String.class);
	}
	@Test
	public void testMaxProp() {
		String expr = "max($Dog, name)";
		Class<?> result = getType(expr);
		assertEquals(result, String.class);
	}
	
	@Test
	public void testMaxMethod() {
		String expr = "max($Dog, getAge)";
		Class<?> result = getType(expr);
		assertEquals(result, String.class);
	}
	
	@Test
	public void testMinProp() {
		String expr = "max($Dog, getAge)";
		Class<?> result = getType(expr);
		assertEquals(result, String.class);
	}
	@Test
	public void testDotProp() {
		String expr = "$Dog.name";
		Class<?> result = getType(expr);
		assertEquals(result, String.class);
	}
	
	@Test
	public void testDotMethod() {
		String expr = "$Dog.getName()";
		Class<?> result = getType(expr);
		assertEquals(result, String.class);
	}
	
	@Test
	public void testDotMethodOverload1(){
		String expr = "$Dog.getAge(12)";
		Class<?> result = getType(expr);
		assertEquals(result, Integer.class);
	}
	
	@Test
	public void testDotMethodOverload2(){
		String expr = "$Dog.getAge(\"12\")";
		Class<?> result = getType(expr);
		assertEquals(result, String.class);
	}
	
	@Test
	public void testDotMethodOverload3(){
		String expr = "$Dog.getAge(1,2)";
		Class<?> result = getType(expr);
		assertEquals(result, Boolean.class);
	}
	
	@Test
	public void testDotMethodOverload4(){
		String expr = "$Dog.getAge(1,\"2\")";
		Class<?> result = getType(expr);
		assertEquals(result, String.class);
	}
	
	@Test
	public void testDotSubMethod() {
		String expr = "$Dog.dogLeg";
		Class<?> result = getType(expr);
		assertEquals(result, Leg.class);
	}
	
	@Test
	public void testDotSubMethod1() {
		String expr = "$Dog.dogLeg.getLegs()";
		Class<?> result = getType(expr);
		assertEquals(result, Integer.class);
	}
	
	@Test
	public void testUFBT(){
		Class<?> class1 = getType("bt(2, 1, 3)");
		assertEquals(class1.equals(Boolean.class), true);
	}
	
	@Test
	public void testUserFunctionIif(){
		Class<?> class1 = getType("IIF(\"1>1\",2,3)");
		assertEquals(class1.equals(Integer.class), true);
	}
	
	@Test
	public void testUserFunctionPlus(){
		Class<?> class1 = getType("1+1");
		assertEquals(class1.equals(Integer.class), true);
	}
	
	@Test
	public void testgetClassByJar(){
		Class<?> class1 = null;
		try {
			//file:/templib/Data.jar
			String filePath = "file:/templib/TestCaseForRule.jar";
			class1 = new ExpressionHelperProxy().getClassByJar(filePath, "gov.customs.jm.data.BhlHead");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(class1.getName().equals("gov.customs.jm.data.BhlHead"), true);
	}
	
	@Test
	public void testGetUsedCalsses(){
		HashMap<String, Class<?>> class1 = null;
		try {
			class1 = new ExpressionHelperProxy().getUsedClass(BigDecimal.valueOf(2),"");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(class1.size(),1);
	}
	
	@Ignore
	public void testGetAllUsedClass() {
		HashMap<BigDecimal, HashMap<String, Class<?>>> class1 = null;
		try {
			class1 = new ExpressionHelperProxy().getAllUsedClass("");
		} catch (MalformedURLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(class1.size(),0);
	}
	
	@Test
	public void testGetType() {
		Class<?> object = null;
		try {
			object = new ExpressionHelperProxy().getType("$preBhlHead", BigDecimal.valueOf(2), "file:");
		} catch (MalformedURLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(object.getName(), "gov.customs.jm.data.PreBhlHead");
	}
	
	@Test
	public void testGetTypeFields() {
		ArrayList<Field> object = null;
		try {
//			object = new ExpressionHelperProxy().getType("$preBhlHead", BigDecimal.valueOf(2), "file:");
			object = new ExpressionHelperProxy().getTypeFields("$preBhlHead.", BigDecimal.valueOf(2), "file:");
		} catch (MalformedURLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(object.size() == 0, true);
	}
	
	@Test
	public void testGetTypeMethods() {
		ArrayList<Method> object = null;
		try {
//			object = new ExpressionHelperProxy().getType("$preBhlHead", BigDecimal.valueOf(2), "file:");
			object = new ExpressionHelperProxy().getTypeMethods("$preBhlList", BigDecimal.valueOf(2), "file:");
			ArrayList<Method> list = (ArrayList<Method>)object;
			ArrayList<String> listStrings = new ArrayList<String>();
			for (Method method : list) {
				listStrings.add(method.getName());
			}
			Collections.sort(listStrings);
			for (String methodName : listStrings) {
				System.out.println(methodName);
			}
		} catch (MalformedURLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(object.size() > 0, true);
	}
	
	/**
	 * 
	 * @param expr
	 * @return
	 */
	private Class<?> getType(String expr) {
		Expression expObj = new Expression();
		Class<?> result = null;
		try {
			result = (Class<?>)expObj.getType(expr, _hmdata, _hmlocal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
