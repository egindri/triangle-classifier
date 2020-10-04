package pucrs.qp.triangle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TriangleClassifierTest {
	
	@Test
	public void testInvalidTriangle() {
		
		assertThrows(InvalidTriangleException.class, () -> TriangleClassifier.classify(5d, 2d, 7d));
	}
	
	@Test
    public void testEscaleno() {
        
		double side1 = 5d;
		double side2 = 2d;
		double side3 = 6d;
		
		TriangleClassification classification = TriangleClassifier.classify(side1, side2, side3);
		
		assertEquals(TriangleAngleType.OBTUSE, classification.getAngleType());
    }

	@Test
	public void testEscaleno2() {
		
		double side1 = 5d;
		double side2 = 2d;
		double side3 = 6d;
		
		TriangleClassification classification = TriangleClassifier.classify(side1, side2, side3);
		
		assertEquals(TriangleAngleType.OBTUSE, classification.getAngleType());
	}
}
