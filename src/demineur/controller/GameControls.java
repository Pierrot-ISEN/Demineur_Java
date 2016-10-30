package demineur.controller;

import demineur.model.EtatMasked;
import demineur.model.EtatRevealed;
import demineur.model.Grid;
import demineur.model.Cell;
import demineur.view.GraphicalCellView;
import demineur.view.GraphicalGridView;
import demineur.view.EndGameFrame;

public class GameControls {

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
        if (compte == grid.getNbMaskMine()) {
            return true;
        } else {
            return false;
        }
    }

    public static void leftClick(Cell cell, GraphicalGridView gridView) {
        if (gridView.getModel().isFristClick()) {
            gridView.getModel().setMines();
            gridView.getModel().setFristClick(false);
        }
        if (cell.getEtatRevealed() == EtatRevealed.MINE) {
            //Loose process
            cell.setShown(true);
            gridView.getMyTimer().stop();
            gridView.getFrame().dispose();           
            EndGameFrame endFrame = new EndGameFrame("Perdu :(",gridView.getTimerValue());
        } else {
            cell.setShown(true);
            gridView.getModel().incNbClick();
            if (!checkWin(gridView.getModel())) {
                if (cell.getEtatMasked() == EtatMasked.EXMARK) {
                    gridView.getModel().setNbMarkedCells(gridView.getModel().getNbMarkedCells() - 1);
                }
                recursiveReveal(cell, gridView);
            } else {
                //Win process
                gridView.getMyTimer().stop();
                gridView.getFrame().dispose();
                EndGameFrame endFrame = new EndGameFrame("Gagné :)",gridView.getTimerValue());
            }

        }
    }
    
    //Is called whenever an empty cell is revealed, if the neighboors are empty
    //the following fontion shows them too.
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

    public static void rightClick(GraphicalCellView button, GraphicalGridView gridView) {
        Grid grid = gridView.getModel();
        if (button.getMyModel().getEtatMasked() == EtatMasked.HASH) {
            if (!(grid.getNbMaskMine() - grid.getNbMarkedCells() == 0)) {
                button.getMyModel().setEtatMasked(EtatMasked.EXMARK);
                grid.setNbMarkedCells(grid.getNbMarkedCells() + 1);
                if (checkWin(grid)) {
                    //win process
                    gridView.getMyTimer().stop();
                    gridView.getFrame().dispose();
                    EndGameFrame endFrame = new EndGameFrame("Gagné :)",gridView.getTimerValue());
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
