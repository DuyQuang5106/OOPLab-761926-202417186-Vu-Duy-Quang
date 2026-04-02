import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose option:");
        System.out.println("1. Linear equation");
        System.out.println("2. System of 2 linear equations");
        System.out.println("3. Quadratic equation");

        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Type in a:");
            double a = sc.nextDouble();
            System.out.println("Type in b:");
            double b = sc.nextDouble();

            if (a == 0) {
                if (b == 0) {
                    System.out.println("Infinite solutions");
                } else {
                    System.out.println("No solution");
                }
            } else {
                double x = -b / a;
                System.out.println("x = " + x);
            }
        } else if (choice == 2) {
            System.out.println("Type in a11:");
            double a11 = sc.nextDouble();
            System.out.println("Type in a12:");
            double a12 = sc.nextDouble();
            System.out.println("Type in b1:");
            double b1 = sc.nextDouble();
            System.out.println("Type in a21:");
            double a21 = sc.nextDouble();
            System.out.println("Type in a22:");
            double a22 = sc.nextDouble();
            System.out.println("Type in b2:");
            double b2 = sc.nextDouble();

            double D = a11 * a22 - a12 * a21;
            double Dx = b1 * a22 - a12 * b2;
            double Dy = a11 * b2 - b1 * a21;

            if (D != 0) {
                double x = Dx / D;
                double y = Dy / D;
                System.out.println("x = " + x + " y = " + y);
            } else {
                if (Dx == 0 && Dy == 0) {
                    System.out.println("Infinite solutions");
                } else {
                    System.out.println("No solution");
                }
            }
        } else if (choice == 3) {
            System.out.println("Type in a:");
            double a = sc.nextDouble();
            System.out.println("Type in b:");
            double b = sc.nextDouble();
            System.out.println("Type in c:");
            double c = sc.nextDouble();

            if (a == 0) {
                if (b == 0) {
                    if (c == 0) {
                        System.out.println("Infinite solutions");
                    } else {
                        System.out.println("No solution");
                    }
                } else {
                    double x = -c / b;
                    System.out.println("x = " + x);
                }
            } else {
                double delta = b * b - 4 * a * c;

                if (delta > 0) {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    System.out.println("x1 = " + x1 + " x2 = " + x2);
                } else if (delta == 0) {
                    double x = -b / (2 * a);
                    System.out.println("x = " + x);
                } else {
                    System.out.println("No real root");
                }
            }
        }

        sc.close();
    }
}