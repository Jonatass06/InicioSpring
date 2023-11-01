package net.weg.api.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/perfil", layout = NavbarApp.class)
public class Perfil extends VerticalLayout {
    public Perfil(){
        add(new H1("Perfil"));
    }

}
