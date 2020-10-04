package pucrs.qp.triangle;

public enum TriangleAngleType {
	
	ACUTE, OBTUSE, RIGHT;
	
	
	public static TriangleAngleType resolve(Double a, Double b, Double c) {
		
    	Double aSquared = squared(a);
    	Double bcSquared = squared(b) + squared(c);
		
    	switch (aSquared.compareTo(bcSquared)) {
        	case -1:
        		return TriangleAngleType.ACUTE;
        	case 0:
        		return TriangleAngleType.RIGHT;
        	case 1:
        	default:
        		return TriangleAngleType.OBTUSE;
    	}
	}
	
    private static double squared(double x) {
    	return x * x;
    }
}
