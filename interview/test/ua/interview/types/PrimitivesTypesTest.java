package ua.interview.types;

import junit.framework.Assert;

import org.junit.Test;

public class PrimitivesTypesTest {

	@Test
	public void testRunSimplePrimitives() {
		PrimitiveTypes primitiveTypes = new PrimitiveTypes(1,10);
		
		primitiveTypes.fillArray(primitiveTypes.firstInt, primitiveTypes.secondInt);
		
		primitiveTypes.incrementArrayElements();
		
			
		//ACTION : put correct numbers instead of 0 to make test green!
		Assert.assertEquals(primitiveTypes.firstInt,     0);
		Assert.assertEquals(primitiveTypes.secondInt,    0);
		Assert.assertEquals(primitiveTypes.intArray[0],  0);
		Assert.assertEquals(primitiveTypes.intArray[1],  0);
		
		
		//QUESTION : Will we see a compilation error if we mark firstInt and secondInt fields at PrimitiveTypes as protected ?
		
	}
}
