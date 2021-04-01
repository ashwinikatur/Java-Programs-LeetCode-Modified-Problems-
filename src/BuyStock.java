/*
Program to find the max profit from a given list of stock prices and return the indices of buying and selling price.
 */
import java.util.ArrayList;

public class BuyStock {
    protected int buyIndex;
    protected int sellIndex;
    protected int profit = 0;

    public static void main(String[] args){

        ArrayList<Integer> stockPrices = new ArrayList<>();
        stockPrices.add(60);
        stockPrices.add(90);
        stockPrices.add(45);
        stockPrices.add(80);
        stockPrices.add(75);
        stockPrices.add(85);
        stockPrices.add(65);

        BuyStock result = findHighestProfit(stockPrices);
        System.out.println("Buy Index: " + result.buyIndex + ", Sell Index: " + result.sellIndex + " Max Profit: " + result.profit);
    }

    protected static BuyStock findHighestProfit(ArrayList<Integer> stockPrices) {
        BuyStock output = new BuyStock();
        output.buyIndex = 0;
        output.sellIndex = 0;
        int minPrice = stockPrices.get(0);
        int p1=0;
        int p2=1;

        while(p1<p2 && p2<stockPrices.size()){
            int currProfit = stockPrices.get(p2)- minPrice;
            if(currProfit>output.profit){
                output.profit = currProfit;
                output.buyIndex = p1;
                output.sellIndex = p2;
            }
            if(stockPrices.get(p2)<stockPrices.get(p1)){
                p1=p2;
                p2=p1+1;
            }
            else{
                p2++;
            }
            minPrice = stockPrices.get(p1);
        }
        return output;
    }
}
