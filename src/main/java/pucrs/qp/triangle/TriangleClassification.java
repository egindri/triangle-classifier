package pucrs.qp.triangle;

public class TriangleClassification {
	
	private TriangleSideType sideType;
	private TriangleAngleType angleType;

	
	public TriangleClassification(TriangleSideType sideType, TriangleAngleType angleType) {
		this.sideType = sideType;
		this.angleType = angleType;
	}

	
	public TriangleSideType getSideType() {
		return sideType;
	}

	public TriangleAngleType getAngleType() {
		return angleType;
	}
}
