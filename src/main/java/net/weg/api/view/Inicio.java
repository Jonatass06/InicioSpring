package net.weg.api.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/inicio", layout = NavbarApp.class)
public class Inicio extends VerticalLayout {
    public Inicio(){
        add(new H1("Inicio"));
    }

}
