package net.weg.api.view;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import net.weg.api.model.dto.EnderecoCadastroDTO;
import net.weg.api.model.dto.UsuarioCadastroDTO;
import net.weg.api.model.entity.Endereco;
import net.weg.api.service.ClienteService;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;


@Route("/cadastro-usuario")
public class CadastroUsuario extends VerticalLayout {

    private final ClienteService clienteService;
    private final TextField usuario = new TextField("Usuario");
    private final TextField nome = new TextField("Nome");
    private final TextField sobrenome = new TextField("Sobrenome");
    private final PasswordField senha = new PasswordField("Senha");
    private final PasswordField confirmarSenha = new PasswordField("Confirme a Senha");
    private final IntegerField idade = new IntegerField("Idade");
    private final Grid<EnderecoCadastroDTO> enderecos = new Grid<>(EnderecoCadastroDTO.class);
    private final Dialog enderecoCadastro = new Dialog();
    private final Button novoEndereco;
    private final Button cadastrar;
    private final BotaoCancelar cancelar;
    private final FormLayout formLayout = new FormLayout();

    CadastroUsuario(ClienteService clienteService) {
        this.setHorizontalComponentAlignment(Alignment.CENTER, formLayout);
        this. cadastrar = new Button("Cadastrar", event -> {
            Notification notification = new Notification();
            notification.setDuration(3000);
            Set<Endereco> listaDeEnderecos = new HashSet<>();
            try {
                if (!senha.getValue().equals(confirmarSenha.getValue())) {
                    throw new Exception("Senhas não conferem");
                }
                enderecos.getListDataView().getItems().forEach(
                        ecdto -> {
                            Endereco endereco = new Endereco();
                            BeanUtils.copyProperties(ecdto, endereco);
                            listaDeEnderecos.add(endereco);
                        }
                );
                clienteService.salvar(new UsuarioCadastroDTO(
                        usuario.getValue(),
                        nome.getValue(),
                        sobrenome.getValue(),
                        senha.getValue(),
                        idade.getValue(),
                        listaDeEnderecos)
                );
                notification.setText("Usuario cadastrado com sucesso");
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            } catch (Exception e) {
                notification.setText("Erro ao cadastrar usuario");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                e.printStackTrace();
            } finally {
                notification.open();
            }
        });
        cadastrar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        this.novoEndereco = new Button("Novo Endereco", event -> enderecoCadastro.open());
        formLayout.setColspan(enderecos, 2);
        formLayout.setColspan(novoEndereco, 2);
        formLayout.setMaxWidth("1000px");
        this.clienteService = clienteService;
        formLayout.add(usuario, nome, sobrenome, senha, confirmarSenha, idade, enderecos, enderecoCadastro,
                novoEndereco, cadastrar, cancelar = new BotaoCancelar(e-> { getUI().get().navigate("inicio");})

        );
        add(formLayout);
        this.enderecoCadastro.add(new CadastroEndereco(enderecos, enderecoCadastro));
    }

}
