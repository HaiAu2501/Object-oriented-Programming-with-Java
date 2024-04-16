import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton[][] buttons = new JButton[3][3];
    private JTextField inputField = new JTextField();
    private char currentPlayerMark = 'X';
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

        inputField.setHorizontalAlignment(JTextField.CENTER);
        inputField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        inputField.addActionListener(this);
        add(inputField, BorderLayout.SOUTH);
    }

    private void initializeButtons(JPanel boardPanel) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setEnabled(false);
                boardPanel.add(buttons[i][j]);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inputField) {
            String text = inputField.getText();
            if (!text.matches("\\d") || text.isEmpty())
                return;
            int pos = Integer.parseInt(text);
            int row = 3 - (pos - 1) / 3 - 1;
            int col = (pos - 1) % 3;
            if (buttons[row][col].getText().equals("")) {
                buttons[row][col].setText(String.valueOf(currentPlayerMark));
                trackMove(currentPlayerMark, row, col);
                manageFourMarks(currentPlayerMark);

                if (checkForWin()) {
                    JOptionPane.showMessageDialog(null, "Player " + currentPlayerMark + " wins!");
                    resetButtons();
                } else if (isBoardFull()) {
                    JOptionPane.showMessageDialog(null, "Draw!");
                    resetButtons();
                }
                currentPlayerMark = (currentPlayerMark == 'X') ? 'O' : 'X';
            }
            inputField.setText("");
        }
    }

    private void trackMove(char player, int row, int col) {
        if (player == 'X') {
            xMoves.add(new Point(row, col));
        } else {
            oMoves.add(new Point(row, col));
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
        xMoves.clear();
        oMoves.clear();
    }

    public static void main(String[] args) {
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.setVisible(true);
    }
}
