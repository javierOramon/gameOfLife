package javi.katas.gameoflife;

import java.util.ArrayList;
import java.util.Collection;

public class AroundCells {

    private final Cell center;
    private final Collection<Cell> aroundCells;

    public AroundCells(Cell center, Collection<Cell> aroundCells){
        this.center = center;
        this.aroundCells = aroundCells;
    }


    public Cell center() {
        return center;
    }

    public Collection<Cell> neightbours() {
        return new ArrayList<Cell>(aroundCells);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AroundCells that = (AroundCells) o;

        if (center != that.center) return false;
        return aroundCells != null ? aroundCells.equals(that.aroundCells) : that.aroundCells == null;
    }

    @Override
    public int hashCode() {
        int result = center != null ? center.hashCode() : 0;
        result = 31 * result + (aroundCells != null ? aroundCells.hashCode() : 0);
        return result;
    }
}
