import java.util.*;

public class Assignment1
{
   public static void main(String[] args)
   {

      // Variables and Constants
      // Stage 1 (S1)
      String custName, custAddress, custPhone, custCredit;
      int daysBooked, promoRate;
      double basicCharge, promoDisc, discCharge;

      // Stage 2 (S2)
      final int HOLIDAY = 50, PEAK = 20, OFF_PEAK = 0;
      int bookPeriod;
      String lateCheck, valetPark;
      double surCharge, lateCheckout = 0, valetCharge = 0, adjustedCharge;
      final double STANDARD_RACK_RATE = 200;
      String selection = "";

      // Stage 3 (S3)
      String roomItemDe, miniItemDe, roomOrders = "", miniOrders = "";
      int roomItemCo, miniItemCo;
      double miniCost = 0, roomCost = 0, finalCharge;

      // scanner
      Scanner sc = new Scanner(System.in);

      // Customer info input (S1)
      System.out.println("***Hotel Invoice System***");
      System.out.print("Enter customer name: ");
      custName = sc.nextLine();
      System.out.print("Enter customer address: ");
      custAddress = sc.nextLine();
      System.out.print("Enter customer phone number: ");
      custPhone = sc.nextLine();
      System.out.print("Enter customer credit card number: ");
      custCredit = sc.nextLine();

      // Nights and promo rate input (S1)
      System.out.print("Enter number of nights booked: ");
      daysBooked = sc.nextInt();
      System.out.print("Enter promotional rate (if any): ");
      promoRate = sc.nextInt();

      // Booking Period details input(S2)
      System.out.println();
      System.out.print("Enter booking period"
                       + "(0 = off-peak, 1 = peak, 2 = holiday): ");
      bookPeriod = sc.nextInt();
      System.out.print("Add Late Checkout (Y/N): ");
      sc.nextLine();
      lateCheck = sc.nextLine();

      // Valet Parking input (S2)
      System.out.print("Enter vehicle registration no." +
               "(Hit enter for NO valet parking)");
      valetPark = sc.nextLine();

      // Room Service/ Mini Bar input loop (S3)
      System.out.println("\n*** Room Service Order / Mini Bar Item Menu ***");
      while (!selection.equalsIgnoreCase("x"))
      {
         System.out.println("\nA - Add Room Service Order");
         System.out.println("B - Add Mini Bar Item");
         System.out.println("X - Exit\n");
         System.out.print("Enter your Selection: ");
         selection = sc.nextLine();

         switch (selection)
         {
            case "A":
            case "a":
               System.out.printf("Enter Room service item desc: ");
               roomItemDe = sc.nextLine();
               System.out.printf("Enter Room service item cost: $");
               roomItemCo = sc.nextInt();
               sc.nextLine();
               roomCost += roomItemCo;
               roomOrders += String.format("%6s %s ($%d)\n", "-", 
                                           roomItemDe,roomItemCo);
               break;

            case "B":
            case "b":
               System.out.printf("Enter mini-bar item desc: ");
               miniItemDe = sc.nextLine();
               System.out.printf("Enter mini-bar item cost: $");
               miniItemCo = sc.nextInt();
               sc.nextLine();
               miniCost += miniItemCo;
               miniOrders += String.format("%6s %s ($%d)\n", "-", 
                                           miniItemDe,miniItemCo);
               break;

            case "X":
            case "x":
               System.out.printf("\n");
               break;

            default:
               System.out.println("Not a valid choice");
               break;

         }
      }

      // Print Customer/Booking Details (S1)
      System.out.println();

      System.out.println("Customer / Booking details\n" 
                         + "--------------------------\n");

      System.out.printf("%-25s %30s\n", "Customer Name:", custName);
      System.out.printf("%-25s %30s\n", "Customer Address:", custAddress);
      System.out.printf("%-25s %30s\n", "Customer Phone:", custPhone);
      System.out.printf("%-25s %30s\n", "Credit Card No:", custCredit);

      // Calculations - basic (S1)
      basicCharge = STANDARD_RACK_RATE  *  daysBooked;
      promoDisc = (basicCharge / 100)  *  promoRate;
      discCharge = basicCharge  -  promoDisc;

      // Print Charges - basic (S1)
      System.out.println("\nBasic Charge Breakdown\n"
                         + "--------------------------\n");
      System.out.printf("%-25s %20s %9.2f %1s\n", "Standard rack rate:", "$",
                        STANDARD_RACK_RATE, "per night");
      System.out.printf("%-25s %30s %1s\n", "Length of stay in room:",
                        daysBooked, "night/s");

      System.out.printf("%-25s %20s %9.2f\n", "Basic invoice charge:", "$",
                        basicCharge);
      System.out.printf("%-25s %18s %9.2f\n", "Minus promotional discount:",
                        "$", promoDisc);
      System.out.printf("\n%-25s %20s %9.2f\n", "Discounted Charge:", "$",
                        discCharge);

      System.out.println();
      System.out.println("Adjusted Charge Calculation\n"
                         +"---------------------------\n");

      // Adjusted Charges (S2)
      // Booking Period Calculation (S2)
      if (bookPeriod == 0)
      {
         System.out.printf("%-25s %30s\n", "Booking Period:", "Off-Peak");
         surCharge = (basicCharge / 100) * OFF_PEAK;
         System.out.printf("%-25s %20s %9.2f\n", "Booking Surcharge:", "$",
                           surCharge);
      }
      else if (bookPeriod == 1)
      {
         System.out.printf("%-25s %30s\n", "Booking Period:", "Peak");
         surCharge = (basicCharge / 100) * PEAK;
         System.out.printf("%-25s %20s %9.2f\n", "Booking Surcharge:", "$",
                           surCharge);
      }
      else
      {
         System.out.printf("%-25s %30s\n", "Booking Period:", "Holiday");
         surCharge = (basicCharge / 100) * HOLIDAY;
         System.out.printf("%-25s %20s %9.2f\n", "Booking Surcharge:", "$",
                           surCharge);
      }

      // Late Checkout Calculation (S2)
      if (lateCheck.equals("Y"))
      {
         System.out.printf("\n%-25s %30s\n", "Late Checkout?", lateCheck);
         lateCheckout += 30;
         System.out.printf("%-25s %20s %9.2f\n", "Late Checkout Surcharge:",
                           "$", lateCheckout);
      }
      else
      {
         System.out.printf("\n%-25s %30s\n", "Late Checkout?", lateCheck);
      }

      // Valet Calculation (S2)
      if (valetPark.isEmpty())
      {

         System.out.printf("\n%-25s %30s\n", "Valet Parking?", "N");
      }
      else
      {
         System.out.printf("\n%-25s %30s (%5s)\n", "Valet Parking?", "Y",
                           valetPark);
         valetCharge += 50;
         System.out.printf("%-25s %20s %9.2f\n", "Valet Parking Surcharge:",
                           "$", valetCharge);
      }

      // Calculate and Print Adjusted Charges (S2)
      adjustedCharge = discCharge  +  surCharge  +  lateCheckout  +  valetCharge;
      System.out.println();
      System.out.printf("%-25s %20s %9.2f\n", "Adjusted Charge:", "$",
                        adjustedCharge);

      // Print Room Service & Mini Bar Items and Charges (S3)
      System.out.println("\nRoom Service / Mini Bar Charges\n"
                         +"-------------------------\n");
      System.out.printf("%-25s %20s %9.2f\n", "Room Service Order Total:",
                         "$",roomCost);
      System.out.println("Room Service Orders:\n");
      System.out.printf(roomOrders + "");
      System.out.println();
      System.out.printf("%-25s %20s %9.2f\n", "Mini-Bar Items Total:", "$",
                        miniCost);
      System.out.println("Mini-Bar Items Consumed:\n");
      System.out.printf(miniOrders + "");

      // Calculate and Print Final Charge (S3)
      finalCharge = adjustedCharge  +  roomCost  +  miniCost;
      System.out.printf("\n%-25s %20s %9.2f\n", "Final Charge:", "$",
                        finalCharge);

   }
}