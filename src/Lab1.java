import java.util.Scanner;

class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x_1 = scanner.nextDouble(), y_1 = scanner.nextDouble(), z_1 = scanner.nextDouble();
        double x_2 = scanner.nextDouble(), y_2 = scanner.nextDouble(), z_2 = scanner.nextDouble();
        double x_3 = scanner.nextDouble(), y_3 = scanner.nextDouble(), z_3 = scanner.nextDouble();

        scanner.close();

        Point3d firstPoint = new Point3d.Builder().setX(x_1).setY(y_1).setZ(z_1).createPoint();
        Point3d secondPoint = new Point3d.Builder().setX(x_2).setY(y_2).setZ(z_2).createPoint();
        Point3d thirdPoint = new Point3d.Builder().setX(x_3).setY(y_3).setZ(z_3).createPoint();

        System.out.println(computeArea(firstPoint, secondPoint, thirdPoint));
    }

    public static double computeArea(Point3d firstPoint, Point3d secondPoint, Point3d thirdPoint) {
        if (isValidTrianglePoints(firstPoint, secondPoint, thirdPoint)) {
            double AB = firstPoint.distanceTo(secondPoint);
            double BC = secondPoint.distanceTo(thirdPoint);
            double AC = firstPoint.distanceTo(thirdPoint);
            double p = (AB + BC + AC) / 2;

            return Math.sqrt(p * (p - AB) * (p - BC) * (p - AC));
        } else {
            throw new IllegalArgumentException("There is no such triangle, points shouldn't be equal");
        }
    }

    public static boolean isValidTrianglePoints(Point3d firstPoint, Point3d secondPoint, Point3d thirdPoint) {
        return !(firstPoint.equals(secondPoint) || firstPoint.equals(thirdPoint) || firstPoint.equals(secondPoint));
    }
}