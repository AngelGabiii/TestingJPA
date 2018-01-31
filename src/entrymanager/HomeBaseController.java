/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrymanager;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * FXML Controller class
 *
 * @author Angelis
 */
public class HomeBaseController implements Initializable {
    
    @FXML TextField usernameTx;
    @FXML TextField username2Tx;
    @FXML  PasswordField passwordTx;
    @FXML  PasswordField password2Tx;
    @FXML TextField emailTx;
    @FXML TextField email2Tx;
    
    @FXML Button scanFingerPrintBtn;
    @FXML Button scanFingerPrint2Btn;
    @FXML Button uploadImageBtn;
    @FXML Button uploadImage2Btn;
    @FXML Button submitBtn;
    @FXML Button editAndSubmitBtn;
    @FXML ImageView imageViewArea;
    @FXML ImageView imageView2Area;
    
   EntityManager em;
   EntityManagerFactory emf;
    
    private StringProperty imageFile= new SimpleStringProperty("Default file location");
    
    /*
        //For the file
            File dFile = new File(imageFile.get());
            FileInputStream in = new FileInputStream(dFile);
            
            pst.setBinaryStream(1, in, dFile.length());
            pst.setString(2, regNumberTx.getText());
            pst.executeUpdate();
    */
    
    
    
    
    /** To handle the image view*/
//    public void browsePassport(){
//         FileChooser fc = new FileChooser();
//         
//            // set Extension filter
//            FileChooser.ExtensionFilter extFilterPics = new FileChooser.ExtensionFilter("Picture files (*jpg, *png)", "*.jpg","*.png");
//            fc.getExtensionFilters().addAll(extFilterPics);
//            
//            //Show open file dialog
//            File selectedFile = fc.showOpenDialog(null);
//                    if (selectedFile != null){
//                        imageFile.set(selectedFile.getPath());
//                    }else{
//                        alert("File is not Valid");
//                    }
//            try{
//                File dFile = new File(imageFile.get());
//                FileInputStream in = new FileInputStream(dFile);
//                Image image = new Image(in);
//                
//                passportImageView.setImage(image);
//            }catch(Exception ex){
//                System.err.println(ex);
//            }
//            
//     }
//    
    
    
    public void toBrowsePicture(){
            
    
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Platform.runLater(()->{ usernameTx.requestFocus();});
        
       
    }    
    
}
