package desafio;

import java.util.ArrayList;
import java.util.List;

public class HorseRide {
    private int counter = 0;

    private int[][] setTabuleiro(int n) {
        int[][] _tabuleiro = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < n; ii++) {
                _tabuleiro[i][ii] = 0;
            }
        }
        return _tabuleiro;
    }

    private boolean testTabuleiro(int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int ii = 0; ii < tab.length; ii++) {
                if (tab[i][ii] == 0) {
                    return false;
                } 
            }
        }
        return true;
    }

    private void printTabuleiro(int[][] tab) {
        String _string = "";
        _string += "counter: " + counter + "\n";
        for (int i = 0; i < tab.length; i++) {
            for (int ii = 0; ii < tab.length; ii++) {
                if (tab[i][ii] < 10) {
                    _string += " ";
                }
                if (tab.length >= 10 && tab[i][ii] < 100) {
                    _string += " ";
                }
                if (tab.length >= 32 && tab[i][ii] < 1000) {
                    _string += " ";
                }
                _string += tab[i][ii];
                if (ii != tab.length - 1) {
                    _string += " ";
                }
            }
            _string += "\n";
        }
        System.out.println(_string);
    }

    private List<int[]> movimentosValidos(int n, int m, int[][] tab) {
        List<int[]> validMoves = new ArrayList<>();
        int[][] possibleMoves = {
            {n + 2, m + 1},
            {n + 2, m - 1},
            {n - 2, m + 1},
            {n - 2, m - 1},
            {n + 1, m + 2},
            {n + 1, m - 2},
            {n - 1, m + 2},
            {n - 1, m - 2}
            };
        for (int[] move : possibleMoves) {
            int x = move[0];
            int y = move[1];
            if (x >= 0 && x < tab.length) {
                if (y >= 0 && y < tab.length) {
                    if (tab[x][y] == 0) {
                        validMoves.add(new int[] {x, y});
                    }
                }
            }
        }
        return validMoves;
    }

private boolean backtrack(int x, int y, int[][] _tab) {
    counter++;
    _tab[x][y] = counter;
    if (testTabuleiro(_tab)) {
        System.out.println("solução:");
        printTabuleiro(_tab);
        return true;
    }
    List<int[]> validMoves = movimentosValidos(x, y, _tab);
    // if (validMoves.isEmpty()) {
    //     System.out.println("sem solução:");
    //     printTabuleiro(_tab);
    // }
    // optimização
    validMoves.sort((a, b) -> 
        movimentosValidos(a[0], a[1], _tab).size() - movimentosValidos(b[0], b[1], _tab).size()
    );
    for (int[] move : validMoves) {
        if (_tab[move[0]][move[1]] == 0) {
            if (backtrack(move[0], move[1], _tab)) {
                return true;
            }
        }
    }
    _tab[x][y] = 0;
    counter--;
    return false;
    }

    public int[][] caminho(int startX, int startY, int n) {
        counter = 0;
        int[][] _tabuleiro = setTabuleiro(n);
        boolean backtrack = backtrack(startX, startY, _tabuleiro);
        if (!backtrack) {
            System.out.println("sem solução");
            _tabuleiro[startX][startY] = 1;
            printTabuleiro(_tabuleiro);
        }
        return _tabuleiro;
    }

}
