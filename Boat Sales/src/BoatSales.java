/*
 * This program will ask for a child’s name, age, the name of two toys, and the cost of each toy.
 * It will calculate the total bill which includes sales tax.
 *  
 * Nico Busatto 12/07/2018
 */

import java.text.*;
import java.util.*;

public class BoatSales {
	
	//Declare variables
	
		static String iString; //Generic input string
		static char iBoatType; //Boat Type
		static String oBoatName; //Boat Literal
		static double iBoatCost; //Single Boat Cost
		static String oBoatCost; //Formatted Boat Cost amount
		static int iAccessoryType; //Accessory Type
		static String oAccessoryName; //Accessory Literal
		static double cAccessoryCost; //Accessory Cost
		static String oAccessoryCost; //Formatted Accessory Cost
		static double cGtAccessoryCost; //Grand Total Accessory Cost
		static int iQty; //Boat Quantity
		static double iPrepCost; //Preparation Cost
		static String oPrepCost; //Formatted Preparation Cost
		static double cGtPrepCost; //Grand Total preparation cost
		static double cMarkupPercent; //Markup Percentage
        static double cMarkupAmount; //Markup Percentage
        static String oMarkupAmount; //Formatted Markup Amount
		static double cSubtotal; //Subtotal Amount
		static String oSubtotal; //Formatted Subtotal amount
		static double cSalesTax; //Sales Taxes
		static String oSalesTax; //Formatted Sales Tax amomunt
		static double cTotalSales; //Subtotal + Accessories + Tax
		static String oTotalSales; //Formatted Total Sales amount
		static double cGrandTotal = 0; //Grand Total amount
		static String oGrandTotal; //Grand Total amount formatted
		static double cGtTax = 0; //Grand total Tax
		static String oGtTax; //Gtand Total tax formatted
		static double cGtSales = 0; //Grand total sales amount
		static String oGtSales; // Formatted Grand Total Sales amount
		static double cGtMarkup = 0; // Grand Total Markup Amount
		static String oGtMarkup; // Grand Total Markup Amount formatted
		static Scanner myScanner; //Input device
		static int cSalesCounter = 0; //Sales Counter
		static NumberFormat nf; //Used to format currency
		static DecimalFormat df1; //Used to format decimals
		static char inputAgain = 'Y'; //Use to control loop

	public static void main(String[] args) {
		
		//Call Init()
		init();
		
		//Loop until user enters 'n'
		while (inputAgain == 'Y') {
			
			//Call input()
			input();
			
			//Call calcs()
			calcs();
			
			//Call output();
			output();
			
		}	
			
		 if (inputAgain == 'N') {
			
			GtOutput();
				
		 }
		
	}	
	
	public static void init() {
		
		//Initialize new scanner
		myScanner = new Scanner(System.in);
		
		//Change delimiter from blank space to Enter Key 
		// to allow spaces in string
		myScanner.useDelimiter(System.getProperty("line.separator"));
		
		//Set formatter to use U.S. currency format
		nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
		
		//Set formatter for decimal numbers
		df1 = new DecimalFormat("##.##");

	}
	
    public static void input() {
    	
    	//Prompt for boat type
    	
    	System.out.println("Select type of boat: B = Bass; P = Pontoon; S = Ski; C = Canoe");
    	System.out.println("");
    	iBoatType = myScanner.next().toUpperCase().charAt(0);
    	
    	if (iBoatType == 'B') {
    		
    		System.out.println("The selected boat type is Bass");
    		System.out.println("");
    		oBoatName = "Bass";
    		cMarkupPercent = 33;
    	
    	  } else if (iBoatType =='P') {
    		
    		System.out.println("The selected boat type is Pontoon");
    		System.out.println("");
    		oBoatName = "Pontoon";
    		cMarkupPercent = 25;
    		
    	  } else if (iBoatType == 'S') {
    		
    		System.out.println("The selected boat type is Ski");
    		System.out.println("");
    		oBoatName = "Ski";
    		cMarkupPercent = 42.5;
    		
    	  } else if (iBoatType == 'C') {
    		
    		System.out.println("The selected boat type is Canoe");
    		System.out.println("");
    		oBoatName = "Canoe";
    		cMarkupPercent = 20;
    		
    	  } else {
    		
    		System.out.println("Boat type must be B = Bass; P = Pontoon; S = Ski; C = Canoe. Defaulted to S = Ski");
    		System.out.println("");
    		oBoatName = "Ski";
    		cMarkupPercent = 42.5;
    	
    	}
    	
    //Prompt for accessories type
    	
    try {
    	
      System.out.println("Select type of accessories: 1 = Electronics; 2 = Ski Package; 3 = Fishing Package");
      System.out.println("");
      iString = myScanner.next();
      iAccessoryType = Integer.parseInt(iString);
      
      switch(iAccessoryType) {
      
            case 1:

   	            System.out.println("The selected accessory is Electronics");
   	            System.out.println("");
   	            oAccessoryName = "Electronics";
   	            cAccessoryCost = 5415.30;
   	            break;
   	   
            case 2:
            	
            	System.out.println("The selected accessory is Ski Package");
        		System.out.println("");
         	    oAccessoryName = "Ski Package";
         	    cAccessoryCost = 3980;
         	    break;
         	    
            case 3:
            	
            	System.out.println("The selected accessory is Fishing Package");
        		System.out.println("");
         	    oAccessoryName = "Fishing Package";
         	    cAccessoryCost = 345.45;
         	    break;
         	    
         	default:
         		
         		System.out.println("Accessory type must be 1 = Eletronics; 2 = Ski Package; 3 = Fishing Package. Defaulted to 1 = Electronics");
        		System.out.println("");
        		oAccessoryName = "Electronics";
        		cAccessoryCost = 5415.30;
        		break;

      }
      
    }  
      
    	
    catch (Exception e){
    		
      System.out.println("Accessory Type must be 1 = Eletronics; 2 = Ski Package; 3 = Fishing Package. Defaulted to 1");
      System.out.println("");
      oAccessoryName = "Electronics";
      cAccessoryCost = 5415.30;
    		
    	}
    
    //Prompt for Boat Quantity
    	
    try {
    	
        System.out.println("Select Boat quantity: 1 - 25");
        System.out.println("");
        iString = myScanner.next();
        iQty = Integer.parseInt(iString);
        
        if (iQty < 0 || iQty > 25) {
 		   System.out.println("The Quantity must be between 1 and 25. Defaulted to 1");
 		   System.out.println("");
 		   iQty = 1;
      	
      	} else {
      		
      		System.out.println("The quantity is " + iQty);
      		System.out.println("");
      		
      	    }
      	
      	}
      	
    catch (Exception e){
      		
        System.out.println("The quantity must be a number between 1 and 25, defaulted to 1");
        System.out.println("");
        iQty = 1;
      		
      	}
    
    //Prompt for Boat Cost
    
    try {
    	
        
        System.out.println("Insert boat price: $2,500.00 - $150,000.00");
        System.out.println("");
        iString = myScanner.next();
        iBoatCost = Double.parseDouble(iString);
        
        if (iBoatCost < 2500.00 || iBoatCost > 150000.00) {
 		   System.out.println("Boat price must be between $2,500.00 - $150,000.00. Defaulted to $2,500.00");
 		  System.out.println("");
 		   iBoatCost = 2500.00;
      	
      	} else {
      		
      		System.out.println("The price entered is " + "$" + iBoatCost);
      		System.out.println("");
      		
      	    }
      	
      	}
      	
    catch (Exception e){
      		
        System.out.println("The price must be a number between $2,500.00 and $150,000.00. Defaulted to $2,500.00");
        System.out.println("");
        iBoatCost = 2500.00;
      		
      	}
    
    //Prompt for Preparation Cost
    
    try {
    	
        System.out.println("Insert preparation cost: $100.00 - $9,999.99");
        iString = myScanner.next();
        iPrepCost = Double.parseDouble(iString);
        
        if (iPrepCost < 100.00 || iPrepCost > 9999.99) {
 		   System.out.println("Preparation cost must be between $100.00 - $9,999.99. Defaulted to $5,000.00");
 		   iPrepCost = 5000.00;
 		   oPrepCost = nf.format(iPrepCost); 
      	
      	} else {
      		
      		System.out.println("The preparation cost entered is " + "$" +  iPrepCost);
      		
      	    }    //Dusk to Dawn By Emancipator
      	
      	}
      	
    catch (Exception e){
      		
        System.out.println("Preparation cost must be between $100.00 - $9,999.99. Defaulted to $5,000.00");
        iPrepCost = 5000.00;
      		
      	}
    		
    }
    
    public static void calcs() {
    	
    	cSalesCounter =+ 1;
    	
    	cMarkupAmount = (cMarkupPercent * iBoatCost) / 100;
    		
    	cSubtotal = (iBoatCost + cAccessoryCost + iPrepCost + cMarkupAmount) * iQty;
    	
    	cSalesTax = (cSubtotal * 0.06);
    	
    	cTotalSales = cSubtotal + cSalesTax;
    	
    	
    	//Add to Grand Total amounts
    	cGrandTotal = cGrandTotal + cSubtotal;
    	
    	cGtTax = cGtTax + cSalesTax;
    	
    	cGtSales = cGtSales + cTotalSales;
    	
    	cGtMarkup =+ cMarkupAmount;
    	
    }
    
    public static void output() {
    	
    	
    	//$ Amounts formatting
    	oBoatCost = nf.format(iBoatCost);
    	oAccessoryCost = nf.format(cAccessoryCost);
    	oPrepCost = nf.format(iPrepCost);
    	oMarkupAmount = nf.format(cMarkupAmount);
    	oSubtotal = nf.format(cSubtotal);
    	oSalesTax = nf.format(cSalesTax);
    	oTotalSales = nf.format(cTotalSales);
    	
        //Decimal Formatting
    	//oMarkupAmount = df1.format(cMarkupAmount);
    	//oSalesTax = df1.format(cSalesTax);
    	
    	//Output messages
    	System.out.println("");
    	System.out.println("");
    	System.out.println("The chosen boat is " + oBoatName);
    	System.out.println("");
    	System.out.println("The chosen accessory is " + oAccessoryName);
    	System.out.println("");
    	
        if (iQty == 1) {
        	
        	System.out.println("You selected " + iQty + " boat");
        	System.out.println("");
        	
        } else {
        	
        	System.out.println("You selected " + iQty + " boats" );
        	System.out.println("");
        	
        } 
        
        if (iQty == 1) {
        	
        	System.out.println("The boat cost is " + oBoatCost);
        	System.out.println("");
        	
        } else {
        	
        	System.out.println("The boats cost is " + oBoatCost);
        	System.out.println("");
        	
        }	
    	
        System.out.println("The accessory cost is " + oAccessoryCost);
        System.out.println("");
        System.out.println("The preparation cost is " + oPrepCost);
        System.out.println("");
        System.out.println("The markup amount on this sale is " + oMarkupAmount);
        System.out.println("");
        System.out.println("The Subtotal before tax is " + oSubtotal);
        System.out.println("");
        System.out.println("The tax amount is " + oSalesTax);
        System.out.println("");
        System.out.println("The Total amount for this sale is " + oTotalSales);
        System.out.println("");
        
        //User prompt to calculate another receipt
        System.out.println("Do you want to calculate another receipt? Y or N");
        inputAgain = myScanner.next().toUpperCase().charAt(0);
        
        //Switch case for inputAgain
 
        switch(inputAgain) {
            case 'Y':
                inputAgain = 'Y';
                break;
                

            case 'N':
                inputAgain = 'N';
                break;
                

            default:
                System.out.println("Invalid choice, please enter Y or N");
                inputAgain = myScanner.next().toUpperCase().charAt(0);
                break;
                
        }
      
    }        
            
    public static void GtOutput() {
    	
    	//$ Amounts formattings
    	oGrandTotal = nf.format(cGrandTotal);
    	oGtTax = nf.format(cGtTax);
    	oGtSales = nf.format(cGtSales);
    	oGtMarkup = nf.format(cGtMarkup);
    	
    	System.out.println("The Total number of sales is " + cSalesCounter);
    	System.out.println("");
    	System.out.println("The Grand Total cost is " + oGrandTotal);
    	System.out.println("");
        System.out.println("The total tax is " + oGtTax);
        System.out.println("");
        System.out.println("The final Markup Amount for the sale is " + oGtMarkup);
        System.out.println("");
        System.out.println("The final Grand Total for the sale is " + oGtSales);
        System.out.println("");
        System.out.println("");
        System.out.println("Program Terminated.");
    	
    }
    
}
	