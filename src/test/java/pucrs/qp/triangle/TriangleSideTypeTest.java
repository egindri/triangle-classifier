package pucrs.qp.triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TriangleSideTypeTest {
	
	@Test
    public void testEquilateralTriangle() {
		
		List<Double> sides = List.of(1d, 1d, 1d);
		
		TriangleSideType sideType = TriangleSideType.resolve(sides);
		
		assertEquals(TriangleSideType.EQUILATERAL, sideType);
    }

	@Test
	public void testIsoscelesTriangle() {
		
		List<Double> sides = List.of(1d, 1d, 1.1d);
		
		TriangleSideType sideType = TriangleSideType.resolve(sides);
		
		assertEquals(TriangleSideType.ISOSCELES, sideType);
	}

	@Test
	public void testScaleneTriangle() {
		
		List<Double> sides = List.of(1d, 0.9d, 1.1d);
		
		TriangleSideType sideType = TriangleSideType.resolve(sides);
		
		assertEquals(TriangleSideType.SCALENE, sideType);
	}
}
