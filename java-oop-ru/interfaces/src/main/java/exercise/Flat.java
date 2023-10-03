package exercise;

// BEGIN
public class Flat implements Home {
    double area;
    double balconyArea;
    Integer floor;

    public Flat(double area, double balconyArea, Integer floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Квартира " +
                "площадью " + getArea() +
                " метров на "  +
                floor + " этаже";
    }

    @Override
    public Double getArea() {
        return area + balconyArea;
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
