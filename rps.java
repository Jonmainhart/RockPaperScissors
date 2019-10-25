/*
 * Copyright (C) 2019 Jonathan Mainhart
 *
 * github @jonmainhart
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package RPS;

import java.util.Scanner;

/**
 *
 * @author jonmainhart
 */
public class rps {
    
    // initialize players
        
        static PlayerAgent player1 = new PlayerAgent();
        static PlayerAgent player2 = new PlayerAgent();


    public static void main(String[] args) {
        
        // set player 2 to computer opponent
        player2.initializeComputerOpponent();

        // main menu
        Boolean menuIsActive = true;
        Scanner scannerIn = new Scanner(System.in);
        System.out.print("**********************************"
                + "\nWelcome to Rock, Paper, Scissors!\n"
                + "**********************************\n"
                + "Please enter your name: ");
        try {
            player1.setPlayerName(scannerIn.next());
        } catch (Exception io) {
            player1.playerName = "Player 1";
        }

        do {
            player2.setComputerChoice();
            System.out.println("\nPlease choose from the following choices:\n"
                    + "1. Rock\n2. Paper\n3. Scissors\nOr select 'q' to quit.\n");
            String menuSelection = scannerIn.next();
            if ("q".equals(menuSelection.toLowerCase())) {
                menuIsActive = false;
                break;
            } else {
                switch (menuSelection) {
                    case "1":
                        player1.setPlayerChoice(0);
                        break;
                    case "2":
                        player1.setPlayerChoice(1);
                        break;
                    case "3":
                        player1.setPlayerChoice(2);
                        break;
                    default:
                        System.out.println("Please make a valid selection.");
                }
                // send weapon choices to GameAgent to determine winner
                GameAgent newGame = new GameAgent(player1.playerChoice, player2.playerChoice);
                // Display results
                System.out.printf("\nIt's %s vs. %s!\n"
                        + "%s has selected %s\n"
                        + "%s has selected %s\n",
                        player1.getPlayerName(),
                        player2.getPlayerName(),
                        player1.getPlayerName(),
                        player1.getPlayerWeapon(),
                        player2.getPlayerName(),
                        player2.getPlayerWeapon());
                System.out.println(newGame.getWinner());
                newGame.resetGame();

            }

        } while (menuIsActive);

        System.out.println("Thank you for playing Rock, Paper, Scissors!");
        System.out.printf("%s's Record\n%s\n", player1.getPlayerName(), player1.getRecord());
        System.out.printf("%s's Record\n%s\n", player2.getPlayerName(), player2.getRecord());

    } // end main

} // end rps
