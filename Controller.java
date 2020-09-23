import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

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
        Parent optionView = FXMLLoader.load(getClass().getResource("View/editMenu.fxml"));

        Scene optionScene = new Scene(optionView);
        optionStage.setScene(optionScene);
        optionStage.show();
    }

    public void handleExit() {
        System.exit(0);
    }

    /*
        ------------Player selection controllers-----------
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
        ------------Start Game controllers---------
    */

    @FXML
    private Button startGame, player1p, player2p, player3p;

    @FXML
    public void gameStart() throws Exception {
        Stage startStage = (Stage)startGame.getScene().getWindow();
        Parent startView = FXMLLoader.load(getClass().getResource("playerPath1.fxml"));

        Scene startScene = new Scene(startView);
        startStage.setScene(startScene);
        startStage.show();
    }

    @FXML
    public void secondPlayer() throws Exception {
        Stage boardStage = (Stage)player1p.getScene().getWindow();
        Parent boardView = FXMLLoader.load(getClass().getResource("playerPath2.fxml"));

        Scene boardScene = new Scene(boardView);
        boardStage.setScene(boardScene);
        boardStage.show();
    }

    @FXML
    public void thirdPlayer() throws Exception {
        Stage boardStage = (Stage)player2p.getScene().getWindow();
        Parent boardView = FXMLLoader.load(getClass().getResource("playerPath3.fxml"));

        Scene boardScene = new Scene(boardView);
        boardStage.setScene(boardScene);
        boardStage.show();
    }

    /*
        -------------Options controllers------------
    */

    @FXML
    private Button editBack, editAtt, editSave;
    @FXML
    private Label acLabel, scLabel, ccLabel, cashLabel;
    @FXML
    private Slider acSlider, scSlider, ccSlider, cashSlider;

    @FXML
    public void adjustActionDeck() {
        acLabel.setText(Integer.toString((int)acSlider.getValue()));
    }

    @FXML
    public void adjustSalaryDeck() {
        scLabel.setText(Integer.toString((int)scSlider.getValue()));
    }

    @FXML
    public void adjustCareerDeck() {
        ccLabel.setText(Integer.toString((int)ccSlider.getValue()));
    }

    @FXML
    public void adjustCash() {
        cashLabel.setText(Integer.toString((int)cashSlider.getValue()));
    }

    @FXML
    public void editAttributes() throws Exception {
        Stage editStage = (Stage)editAtt.getScene().getWindow();
        Parent editView = FXMLLoader.load(getClass().getResource("editableAttributes.fxml"));

        Scene editScene = new Scene(editView);
        editStage.setScene(editScene);
        editStage.show();
    }

    @FXML
    public void noEdit() throws Exception {
        Stage doneStage = (Stage)editBack.getScene().getWindow();
        Parent doneView = FXMLLoader.load(getClass().getResource("editMenu.fxml"));

        Scene doneScene = new Scene(doneView);
        doneStage.setScene(doneScene);
        doneStage.show();
    }

    @FXML
    public void editDone() throws Exception {

        //update deck or cash values here

        Stage doneStage = (Stage)editSave.getScene().getWindow();
        Parent doneView = FXMLLoader.load(getClass().getResource("editMenu.fxml"));

        Scene doneScene = new Scene(doneView);
        doneStage.setScene(doneScene);
        doneStage.show();
    }

    @FXML
    public void optionReturn() throws Exception {
        Stage returnStage = (Stage)editBack.getScene().getWindow();
        Parent returnView = FXMLLoader.load(getClass().getResource("View/mainMenu.fxml"));

        Scene returnScene = new Scene(returnView);
        returnStage.setScene(returnScene);
        returnStage.show();
    }
































































    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
