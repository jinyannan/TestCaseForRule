package org.antlr.ext.TestCase;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;

import org.antlr.ext.ConditionExpression.*;
import org.antlr.ext.ConditionExpression.Visitor.TypeFunctionExpression;
import org.antlr.ext.ConditionExpression.Visitor.TypeExpression;
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
		_hmdata.put("Dog", new Dog().getClass());
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
	
	/**
	 * 
	 * @param expr
	 * @return
	 */
	private Class<?> getType(String expr) {
		Expression expObj = new Expression();
		Class<?> result = (Class<?>)expObj.getType(expr, _hmdata, _hmlocal);
		
		return result;
	}
}
