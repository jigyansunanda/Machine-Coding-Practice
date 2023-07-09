package Driver;

import Model.PieceType;
import Service.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputPlayerCount = 0;
        while (inputPlayerCount < game.getPlayerService().getPlayerCount()) {
            String[] playerInfo = br.readLine().trim().split(" ");
            String playerPiece = playerInfo[0];
            String playerName = playerInfo[1];
            PieceType pieceType = PieceType.X;
            switch (playerPiece) {
                case "X" -> pieceType = PieceType.X;
                case "O" -> pieceType = PieceType.O;
                default -> {
                }
            }
            boolean isPlayerAdded = game.getPlayerService().addPlayer(pieceType, playerName);
            if (isPlayerAdded) ++inputPlayerCount;
        }
        if (inputPlayerCount == game.getPlayerService().getPlayerCount()) {
            System.out.println("All the players are added");
        } else {
            System.out.println("All Players are not added");
            System.exit(0);
        }
        while (true) {
            String[] moveInfo = br.readLine().trim().split(" ");
            if (moveInfo[0].compareTo("exit") == 0) {
                System.out.println("Game Over");
                System.exit(0);
            }else {
                int row = Integer.parseInt(moveInfo[0]) - 1;
                int col = Integer.parseInt(moveInfo[1]) - 1;
                int isCurrentPlayerWinner = game.makeMove(row, col);
                switch (isCurrentPlayerWinner) {
                    case -1 -> System.out.println("Invalid Move");
                    case 1 -> {
                        String playerName = game.getPlayerService().getLastTurnPlayer().getName();
                        System.out.println(playerName + " won the game");
                        System.exit(0);
                    }
                    default -> {
                    }
                }
            }
        }
    }
}
