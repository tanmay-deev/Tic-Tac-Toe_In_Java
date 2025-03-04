import jdk.jshell.execution.Util;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 650; //50px for the text paner on the top

    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLable = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    boolean gameOver = false;
    int turns = 0;

    TicTacToe(){
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLable.setBackground(Color.darkGray);
        textLable.setForeground(Color.WHITE);
        textLable.setFont(new Font("Arial", Font.BOLD, 50));
        textLable.setHorizontalAlignment(JLabel.CENTER);
        textLable.setText("Tic-Tac-Toe");
        textLable.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLable);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        for (int r =0; r< 3; r++){
            for (int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.WHITE);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);
//                tile.setText(currentPlayer);

                tile.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if (gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        if (tile.getText() == ""){
                            tile.setText(currentPlayer);
                            turns++;
                            checkWinner();
                            if (!gameOver) {
                                currentPlayer = currentPlayer == playerX ? playerO : playerX;
                                textLable.setText(currentPlayer + "s turn.");
                            }

                        }
                    }
                });

            }
        }

    }

    void checkWinner(){
        //for Horizontl
        for (int r = 0; r < 3; r++){
            if (board[r][1].getText() == "") continue;

            if (board[r][0].getText() == board[r][1].getText() &&
            board[r][1].getText() == board[r][2].getText()){
                for (int i = 0; i < 3; i++){
                    setWinner(board[r][i]);
                }
                gameOver = true;
                return;
            }
        }
        //for Vertical
        for (int c = 0; c < 3; c++){
            if (board[0][c].getText() == "") continue;

            if (board[0][c].getText() == board[1][c].getText() &&
            board[1][c].getText() == board[2][c].getText()){
                for (int i = 0; i < 3; i++){
                    setWinner(board[i][c]);
                }
                gameOver = true;
                return;
            }
        }

        //for diagonally
    if (board[0][0].getText() == board[1][1].getText() &&
    board[1][1].getText() == board[2][2].getText() &&
    board[0][0].getText() != "") {
        for (int i = 0; i < 3; i++){
            setWinner(board[i][i]);
        }
        gameOver = true;
        return;
    }

    // for anti-diagonally
        if (board[0][2].getText() == board[1][1].getText() &&
        board[1][1].getText() == board[2][0].getText() &&
        board[0][2].getText() != ""){
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
            gameOver = true;
            return;
        }

        if (turns == 9){
            for (int r = 0; r < 3; r++){
                for (int c = 0; c < 3; c++){
                    setTie(board[r][c]);
                }
            }
            gameOver = true;
        }

    }

    void setWinner(JButton tile){
        tile.setForeground(Color.green);
        tile.setBackground(Color.gray);
        textLable.setText(currentPlayer + " " + "is the winner");
    }

    void setTie(JButton tile){
        tile.setForeground(Color.orange);
        tile.setBackground(Color.gray);
        textLable.setText("Tie!");
    }

}