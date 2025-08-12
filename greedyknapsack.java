import java.util.Arrays;
import java.util.Scanner;

class Item {
    int profit, weight;
    double ratio;

    Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
        this.ratio = (double) profit / weight;
    }
}

class GKnapsack {
    public double greedy(int n, Item[] items, int M) {

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        int remaining_capacity = M;
        double total_profit = 0.0;
        double[] x = new double[n];

        for (int i = 0; i < n; i++) {
            if (items[i].weight <= remaining_capacity) {
                x[i] = 1.0;
                total_profit += items[i].profit;
                remaining_capacity -= items[i].weight;
            } else {
                x[i] = (double)remaining_capacity / items[i].weight;
                total_profit += items[i].profit * x[i];
                break;
            }
        }
        return total_profit;
    }

    public static void main(String[] args) {
        GKnapsack obj = new GKnapsack();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of Items: ");
        int n = sc.nextInt();
        int[] weight = new int[n];
        int[] profit = new int[n];

        System.out.println("Enter the profits of each item: ");
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }
        System.out.println("Enter the weights of each item: ");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.println("Enter knapsack capacity: ");
        int M = sc.nextInt();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(profit[i], weight[i]);
        }

        double max_profit = obj.greedy(n, items, M);

        System.out.println("Maximum profit is: " + max_profit);
    }
}

//yt link
//https://youtu.be/oTTzNMHM05I?si=qxITyzjlX8XRYGvX
