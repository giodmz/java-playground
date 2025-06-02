public class Professor {

    private double hourPrice;
    private int classes;

    public Professor() {
    }

    public Professor(double hourPrice, int classes) {
        this.hourPrice = hourPrice;
        this.classes = classes;

    }

    public double getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(double hourPrice) {
        this.hourPrice = hourPrice;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public double inssCalc(double salary) {

        double discount;

        if (salary <= 1518.00) {
            discount = 0.075;
        } else if (salary <= 2793.88) {
            discount = 0.09;
        } else if (salary <= 4190.84) {
            discount = 0.12;
        } else if (salary <= 8157.41) {
            discount = 0.14;
        } else {
            discount = 0.15;
        }

        return salary - (salary * discount);
    }

}

