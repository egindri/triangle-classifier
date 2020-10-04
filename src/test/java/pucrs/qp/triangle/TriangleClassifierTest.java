package pucrs.qp.triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TriangleClassifierTest {
	
	@BeforeAll
	public static void setup() {
		mockStatic(TriangleAngleType.class);
		mockStatic(TriangleSideType.class);
	}
	
	
	@Test
	public void testInvalidTriangleAEqualsOtherSides() {
		
		double side1 = 1d;
		double side2 = 2d;
		double side3 = 3d;
		
		assertThrows(InvalidTriangleException.class, () -> TriangleClassifier.classify(side1, side2, side3));
	}

	@Test
	public void testInvalidTriangleAEqualsOtherSidesReverseOrder() {
		
		double side1 = 3d;
		double side2 = 2d;
		double side3 = 1d;
		
		assertThrows(InvalidTriangleException.class, () -> TriangleClassifier.classify(side1, side2, side3));
	}

	@Test
	public void testInvalidTriangleAGreaterThanOtherSides() {
		
		double side1 = 1d;
		double side2 = 2d;
		double side3 = 3.1d;
		
		assertThrows(InvalidTriangleException.class, () -> TriangleClassifier.classify(side1, side2, side3));
	}

	@Test
	public void testInvalidTriangleAGreaterThanOtherSidesReverseOrder() {
		
		double side1 = 3.1d;
		double side2 = 2d;
		double side3 = 1d;
		
		assertThrows(InvalidTriangleException.class, () -> TriangleClassifier.classify(side1, side2, side3));
	}
	
	@Test
    public void testValidTriangle() {
		
		TriangleAngleType mockedAngleType = TriangleAngleType.RIGHT;
		TriangleSideType mockedSideType = TriangleSideType.SCALENE;
		when(TriangleAngleType.resolve(anyDouble(), anyDouble(), anyDouble())).thenReturn(mockedAngleType);
		when(TriangleSideType.resolve(anyList())).thenReturn(mockedSideType);
		double side1 = 1d;
		double side2 = 2d;
		double side3 = 2.9d;
		
		TriangleClassification classification = TriangleClassifier.classify(side1, side2, side3);
		
		assertEquals(mockedAngleType, classification.getAngleType());
		assertEquals(mockedSideType, classification.getSideType());
    }

	@Test
	public void testValidTriangleReverseOrder() {
		
		TriangleAngleType mockedAngleType = TriangleAngleType.RIGHT;
		TriangleSideType mockedSideType = TriangleSideType.SCALENE;
		when(TriangleAngleType.resolve(anyDouble(), anyDouble(), anyDouble())).thenReturn(mockedAngleType);
		when(TriangleSideType.resolve(anyList())).thenReturn(mockedSideType);
		double side1 = 2.9d;
		double side2 = 2d;
		double side3 = 1d;
		
		TriangleClassification classification = TriangleClassifier.classify(side1, side2, side3);
		
		assertEquals(mockedAngleType, classification.getAngleType());
		assertEquals(mockedSideType, classification.getSideType());
	}
}
