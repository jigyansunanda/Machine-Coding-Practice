package Service;

import Model.Player;

public class Game {
    private GridService gridService;
    private PlayerService playerService;
    private static final int DEFAULT_BOARD_SIZE = 3;
    private static final int PLAYER_COUNT = 2;

    public Game() {
        this.gridService = new GridService(DEFAULT_BOARD_SIZE);
        this.playerService = new PlayerService(PLAYER_COUNT);
        this.gridService.printGrid();
    }

    public Game(int boardSize) {
        this.gridService = new GridService(boardSize);
        this.playerService = new PlayerService(PLAYER_COUNT);
        this.gridService.printGrid();
    }

    public Game(int boardSize, int playerCount) {
        this.gridService = new GridService(boardSize);
        this.playerService = new PlayerService(playerCount);
        this.gridService.printGrid();
    }

    public GridService getGridService() {
        return gridService;
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    public int makeMove(int row, int col) {
        if (!gridService.isValidMove(row, col)) {
            return -1;
        }
        Player currentTurnPlayer = playerService.getCurrentTurnPlayer();
        boolean didCurrentPlayerWin = gridService.makeMove(currentTurnPlayer, row, col);
        this.gridService.printGrid();
        playerService.setNextPlayer();
        if (didCurrentPlayerWin) return 1;
        else return 0;
    }
}
