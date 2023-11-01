package net.weg.api.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/seguradoras", layout = NavbarApp.class)
public class Seguradoras extends VerticalLayout {
    public Seguradoras(){
        add(new H1("Seguradoras"));
    }

}
