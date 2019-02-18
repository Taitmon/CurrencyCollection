package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CurrencyCollection
{
     private ArrayList<Quarter> quarters = new ArrayList<>();
     private ArrayList<Dime> dimes = new ArrayList<>();
     private ArrayList<Nickel> nickels = new ArrayList<>();
     private ArrayList<Penny> pennies = new ArrayList<>();

     public CurrencyCollection(int quarterCount, int dimeCount, int nickelCount, int pennyCount)
     {
          for (int i = 1; i <= quarterCount; i++)
          {
               Quarter quarter = new Quarter();
               this.quarters.add(quarter);
          }

          for (int i = 1; i <= dimeCount; i++)
          {
               Dime dime = new Dime();
               this.dimes.add(dime);
          }

          for (int i = 1; i <= nickelCount; i++)
          {
               Nickel nickle = new Nickel();
               this.nickels.add(nickle);
          }

          for (int i = 1; i <= pennyCount; i++)
          {
               Penny penny = new Penny();
               this.pennies.add(penny);
          }
     }

     //add coins
     public void addQuarter(int year)
     {
          Quarter quarter = new Quarter(year);
          this.quarters.add(quarter);
}

     public void addDime(int year)
     {
          Dime dime = new Dime(year);
          this.dimes.add(dime);
     }

     public void addNickel(int year)
     {
          Nickel nickle = new Nickel(year);
          this.nickels.add(nickle);
     }

     public void addPenny(int year)
     {
          Penny penny = new Penny(year);
          this.pennies.add(penny);
     }

     //get face values.
     public BigDecimal getQuartersFaceValue()
     {
          BigDecimal amountOfQuarters = new BigDecimal(quarters.size());
          BigDecimal  quarterFaceValueSum = Quarter.getFaceValue().multiply(amountOfQuarters);

          return quarterFaceValueSum;
     }

     public BigDecimal getDimesFaceValue()
     {
          BigDecimal amountOfDimes = new BigDecimal(dimes.size());
          BigDecimal dimeFaceValueSum = Dime.getFaceValue().multiply(amountOfDimes);

          return dimeFaceValueSum;
     }

     public BigDecimal getNickelsFaceValue()
     {
          BigDecimal amountOfNickels = new BigDecimal(nickels.size());
          BigDecimal nickelFaceValueSum = Nickel.getFaceValue().multiply(amountOfNickels);

          return nickelFaceValueSum;
     }
     public BigDecimal getPenniesFaceValue()
     {
          BigDecimal amountOfPennies = new BigDecimal(pennies.size());
          BigDecimal pennyFaceValueSum = Penny.getFaceValue().multiply(amountOfPennies);

          return pennyFaceValueSum;
     }

     public BigDecimal getQuartersCollectibleValue()
     {
          BigDecimal sumOfCollectionValue = new BigDecimal("0");
          for (Quarter quarter : quarters)
          {
               sumOfCollectionValue = sumOfCollectionValue.add(quarter.getCollectionValue());
               System.out.println(sumOfCollectionValue);

          }
          return sumOfCollectionValue;
     }

     public BigDecimal getDimesCollectibleValue()
     {
          BigDecimal sumOfCollectionValue = new BigDecimal("0");
          for (Dime dime : dimes)
          {
               sumOfCollectionValue = sumOfCollectionValue.add(dime.getCollectionValue());

          }
          return sumOfCollectionValue;
     }

     public BigDecimal getNickelsCollectibleValue()
     {
          BigDecimal sumOfCollectionValue = new BigDecimal("0");
          for (Nickel nickel : nickels)
          {
               sumOfCollectionValue = sumOfCollectionValue.add(nickel.getCollectionValue());
          }
          return sumOfCollectionValue;
     }

     public BigDecimal getPenniesCollectibleValue()
     {
          BigDecimal sumOfCollectionValue = new BigDecimal("0");
          for (Penny penny : pennies)
          {
               sumOfCollectionValue = sumOfCollectionValue.add(penny.getCollectionValue());
          }
          return sumOfCollectionValue;
     }

     public BigDecimal getFaceValue()
     {
          BigDecimal sum = new BigDecimal("0");
          sum = sum.add(getQuartersFaceValue().add(getDimesFaceValue().add(getNickelsFaceValue().add(getPenniesFaceValue()))));


          return sum;
     }

     public BigDecimal getCollectibleValue()
     {
          BigDecimal sum;
          sum = getQuartersCollectibleValue().add(getDimesCollectibleValue().add(getNickelsCollectibleValue().add(getPenniesCollectibleValue())));

          return sum;
     }
}

