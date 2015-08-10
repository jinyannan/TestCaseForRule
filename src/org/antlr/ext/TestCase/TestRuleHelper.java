package org.antlr.ext.TestCase;

import static org.junit.Assert.assertEquals;
import gov.customs.rule.complexrule.RuleHelper;
import gov.customs.rule.data.*;
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
public class TestRuleHelper {

	private BigDecimal _param;
	private Object _result;
	private List<RuleData> _list = null;

	public TestRuleHelper(BigDecimal paramInt, Object result) {
		this._param = paramInt;
		this._result = result;
	}

	@Ignore
	public void getRuleData() {
		Query query = UtilTools.getSessionFactory().createSQLQuery(
				"select * from RULE_DATA").addEntity(RuleData.class);
		this._list = query.list();
	}

	@Parameters
	public static Collection<?> data() {
		Object object[][] = new Object[][] {{ BigDecimal.valueOf(202), true }};
		return Arrays.asList(object);
	}

	@Test
	public void testByParams() {
		Object bool = testExpression(_param);
		if (bool != null) {
			RuleFeedback feedback = (RuleFeedback)bool;
			System.out.print(feedback.getRuleId() + ":" );
			System.out.println(feedback.getHitDesc());
		}
		Assert.assertEquals(bool != null, _result);
	}

	private Object testExpression(BigDecimal ruleId) {
		Object result = null;
		RuleData ruleData = null;
		Object data = UtilTools.propareTestData();

		result = new RuleHelper().executeSingleRule(ruleId, data);
		return result;
	}

}