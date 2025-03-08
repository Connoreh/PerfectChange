import java.util.Scanner;

public class PerfectChange {
    static Scanner sc = new Scanner(System.in);
    static int qoh, doh, noh, poh; // Quarters.dimes,nickels,pennies on hand


    public static void main(String[] args) {
        String menu;
        int userChoice;
        boolean usingSet;
        usingSet = getCoinSet();
        System.out.println("Using set is " + usingSet);
        menu = "What value would you like change for? (# cents, -1=New Coin set, -2=All or 0=quit)";
        userChoice = UserInput.getInt(menu, -2);



        while (userChoice != 0) {
            if ( userChoice == -1) {
                usingSet = getCoinSet();
            } else if(userChoice == -2) {
                allValues(usingSet);


            }

            else {
                if (usingSet){
                    perfectChange(userChoice);
                }
                else {
                    makeChange(userChoice);
                }
            }
//            System.out.println("You are in the loop");
            userChoice = UserInput.getInt(menu, -2);
        } // end of while
    } // end of main

    private static void makeChange(int cents) {
        int q = 0,d = 0 ,n = 0 ,p = 0;
        int t = 0; // working count
        while (t + 25 <= cents) {
            t += 25;
            q +=1;
        }
        while (t + 10 <= cents) {
            t += 10;
            d +=1;
        }
        while (t + 5 <= cents) {
            t += 5;
            n +=1;
        }
        p = cents - t;
        System.out.println("For " + cents + " cents I give: " +
                q + " quarter(s), " +
                d + " dime(s), " +
                n + " nickel(s), " +
                p + " penn(ies). " );


    }
    private static void perfectChange(int cents) {
        int qReturned = 0, dReturned = 0, nReturned = 0, pReturned = 0;
        int t = 0;

        while (t + 25 <= cents && qoh > 0) {
//            if (qoh > 0) {
                qReturned++;
                qoh--;
//            }
            t += 25;

        }
        while (t + 10 <= cents && doh > 0) {

            dReturned++;
            doh--;

            t += 10;

        }
        while (t + 5 <= cents && noh > 0) {

            nReturned++;
            noh--;

            t += 5;


        }
        while (t + 1 <= cents && poh > 0) {
//            if (poh > 0) {
                pReturned++;
                poh--;

//            }
            t++;

            }
//            if {
//                System.out.println("I could not make change for " +
//                    cents + " I am short: " + t +
//                    " cents.");
//                cents = 0;
//            }


//System.out.println(cents);
//        System.out.println(t);
//        if (cents == t) {

//            System.out.println(cents + t);
        if(cents == t) {
            System.out.println("For " + cents + " cents I give: " +
                    qReturned + " quarter(s), " +
                    dReturned + " dime(s), " +
                    nReturned + " nickel(s), " +
                    pReturned + " penn(ies). " +
                    "leaving \n " + qoh + " quarter(s), " +
                    doh + " dime(s), " +
                    noh + " nickel(s), " +
                    poh + " penn(ies). ");

        } else {
//            System.out.println(cents + t);
            System.out.println("I could not make change for " +
                    cents + " cents. I am short: " + (cents - t) +
                    " cents.");


        }
        t = 0;


//        } else {
//            System.out.println(cents + t);
//            System.out.println("I could not make change for " +
//                    cents + " I am short: " + t +
//                    " cents.");
//        }
    }


    private static boolean getCoinSet () {
        System.out.print("Do you have a set of coins for making change? (Y/N): ");
        String answer = sc.nextLine();
        boolean b;

        if (answer.toLowerCase().startsWith("y")){

            qoh = UserInput.getInt("How many quarters on hand? ", 0 );
            doh = UserInput.getInt("How many dimes on hand? ", 0);
            noh = UserInput.getInt("How many nickels on hand? ", 0);
            poh = UserInput.getInt("How many pennies on hand? ", 0);


            b = true;
        } else {
            qoh = 0;
            doh = 0;
            noh = 0;
            poh = 0;

            b = false;
        }
       return b;

    }
    private static void allValues(boolean useSet){

        for(int i = 0; i <= 100; i++ ){
            if (useSet){
                perfectChange(i);
            }
            else {
                makeChange(i);
            }
        }

    }

}
