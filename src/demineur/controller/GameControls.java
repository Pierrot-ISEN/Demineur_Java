package demineur.controller;

import demineur.model.EtatMasked;
import demineur.model.EtatRevealed;
import demineur.model.Grid;
import demineur.model.Cell;
import demineur.view.GraphicalCellView;
import demineur.view.GraphicalGridView;

/* Jframe.dispose*/
public class GameControls {

    /* static void command(String entry, Grid grid) {

        String tab[] = entry.split(" ");

        String action = tab[0];

        if (action.equals("q")) {
            System.out.println("---User quit game---");
            System.out.println("");
            System.exit(1);
        }

        int x = Integer.parseInt(tab[1]);
        int y = Integer.parseInt(tab[2]);

        if (action.equals("d")) {
            if (grid.getCells()[x][y].getEtatRevealed() == EtatRevealed.MINE) {
                System.out.println("---BOOOOOOOOOM---");
                System.out.println(grid);
                grid.getCells()[x][y].setShown(true);
                System.exit(1);
            } else {
                grid.getCells()[x][y].setShown(true);
                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                        if (i > -1 && i < grid.getWidth() && j > -1 && j < grid.getHeight()) {
                            if (grid.getCell(i, j).getEtatRevealed() == EtatRevealed.EMPTY) {
                                command("d " + i + " " + j, grid);
                            }
                        }
                    }
                }
            }
        }

        if (entry.length() > 6) {
            String mark = tab[3];
            if (!grid.getCells()[x][y].isShown()) {
                switch (mark) {
                    case "!":
                        grid.getCells()[x][y].setEtatMasked(EtatMasked.EXMARK);
                        break;
                    case "?":
                        grid.getCells()[x][y].setEtatMasked(EtatMasked.QMARK);
                        break;
                    case "#":
                        grid.getCells()[x][y].setEtatMasked(EtatMasked.HASH);
                        break;
                }
            }
        }

    }
     */
    private static boolean checkWin(Grid grid) {

        int compte = 0;
        if (grid.getNbMaskMine() == grid.getHeight() * grid.getWidth() - grid.getNbClick()) {
            for (int x = 0; x < grid.getWidth(); x++) {
                for (int y = 0; y < grid.getHeight(); y++) {
                    if (grid.getCell(x, y).getEtatMasked() == EtatMasked.EXMARK) {
                        compte++;
                    }
                }
            }
        }
        if (compte == grid.getNbMaskMine())  {
            return true;
        } else {
            return false;
        }
    }

    public static void leftClick(Cell cell, GraphicalGridView grid) {
        if (grid.getModel().isFristClick()) {
            grid.getModel().setMines();
            grid.getModel().setFristClick(false);
        }
        if (cell.getEtatRevealed() == EtatRevealed.MINE) {
            System.out.println("---BOOOOOOOOOM---");
            cell.setShown(true);
            System.exit(1);
        } else {
            cell.setShown(true);
            grid.getModel().incNbClick();
            if (!checkWin(grid.getModel())) {
                if (cell.getEtatMasked() == EtatMasked.EXMARK) {
                    grid.getModel().setNbMarkedCells(grid.getModel().getNbMarkedCells() - 1);
                }
                recursiveReveal(cell, grid);
            } else {
                System.out.print("WIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIN");
                System.exit(1);
            }

        }
    }

    public static void recursiveReveal(Cell cell, GraphicalGridView grid) {
        if (cell.getEtatMasked() == EtatMasked.EXMARK) {
            grid.getModel().setNbMarkedCells(grid.getModel().getNbMarkedCells() - 1);
        }
        if (cell.getNbNeighbour() == 0) {
            int x = cell.getX();
            int y = cell.getY();
            int a = grid.getModel().getWidth();
            int b = grid.getModel().getHeight();

            int i = x - 1;
            int j = y;

            if (i > -1 && i < a && j > -1 && j < b) {
                if (grid.getJCell(i, j).getMyModel().getEtatRevealed() == EtatRevealed.EMPTY) {
                    if (!grid.getJCell(i, j).getMyModel().isShown()) {
                        grid.getJCell(i, j).getMyModel().setShown(true);
                        grid.getModel().incNbClick();
                        recursiveReveal(grid.getJCell(i, j).getMyModel(), grid);
                    }
                }
            }

            i = x + 1;
            j = y;
            if (i > -1 && i < a && j > -1 && j < b) {
                if (grid.getJCell(i, j).getMyModel().getEtatRevealed() == EtatRevealed.EMPTY) {
                    if (!grid.getJCell(i, j).getMyModel().isShown()) {
                        grid.getJCell(i, j).getMyModel().setShown(true);
                        grid.getModel().incNbClick();
                        recursiveReveal(grid.getJCell(i, j).getMyModel(), grid);
                    }
                }
            }

            i = x;
            j = y - 1;
            if (i > -1 && i < a && j > -1 && j < b) {
                if (grid.getJCell(i, j).getMyModel().getEtatRevealed() == EtatRevealed.EMPTY) {
                    if (!grid.getJCell(i, j).getMyModel().isShown()) {
                        grid.getJCell(i, j).getMyModel().setShown(true);
                        grid.getModel().incNbClick();
                        recursiveReveal(grid.getJCell(i, j).getMyModel(), grid);
                    }
                }
            }

            i = x;
            j = y + 1;
            if (i > -1 && i < a && j > -1 && j < b) {
                if (grid.getJCell(i, j).getMyModel().getEtatRevealed() == EtatRevealed.EMPTY) {
                    if (!grid.getJCell(i, j).getMyModel().isShown()) {
                        grid.getJCell(i, j).getMyModel().setShown(true);
                        grid.getModel().incNbClick();
                        recursiveReveal(grid.getJCell(i, j).getMyModel(), grid);
                    }
                }
            }
        }
    }

    public static void rightClick(GraphicalCellView button, Grid grid) {
        if (button.getMyModel().getEtatMasked() == EtatMasked.HASH) {
            if (!(grid.getNbMaskMine() - grid.getNbMarkedCells() == 0)) {
                button.getMyModel().setEtatMasked(EtatMasked.EXMARK);
                grid.setNbMarkedCells(grid.getNbMarkedCells() + 1);
                if(checkWin(grid)){
                    System.out.print("WIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIN");
                    System.exit(1);
                }
            }
        } else if (button.getMyModel().getEtatMasked() == EtatMasked.EXMARK) {
            button.getMyModel().setEtatMasked(EtatMasked.QMARK);
            grid.setNbMarkedCells(grid.getNbMarkedCells() - 1);
        } else if (button.getMyModel().getEtatMasked() == EtatMasked.QMARK) {
            button.getMyModel().setEtatMasked(EtatMasked.HASH);
        }
    }
}
