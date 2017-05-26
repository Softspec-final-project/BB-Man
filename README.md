# **BB-Man**
A game for Software Specification & Design
(JAR-file is in /out/artifacts/BBMan_jar )

## **Project collaborators**
1. [Nutthapol Sinthaveelert 5810546641](https://github.com/babestvl)
2. [Thanut Sajjakulnukit 5810545416](https://github.com/oatThanut)

## **Use cases**
1. Player has only one life
2. Player can move in 4 direction
3. Each time player move player will move in one block
4. Every units in this game has a bomb
5. Every units can plant the bomb only one at the time
6. Only brick block can be destroy by the bomb
7. The metal block can't be destroy
8. Player bomb can use for kill every unit in the game
9. Enemy's bomb can't kill anyone except player or destroy the brick block
10. If player die game will end
11. If player can kill all Enemy game is end and player win

## **Design patterns**
* Singleton pattern
* Observer pattern
* Command pattern
* Flyweight pattern

## **Principles**
* Single responsibility principle 
* Open/closed principle
* Interface-segregation principle

## **Nutthapol-Part**
* Player move
* Enemy AI
* Plant the bomb
* Unit can't walk through the block
* If fire hit the brick destroy it
* Replay using list of command
* Enemy and player died when fire hit them
* Fix bugs

## **Thanut-Part**
* Initial project
* Plant the bomb and fire
* All about graphic and set position
* Seperate object
* Start and End game
* Find and use external library
* Refactor code
* Built JAR
