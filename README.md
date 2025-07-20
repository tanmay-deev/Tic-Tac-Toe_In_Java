### Tic-Tac-Toe Game in Java

#### What I Learned
1. **Swing for GUI Development**
   - Learned how to create a graphical user interface using `JFrame`, `JPanel`, `JButton`, and `JLabel`.
   - Implemented `GridLayout` and `BorderLayout` to structure the UI properly.

2. **Event Handling in Java**
   - Used `ActionListener` to detect and handle button clicks.
   - Understood how to use `getSource()` to determine which button was clicked.

3. **Game Logic Implementation**
   - Implemented logic for checking horizontal, vertical, and diagonal wins.
   - Managed player turns and game-over conditions effectively.
   - Handled a tie scenario when all tiles are filled without a winner.

4. **Using 2D Arrays**
   - Stored the buttons in a `JButton[][]` array for easy access and manipulation.
   - Simplified win-checking by iterating over rows and columns.

5. **String Comparisons in Java**
   - Used `.equals()` for comparing button texts instead of `==` to avoid incorrect comparisons.
   - Ensured that empty string checks were done properly.

6. **Styling the UI**
   - Set custom colors, fonts, and text alignment to enhance the user experience.
   - Changed button colors dynamically to highlight winning moves.

7. **Managing Game State**
   - Used a boolean flag (`gameOver`) to prevent further moves after a win or tie.
   - Kept track of the number of turns to determine a tie scenario.

8. **Adding a Restart Button**
   - Implemented a `JButton` to restart the game after a win or tie.
   - Reset the board, game state, and UI elements when the restart button is clicked.
   - Allowed seamless replaying of the game without restarting the application.

This project helped me reinforce my understanding of Java Swing, event handling, and logical thinking for game development. I also gained experience in debugging common issues related to UI programming.

