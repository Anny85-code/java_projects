package cs1102.projects;

import java.util.ArrayList;

/**
 * data analysis project that processes an array of opening stock prices 
 * containing 10 days of data as float datatype.
 * calculateAveragePrice, which takes the array of stock prices as input and returns the average price of the stocks.
 * findMaximumPrice, which takes the array of stock prices as input and returns the maximum price among all the stocks. 
 * countOccurrences, which takes the array of stock prices and a target price as input and returns the number of times the target price occurs in the array. 
 * computeCumulativeSum, which takes the ArrayList of stock prices as input and returns a new ArrayList containing the cumulative sum of prices at each position.
 */

public class StockScreener {

    public static void main(String[] args) {
        // stock price array
        int[] stockPricesArray = {10, 15, 20, 25, 18, 30, 22, 40, 35, 28};
        ArrayList<Integer> stockPricesList = new ArrayList<>(10);

        for (int price : stockPricesArray) {
            stockPricesList.add(price);
        }

        double averagePrice = calculateAveragePrice(stockPricesArray);
        System.out.println("Average Stock Price: " + averagePrice);

        int maxPrice = findMaximumPrice(stockPricesArray);
        System.out.println("Maximum Stock Price: " + maxPrice);

        int targetPrice = 40;
        int occurrences = countOccurrences(stockPricesArray, targetPrice);
        System.out.println("Occurrences of " + targetPrice + ": " + occurrences);

        ArrayList<Integer> cumulativeSumList = computeCumulativeSum(stockPricesList);
        System.out.println("Cumulative Sum of Stock Prices: " + cumulativeSumList);
    }

    // Calculate the average stock price
    public static double calculateAveragePrice(int[] stockPrices) {
        double sum = 0;
        for (int price : stockPrices) {
            sum += price;
        }
        return sum / stockPrices.length;
    }

    // Find the maximum stock price
    public static int findMaximumPrice(int[] stockPrices) {
        int maxPrice = Integer.MIN_VALUE;
        for (int price : stockPrices) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;
    }

    // Determine the occurrence count of a specific price
    public static int countOccurrences(int[] stockPrices, int targetPrice) {
        int count = 0;
        for (int price : stockPrices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    // Compute the cumulative sum of stock prices
    public static ArrayList<Integer> computeCumulativeSum(ArrayList<Integer> stockPrices) {
        ArrayList<Integer> cumulativeSumList = new ArrayList<>(stockPrices.size());
        int sum = 0;
        for (int price : stockPrices) {
            sum += price;
            cumulativeSumList.add(sum);
        }
        return cumulativeSumList;
    }
}
