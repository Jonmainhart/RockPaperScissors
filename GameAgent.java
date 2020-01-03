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

/**
 *
 * @author jonmainhart
 */
public class GameAgent {

    /*  Game Agent Class accepts integer inputs based on the choice of the players -
        0 = Rock
        1 = Paper
        2 = Scissors -
        and determines a winner based on those choices.
     */
    private static int player1WeaponValue;
    private static int player2WeaponValue;

    public GameAgent(int player1Weapon, int player2Weapon) {
        GameAgent.player1WeaponValue = player1Weapon;
        GameAgent.player2WeaponValue = player2Weapon;
    }

    public void resetGame() {
        GameAgent.player1WeaponValue = 5;
        GameAgent.player2WeaponValue = 5;
    }

    public String getWinner() {
        switch (player1WeaponValue) {
            case 0:
                if (player2WeaponValue == 0) {
                    // draw
                    rps.player1.isDraw();
                    rps.player2.isDraw();
                    return "It's a draw!";
                } else if (player2WeaponValue == 1) {
                    // player 2 wins
                    rps.player1.isLoser();
                    rps.player2.isWinner();
                    return "Paper beats Rock. Computer wins.";
                } else if (player2WeaponValue == 2) {
                    // player 1 wins
                    rps.player1.isWinner();
                    rps.player2.isLoser();
                    return "Rock beats Scissors. YOU WIN! ";
                } else {
                    return "Something is wrong.";
                }
            case 1:
                if (player2WeaponValue == 0) {
                    // player 1 wins
                    rps.player1.isWinner();
                    rps.player2.isLoser();
                    return "Paper beats Rock. YOU WIN!";
                } else if (player2WeaponValue == 1) {
                    // draw
                    rps.player1.isDraw();
                    rps.player2.isDraw();
                    return "It's a draw!";
                } else if (player2WeaponValue == 2) {
                    // player 2 wins
                    rps.player1.isLoser();
                    rps.player2.isWinner();
                    return "Scissors beats paper. Computer wins.";
                } else {
                    return "Something is wrong.";
                }
            case 2:
                if (player2WeaponValue == 0) {
                    // player 2 wins
                    rps.player1.isLoser();
                    rps.player2.isWinner();
                    return "Rock beats Scissors. Computer wins.";
                } else if (player2WeaponValue == 1) {
                    // player 1 wins
                    rps.player1.isWinner();
                    rps.player2.isLoser();
                    return "Scissors beats Paper. YOU WIN!";
                } else if (player2WeaponValue == 2) {
                    // draw
                    rps.player1.isDraw();
                    rps.player2.isDraw();
                    return "It's a draw!";
                } else {
                    return "Something is wrong.";
                }
            default:
                return "Something went wrong during the game. Make sure you have all of your fingers.";
        }
    }

}
