package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StocksPortfolioTest {

    //1.Prepare a mock to substitute the remote service (@Mock annotation)
    @Mock
    IStockMarket market;

    // 2.Create an instance of the subject under test (SuT) and use the mock to set the (remote) service instance.
    @InjectMocks
    StocksPortfolio portfolio;

    @Test
    void getTotalValue() {
        // 3.Load the mock with the proper expectations (when...thenReturn)
        when( market.getPrice("EBAY")).thenReturn(5.0);
        when( market.getPrice("AliExpress")).thenReturn(6.0);

        // 4.Execute the test (use the service in the SuT)
        portfolio.addStock(new Stock("EBAY",2));
        portfolio.addStock(new Stock("AliExpress",4));
        double result = portfolio.getTotalValue();

        // 5.Verify the result (assert) and the use of the mock (verify)
        assertEquals(34,result);
        verify(market,times(2)).getPrice(anyString());

        // Hamcrest
        assertThat(result,is(34.0));
    }
}