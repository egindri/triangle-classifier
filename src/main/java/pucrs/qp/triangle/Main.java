package pucrs.qp.triangle;

import java.io.IOException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
        
		TriangleClassification triangleClassification = null;
		
		try (Scanner input = new Scanner(System.in)) {
			Triangle triangle = new Triangle(input.nextDouble(), input.nextDouble(), input.nextDouble());
			triangle.classify();
			triangleClassification = triangle.getClassification();
		} catch (InvalidTriangleException e) {
			System.out.println("NAO FORMA TRIANGULO");
			return;
		}
		
		switch (triangleClassification.getAngleType()) {
			case ACUTE:
				System.out.println("TRIANGULO ACUTANGULO");
				break;
			case OBTUSE:
				System.out.println("TRIANGULO OBTUSANGULO");
				break;
			case RIGHT:
				System.out.println("TRIANGULO RETANGULO");
		}
		
		switch (triangleClassification.getSideType()) {
			case EQUILATERAL:
				System.out.println("TRIANGULO EQUILATERO");
				break;
			case ISOSCELES:
				System.out.println("TRIANGULO ISOSCELES");
			case SCALENE:
		}
    }
}