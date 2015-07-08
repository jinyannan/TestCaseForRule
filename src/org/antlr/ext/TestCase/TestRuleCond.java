package org.antlr.ext.TestCase;

import gov.customs.jm.data.BhlHead;
import gov.customs.jm.data.BhlList;
import gov.customs.jm.data.PreBhlHead;
import gov.customs.jm.data.PreBhlList;
import gov.customs.jm.data.RuleData;
import gov.customs.rule.data.RuleEntityJar;
import gov.customs.rule.expression.proxy.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javassist.expr.NewArray;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.stringtemplate.v4.compiler.CodeGenerator.list_return;

@RunWith(Parameterized.class)
public class TestRuleCond {

	private BigDecimal _param;
	private Object _result;
	private List<RuleData> _list = null;
	
	public TestRuleCond(BigDecimal paramInt, Object result) {
		this._param = paramInt;
		this._result = result;
	}
	
	@Ignore
	public void getRuleData(){
		Query query = UtilTools.getSessionFactory().createSQLQuery("select * from RULE_DATA").addEntity(RuleData.class);
		this._list = query.list();
	}
	
	@Parameters
	public static Collection<?> data() {
		Object object[][] = new Object[][] {{ BigDecimal.valueOf(35), true},
											{ BigDecimal.valueOf(36), false},
											{ BigDecimal.valueOf(53), true},
											{ BigDecimal.valueOf(54), true},
											{ BigDecimal.valueOf(55), true},
											{ BigDecimal.valueOf(57), true},
											{ BigDecimal.valueOf(72), true},
											{ BigDecimal.valueOf(74), true},
											{ BigDecimal.valueOf(75), true}};
		return Arrays.asList(object);
	}

	@Test
	public void testByParams(){
		Object bool = testExpression(_param);
		Assert.assertEquals(bool, _result);
	}
	
	private Object testExpression(BigDecimal ruleId){
		Object result = null;
		RuleData ruleData = null;
		Object data = null;
		if (_list == null) {
			String sql = "select * from RULE_DATA where rule_id = " + ruleId;
			Query query = UtilTools.getSessionFactory().createSQLQuery(sql).addEntity(RuleData.class);
			_list = query.list();
		}
		
		if (_list.size() > 0) {
			ruleData = _list.get(0);
			data = UtilTools.propareTestData();
			result =  new ExpressionHelperProxy().ExecuteExpression(ruleData.getRuleCond(), data);
		}else {
			result = false;
		}
		return result;
	}
	

	
}