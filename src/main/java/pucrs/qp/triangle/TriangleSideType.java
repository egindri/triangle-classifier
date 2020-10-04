package pucrs.qp.triangle;

import java.util.Arrays;
import java.util.List;

public enum TriangleSideType {
	
	EQUILATERAL(1),
	ISOSCELES(2), 
	SCALENE(3);
	
	
	private int numberOfDifferentSides;
	
	
	TriangleSideType(int numberOfDifferentSides) {
		this.numberOfDifferentSides = numberOfDifferentSides;
	}

	
	public static TriangleSideType resolve(List<Double> sides) {
		Long numberOfDifferentSides = sides.stream().distinct().count();
		return Arrays.stream(TriangleSideType.values()).filter(t -> t.numberOfDifferentSides == numberOfDifferentSides).findAny().get();
	}
}
