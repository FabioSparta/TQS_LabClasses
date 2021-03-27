package org.example;

import java.util.ArrayList;

public class StocksPortfolio {
    private IStockMarket market;
    private String name;
    private ArrayList<Stock> stocks;


    public StocksPortfolio(IStockMarket market) {
        this.market = market;
        this.stocks= new ArrayList<>();
    }

    public IStockMarket getMarketService(){ return market; }
    public void setMarketService(IStockMarket market){ this.market=market; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getTotalValue(){
        double value = 0.0;

        for (Stock st : stocks)
            value+= st.getQuantity() * market.getPrice(st.getName());

        return value;
    }

    public void addStock(Stock st){
            stocks.add(st);
    }

}
