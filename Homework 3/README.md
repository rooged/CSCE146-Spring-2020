# Homework 3 - Hot Potato

## How To Use:
- Compile and execute the Java file
- Follow programs prompts

## Result
Program that reads a .txt file of a board and a .txt file of the movement commands. It then prints out each move
until the robot reaches the exit.

### .txt Board File Structure
10x10 board. '_' is a blank space, meaning the robot can move there. 'X' is a blocked space, robot can't move there.
Top left spot (0x0) is the robot's starting position so must be a '_'. Bottom right spot (10x10) is the exit and also
must be a '_'. Must have a valid path through the maze.

### .txt Robot Movement File Structure
Left

Right

Down

Up
