package javi.katas.gameoflife;

import java.util.Collection;

public class AroundCells {

    private final Cell center;
    private final Collection<Cell> aroundCells;

    public AroundCells(Cell center, Collection<Cell> aroundCells){

        this.center = center;
        this.aroundCells = aroundCells;
    }
}
