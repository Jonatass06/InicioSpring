package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.List;

@Data
public abstract class PaginaPadrao<T>  extends VerticalLayout {

    private Grid<T> grid;
    private H1 titulo;
    private HorizontalLayout hl;

    PaginaPadrao(String titulo, List<T> itens, Class<T> classe){
        grid = new Grid<>(classe);
        this.grid.setItems(itens);
        this.hl = new HorizontalLayout();
        this.hl.add(titulo);
        this.titulo = new H1(titulo);
        this.add(this.hl,this.grid);
    }

    PaginaPadrao(String titulo, List<T> itens, Class<T> classe, Button button){
        this(titulo, itens, classe);
        hl.add(button);
    }
}
