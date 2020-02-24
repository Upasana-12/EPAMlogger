package org.example;

import java.util.*;
import org.example.homecost.*;
import org.example.interest.*;
import org.apache.logging.log4j.LogManager;

public class App1
{
    public static void main( String[] args )
    {

        final org.apache.logging.log4j.Logger logger = LogManager.getLogger(org.example.App.class);

        Scanner sc = new Scanner(System.in);

        logger.info("Enter \"interest\" to calculate SI or CI or \"cost\" to calculate cost of construction\n");
        String choice = sc.nextLine();
        switch(choice)
        {
            case "interest" :
                double p,r,t;
                int option;

                logger.info("Enter principal\n");
                p = sc.nextDouble();

                logger.info("Enter rate of interest\n");
                r = sc.nextDouble();

                logger.info("Enter time\n");
                t = sc.nextDouble();

                Interest ob = new Interest(p,r,t);

                logger.info("Enter 1 for SI and 2 for CI\n");
                option = sc.nextInt();

                if(option == 1)
                    logger.info(ob.calculate_SI());
                else if(option == 2)
                    logger.info(ob.calculate_CI());
                else
                    logger.info("Wrong choice");
                break;

            case "cost" :
                logger.info("Enter \"sm\" for standard material\nEnter \"asm\" for above standard material\nEnter \"hsm\" for high standard material\n");
                String material = sc.next();

                logger.info("Enter total area of house\n");
                double area = sc.nextDouble();

                logger.info("Want fully automated home ? (True/False)\n");
                Boolean opt = sc.nextBoolean();
                Home h = new Home(material, area, opt);
                logger.info("Total cost is "+h.totalCost());
                break;

            default :
                logger.info("Wrong choice");
                break;
        }
    }
}