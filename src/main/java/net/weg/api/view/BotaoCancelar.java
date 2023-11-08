package net.weg.api.view;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;

public class BotaoCancelar extends Button {
    public BotaoCancelar(Dialog dialog){
        super("Cancelar", event -> dialog.close());
    }

    public BotaoCancelar(ComponentEventListener listener){
        super("Cancelar", listener);
    }
}
