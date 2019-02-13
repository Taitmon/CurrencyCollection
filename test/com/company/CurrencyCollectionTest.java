package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CurrencyCollectionTest
{
    private static final BigDecimal THREE_SEVENTEEN = new BigDecimal("3.17");

    private CurrencyCollection currencyCollection;

    @BeforeEach
    void setUp()
    {
        currencyCollection = new CurrencyCollection(10, 5, 3, 2);
    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void addPenny()
    {
        currencyCollection.addPenny(1900);
        currencyCollection.addPenny(1940);
    }

    @Test
    void addNickel()
    {
        currencyCollection.addNickel(1903);
        currencyCollection.addNickel(1993);
    }

    @Test
    void addDime()
    {
        currencyCollection.addDime(1905);
        currencyCollection.addDime(1978);
    }

    @Test
    void addQuarter()
    {
        currencyCollection.addQuarter(1908);
        currencyCollection.addQuarter(2008);
    }

    @Test
    void getPenniesFaceValue()
    {
        currencyCollection.addPenny(1900);
        currencyCollection.addPenny(1940);

        assertEquals(new BigDecimal("0.04"), currencyCollection.getPenniesFaceValue());
    }

    @Test
    void getPenniesCollectibleValue()
    {
        currencyCollection.addPenny(1900);  //1.36
        currencyCollection.addPenny(1940);  //0.16

        assertEquals(new BigDecimal("1.54"), currencyCollection.getPenniesCollectibleValue());
    }

    @Test
    void getNickelsFaceValue()
    {
        currencyCollection.addNickel(1903);
        currencyCollection.addNickel(1993);

        assertEquals(new BigDecimal("0.25"), currencyCollection.getNickelsFaceValue());

    }

    @Test
    void getNickelsCollectibleValue()
    {
        currencyCollection.addNickel(1903); //3.25
        currencyCollection.addNickel(1993); //0.05

        assertEquals(new BigDecimal("3.45"), currencyCollection.getNickelsCollectibleValue());
    }

    @Test
    void getDimesFaceValue()
    {
        currencyCollection.addDime(1905);
        currencyCollection.addDime(1978);

        assertEquals(new BigDecimal("0.70"), currencyCollection.getDimesFaceValue());

    }

    @Test
    void getDimesCollectibleValue()
    {
        currencyCollection.addDime(1905);
        currencyCollection.addDime(1978);

        assertEquals(new BigDecimal("0.70"), currencyCollection.getDimesCollectibleValue());
    }

    @Test
    void getQuartersFaceValue()
    {
        currencyCollection.addQuarter(1908);
        currencyCollection.addQuarter(2008);

        assertEquals(new BigDecimal("3.00"), currencyCollection.getQuartersFaceValue());

    }

    @Test
    void getQuartersCollectibleValue()
    {
        currencyCollection.addQuarter(1908); //3.55
        currencyCollection.addQuarter(2008); //0.25

        assertEquals(new BigDecimal("6.30"), currencyCollection.getQuartersCollectibleValue());
    }

    @Test
    void getFaceValue()
    {
        assertEquals(THREE_SEVENTEEN, currencyCollection.getFaceValue());

        currencyCollection.addPenny(1900);
        currencyCollection.addNickel(1903);
        currencyCollection.addDime(1905);
        currencyCollection.addQuarter(1908);

        currencyCollection.addPenny(1940);
        currencyCollection.addNickel(1993);
        currencyCollection.addDime(1978);
        currencyCollection.addQuarter(2008);

        assertEquals(new BigDecimal("3.99"), currencyCollection.getFaceValue());
    }

    @Test
    void getCollectibleValue()
    {

        assertEquals(THREE_SEVENTEEN, currencyCollection.getCollectibleValue());

        currencyCollection.addPenny(1900);
        currencyCollection.addNickel(1903);
        currencyCollection.addDime(1905);
        currencyCollection.addQuarter(1908);

        currencyCollection.addPenny(1940);
        currencyCollection.addNickel(1993);
        currencyCollection.addDime(1978);
        currencyCollection.addQuarter(2008);

        assertEquals(new BigDecimal("11.99"), currencyCollection.getCollectibleValue());
    }
}