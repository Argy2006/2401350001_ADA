import java.util.*;

class Product {
    int profit, mass;
    double density;

    Product(int p, int m) {
        profit = p;
        mass = m;
        density = (double) profit / mass;
    }
}

public class fractionalKnapsack {

    public static void calculateMax(Product[] arr, int limit) {

        Arrays.sort(arr, (a, b) -> Double.compare(b.density, a.density));

        double maxProfit = 0;

        System.out.println("Items Chosen (profit, weight, portion):");

        for (Product p : arr) {
            if (limit >= p.mass) {
                maxProfit += p.profit;
                limit -= p.mass;

                System.out.println(p.profit + ", " + p.mass + ", 1");
            } else {
                double part = (double) limit / p.mass;
                maxProfit += p.profit * part;

                System.out.println(p.profit + ", " + p.mass + ", " + part);
                break;
            }
        }

        System.out.println("Total Maximum Profit = " + maxProfit);
    }

    public static void main(String[] args) {

        Product[] arr = {
            new Product(40, 5),
            new Product(70, 10),
            new Product(90, 15),
            new Product(120, 30)
        };

        int limit = 35;

        calculateMax(arr, limit);
    }
}