import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.imageio.IIOException;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_space;

    @FXML
    private PasswordField password_space;

    @FXML
    private Button enter_button;

    @FXML
    private Button cancel_button;

//////// надо сделать очистку по нажатию на ОТМЕНА ////////
//перечисление введенных элементов
    @FXML
    void initialize(){
        //очистка полей//
        cancel_button.setOnAction(actionEvent -> {
            login_space.clear();
            password_space.clear();
        });
        //очистка полей//
        //вывод на консоль//
        System.out.println(login_space.getText());
        System.out.println(password_space.getText());
        //запись в файл -- начало (сделать для регистрации)
        try(FileOutputStream fos = new FileOutputStream("C://Users//photo//IdeaProjects//Snake//src//information.txt")) {

            byte[] login = login_space.getText().getBytes();
            byte[] password = password_space.getText().getBytes();

            fos.write(login, 0, login.length);
            fos.write(password, 0, password.length);
        }
        catch (IIOException ex){
            System.out.println(ex.getMessage());} catch (IOException e) {
            e.printStackTrace();
        }
        //запись в файл -- конец (сделать для регистрации)
        //


        }
    }

