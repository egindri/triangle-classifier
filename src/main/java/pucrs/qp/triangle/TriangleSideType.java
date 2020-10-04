package pucrs.qp.triangle;

public enum TriangleSideType {
	
	EQUILATERAL(1),
	ISOSCELES(2), 
	SCALENE(3);
	
	
	private int numberOfDifferentSides;
	
	
	TriangleSideType(int numberOfDifferentSides) {
		this.numberOfDifferentSides = numberOfDifferentSides;
	}


	public int getNumberOfDifferentSides() {
		return numberOfDifferentSides;
	}
}
