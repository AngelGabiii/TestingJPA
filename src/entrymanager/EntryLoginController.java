/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrymanager;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Angelis
 */
public class EntryLoginController implements Initializable {
    @FXML private Label prompt;
    @FXML private TextField usernameTx;
    @FXML private PasswordField passwordTx;
    @FXML private Button loginBtn;
   
        String a = "root";
        String b = "rt";
        
  
    /** The master entry login method*/
    public boolean simpleEntry() {
     
            String username = usernameTx.getText();
            String password = passwordTx.getText();
            
            if(username.equals(a) && password.equals(b) ){
                try {
                    Stage stage= (Stage) loginBtn.getScene().getWindow();
                    stage.close();
                
                    FXMLLoader loader = new FXMLLoader();
                    BorderPane boderPane = loader.load(getClass().getResource("HomeBase.fxml"));
                    Scene scene = new Scene(boderPane);
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    stage.show();
                    return true;
                } catch (IOException ex) {
                    Logger.getLogger(EntryLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
            }
            return false;
    }
     

    public void enterBtnLogin(){
        passwordTx.setOnKeyPressed((e)->{
                if(e.getCode()==KeyCode.ENTER){
                    loginArrangements();
                }
        });       
        }
              
    public void loginArrangements(){
    
        if(simpleEntry()){
            simpleEntry();
        }else if(admins()){
                admins();
        }else if(users()){
                users();
        }else{
            fiticious();
        }
    }
    
    
    //================================================================================
    //To create an Entity Manager
        EntityManager em;
        EntityManagerFactory emf;
        
    public void toBegin(){
        emf = Persistence.createEntityManagerFactory("EntrymanagerPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    
    
    private boolean admins() {
        toBegin();
        Query query = em.createQuery("SELECT a FROM Adminusers a WHERE a.userName =:userName And a.password =:password");
        query.setParameter("userName", usernameTx.getText());
        query.setParameter("password", passwordTx.getText());
        List<Adminusers>list = query.getResultList();
        
            for(Adminusers ad : list){
                if(ad.getUserName().equals(usernameTx.getText())){
                    if(ad.getPassword().equals(passwordTx.getText())){
                        try {
                    Stage stage= (Stage) loginBtn.getScene().getWindow();
                    stage.close();
                
                    FXMLLoader loader = new FXMLLoader();
                    BorderPane boderPane = loader.load(getClass().getResource("HomeBase.fxml"));
                    Scene scene = new Scene(boderPane);
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    stage.show();
                    
                    enterBtnLogin();
                    return true;
                        } catch (IOException ex) {
                            System.err.println(ex);
                        }
                    }else{
                        prompt.setText("Invalide password");
                    }
                }else{
                    prompt.setText("invalide Username");
                }
            }
        return false; 
    }
    
    //===============================================================================

    
    private boolean users() {
        toBegin();
      //  Query query = em.createQuery("SELECT u FROM Users u WHERE u.userName =:userName And u.password =:password");
        Query query = em.createNamedQuery("Authenticate user");
        query.setParameter("userName", usernameTx.getText());
        query.setParameter("password", passwordTx.getText());
        List<Users>list = query.getResultList();
        
            for(Users us : list){
                if(us.getUserName().equals(usernameTx.getText())){
                    if(us.getPassword().equals(passwordTx.getText())){
                        try {
                    Stage stage= (Stage) loginBtn.getScene().getWindow();
                    stage.close();
                
                    FXMLLoader loader = new FXMLLoader();
                    BorderPane boderPane = loader.load(getClass().getResource("HomeBase.fxml"));
                    Scene scene = new Scene(boderPane);
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    stage.show();
                    
                    enterBtnLogin();
                    em.clear();
                    return true;
                        } catch (IOException ex) {
                            System.err.println(ex);
                        }
                    }else{
                        Platform.runLater(()->{ prompt.setText("Invalide password"); });
                    }
                }else{
                    Platform.runLater(()->{ prompt.setText("invalide Username"); });
                }
            }
            em.close();
            emf.close();
        return false; 
    }

    private void fiticious() {
         
    }

    
    
    
    
            
            
           
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //To login
        loginBtn.setOnAction((e)->{
            try {
                loginArrangements();
            } catch (Exception ex) {
                System.err.println(ex);
            }
        });
        
       // To login by the press of enter button
             enterBtnLogin();
        
        
        
        
        
        
    }    

   
}
