package org.antlr.ext.TestCase;

import static org.junit.Assert.*;

import org.antlr.ext.TestCase.UtilTools;

import gov.customs.rule.complexrule.RuleHelper;
import gov.customs.rule.data.BhlHead;
import gov.customs.rule.data.BhlList;
import gov.customs.rule.data.PreBhlHead;
import gov.customs.rule.data.PreBhlList;
import gov.customs.rule.data.RuleFeedback;
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

public class TestComplexRule {

	@Test
	public void testComlexRule1() {
		// 38复合规则，两层嵌套
		// 39单层规则
		// 198单层包括数学函数
		// 202测试循环
		// 288 循环，测试getcolvalue
		// 269
		// 353 测试复合规则
		BigDecimal ruleId = BigDecimal.valueOf(481);
		// $preBhlList.gNo
		Object result = null;
		
		BigDecimal i = BigDecimal.valueOf(1);
		int j = 1 ;
		try {
			result = testExpression(ruleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result.toString());
		assertEquals(result, true);
	}

	private Object testExpression(BigDecimal ruleId) {
		Object data = UtilTools.propareTestData();
		ArrayList<RuleFeedback> feedbacks = null;
		Boolean result = false;
		try {
			feedbacks = new RuleHelper().executeComplexRule(ruleId, data);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (feedbacks == null || feedbacks.size() == 0) {
			return false;
		}

		if (feedbacks.size() > 0) {
			System.out.println("命中条数：" + feedbacks.size());
			for (RuleFeedback ruleFeedback : feedbacks) {
				System.out.println(ruleFeedback.getRuleId() + ":"
						+ ruleFeedback.getHitDesc() + ":"
						+ ruleFeedback.getPositionDesc() + ":"
						+ ruleFeedback.getBusinessCode() + ":"
						+ ruleFeedback.getIsFeedBack());
			}
			result = true;
		}
		return result;
	}

}