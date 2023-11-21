package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import net.weg.api.model.dto.IDTO;

public class BotaoSalvar<T,ID> extends Button {

    BotaoSalvar(IService<T,ID> service, IDTO dto){

        Notification notification = new Notification();
        notification.setDuration(3000);
        try {
            service.cadastrar(dto);
            notification.setText("Cadasstro realizado com sucesso!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } catch (Exception exp) {
            notification.setText("Erro ao cadastrar!");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        } finally {
            notification.open();
        }

    }

    BotaoSalvar(ComponentEventListener<ClickEvent<Button>> event){
        super("Salvar", event);
    }

}
