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

import java.util.Random;

/**
 *
 * @author jonmainhart
 */
public class PlayerAgent {

    Random randomGen;

    public String playerName = "Human";
    public int playerChoice = 0;
    public int winRecord = 0;

    public PlayerAgent() {
        // initializes a player with default values
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerChoice(int choice) {
        this.playerChoice = choice;
    }

    public int getPlayerChoice() {
        return this.playerChoice;
    }

    public String getPlayerWeapon() { // returns string based on player's choice 
        switch (playerChoice) {
            case 0:
                return "Rock";

            case 1:
                return "Paper";

            case 2:
                return "Scissors";

            default:
                return "Something went wrong";
        }
    }

    private void setComputerChoice() {
        randomGen = new Random();
        this.playerChoice = randomGen.nextInt(3);
    }

    public void initializeComputerOpponent() {
        this.playerName = "Computer";
        setComputerChoice();
        // this.playerChoice controlled by randomGen
    }

}
