import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private int starterCash;
    private int numAction;
    private int numSalary;
    private int numCareer;
    /*
        ----------Main menu controllers-----------
    */

    @FXML
    private Button optionsMenu, playGame;

    @FXML
    public void handlePlay() throws Exception{
        Stage playerStage = (Stage)playGame.getScene().getWindow();
        Parent playerView = FXMLLoader.load(getClass().getResource("View/playerChoose.fxml"));

        Scene playerScene = new Scene(playerView);
        playerStage.setScene(playerScene);
        playerStage.show();
    }

    @FXML
    public void handleOptions() throws Exception {
        Stage optionStage = (Stage)optionsMenu.getScene().getWindow();
        Parent optionView = FXMLLoader.load(getClass().getResource("View/optionsMenu.fxml"));

        Scene optionScene = new Scene(optionView);
        optionStage.setScene(optionScene);
        optionStage.show();
    }

    public void handleExit() {
        System.exit(0);
    }

    /*
        ------------Play game controllers-----------
    */

    @FXML
    private Button playerBack, player2, player3;

    @FXML
    public void twoPlayerGame() throws Exception {
        Stage twoP = (Stage)player2.getScene().getWindow();
        Parent twoView = FXMLLoader.load(getClass().getResource("View/twoPlayers.fxml"));

        Scene twoScene = new Scene(twoView);
        twoP.setScene(twoScene);
        twoP.show();
    }

    @FXML
    public void threePlayerGame() throws Exception {
        Stage threeP = (Stage)player3.getScene().getWindow();
        Parent threeView = FXMLLoader.load(getClass().getResource("View/threePlayers.fxml"));

        Scene threeScene = new Scene(threeView);
        threeP.setScene(threeScene);
        threeP.show();
    }

    @FXML
    public void playerReturn() throws Exception {
        Stage pReturn = (Stage)playerBack.getScene().getWindow();
        Parent pRView = FXMLLoader.load(getClass().getResource("View/mainMenu.fxml"));

        Scene pRScene = new Scene(pRView);
        pReturn.setScene(pRScene);
        pReturn.show();
    }

    /*
        -------------Options controllers------------
    */

    @FXML
    private Button optionsBack, optionsCash, optionsDeck, deckSave, deckBack, cashSave, cashBack;

    @FXML
    public void changeSize() throws Exception {
        Stage deckStage = (Stage)optionsDeck.getScene().getWindow();
        Parent deckView = FXMLLoader.load(getClass().getResource("View/editDeck.fxml"));

        Scene deckScene = new Scene(deckView);
        deckStage.setScene(deckScene);
        deckStage.show();
    }

    @FXML
    public void savedDeck() throws Exception {
        Stage dSave = (Stage)deckSave.getScene().getWindow();
        Parent dView = FXMLLoader.load(getClass().getResource("View/optionsMenu.fxml"));

        Scene dScene = new Scene(dView);
        dSave.setScene(dScene);
        dSave.show();
    }

    @FXML
    public void backDeck() throws Exception {
        Stage dBack = (Stage)deckBack.getScene().getWindow();
        Parent bView = FXMLLoader.load(getClass().getResource("View/optionsMenu.fxml"));

        Scene bScene = new Scene(bView);
        dBack.setScene(bScene);
        dBack.show();
    }


    @FXML
    public void changeCash() throws Exception {
        Stage cashStage = (Stage)optionsCash.getScene().getWindow();
        Parent cashView = FXMLLoader.load(getClass().getResource("View/editCashAmt.fxml"));

        Scene cashScene = new Scene(cashView);
        cashStage.setScene(cashScene);
        cashStage.show();
    }

    @FXML
    public void savedCash() throws Exception {
        Stage cSave = (Stage)cashSave.getScene().getWindow();
        Parent cView = FXMLLoader.load(getClass().getResource("View/optionsMenu.fxml"));

        //insert code snippet to update cash amount
        Scene cScene = new Scene(cView);
        cSave.setScene(cScene);
        cSave.show();
    }

    @FXML
    public void backCash() throws Exception {
        Stage cBack = (Stage)cashBack.getScene().getWindow();
        Parent bView = FXMLLoader.load(getClass().getResource("View/optionsMenu.fxml"));

        Scene bScene = new Scene(bView);
        cBack.setScene(bScene);
        cBack.show();
    }

    @FXML
    public void optionReturn() throws Exception {
        Stage returnStage = (Stage)optionsBack.getScene().getWindow();
        Parent returnView = FXMLLoader.load(getClass().getResource("View/mainMenu.fxml"));

        Scene returnScene = new Scene(returnView);
        returnStage.setScene(returnScene);
        returnStage.show();
    }
































































    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
