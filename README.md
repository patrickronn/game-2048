# game-2048

Date completed: April 6, 2021

## Description
A command-line version of the 2048 game using Java.

To begin a game, run the `main()` method in `SimpleClient`.

## List of assumptions and additional notes
- The game board has a short length (e.g. length of 4) which means that performing operations that modifying the board of time complexity O(n^2) will not have much affect on performance. For example, when making a move, I chose to consider more readability/maintainability using abstract methods and a single algorithmic method for sliding values in an array. That meant my functions for reversing an array and extracting the column array use additional for loops.
- A single row/column can have multiple collisions as long as a collision doesn't happen at the same index more than once (e.g. [2 2 2 2] with a left move results in [4 4 0 0])
- If more time permitted, I would have conducted more detailed unit testing. I would have used mock objects to isolate methods as well as consider more equivalent classes / boundary classes. I focused on creating tests that covered cases where my code was likely to have bugs (e.g. Move class, Board class, RandomGenerator class)
- In terms of using the API, I developed a simple client (SimpleClient) in order to display and play the game using the command-line. If this was an actual server API, then the communication between client and server should be managed through sockets or HTTP.
