package pucrs.qp.triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TriangleAngleTypeTest {
	
	@Test
    public void testRightTriangle() {
		
		double a = 5d;
		double b = 4d;
		double c = 3d;
		
		TriangleAngleType angleType = TriangleAngleType.resolve(a, b, c);
		
		assertEquals(TriangleAngleType.RIGHT, angleType);
    }

	@Test
	public void testObtuseTriangle() {
		
		double a = 5.1d;
		double b = 4d;
		double c = 3d;
		
		TriangleAngleType angleType = TriangleAngleType.resolve(a, b, c);
		
		assertEquals(TriangleAngleType.OBTUSE, angleType);
	}

	@Test
	public void testAcuteTriangle() {
		
		double a = 4.9d;
		double b = 4d;
		double c = 3d;
		
		TriangleAngleType angleType = TriangleAngleType.resolve(a, b, c);
		
		assertEquals(TriangleAngleType.ACUTE, angleType);
	}
}
