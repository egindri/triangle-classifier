package pucrs.qp.triangle;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriangleClassifier {

	public static TriangleClassification classify(double side1, double side2, double side3) throws InvalidTriangleException {
        
		List<Double> sides = Stream.of(side1, side2, side3).sorted().collect(Collectors.toList());

        double a = sides.get(2);
        double b = sides.get(1);
        double c = sides.get(0);

    	if (a >= b + c) {
    		throw new InvalidTriangleException();
        } else {

        	TriangleAngleType angleType = TriangleAngleType.resolve(a, b, c);
        	TriangleSideType sideType = TriangleSideType.resolve(sides);

    		return new TriangleClassification(sideType, angleType);
        }
    }
}
