package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.H1;

import java.util.Collection;
import java.util.List;

public abstract class PaginaPadrao<T> extends VerticalLayout {
    private Grid<T> grid;
    private HorizontalLayout hl = new HorizontalLayout();
    private H1 h1;


    PaginaPadrao(String titulo, Collection<T> itens, Class<T> classe){
        this.h1 = new H1(titulo);
        this.grid = new Grid<>(classe);
        this.grid.setItems(itens);
        this.grid.removeColumn(grid.getColumnByKey("id"));
        add(this.h1 ,this.grid);
    }
    PaginaPadrao(String titulo, Collection<T> itens, Class<T> classe, Button button){
        this.h1 = new H1(titulo);
        this.grid = new Grid<>(classe);
        this.grid.setItems(itens);
        this.grid.removeColumn(grid.getColumnByKey("id"));
        this.hl.add(h1, button);
        add(this.hl ,this.grid);
    }

}
