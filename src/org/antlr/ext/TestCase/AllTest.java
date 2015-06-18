package org.antlr.ext.TestCase;

import org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({org.antlr.ext.TestCase.TestGetKeys.class, 
			   org.antlr.ext.TestCase.TestGetType.class})
public class AllTest {
	public static void main(String[] args) {
		JUnitCore.main("AllTest");
	}

}
