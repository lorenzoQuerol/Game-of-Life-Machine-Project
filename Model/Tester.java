//package Model;
//
//import java.util.Scanner;
//
//public class Tester {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        boolean gameOver = false;
//        int counter = 0;
//
//        Board b = new Board();
//        b.initializeData(50, 7, 10, 0, 0);
//        System.out.print("Player count: ");
//        int choice = Integer.parseInt(in.nextLine());
//        String n;
//        String p;
//        for (int i = 0; i < choice; i++) {
//            b.getPlayers().add(new Player(200000));
//            System.out.print("name: ");
//            n = in.nextLine();
//            System.out.print("path: ");
//            p = in.nextLine();
//            b.getPlayers().get(i).setCurrentPath(p);
//            b.getPlayers().get(i).setName(n);
//        }
//
//        while (!gameOver) {
//            System.out.println("Player " + counter + "'s Turn");
//            System.out.println(" ");
//            System.out.println("Would you like to continue drawing action cards? ");
//            System.out.println("\t(1) Spin");
//            System.out.println("\t(2) Quit");
//            System.out.print("Choice: ");
//            choice = Integer.parseInt(in.nextLine());
//
//            if (choice == 1) {
//                b.takeTurn(b.getPlayers().get(counter), in, b.getActionDeck(), b.getCareerDeck(), b.getBlueDeck(), b.getSalaryDeck(), b.getHouseDeck());
//                counter++;
//            }
//            else if (choice == 2) {
//                break;
//            }
//            else {
//                System.out.println("Invalid input! Please try again.\n\n");
//            }
//
//            if (counter > b.getPlayers().size() - 1)
//                counter = 0;
//        }
//        in.close();
//    }
//}
