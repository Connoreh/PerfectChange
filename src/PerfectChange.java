import java.util.Scanner;

public class PerfectChange {
    static Scanner sc = new Scanner(System.in);
    static int qoh, doh, noh, poh; // Quarters.dimes,nickels,pennies on hand
//    static int c = 0;


    public static void main(String[] args) {
        int c = 0;
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
                    makeChangeDiv(userChoice);
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
        System.out.println("By the ADD method, for " + cents + " cents I give: " +
                q + " quarter(s), " +
                d + " dime(s), "  +
                n + " nickel(s), " +
                p + " penn(ies). " );


    }
    private static void makeChangeDiv(int cents){
        int q, d, n, p , r = cents;
        q = r / 25; // quarters to give
        r = r - (q * 25);

        d = r / 10; // dimes to give
        r = r - (d * 10);

        n = r / 5;
        r = r - (n * 5);

        p = r;

        System.out.println("By the DIV method, for " + cents + " cents I give: " +
                q + " quarter(s), " +
                d + " dime(s), "  +
                n + " nickel(s), " +
                p + " penn(ies). " );






    }
    private static void perfectChange(int cents) {
//        int qReturned = 0, dReturned = 0, nReturned = 0, pReturned = 0, r = cents;

        int q, d, n, p, r = cents;
        if (qoh > 0 && (r/25 >= 1)) {


                q = (r / 25);
                if( q > qoh){
                    q = qoh;
                }
//                q = r / 25; // quarters to give
                r = r - (q * 25);
                qoh = qoh - q;
            } else {
                q = 0;
            }
//            q = r / 25; // quarters to give
//            r = r - (q * 25);


        if (doh > 0) {
            if ((r / 10) >= 1) {


                d = r / 10; // dimes to give
                if ( d > doh){
                    d = doh;
                }
                r = r - (d * 10);
                doh = doh - d;
            } else {
                d = 0;
            }
        } else {
            d = 0;
        }

        if (noh > 0) {
            if ((r / 5) >= 1) {


                n = (r / 5);
                if( n > noh){
                    n = noh;
                }
                r = r - (n * 5);
                noh = noh - n;
            } else {
                n = 0;
            }
        } else {
            n = 0;
        }
            if (r > 0) {
                if (r <= poh) {
                    p = r;
                    poh = poh - p;
                    r = r - p;
                } else {
                    qoh = q + qoh;
                    doh = d + doh;
                    noh = n + noh;
                    p = 0;
                    r = r - poh;


                }
            }
            else if (r != 0) {
                qoh = q + qoh;
                doh = d + doh;
                noh = n + noh;
                p = 0;
            }

//                }
            else {
                p = 0;
            }





//        p = r;

//        System.out.println("By the DIV method, for " + cents + " cents I give: " +
//                q + " quarter(s), " +
//                d + " dime(s), "  +
//                n + " nickel(s), " +
//                p + " penn(ies). " );

//        System.out.println(t + " t " + cents + " cents");
//        int c = 0;

//        while (c + 25 <= cents && qoh > 0) {
////            if (qoh > 0) {
//                qReturned++;
//                qoh--;
//                c += 25;
//
////            c += 25;
////            System.out.println(t + " t " + cents + " cents");
//
//
//        }
//         while (c + 10 <= cents && doh > 0) {
//
//            dReturned++;
//            doh--;
//
//            c += 10;
//
//        }
//        while (c + 5 <= cents && noh > 0) {
//
//            nReturned++;
//            noh--;
//
//            c += 5;
////            System.out.println(c);
////            System.out.println(cents);
//////            System.out.println(poh);
//
//
//        }
//        while (poh > 0 && c + 1 <= cents) {
//                poh--;
//                pReturned++;
////                System.out.println(c);
//                c++;
//
//
//
//
////            c++;
//        }
//        c++;
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
        if(r == 0) {
//            System.out.println(t);
            System.out.println("For " + cents + " cents I give: " +
                    q + " quarter(s), " +
                    d + " dime(s), " +
                    n + " nickel(s), " +
                    p + " penn(ies). " +
                    "leaving \n " + qoh + " quarter(s), " +
                    doh + " dime(s), " +
                    noh + " nickel(s), " +
                    poh + " penn(ies). ");

        } else {
//            System.out.println(q + " " + d + " " + n + " " + p);
//            System.out.println(qoh);


//            System.out.println(c);
            System.out.println("I could not make change for " +
                    cents + " cents. I am short: " + r +
                    " cents.");


        }
//        t = 0;


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

        for(int i = 1; i <= 100; i++ ){
            if (useSet){
                perfectChange(i);
            }
            else {
                makeChange(i);
                makeChangeDiv(i);
            }
        }

    }

}
