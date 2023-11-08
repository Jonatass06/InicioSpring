package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;

public class BotaoSalvar <T, S> extends Button {

    BotaoSalvar(S service, T objeto, Dialog dialog){
        super("Salvar", event -> {
            service.salvar(objeto);
            dialog.close();
        });
    }

}
