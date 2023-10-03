package exercise;

// BEGIN
public class Cottage implements Home {
    double area;

    public Cottage(double area, Integer floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " +
                area + " метров";
    }

    Integer floorCount;

    @Override
    public Double getArea() {
        return area;
    }

    @Override
    public Integer compareTo(Home another) {
        if (getArea() > another.getArea()) {
            return 1;
        } else if (getArea() < another.getArea()) {
            return -1;
        }
        return 0;
    }
}
// END
