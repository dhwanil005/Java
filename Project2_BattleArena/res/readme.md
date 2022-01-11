## 1.About/Overview
We were asked to design and implement a role playing game where 2 players entered an arena and they had some basic abilities like Strength, Constitution, Dexterity, Charisma, then the player were assigned some random gear from an item bag, thus enhancing their basic abilities temporarily, then he had to choose a weapon and the player with greater Charisma could charm their opponent and attack first, players had to go in turns to strike, they could defend themselves based on their avoidance abilities and thus the player whose health becomes zero or below zero.

## 2.List Of Features
->Deciding the value of the player's Basic Abilities by rolling a dice 4 times and adding the top 3 values rolled, thus assiging some random values to the player's Basic Abilities.
-> Assigning random 20 gears to the player from an item bag.
-> Calculating what effect does the equipped gear have on the player's Basic Abilities.
-> Printing the gear from head to toe.
-> Assigning a random weapon to the player.
-> Calculating the effect that the weapon has on some player's abilites like Potential Striking Damage, Avoidance Ability.
-> Which player gets to strike first.
->2 Playes enter an arena.
->Player Attack and checking if their opponent can defend or not, thus calculating if the damage is inflicted or not.
-> Getting Winner.

## 3.How To Run Jar file
Open Terminal type java -jar and drag and drop the jar file in the terminal.

## 4.How To Use The Program
Run, that's it.
## 5. Description Of Examples
I have submitted 2 run files, both have different players winning, firstly I print out details of player 1 , then the details of gear , then the health of both players after each round is also printed and lastly we get know who wins the game.

## 6.Design Changes
->Made Classes For Gear and Weapons instead of enum so that we can easily calculate their values and their effects on basic abilities.
->Had interfaces for Gear Class and Weapon Class.
->Added some Methods to the Arena Class.

## 7.Assumptions
->Player 1 gets to attack first even if the Potential Striking Damage of Player 1 is equal to the Avoidance Ability of Player 2.
-> We change the avoidance Ability of a player to (-5) its original value just so the game doesn't end up in a loop and we get our desired output.

## 8.Limitations
-> Don't have any method to check the unit for belt, that the player cannot wear more than 10 units of belt.
-> Did not assign names to each and every item of gear so did'nt print them in alphabetical order.
-> Had the dice roll values from 2 to 6 so did not have to reroll for 1's.

## 9.Citations
->Nothing to cite.