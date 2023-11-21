package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

@AllArgsConstructor
@Data
public class Modal extends Dialog {
    private Button cancelar;
    private IFormulario formulario;

    protected Modal(IFormulario formLayout){
        this.formulario = formLayout;
        cancelar = new BotaoCancelar(event-> this.close());
        this.formulario.getElement().getComponent().get();
        this.getFooter().add(cancelar,formulario.getSalvar());
        this.add(formulario);
    }
}
