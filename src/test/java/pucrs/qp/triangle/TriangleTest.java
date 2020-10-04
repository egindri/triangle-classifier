package pucrs.qp.triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TriangleTest {
	
	@Test
	public void testInvalidTriangleAEqualsOtherSides() {
		
		Triangle triangle = new Triangle(1d, 2d, 3d);

		assertThrows(InvalidTriangleException.class, () -> triangle.classify());
	}

	@Test
	public void testInvalidTriangleAEqualsOtherSidesReverseOrder() {
		
		Triangle triangle = new Triangle(3d, 2d, 1d);

		assertThrows(InvalidTriangleException.class, () -> triangle.classify());
	}

	@Test
	public void testInvalidTriangleAGreaterThanOtherSides() {
		
		Triangle triangle = new Triangle(1d, 2d, 3.1d);

		assertThrows(InvalidTriangleException.class, () -> triangle.classify());
	}

	@Test
	public void testInvalidTriangleAGreaterThanOtherSidesReverseOrder() {

		Triangle triangle = new Triangle(3.1d, 2d, 1d);

		assertThrows(InvalidTriangleException.class, () -> triangle.classify());
	}
	
	@Test
    public void testRightTriangle() {

		Triangle triangle = new Triangle(5d, 4d, 3d);

		triangle.classify();
		
		assertEquals(TriangleAngleType.RIGHT, triangle.getClassification().getAngleType());
    }

	@Test
	public void testRightTriangleReverseOrder() {

		Triangle triangle = new Triangle(3d, 4d, 5d);

		triangle.classify();
		
		assertEquals(TriangleAngleType.RIGHT, triangle.getClassification().getAngleType());
	}

	@Test
	public void testObtuseTriangle() {

		Triangle triangle = new Triangle(5.1d, 4d, 3d);

		triangle.classify();
		
		assertEquals(TriangleAngleType.OBTUSE, triangle.getClassification().getAngleType());
	}
	
	@Test
	public void testObtuseTriangleReverseOrder() {
		
		Triangle triangle = new Triangle(3d, 4d, 5.1d);
		
		triangle.classify();
		
		assertEquals(TriangleAngleType.OBTUSE, triangle.getClassification().getAngleType());
	}

	@Test
	public void testAcuteTriangle() {
		
		Triangle triangle = new Triangle(4.9d, 4d, 3d);
		
		triangle.classify();
		
		assertEquals(TriangleAngleType.ACUTE, triangle.getClassification().getAngleType());
	}
	
	@Test
	public void testAcuteTriangleReverseOrder() {
		
		Triangle triangle = new Triangle(3d, 4d, 4.9d);
		
		triangle.classify();
		
		assertEquals(TriangleAngleType.ACUTE, triangle.getClassification().getAngleType());
	}

	@Test
	public void testIsoscelesTriangle() {
		
		Triangle triangle = new Triangle(1d, 1d, 1.1d);
		
		triangle.classify();
		
		assertEquals(TriangleSideType.ISOSCELES, triangle.getClassification().getSideType());
	}

	@Test
	public void testIsoscelesTriangleReverseOrder() {
		
		Triangle triangle = new Triangle(1.1d, 1d, 1d);
		
		triangle.classify();
		
		assertEquals(TriangleSideType.ISOSCELES, triangle.getClassification().getSideType());
	}

	@Test
	public void testScaleneTriangle() {
		
		Triangle triangle = new Triangle(1d, 0.9d, 1.1d);
		
		triangle.classify();
		
		assertEquals(TriangleSideType.SCALENE, triangle.getClassification().getSideType());
	}

	@Test
	public void testScaleneTriangleReverseOrder() {
		
		Triangle triangle = new Triangle(1.1d, 0.9d, 1d);
		
		triangle.classify();
		
		assertEquals(TriangleSideType.SCALENE, triangle.getClassification().getSideType());
	}

	@Test
    public void testEquilateralTriangle() {

		Triangle triangle = new Triangle(1d, 1d, 1d);
		
		triangle.classify();
		
		assertEquals(TriangleSideType.EQUILATERAL, triangle.getClassification().getSideType());
    }
}
