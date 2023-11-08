package net.weg.api.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;

public class NavbarApp extends AppLayout {


    public NavbarApp() {
        H1 title = new H1("SeguraAí");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("left", "var(--lumo-space-l)").set("margin", "0")
                .set("position", "absolute");
        Tabs tabs = getTabs();
        Button button = new Button("Cadastrar Usuário", event ->  getUI().get().navigate("cadastro-usuario"));
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addToNavbar(title, tabs, button);
    }

    private Tabs getTabs() {
        Tabs tabs = new Tabs();
        tabs.getStyle().set("margin", "auto");
        tabs.add(createTab("Inicio", Inicio.class),
                createTab("Meus Seguros", MeusSeguros.class),
                createTab("Meus Automóveis", MeusAutomoveis.class),
                createTab("Seguradoras", Seguradoras.class),
                createTab("Perfil", Perfil.class));
        return tabs;
    }

    private Tab createTab(String viewName, Class classe) {
        RouterLink link = new RouterLink();
        link.add(viewName);
        link.setRoute(classe);
        link.setTabIndex(-1);
        return new Tab(link);
    }

}
