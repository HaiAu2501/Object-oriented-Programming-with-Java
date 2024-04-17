import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton[][] buttons = new JButton[3][3];
    private JLabel statusLabel = new JLabel("X's turn", SwingConstants.CENTER);
    private JLabel scoreLabel = new JLabel("Player 1: 0 | Player 2: 0", SwingConstants.CENTER);
    private char currentPlayerMark = 'X';
    private int player1Score = 0;
    private int player2Score = 0;
    private boolean isPlayer1X = true; // Track who is playing 'X'
    private Queue<Point> xMoves = new LinkedList<>();
    private Queue<Point> oMoves = new LinkedList<>();

    public TicTacToe() {
        super("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        initializeButtons(boardPanel);
        add(boardPanel, BorderLayout.CENTER);

        JPanel statusPanel = new JPanel(new GridLayout(2, 1));
        statusLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        scoreLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        statusPanel.add(statusLabel);
        statusPanel.add(scoreLabel);
        add(statusPanel, BorderLayout.NORTH);
    }

    private void initializeButtons(JPanel boardPanel) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setBackground(Color.WHITE); // Set background color
                buttons[i][j].setOpaque(true);
                buttons[i][j].addActionListener(this);
                boardPanel.add(buttons[i][j]);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        if (buttonClicked.getText().equals("")) {
            buttonClicked.setText(String.valueOf(currentPlayerMark));
            buttonClicked.setForeground(currentPlayerMark == 'X' ? Color.RED : Color.BLUE);
            Point move = findPosition(buttonClicked);
            trackMove(currentPlayerMark, move);
            manageFourMarks(currentPlayerMark);

            if (checkForWin()) {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayerMark + " wins!");
                updateScore(currentPlayerMark);
                resetButtons();
                switchPlayers();
            } else if (isBoardFull()) {
                JOptionPane.showMessageDialog(null, "Draw!");
                resetButtons();
                switchPlayers();
            } else {
                currentPlayerMark = (currentPlayerMark == 'X') ? 'O' : 'X';
                statusLabel.setText(currentPlayerMark + "'s turn");
            }
        }
    }

    private Point findPosition(JButton button) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j] == button) {
                    return new Point(i, j);
                }
            }
        }
        return null; // Should never happen
    }

    private void trackMove(char player, Point move) {
        if (player == 'X') {
            xMoves.add(move);
        } else {
            oMoves.add(move);
        }
    }

    private void manageFourMarks(char player) {
        Queue<Point> moves = (player == 'X') ? xMoves : oMoves;
        if (moves.size() > 3) {
            Point oldMove = moves.poll();
            buttons[oldMove.x][oldMove.y].setText("");
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayers() {
        isPlayer1X = !isPlayer1X;
    }

    private void updateScore(char winner) {
        if ((winner == 'X' && isPlayer1X) || (winner == 'O' && !isPlayer1X)) {
            player1Score++;
        } else {
            player2Score++;
        }
        scoreLabel.setText("Player 1: " + player1Score + " | Player 2: " + player2Score);
    }

    private boolean checkForWin() {
        return checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin();
    }

    private boolean check(JButton b1, JButton b2, JButton b3) {
        return !b1.getText().equals("") && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText());
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (check(buttons[i][0], buttons[i][1], buttons[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (check(buttons[0][i], buttons[1][i], buttons[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return check(buttons[0][0], buttons[1][1], buttons[2][2]) || check(buttons[0][2], buttons[1][1], buttons[2][0]);
    }

    private void resetButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        currentPlayerMark = 'X'; // 'X' luôn là người chơi đầu tiên
        statusLabel.setText(currentPlayerMark + "'s turn");
        xMoves.clear();
        oMoves.clear();
    }

    public static void main(String[] args) {
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.setVisible(true);
    }
}
