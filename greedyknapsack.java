import java.util.*;

// Class to represent each item with profit, weight, and profit/weight ratio
class Item {
    int profit, weight;
    double ratio;

    // Constructor to initialize profit, weight and compute ratio
    Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
        this.ratio = (double)profit/weight;
    }
}

//main class
class GreedyKnapsack {

    //greedy approach 
    public double greedy(int n, Item[] items,int M) {

        //Sort items in descending order of profit-to-weight ratio
        Arrays.sort(items, (a,b) -> Double.compare(b.ratio, a.ratio)); 

        double[] x = new double[n]; // Array to store fraction of items which got included
        int rc = M; //remaining capacity
        double tp = 0.0; // total profit
        
        for(int i = 0; i < n ; i++) {
            if(items[i].weight <= rc) {  // If whole item can be included
                x[i] = 1.0;
                tp += items[i].profit;
                rc -= items[i].weight;
            } else { // If only part of the item can be included
                x[i] = (double)rc/items[i].weight;
                tp += items[i].profit * x[i];
                break; //knapsack is full
            }
            }
            return tp;
        }


//main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("KnapSack Using Greedy Approach");

        System.out.println("Enter no. of items");
        int n = sc.nextInt();

        int[] profit = new int[n];
        int[] weight = new int[n];

        System.out.println("Enter the profits of each item");
        for(int i = 0; i < n; i++) {
             profit[i] = sc.nextInt();
        }

        System.out.println("Enter the weights of each item");
        for(int i = 0; i < n;i++) {
            weight[i] = sc.nextInt();
        }

        // Create array of Item objects using profit and weight
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(profit[i], weight[i]);
        }

        System.out.println("Enter the capacity of the Knapsack");
        int M = sc.nextInt();

        GreedyKnapsack obj = new GreedyKnapsack();
        double  max_profit = obj.greedy(n,items,M);

        System.out.println("The Maximum Profit:"+max_profit);

    }
}


//yt link
//https://youtu.be/oTTzNMHM05I?si=qxITyzjlX8XRYGvX

// OR
// without extra class
// import java.util.*;

// class GreedyKnapsack {

//     public double greedy(int n, int[] profit, int[] weight, int M) {
//         double[] ratio = new double[n];
//         Integer[] index = new Integer[n];

//         // Calculate ratio and initialize index
//         for (int i = 0; i < n; i++) {
//             ratio[i] = (double) profit[i] / weight[i];
//             index[i] = i;
//         }

//         // Sort indices based on ratio in descending order
//         Arrays.sort(index, (a, b) -> Double.compare(ratio[b], ratio[a]));

//         double[] x = new double[n];
//         int rc = M;
//         double tp = 0.0;

//         for (int i = 0; i < n; i++) {
//             int idx = index[i];
//             if (weight[idx] <= rc) {
//                 x[idx] = 1.0;
//                 tp += profit[idx];
//                 rc -= weight[idx];
//             } else {
//                 x[idx] = (double) rc / weight[idx];
//                 tp += profit[idx] * x[idx];
//                 break;
//             }
//         }

//         return tp;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Knapsack Using Greedy Approach");

//         System.out.println("Enter number of items:");
//         int n = sc.nextInt();

//         int[] profit = new int[n];
//         int[] weight = new int[n];

//         System.out.println("Enter profits of items:");
//         for (int i = 0; i < n; i++) {
//             profit[i] = sc.nextInt();
//         }

//         System.out.println("Enter weights of items:");
//         for (int i = 0; i < n; i++) {
//             weight[i] = sc.nextInt();
//         }

//         System.out.println("Enter capacity of the Knapsack:");
//         int M = sc.nextInt();

//         GreedyKnapsack obj = new GreedyKnapsack();
//         double max_profit = obj.greedy(n, profit, weight, M);

//         System.out.println("Maximum Profit: " + max_profit);
//     }
// }
