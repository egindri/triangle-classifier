package pucrs.qp.triangle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Triangle {

	private double side1, side2, side3;
	private TriangleClassification classification;

	
	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	
	public void classify() throws InvalidTriangleException {
        
		List<Double> sides = Stream.of(side1, side2, side3).sorted().collect(Collectors.toList());

        double a = sides.get(2);
        double b = sides.get(1);
        double c = sides.get(0);

    	if (a >= b + c) {
    		throw new InvalidTriangleException();
        } else {

        	TriangleSideType sideType = resolveSideType(sides);
        	TriangleAngleType angleType = resolveAngleType(a, b, c);

    		classification = new TriangleClassification(sideType, angleType);
        }
    }
	
	private TriangleSideType resolveSideType(List<Double> sides) {
		Long numberOfDifferentSides = sides.stream().distinct().count();
		return Arrays.stream(TriangleSideType.values()).filter(t -> t.getNumberOfDifferentSides() == numberOfDifferentSides).findAny().get();
	}
	
	private TriangleAngleType resolveAngleType(Double a, Double b, Double c) {
		
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

	public TriangleClassification getClassification() {
		return classification;
	}
}
