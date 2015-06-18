package org.antlr.ext.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParamTest {

	private int param;
	private int result;
	
	public ParamTest(int paramInt, int resultInt) {
		this.param = paramInt;
		this.result = resultInt;
	}
	
	@Parameters
	public static Collection<?> data() {
		return Arrays.asList(new Object[][] { { 2, 4 }, { 3, 5 }, { 4, 6 } });
	}

	@Test
	public void testByParams(){
		Assert.assertEquals(test1(param), result);
	}
	
	private int test1(int param){
		return this.param + 2;
	}
	
}
