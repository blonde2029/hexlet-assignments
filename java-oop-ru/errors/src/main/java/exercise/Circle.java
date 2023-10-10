package exercise;

// BEGIN
public class Circle {
    private Point point;
    private int radius;

    public int getRadius() {
        return radius;
    }
    public double getSquare() throws NegativeRadiusException {
        double result;
        if (radius >= 0) {
            result = Math.PI * radius * radius;
        } else throw new NegativeRadiusException("Не удалось посчитать площадь");
        return result;
    }



    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }
}
// END
