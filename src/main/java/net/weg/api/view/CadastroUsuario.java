package net.weg.api.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import net.weg.api.model.dto.EnderecoCadastroDTO;
import net.weg.api.model.dto.UsuarioCadastroDTO;
import net.weg.api.model.entity.Cliente;
import net.weg.api.model.entity.Endereco;
import net.weg.api.service.UsuarioService;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;

@Route(value="/cadastro-usuario", layout = NavBarApp.class)
public class CadastroUsuario extends PaginaPadrao<Cliente> {

    private TextField usuario = new TextField("Usuario");
    private TextField nome = new TextField("Nome");
    private TextField sobrenome = new TextField("Sobrenome");

    private PasswordField senha = new PasswordField("Senha");
    private PasswordField confirmacaoSenha = new PasswordField("Confirmar senha");
    private IntegerField idade = new IntegerField("Idade");
    private Grid<EnderecoCadastroDTO> gridEnderecos = new Grid<>(EnderecoCadastroDTO.class);
    private Dialog cadastroEndereco = new Dialog();
    private UsuarioService usuarioService;

    private Button novoEndereco;
    private Button salvar;
    private Button cancelar;


    CadastroUsuario(UsuarioService usuarioService){
        super();
        FormLayout formLayout = new FormLayout();
        this.setHorizontalComponentAlignment(
                Alignment.CENTER,formLayout
        );
        this.usuarioService = usuarioService;
        cadastroEndereco.add(new CadastroEndereco(gridEnderecos,cadastroEndereco));
        novoEndereco = new Button("Novo Endereco", e -> cadastroEndereco.open());
        salvar = new Button("Salvar", e -> {

            Notification notification = new Notification();
            notification.setDuration(3000);
            try {
                if (senha.getValue().equals(confirmacaoSenha.getValue())){
                    throw new RuntimeException();
                }
                Set<Endereco> enderecos = new HashSet<>();
                gridEnderecos.getListDataView().getItems().forEach(enderecoCadastroDTO -> {
                    Endereco endereco = new Endereco();
                    BeanUtils.copyProperties(enderecoCadastroDTO, endereco);
                    enderecos.add(endereco);
                });
                usuarioService.cadastrar(new UsuarioCadastroDTO(nome.getValue(), sobrenome.getValue(),usuario.getValue(), senha.getValue(), idade.getValue(), enderecos));
                notification.setText("Usuario cadastrado com sucesso!");
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            }catch (Exception exception){
                notification.setText("Erro no cadastro do usuario!");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            } finally {
                notification.open();
            }
        });
        salvar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancelar = new Button("Cancelar", event -> new UI().navigate("/"));
//        var vertical = new VerticalLayout(new HorizontalLayout(nome, sobrenome), new HorizontalLayout(senha, confirmacaoSenha),
//                new HorizontalLayout(idade,usuario),novoEndereco, gridEnderecos, new HorizontalLayout(cancelar, salvar));
        formLayout.setColspan(gridEnderecos,2);
        formLayout.setColspan(novoEndereco,2);
        formLayout.setMaxWidth("1000px");
        formLayout.add(nome,sobrenome,usuario,idade,senha,confirmacaoSenha,novoEndereco,gridEnderecos,cadastroEndereco,cancelar,salvar);
        add(formLayout);
    }
}
