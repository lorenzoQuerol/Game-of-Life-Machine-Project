import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Model model = Model.getInstance();

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

        model.setNumPlayers(2);
        System.out.println("Players set to: " + model.getNumPlayers());

        Stage twoP = (Stage)player2.getScene().getWindow();
        Parent twoView = FXMLLoader.load(getClass().getResource("View/twoPlayers.fxml"));

        Scene twoScene = new Scene(twoView);
        twoP.setScene(twoScene);
        twoP.show();
    }

    @FXML
    public void threePlayerGame() throws Exception {

        model.setNumPlayers(3);
        System.out.println("Players set to: " + model.getNumPlayers());

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

    @FXML private Button startGame, player1p, player2p, P3_player2p, player3p, player1Job, player2Job, player3Job;
    @FXML private TextField textFieldP1, textFieldP2, textFieldP3;

    @FXML
    public void gameStart() throws Exception {
        Stage startStage = (Stage)startGame.getScene().getWindow();
        Parent startView = FXMLLoader.load(getClass().getResource("View/playerPath1.fxml"));

        Scene startScene = new Scene(startView);
        startStage.setScene(startScene);
        startStage.show();
    }

    @FXML
    public void secondPlayer(ActionEvent e) throws Exception {
        if(e.getSource() == player1Job) {
            Stage chooseP = new Stage();
            Parent chooseCard = FXMLLoader.load(getClass().getResource("View/collegeChoice.fxml"));

            chooseP.initStyle(StageStyle.UNDECORATED);
            chooseP.initModality(Modality.APPLICATION_MODAL);
            chooseP.setScene(new Scene(chooseCard, 600, 400));
            chooseP.setResizable(false);
            chooseP.showAndWait();

            Stage boardStage = (Stage)player1p.getScene().getWindow();
            Parent boardView = FXMLLoader.load(getClass().getResource("View/playerPath2.fxml"));

            Scene boardScene = new Scene(boardView);
            boardStage.setScene(boardScene);
            boardStage.show();
        }
        else {
            Stage boardStage = (Stage)player1p.getScene().getWindow();
            Parent boardView = FXMLLoader.load(getClass().getResource("View/playerPath2.fxml"));

            Scene boardScene = new Scene(boardView);
            boardStage.setScene(boardScene);
            boardStage.show();
        }
    }

    @FXML
    public void thirdPlayer(ActionEvent e) throws Exception {
        if(e.getSource() == player2Job) {
            Stage chooseP = new Stage();
            Parent chooseCard = FXMLLoader.load(getClass().getResource("View/collegeChoice.fxml"));

            chooseP.initStyle(StageStyle.UNDECORATED);
            chooseP.initModality(Modality.APPLICATION_MODAL);
            chooseP.setScene(new Scene(chooseCard, 600, 400));
            chooseP.setResizable(false);
            chooseP.showAndWait();

            Stage boardStage = (Stage)player2p.getScene().getWindow();
            Parent boardView = FXMLLoader.load(getClass().getResource("View/playerPath3.fxml"));

            Scene boardScene = new Scene(boardView);
            boardStage.setScene(boardScene);
            boardStage.show();
        }
        else {
            Stage boardStage = (Stage)player2p.getScene().getWindow();
            Parent boardView = FXMLLoader.load(getClass().getResource("View/playerPath3.fxml"));

            Scene boardScene = new Scene(boardView);
            boardStage.setScene(boardScene);
            boardStage.show();
        }
    }

    @FXML
    public void displayBoard(ActionEvent e) throws Exception {
        if(e.getSource() == player3Job) {
            Stage chooseP = new Stage();
            Parent chooseCard = FXMLLoader.load(getClass().getResource("View/collegeChoice.fxml"));

            chooseP.initStyle(StageStyle.UNDECORATED);
            chooseP.initModality(Modality.APPLICATION_MODAL);
            chooseP.setScene(new Scene(chooseCard, 600, 400));
            chooseP.setResizable(false);
            chooseP.showAndWait();

            Stage boardStage = (Stage)player3p.getScene().getWindow();
            Parent boardView = FXMLLoader.load(getClass().getResource("View/gameBoard.fxml"));

            Scene boardScene = new Scene(boardView);
            boardStage.setScene(boardScene);
            boardStage.show();
        }
        else {
            Stage boardStage = (Stage)player3p.getScene().getWindow();
            Parent boardView = FXMLLoader.load(getClass().getResource("View/gameBoard.fxml"));

            Scene boardScene = new Scene(boardView);
            boardStage.setScene(boardScene);
            boardStage.show();
        }
    }

    /*
        ------------Board proper controllers------------
    */
    @FXML
    private Label diceLabel, nameLabel, moneyLabel, jobLabel, salaryLabel, houseLabel;
    @FXML
    private Button rollSpin, nextPlayer, drawCard;
    @FXML
    private Rectangle space1, space2, space3, space4, space5, space6, space7, space8, space9, space10, space11, space12, space13, space14, space15, space16, space17, space18, space19, space20, space21, space22, space23, space24, space25, space26, space27, space28, space29, space30, space31, space32, space33, space34, space35, space36, space37, space38, space39, space40, space41;
    @FXML
    private Rectangle space1a, space2a, space3a, space4a, space5a, space6a, space7a, space8a, space20a, space21a, space22a, space23a, space24a, space25a, space26a, space27a;
    @FXML
    private Circle gamePiece1, gamePiece2, gamePiece3;

    private static int countP1 = 0;
    private static int countP2 = 0;
    private static int countP3 = 0;

    private static int stopPinkP1 = 10;
    private static int stopPinkP2 = 10;
    private static int stopPinkP3 = 10;

    private static int ctr = 0;


    @FXML
    public void rollDice() {
        int diceRoll;
        int countMove;

        diceRoll = (int)(Math.random() * (10 - 1 + 1) + 1);
        diceLabel.setText(Integer.toString(diceRoll));

        countMove = 0;

        if(ctr == 0) {
            countMove = countP1;
            countMove += diceRoll;
            countP1 += diceRoll;
//            if(countMove >= stopPinkP1 && player path is college path) {
//                countMove = stopPinkP1;
//                countP1 = stopPinkP1;
//            }
            if(countMove >= stopPinkP1) {
                countMove = stopPinkP1;
                countP1 = stopPinkP1;
            }
        }
        else if(ctr == 1) {
            countMove = countP2;
            countMove += diceRoll;
            countP2 += diceRoll;
//            if(countMove >= stopPinkP2 && player path is college path) {
//                countMove = stopPinkP2;
//                countP2 = stopPinkP2;
//            }
            if(countMove >= stopPinkP2) {
                countMove = stopPinkP2;
                countP2 = stopPinkP2;
            }
        }
        else if(ctr == 2) {
            countMove = countP3;
            countMove += diceRoll;
            countP3 += diceRoll;
//            if(countMove >= stopPinkP3 && player path is college path) {
//                countMove = stopPinkP3;
//                countP3 = stopPinkP3;
//            }
            if(countMove >= stopPinkP3) {
                countMove = stopPinkP3;
                countP3 = stopPinkP3;
            }
        }

        if(countMove <= 41) {
            switch(countMove) {
                case 1:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space1.getLayoutX() + (space1.getWidth() / 2));
                        gamePiece1.setLayoutY(space1.getLayoutY() + (space1.getHeight() / 2));
                        stopPinkP1 = 15;
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space1.getLayoutX() + (space1.getWidth() / 2));
                        gamePiece2.setLayoutY(space1.getLayoutY() + (space1.getHeight() / 2));
                        stopPinkP2 = 15;
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space1.getLayoutX() + (space1.getWidth() / 2));
                        gamePiece3.setLayoutY(space1.getLayoutY() + (space1.getHeight() / 2));
                        stopPinkP3 = 15;
                    }
//                    else if(ctr == 0 && player path is college path){
//                        gamePiece1.setLayoutX(space1a.getLayoutX() + (space1a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space1a.getLayoutY() + (space1a.getHeight() / 2));
//                    }
//                    else if(ctr == 1 && player path is college path) {
//                        gamePiece2.setLayoutX(space1a.getLayoutX() + (space1a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space1a.getLayoutY() + (space1a.getHeight() / 2));
//                    }
//                    else if(ctr == 2 && player path is college path) {
//                        gamePiece3.setLayoutX(space1a.getLayoutX() + (space1a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space1a.getLayoutY() + (space1a.getHeight() / 2));
//                    }
                    break;
                case 2:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space2.getLayoutX() + (space2.getWidth() / 2));
                        gamePiece1.setLayoutY(space2.getLayoutY() + (space2.getHeight() / 2));
                        stopPinkP1 = 15;
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space2.getLayoutX() + (space2.getWidth() / 2));
                        gamePiece2.setLayoutY(space2.getLayoutY() + (space2.getHeight() / 2));
                        stopPinkP2 = 15;
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space2.getLayoutX() + (space2.getWidth() / 2));
                        gamePiece3.setLayoutY(space2.getLayoutY() + (space2.getHeight() / 2));
                        stopPinkP3 = 15;
                    }
//                    else if(ctr == 0){
//                        gamePiece1.setLayoutX(space2a.getLayoutX() + (space2a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space2a.getLayoutY() + (space2a.getHeight() / 2));
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space2a.getLayoutX() + (space2a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space2a.getLayoutY() + (space2a.getHeight() / 2));
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space2a.getLayoutX() + (space2a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space2a.getLayoutY() + (space2a.getHeight() / 2));
//                    }
                    break;
                case 3:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space3.getLayoutX() + (space3.getWidth() / 2));
                        gamePiece1.setLayoutY(space3.getLayoutY() + (space3.getHeight() / 2));
                        stopPinkP1 = 15;
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space3.getLayoutX() + (space3.getWidth() / 2));
                        gamePiece2.setLayoutY(space3.getLayoutY() + (space3.getHeight() / 2));
                        stopPinkP2 = 15;
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space3.getLayoutX() + (space3.getWidth() / 2));
                        gamePiece3.setLayoutY(space3.getLayoutY() + (space3.getHeight() / 2));
                        stopPinkP3 = 15;
                    }
//                   else if(ctr == 0){
//                        gamePiece1.setLayoutX(space3a.getLayoutX() + (space3a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space3a.getLayoutY() + (space3a.getHeight() / 2));
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space3a.getLayoutX() + (space3a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space3a.getLayoutY() + (space3a.getHeight() / 2));
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space3a.getLayoutX() + (space3a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space3a.getLayoutY() + (space3a.getHeight() / 2));
//                    }
                    break;
                case 4:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space4.getLayoutX() + (space4.getWidth() / 2));
                        gamePiece1.setLayoutY(space4.getLayoutY() + (space4.getHeight() / 2));
                        stopPinkP1 = 15;
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space4.getLayoutX() + (space4.getWidth() / 2));
                        gamePiece2.setLayoutY(space4.getLayoutY() + (space4.getHeight() / 2));
                        stopPinkP2 = 15;
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space4.getLayoutX() + (space4.getWidth() / 2));
                        gamePiece3.setLayoutY(space4.getLayoutY() + (space4.getHeight() / 2));
                        stopPinkP3 = 15;
                    }
//                    else if(ctr == 0){
//                        gamePiece1.setLayoutX(space4a.getLayoutX() + (space4a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space4a.getLayoutY() + (space4a.getHeight() / 2));
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space4a.getLayoutX() + (space4a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space4a.getLayoutY() + (space4a.getHeight() / 2));
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space4a.getLayoutX() + (space4a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space4a.getLayoutY() + (space4a.getHeight() / 2));
//                    }
                    break;
                case 5:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space5.getLayoutX() + (space5.getWidth() / 2));
                        gamePiece1.setLayoutY(space5.getLayoutY() + (space5.getHeight() / 2));
                        stopPinkP1 = 15;
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space5.getLayoutX() + (space5.getWidth() / 2));
                        gamePiece2.setLayoutY(space5.getLayoutY() + (space5.getHeight() / 2));
                        stopPinkP2 = 15;
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space5.getLayoutX() + (space5.getWidth() / 2));
                        gamePiece3.setLayoutY(space5.getLayoutY() + (space5.getHeight() / 2));
                        stopPinkP3 = 15;
                    }
//                    else if(ctr == 0){
//                        gamePiece1.setLayoutX(space5a.getLayoutX() + (space5a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space5a.getLayoutY() + (space5a.getHeight() / 2));
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space5a.getLayoutX() + (space5a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space5a.getLayoutY() + (space5a.getHeight() / 2));
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space5a.getLayoutX() + (space5a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space5a.getLayoutY() + (space5a.getHeight() / 2));
//                    }
                    break;
                case 6:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space6.getLayoutX() + (space6.getWidth() / 2));
                        gamePiece1.setLayoutY(space6.getLayoutY() + (space6.getHeight() / 2));
                        stopPinkP1 = 15;
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space6.getLayoutX() + (space6.getWidth() / 2));
                        gamePiece2.setLayoutY(space6.getLayoutY() + (space6.getHeight() / 2));
                        stopPinkP2 = 15;
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space6.getLayoutX() + (space6.getWidth() / 2));
                        gamePiece3.setLayoutY(space6.getLayoutY() + (space6.getHeight() / 2));
                        stopPinkP3 = 15;
                    }
//                    else if(ctr == 0){
//                        gamePiece1.setLayoutX(space6a.getLayoutX() + (space6a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space6a.getLayoutY() + (space6a.getHeight() / 2));
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space6a.getLayoutX() + (space6a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space6a.getLayoutY() + (space6a.getHeight() / 2));
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space6a.getLayoutX() + (space6a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space6a.getLayoutY() + (space6a.getHeight() / 2));
//                    }
                    break;
                case 7:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space7.getLayoutX() + (space7.getWidth() / 2));
                        gamePiece1.setLayoutY(space7.getLayoutY() + (space7.getHeight() / 2));
                        stopPinkP1 = 15;
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space7.getLayoutX() + (space7.getWidth() / 2));
                        gamePiece2.setLayoutY(space7.getLayoutY() + (space7.getHeight() / 2));
                        stopPinkP2 = 15;
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space7.getLayoutX() + (space7.getWidth() / 2));
                        gamePiece3.setLayoutY(space7.getLayoutY() + (space7.getHeight() / 2));
                        stopPinkP3 = 15;
                    }
//                    else if(ctr == 0){
//                        gamePiece1.setLayoutX(space7a.getLayoutX() + (space7a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space7a.getLayoutY() + (space7a.getHeight() / 2));
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space7a.getLayoutX() + (space7a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space7a.getLayoutY() + (space7a.getHeight() / 2));
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space7a.getLayoutX() + (space7a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space7a.getLayoutY() + (space7a.getHeight() / 2));
//                    }
                    break;
                case 8:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space8.getLayoutX() + (space8.getWidth() / 2));
                        gamePiece1.setLayoutY(space8.getLayoutY() + (space8.getHeight() / 2));
                        stopPinkP1 = 15;
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space8.getLayoutX() + (space8.getWidth() / 2));
                        gamePiece2.setLayoutY(space8.getLayoutY() + (space8.getHeight() / 2));
                        stopPinkP2 = 15;
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space8.getLayoutX() + (space8.getWidth() / 2));
                        gamePiece3.setLayoutY(space8.getLayoutY() + (space8.getHeight() / 2));
                        stopPinkP3 = 15;
                    }
//                    else if(ctr == 0){
//                        gamePiece1.setLayoutX(space8a.getLayoutX() + (space8a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space8a.getLayoutY() + (space8a.getHeight() / 2));
//                        stopPinkP1 = 15;
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space8a.getLayoutX() + (space8a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space8a.getLayoutY() + (space8a.getHeight() / 2));
//                        stopPinkP2 = 15;
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space8a.getLayoutX() + (space8a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space8a.getLayoutY() + (space8a.getHeight() / 2));
//                        stopPinkP3 = 15;
//                    }
                    break;
                case 9:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space9.getLayoutX() + (space9.getWidth() / 2));
                        gamePiece1.setLayoutY(space9.getLayoutY() + (space9.getHeight() / 2));
                        stopPinkP1 = 15;
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space9.getLayoutX() + (space9.getWidth() / 2));
                        gamePiece2.setLayoutY(space9.getLayoutY() + (space9.getHeight() / 2));
                        stopPinkP2 = 15;
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space9.getLayoutX() + (space9.getWidth() / 2));
                        gamePiece3.setLayoutY(space9.getLayoutY() + (space9.getHeight() / 2));
                        stopPinkP3 = 15;
                    }
                    break;
                case 10:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space10.getLayoutX() + (space10.getWidth() / 2));
                        gamePiece1.setLayoutY(space10.getLayoutY() + (space10.getHeight() / 2));
                        stopPinkP1 = 15;
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space10.getLayoutX() + (space10.getWidth() / 2));
                        gamePiece2.setLayoutY(space10.getLayoutY() + (space10.getHeight() / 2));
                        stopPinkP2 = 15;
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space10.getLayoutX() + (space10.getWidth() / 2));
                        gamePiece3.setLayoutY(space10.getLayoutY() + (space10.getHeight() / 2));
                        stopPinkP3 = 15;
                    }
                    break;
                case 11:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space11.getLayoutX() + (space11.getWidth() / 2));
                        gamePiece1.setLayoutY(space11.getLayoutY() + (space11.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space11.getLayoutX() + (space11.getWidth() / 2));
                        gamePiece2.setLayoutY(space11.getLayoutY() + (space11.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space11.getLayoutX() + (space11.getWidth() / 2));
                        gamePiece3.setLayoutY(space11.getLayoutY() + (space11.getHeight() / 2));
                    }
                    break;
                case 12:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space12.getLayoutX() + (space12.getWidth() / 2));
                        gamePiece1.setLayoutY(space12.getLayoutY() + (space12.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space12.getLayoutX() + (space12.getWidth() / 2));
                        gamePiece2.setLayoutY(space12.getLayoutY() + (space12.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space12.getLayoutX() + (space12.getWidth() / 2));
                        gamePiece3.setLayoutY(space12.getLayoutY() + (space12.getHeight() / 2));
                    }
                    break;
                case 13:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space13.getLayoutX() + (space14.getWidth() / 2));
                        gamePiece1.setLayoutY(space13.getLayoutY() + (space14.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space13.getLayoutX() + (space14.getWidth() / 2));
                        gamePiece2.setLayoutY(space13.getLayoutY() + (space14.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space13.getLayoutX() + (space14.getWidth() / 2));
                        gamePiece3.setLayoutY(space13.getLayoutY() + (space14.getHeight() / 2));
                    }
                    break;
                case 14:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space14.getLayoutX() + (space14.getWidth() / 2));
                        gamePiece1.setLayoutY(space14.getLayoutY() + (space14.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space14.getLayoutX() + (space14.getWidth() / 2));
                        gamePiece2.setLayoutY(space14.getLayoutY() + (space14.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space14.getLayoutX() + (space14.getWidth() / 2));
                        gamePiece3.setLayoutY(space14.getLayoutY() + (space14.getHeight() / 2));
                    }
                    break;
                case 15:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space15.getLayoutX() + (space15.getWidth() / 2));
                        gamePiece1.setLayoutY(space15.getLayoutY() + (space15.getHeight() / 2));
                        stopPinkP1 = 19;
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space15.getLayoutX() + (space15.getWidth() / 2));
                        gamePiece2.setLayoutY(space15.getLayoutY() + (space15.getHeight() / 2));
                        stopPinkP2 = 19;
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space15.getLayoutX() + (space15.getWidth() / 2));
                        gamePiece3.setLayoutY(space15.getLayoutY() + (space15.getHeight() / 2));
                        stopPinkP3 = 19;
                    }
                    break;
                case 16:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space16.getLayoutX() + (space16.getWidth() / 2));
                        gamePiece1.setLayoutY(space16.getLayoutY() + (space16.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space16.getLayoutX() + (space16.getWidth() / 2));
                        gamePiece2.setLayoutY(space16.getLayoutY() + (space16.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space16.getLayoutX() + (space16.getWidth() / 2));
                        gamePiece3.setLayoutY(space16.getLayoutY() + (space16.getHeight() / 2));
                    }
                    break;
                case 17:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space17.getLayoutX() + (space17.getWidth() / 2));
                        gamePiece1.setLayoutY(space17.getLayoutY() + (space17.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space17.getLayoutX() + (space17.getWidth() / 2));
                        gamePiece2.setLayoutY(space17.getLayoutY() + (space17.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space17.getLayoutX() + (space17.getWidth() / 2));
                        gamePiece3.setLayoutY(space17.getLayoutY() + (space17.getHeight() / 2));
                    }
                    break;
                case 18:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space18.getLayoutX() + (space18.getWidth() / 2));
                        gamePiece1.setLayoutY(space18.getLayoutY() + (space18.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space18.getLayoutX() + (space18.getWidth() / 2));
                        gamePiece2.setLayoutY(space18.getLayoutY() + (space18.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space18.getLayoutX() + (space18.getWidth() / 2));
                        gamePiece3.setLayoutY(space18.getLayoutY() + (space18.getHeight() / 2));
                    }
                    break;
                case 19:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space19.getLayoutX() + (space19.getWidth() / 2));
                        gamePiece1.setLayoutY(space19.getLayoutY() + (space19.getHeight() / 2));
                        stopPinkP1 = 30;
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space19.getLayoutX() + (space19.getWidth() / 2));
                        gamePiece2.setLayoutY(space19.getLayoutY() + (space19.getHeight() / 2));
                        stopPinkP2 = 30;
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space19.getLayoutX() + (space19.getWidth() / 2));
                        gamePiece3.setLayoutY(space19.getLayoutY() + (space19.getHeight() / 2));
                        stopPinkP3 = 30;
                    }
//                    else if(ctr == 0){
//                        gamePiece1.setLayoutX(space19.getLayoutX() + (space19.getWidth() / 2));
//                        gamePiece1.setLayoutY(space19.getLayoutY() + (space19.getHeight() / 2));
//                        stopPinkP1 = 21;
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space19.getLayoutX() + (space19.getWidth() / 2));
//                        gamePiece2.setLayoutY(space19.getLayoutY() + (space19.getHeight() / 2));
//                        stopPinkP2 = 21;
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space19.getLayoutX() + (space19.getWidth() / 2));
//                        gamePiece3.setLayoutY(space19.getLayoutY() + (space19.getHeight() / 2));
//                        stopPinkP3 = 21;
//                    }
                    break;
                case 20:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space20.getLayoutX() + (space20.getWidth() / 2));
                        gamePiece1.setLayoutY(space20.getLayoutY() + (space20.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space20.getLayoutX() + (space20.getWidth() / 2));
                        gamePiece2.setLayoutY(space20.getLayoutY() + (space20.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space20.getLayoutX() + (space20.getWidth() / 2));
                        gamePiece3.setLayoutY(space20.getLayoutY() + (space20.getHeight() / 2));
                    }
//                    else if(ctr == 0){
//                        gamePiece1.setLayoutX(space20a.getLayoutX() + (space20a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space20a.getLayoutY() + (space20a.getHeight() / 2));
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space20a.getLayoutX() + (space20a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space20a.getLayoutY() + (space20a.getHeight() / 2));
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space20a.getLayoutX() + (space20a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space20a.getLayoutY() + (space20a.getHeight() / 2));
//                    }
                    break;
                case 21:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space21.getLayoutX() + (space21.getWidth() / 2));
                        gamePiece1.setLayoutY(space21.getLayoutY() + (space21.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space21.getLayoutX() + (space21.getWidth() / 2));
                        gamePiece2.setLayoutY(space21.getLayoutY() + (space21.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space21.getLayoutX() + (space21.getWidth() / 2));
                        gamePiece3.setLayoutY(space21.getLayoutY() + (space21.getHeight() / 2));
                    }
//                    else if(ctr == 0){
//                        gamePiece1.setLayoutX(space21a.getLayoutX() + (space21a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space21a.getLayoutY() + (space21a.getHeight() / 2));
//                        stopPinkP1 = 30;
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space21.getLayoutX() + (space21a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space21.getLayoutY() + (space21a.getHeight() / 2));
//                        stopPinkP2 = 30;
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space21a.getLayoutX() + (space21a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space21a.getLayoutY() + (space21a.getHeight() / 2));
//                        stopPinkP3 = 30;
//                    }
                    break;
                case 22:
                    if(ctr == 0) {
                        gamePiece1.setLayoutX(space22.getLayoutX() + (space22.getWidth() / 2));
                        gamePiece1.setLayoutY(space22.getLayoutY() + (space22.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space22.getLayoutX() + (space22.getWidth() / 2));
                        gamePiece2.setLayoutY(space22.getLayoutY() + (space22.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space22.getLayoutX() + (space22.getWidth() / 2));
                        gamePiece3.setLayoutY(space22.getLayoutY() + (space22.getHeight() / 2));
                    }
//                    else if(ctr == 0) {
//                        gamePiece1.setLayoutX(space22a.getLayoutX() + (space22a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space22a.getLayoutY() + (space22a.getHeight() / 2));
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space22a.getLayoutX() + (space22a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space22a.getLayoutY() + (space22a.getHeight() / 2));
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space22a.getLayoutX() + (space22a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space22a.getLayoutY() + (space22a.getHeight() / 2));
//                    }
                    break;
                case 23:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space23.getLayoutX() + (space23.getWidth() / 2));
                        gamePiece1.setLayoutY(space23.getLayoutY() + (space23.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space23.getLayoutX() + (space23.getWidth() / 2));
                        gamePiece2.setLayoutY(space23.getLayoutY() + (space23.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space23.getLayoutX() + (space23.getWidth() / 2));
                        gamePiece3.setLayoutY(space23.getLayoutY() + (space23.getHeight() / 2));
                    }
//                    else if(ctr == 0){
//                        gamePiece1.setLayoutX(space23a.getLayoutX() + (space23a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space23a.getLayoutY() + (space23a.getHeight() / 2));
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space23a.getLayoutX() + (space23a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space23a.getLayoutY() + (space23a.getHeight() / 2));
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space23a.getLayoutX() + (space23a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space23a.getLayoutY() + (space23a.getHeight() / 2));
//                    }
                    break;
                case 24:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space24.getLayoutX() + (space24.getWidth() / 2));
                        gamePiece1.setLayoutY(space24.getLayoutY() + (space24.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space24.getLayoutX() + (space24.getWidth() / 2));
                        gamePiece2.setLayoutY(space24.getLayoutY() + (space24.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space24.getLayoutX() + (space24.getWidth() / 2));
                        gamePiece3.setLayoutY(space24.getLayoutY() + (space24.getHeight() / 2));
                    }
//                    else if(ctr == 0){
//                        gamePiece1.setLayoutX(space24a.getLayoutX() + (space24a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space24a.getLayoutY() + (space24a.getHeight() / 2));
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space24a.getLayoutX() + (space24a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space24a.getLayoutY() + (space24a.getHeight() / 2));
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space24a.getLayoutX() + (space24a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space24a.getLayoutY() + (space24a.getHeight() / 2));
//                    }
                    break;
                case 25:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space25.getLayoutX() + (space25.getWidth() / 2));
                        gamePiece1.setLayoutY(space25.getLayoutY() + (space25.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space25.getLayoutX() + (space25.getWidth() / 2));
                        gamePiece2.setLayoutY(space25.getLayoutY() + (space25.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space25.getLayoutX() + (space25.getWidth() / 2));
                        gamePiece3.setLayoutY(space25.getLayoutY() + (space25.getHeight() / 2));
                    }
//                    else if(ctr == 0){
//                        gamePiece1.setLayoutX(space25a.getLayoutX() + (space25a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space25a.getLayoutY() + (space25a.getHeight() / 2));
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space25a.getLayoutX() + (space25a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space25a.getLayoutY() + (space25a.getHeight() / 2));
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space25a.getLayoutX() + (space25a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space25a.getLayoutY() + (space25a.getHeight() / 2));
//                    }
                    break;
                case 26:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space26.getLayoutX() + (space26.getWidth() / 2));
                        gamePiece1.setLayoutY(space26.getLayoutY() + (space26.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space26.getLayoutX() + (space26.getWidth() / 2));
                        gamePiece2.setLayoutY(space26.getLayoutY() + (space26.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space26.getLayoutX() + (space26.getWidth() / 2));
                        gamePiece3.setLayoutY(space26.getLayoutY() + (space26.getHeight() / 2));
                    }
//                    else if(ctr == 0){
//                        gamePiece1.setLayoutX(space26a.getLayoutX() + (space26a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space26a.getLayoutY() + (space26a.getHeight() / 2));
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space26a.getLayoutX() + (space26a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space26a.getLayoutY() + (space26a.getHeight() / 2));
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space26a.getLayoutX() + (space26a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space26a.getLayoutY() + (space26a.getHeight() / 2));
//                    }
                    break;
                case 27:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space27.getLayoutX() + (space27.getWidth() / 2));
                        gamePiece1.setLayoutY(space27.getLayoutY() + (space27.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space27.getLayoutX() + (space27.getWidth() / 2));
                        gamePiece2.setLayoutY(space27.getLayoutY() + (space27.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space27.getLayoutX() + (space27.getWidth() / 2));
                        gamePiece3.setLayoutY(space27.getLayoutY() + (space27.getHeight() / 2));
                    }
//                    else if(ctr == 0){
//                        gamePiece1.setLayoutX(space27a.getLayoutX() + (space27a.getWidth() / 2));
//                        gamePiece1.setLayoutY(space27a.getLayoutY() + (space27a.getHeight() / 2));
//                    }
//                    else if(ctr == 1) {
//                        gamePiece2.setLayoutX(space27a.getLayoutX() + (space27a.getWidth() / 2));
//                        gamePiece2.setLayoutY(space27a.getLayoutY() + (space27a.getHeight() / 2));
//                    }
//                    else if(ctr == 2) {
//                        gamePiece3.setLayoutX(space27a.getLayoutX() + (space27a.getWidth() / 2));
//                        gamePiece3.setLayoutY(space27a.getLayoutY() + (space27a.getHeight() / 2));
//                    }
                    break;
                case 28:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space28.getLayoutX() + (space28.getWidth() / 2));
                        gamePiece1.setLayoutY(space28.getLayoutY() + (space28.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space28.getLayoutX() + (space28.getWidth() / 2));
                        gamePiece2.setLayoutY(space28.getLayoutY() + (space28.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space28.getLayoutX() + (space28.getWidth() / 2));
                        gamePiece3.setLayoutY(space28.getLayoutY() + (space28.getHeight() / 2));
                    }
                    break;
                case 29:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space29.getLayoutX() + (space29.getWidth() / 2));
                        gamePiece1.setLayoutY(space29.getLayoutY() + (space29.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space29.getLayoutX() + (space29.getWidth() / 2));
                        gamePiece2.setLayoutY(space29.getLayoutY() + (space29.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space29.getLayoutX() + (space29.getWidth() / 2));
                        gamePiece3.setLayoutY(space29.getLayoutY() + (space29.getHeight() / 2));
                    }
                    break;
                case 30:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space30.getLayoutX() + (space30.getWidth() / 2));
                        gamePiece1.setLayoutY(space30.getLayoutY() + (space30.getHeight() / 2));
                        stopPinkP1 = 33;
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space30.getLayoutX() + (space30.getWidth() / 2));
                        gamePiece2.setLayoutY(space30.getLayoutY() + (space30.getHeight() / 2));
                        stopPinkP2 = 33;
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space30.getLayoutX() + (space30.getWidth() / 2));
                        gamePiece3.setLayoutY(space30.getLayoutY() + (space30.getHeight() / 2));
                        stopPinkP3 = 33;
                    }
                    break;
                case 31:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space31.getLayoutX() + (space31.getWidth() / 2));
                        gamePiece1.setLayoutY(space31.getLayoutY() + (space31.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space31.getLayoutX() + (space31.getWidth() / 2));
                        gamePiece2.setLayoutY(space31.getLayoutY() + (space31.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space31.getLayoutX() + (space31.getWidth() / 2));
                        gamePiece3.setLayoutY(space31.getLayoutY() + (space31.getHeight() / 2));
                    }
                    break;
                case 32:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space32.getLayoutX() + (space32.getWidth() / 2));
                        gamePiece1.setLayoutY(space32.getLayoutY() + (space32.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space32.getLayoutX() + (space32.getWidth() / 2));
                        gamePiece2.setLayoutY(space32.getLayoutY() + (space32.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space32.getLayoutX() + (space32.getWidth() / 2));
                        gamePiece3.setLayoutY(space32.getLayoutY() + (space32.getHeight() / 2));
                    }
                    break;
                case 33:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space33.getLayoutX() + (space33.getWidth() / 2));
                        gamePiece1.setLayoutY(space33.getLayoutY() + (space33.getHeight() / 2));
                        stopPinkP1 = 41;
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space33.getLayoutX() + (space33.getWidth() / 2));
                        gamePiece2.setLayoutY(space33.getLayoutY() + (space33.getHeight() / 2));
                        stopPinkP2 = 41;
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space33.getLayoutX() + (space33.getWidth() / 2));
                        gamePiece3.setLayoutY(space33.getLayoutY() + (space33.getHeight() / 2));
                        stopPinkP3 = 41;
                    }
                    break;
                case 34:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space34.getLayoutX() + (space34.getWidth() / 2));
                        gamePiece1.setLayoutY(space34.getLayoutY() + (space34.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space34.getLayoutX() + (space34.getWidth() / 2));
                        gamePiece2.setLayoutY(space34.getLayoutY() + (space34.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space34.getLayoutX() + (space34.getWidth() / 2));
                        gamePiece3.setLayoutY(space34.getLayoutY() + (space34.getHeight() / 2));
                    }
                    break;
                case 35:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space35.getLayoutX() + (space35.getWidth() / 2));
                        gamePiece1.setLayoutY(space35.getLayoutY() + (space35.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space35.getLayoutX() + (space35.getWidth() / 2));
                        gamePiece2.setLayoutY(space35.getLayoutY() + (space35.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space35.getLayoutX() + (space35.getWidth() / 2));
                        gamePiece3.setLayoutY(space35.getLayoutY() + (space35.getHeight() / 2));
                    }
                    break;
                case 36:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space36.getLayoutX() + (space36.getWidth() / 2));
                        gamePiece1.setLayoutY(space36.getLayoutY() + (space36.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space36.getLayoutX() + (space36.getWidth() / 2));
                        gamePiece2.setLayoutY(space36.getLayoutY() + (space36.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space36.getLayoutX() + (space36.getWidth() / 2));
                        gamePiece3.setLayoutY(space36.getLayoutY() + (space36.getHeight() / 2));
                    }
                    break;
                case 37:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space37.getLayoutX() + (space37.getWidth() / 2));
                        gamePiece1.setLayoutY(space37.getLayoutY() + (space37.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space37.getLayoutX() + (space37.getWidth() / 2));
                        gamePiece2.setLayoutY(space37.getLayoutY() + (space37.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space37.getLayoutX() + (space37.getWidth() / 2));
                        gamePiece3.setLayoutY(space37.getLayoutY() + (space37.getHeight() / 2));
                    }
                    break;
                case 38:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space38.getLayoutX() + (space38.getWidth() / 2));
                        gamePiece1.setLayoutY(space38.getLayoutY() + (space38.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space38.getLayoutX() + (space38.getWidth() / 2));
                        gamePiece2.setLayoutY(space38.getLayoutY() + (space38.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space38.getLayoutX() + (space38.getWidth() / 2));
                        gamePiece3.setLayoutY(space38.getLayoutY() + (space38.getHeight() / 2));
                    }
                    break;
                case 39:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space39.getLayoutX() + (space39.getWidth() / 2));
                        gamePiece1.setLayoutY(space39.getLayoutY() + (space39.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space39.getLayoutX() + (space39.getWidth() / 2));
                        gamePiece2.setLayoutY(space39.getLayoutY() + (space39.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space39.getLayoutX() + (space39.getWidth() / 2));
                        gamePiece3.setLayoutY(space39.getLayoutY() + (space39.getHeight() / 2));
                    }
                    break;
                case 40:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space40.getLayoutX() + (space40.getWidth() / 2));
                        gamePiece1.setLayoutY(space40.getLayoutY() + (space40.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space40.getLayoutX() + (space40.getWidth() / 2));
                        gamePiece2.setLayoutY(space40.getLayoutY() + (space40.getHeight() / 2));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space40.getLayoutX() + (space40.getWidth() / 2));
                        gamePiece3.setLayoutY(space40.getLayoutY() + (space40.getHeight() / 2));
                    }
                    break;
                case 41:
                    if(ctr == 0){
                        gamePiece1.setLayoutX(space41.getLayoutX() + (space41.getWidth() / 2));
                        gamePiece1.setLayoutY(space41.getLayoutY() + (space41.getHeight() / 2));
                    }
                    else if(ctr == 1) {
                        gamePiece2.setLayoutX(space41.getLayoutX() + (space41.getWidth() / 3));
                        gamePiece2.setLayoutY(space41.getLayoutY() + (space41.getHeight() / 3));
                    }
                    else if(ctr == 2) {
                        gamePiece3.setLayoutX(space41.getLayoutX() + (space41.getWidth() / 4));
                        gamePiece3.setLayoutY(space41.getLayoutY() + (space41.getHeight() / 4));
                    }
                    break;
            }
        }

        if(ctr == 2) {
            ctr -= 2;
        }
        else {
            ctr++;
        }

        rollSpin.setDisable(true);
        drawCard.setDisable(false);
    }

    @FXML
    public void cardDraw() throws Exception{
        //if else ladder can be placed here for space color identification
        //i.e. if space is orange, call openAction, else if, call blueAction etc
        drawCard.setDisable(true);

        openAction();
        openBlue();
        openGreen();
        nextPlayer.setDisable(false);
    }

  //Action card stuff HERE -------------------------------------
  @FXML
  private Label actionLabel;
  @FXML
  private Button actionDraw, actionDone, payPlayer1, payPlayer2, collectPlayer1, collectPlayer2, payBank, collectBank;

  @FXML
  public void openAction() throws Exception{
      Stage actionP = new Stage();
      Parent popCard = FXMLLoader.load(getClass().getResource("View/actionCardPop.fxml"));

      actionP.initStyle(StageStyle.UNDECORATED);
      actionP.initModality(Modality.APPLICATION_MODAL);

      actionP.setScene(new Scene(popCard, 600, 400));
      actionP.setResizable(false);

      actionP.showAndWait();
  }

  public void otherAction(ActionEvent e) {
      if(e.getSource() == actionDraw) {

          //card draw and conditional ladder for different action card types can be set here
          actionDraw.setDisable(true);
          actionDraw.setVisible(false);

          actionLabel.setText("Filed a lawsuit! Sue a motherfucker");

          collectPlayer1.setVisible(true);
          collectPlayer1.setDisable(false);
          collectPlayer2.setVisible(true);
          collectPlayer2.setDisable(false);
      }

      else if(e.getSource() == payPlayer1) {
          actionLabel.setText("You have paid player 1!");

          payPlayer1.setDisable(true);
          payPlayer2.setDisable(true);

          actionDone.setVisible(true);
          actionDone.setDisable(false);
      }
      else if(e.getSource() == payPlayer2) {
          actionLabel.setText("You have paid player 2!");

          payPlayer1.setDisable(true);
          payPlayer2.setDisable(true);

          actionDone.setVisible(true);
          actionDone.setDisable(false);
      }
      else if(e.getSource() == collectPlayer1) {
          actionLabel.setText("You have collected from player 1!");

          collectPlayer1.setDisable(true);
          collectPlayer2.setDisable(true);

          actionDone.setVisible(true);
          actionDone.setDisable(false);
      }
      else if(e.getSource() == collectPlayer2) {
          actionLabel.setText("You have collected from player 2!");

          collectPlayer1.setDisable(true);
          collectPlayer2.setDisable(true);

          actionDone.setVisible(true);
          actionDone.setDisable(false);
      }
      else if(e.getSource() == payBank) {
          actionLabel.setText("You have paid the bank!");

          payBank.setDisable(true);

          actionDone.setVisible(true);
          actionDone.setDisable(false);
      }
      else if(e.getSource() == collectBank) {
          actionLabel.setText("You have collected from the bank!");

          collectBank.setDisable(true);

          actionDone.setVisible(true);
          actionDone.setDisable(false);
      }
  }


  //Blue space stuff HERE-------------------------------------
  @FXML
  private Button blueDone, blueDraw, payPlayer, payBankBlue, collectBankBlue;
  @FXML
  private Label blueLabel;

  @FXML
  public void openBlue() throws Exception{
      Stage blueP = new Stage();
      Parent popCard = FXMLLoader.load(getClass().getResource("View/blueCardPop.fxml"));

      blueP.initStyle(StageStyle.UNDECORATED);
      blueP.initModality(Modality.APPLICATION_MODAL);
      blueP.setScene(new Scene(popCard, 600, 400));
      blueP.setResizable(false);
      blueP.showAndWait();
  }

  public void otherBlue(ActionEvent e) {
      if(e.getSource() == blueDraw) {

          //card draw and conditional ladder can be set here
          blueDraw.setDisable(true);
          blueDraw.setVisible(false);

          blueLabel.setText("Salary Tax Due\n Pay the Tax Collector");

          payPlayer.setText("Pay Enzo");
          payPlayer.setVisible(true);
          payPlayer.setDisable(false);
      }
      else if(e.getSource() == collectBankBlue) {
          blueLabel.setText("It is your career! You get paid");

          collectBankBlue.setDisable(true);

          blueDone.setVisible(true);
          blueDone.setDisable(false);
      }
      else if(e.getSource() == payBankBlue) {
          blueLabel.setText("Nobody has this career. Pay the bank");

          payBankBlue.setDisable(true);

          blueDone.setVisible(true);
          blueDone.setDisable(false);
      }
      else if(e.getSource() == payPlayer) {
          blueLabel.setText("You have paid the player");

          payPlayer.setDisable(true);

          blueDone.setVisible(true);
          blueDone.setDisable(false);
      }
  }


  //Green space stuff here-----------------------------------
  @FXML
  private Label greenLabel;
  @FXML
  private Button greenWhat, greenDone;

  @FXML
  public void openGreen() throws Exception{
      Stage greenP = new Stage();
      Parent popCard = FXMLLoader.load(getClass().getResource("View/greenSpacePop.fxml"));

      greenP.initStyle(StageStyle.UNDECORATED);
      greenP.initModality(Modality.APPLICATION_MODAL);
      greenP.setScene(new Scene(popCard, 600, 400));
      greenP.setResizable(false);
      greenP.showAndWait();
  }

  public void greenAction(ActionEvent e) {
      if(e.getSource() == greenWhat) {
          //if else for the two green space types
          greenLabel.setText("It's PAY DAY!!!");

          greenWhat.setVisible(false);
          greenWhat.setDisable(true);

          greenDone.setVisible(true);
          greenDone.setDisable(false);
      }
  }

    //Get married space stuff HERE -------------------------------
    @FXML
    private Button marryEven, marryOdd, marryRoll, marryCont;
    @FXML
    private Label marryLabel;

    @FXML
    public void getMarried() throws Exception{
        Stage marryP = new Stage();
        Parent marryCard = FXMLLoader.load(getClass().getResource("View/marriedSpacePop.fxml"));

        marryP.initStyle(StageStyle.UNDECORATED);
        marryP.initModality(Modality.APPLICATION_MODAL);
        marryP.setScene(new Scene(marryCard, 600, 400));
        marryP.setResizable(false);
        marryP.showAndWait();
    }

    public void marriageAction(ActionEvent e) {
        int diceRoll;
        marryRoll.setDisable(false);

        if(e.getSource() == marryRoll){
            diceRoll = (int)(Math.random() * (10) + 1);
            marryLabel.setText(Integer.toString(diceRoll));

            if(diceRoll % 2 == 0) {
                marryEven.setDisable(false);
            }
            else {
                marryOdd.setDisable(false);
            }
        }
        else if(e.getSource() == marryOdd){

            //set method to collect money from other players here

            marryOdd.setDisable(true);
            marryRoll.setVisible(false);
            marryCont.setVisible(true);
        }
        else if(e.getSource() == marryEven){

            //set method to collect money from other players here

            marryEven.setDisable(true);
            marryRoll.setVisible(false);
            marryCont.setVisible(true);
        }
    }


    //Job Search stuff HERE -----------------------------------------
    @FXML
    private Button bRetain, bChange, jobDraw, jobDone;
    @FXML
    private Label jobDescription, salaryDescription;

    @FXML
    public void jobHunt() throws Exception{
        Stage jobP = new Stage();
        Parent jobCard = FXMLLoader.load(getClass().getResource("View/jobSearch.fxml"));

        jobP.initStyle(StageStyle.UNDECORATED);
        jobP.initModality(Modality.APPLICATION_MODAL);
        jobP.setScene(new Scene(jobCard, 600, 400));
        jobP.setResizable(false);
        jobP.showAndWait();
    }

    public void huntAction(ActionEvent e) {
        if(e.getSource() == jobDraw) {

            //draw career and salary card method call
            bChange.setDisable(false);
            bRetain.setDisable(false);
        }
        else if(e.getSource() == bRetain){

            //set method to update values here
            bChange.setDisable(true);
            bRetain.setDisable(true);
        }
        else if(e.getSource() == bChange){

            //set method to update values here
            bChange.setDisable(true);
            bRetain.setDisable(true);
        }
        jobDone.setVisible(true);
        jobDone.setDisable(false);
    }
    
    //Buy house space stuff HERE --------------------------------
    @FXML
    private Label mobileHomeLabel, cabinLabel, apartmentLabel, villaLabel, condoLabel;
    @FXML
    private Button bMobileHome, bCabin, bApartment, bVilla, bCondo, houseRoll, houseCont;

    @FXML
    public void buyHouse() throws Exception {
        Stage houseP = new Stage();
        Parent hCard = FXMLLoader.load(getClass().getResource("View/buyHouse.fxml"));

        houseP.initStyle(StageStyle.UNDECORATED);
        houseP.initModality(Modality.APPLICATION_MODAL);
        houseP.setScene(new Scene(hCard, 600, 400));
        houseP.setResizable(false);
        houseP.showAndWait();
    }

    public void houseAction(ActionEvent e) {
        int diceRoll;

        if(e.getSource() == houseRoll) {
            diceRoll = (int)(Math.random() * (10) + 1);

            houseRoll.setDisable(true);
            houseRoll.setVisible(false);

            //if else for odd or even pricing. dont forget setText on the labels

            bMobileHome.setDisable(false);
            bCabin.setDisable(false);
            bApartment.setDisable(false);
            bVilla.setDisable(false);
            bCondo.setDisable(false);
        }
        else if(e.getSource() == bMobileHome) {

            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);
        }
        else if(e.getSource() == bCabin) {

            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);
        }
        else if(e.getSource() == bApartment) {

            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);
        }
        else if(e.getSource() == bVilla) {

            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);
        }
        else if(e.getSource() == bCondo) {

            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);
        }

        houseCont.setVisible(true);
        houseCont.setDisable(false);
    }

    //Path selection space stuff HERE ---------------------------
    @FXML
    private Label forkLabel;
    @FXML
    private Button careerChange, continuePath, forkContinue;

    @FXML
    public void chooseAgain() throws Exception {
        Stage chooseP = new Stage();
        Parent chooseCard = FXMLLoader.load(getClass().getResource("View/secondFork.fxml"));

        chooseP.initStyle(StageStyle.UNDECORATED);
        chooseP.initModality(Modality.APPLICATION_MODAL);
        chooseP.setScene(new Scene(chooseCard, 600, 400));
        chooseP.setResizable(false);
        chooseP.showAndWait();
    }

    public void chosenAction(ActionEvent e) {
        if(e.getSource() == careerChange) {

            //position update on game piece here
            forkLabel.setText("Your new career is Engineer!\nSalary: 90000");
            careerChange.setVisible(false);
            careerChange.setDisable(true);
            continuePath.setVisible(false);
            continuePath.setDisable(true);
        }
        else if(e.getSource() == continuePath) {

            //position update on game piece here
            forkLabel.setText("So I guess it's time to start a family huh");
            careerChange.setVisible(false);
            careerChange.setDisable(true);
            continuePath.setVisible(false);
            continuePath.setDisable(true);
        }
        forkContinue.setVisible(true);
        forkContinue.setDisable(false);
    }

    public void closeAction(ActionEvent e) {
        Stage actionP = (Stage)((Node)e.getSource()).getScene().getWindow();
        actionP.close();
    }

    //College choice stuff HERE --------------------------------
    @FXML
    private Label jobLabel1, jobLabel2, wageLabel1, wageLabel2;
    @FXML
    private Button career1, career2, salary1, salary2, showThem, collegeCont;

    @FXML
    public void chooseCareer() throws Exception {
        Stage pickP = new Stage();
        Parent pickCard = FXMLLoader.load(getClass().getResource("View/collegeChoice.fxml"));

        pickP.initStyle(StageStyle.UNDECORATED);
        pickP.initModality(Modality.APPLICATION_MODAL);
        pickP.setScene(new Scene(pickCard, 600, 400));
        pickP.setResizable(false);
        pickP.showAndWait();
    }

    public void careerAction(ActionEvent e) {
        if(e.getSource() == showThem) {
            //update label text
            showThem.setVisible(false);

            career1.setVisible(true);
            career2.setVisible(true);
            salary1.setVisible(true);
            salary2.setVisible(true);
        }
        else if(e.getSource() == career1) {
            career1.setDisable(true);
            career2.setDisable(true);
        }
        else if(e.getSource() == career2) {
            career1.setDisable(true);
            career2.setDisable(true);
        }
        else if(e.getSource() == salary1) {
            salary1.setDisable(true);
            salary2.setDisable(true);
        }
        else if(e.getSource() == salary2) {
            salary1.setDisable(true);
            salary2.setDisable(true);
        }
        collegeCont.setVisible(true);
    }

    //Winner screen stuff HERE --------------------------------
    @FXML
    private Label winnerName, winnerCash, winnerMarriage, winnerKids;
    @FXML
    private Button winnerWinner, winnerDone;

    @FXML
    public void displayWinner() throws Exception {
        Stage winnerP = new Stage();
        Parent winnerCard = FXMLLoader.load(getClass().getResource("View/winnerPop.fxml"));

        winnerP.initStyle(StageStyle.UNDECORATED);
        winnerP.initModality(Modality.APPLICATION_MODAL);
        winnerP.setScene(new Scene(winnerCard, 600, 400));
        winnerP.setResizable(false);
        winnerP.showAndWait();
    }

    public void winnerStats(ActionEvent e) {
        if(e.getSource() == winnerWinner) {
            winnerName.setText("Player Name: *insert here*");
            winnerCash.setText("Cash Remaining: $999999");
            winnerMarriage.setText("Got Married? : Yes");
            winnerKids.setText("Children: 2");

            winnerWinner.setVisible(false);
            winnerDone.setVisible(true);
        }
    }    
        
    @FXML
    public void nextTurn() {
        //update counter here
        //if else to loop back if last player

        rollSpin.setDisable(false);
        nextPlayer.setDisable(true);
    }

    //Have a baby stuff HERE ------------------------------------
    @FXML
    private Label babyLabel;
    @FXML
    private Button babyRoll, babyCollect, babyCont;

    @FXML
    public void getBaby() throws Exception {
        Stage babyP = new Stage();
        Parent babyCard = FXMLLoader.load(getClass().getResource("View/haveBaby.fxml"));

        babyP.initStyle(StageStyle.UNDECORATED);
        babyP.initModality(Modality.APPLICATION_MODAL);
        babyP.setScene(new Scene(babyCard, 600, 400));
        babyP.setResizable(false);
        babyP.showAndWait();
    }

    public void babyAction(ActionEvent e) {
        int diceRoll;

        if(e.getSource() == babyRoll) {
            diceRoll = (int)(Math.random() * (2-1+1) + 1);

            babyRoll.setDisable(true);
            babyRoll.setVisible(false);

            switch(diceRoll) {
                case 1:
                    babyLabel.setText("Congratulations!\nCollect $5000 from other players!");
                    babyCollect.setText("Collect $5000");
                    babyCollect.setDisable(false);
                    break;
                case 2:
                    babyLabel.setText("TWINS!\nCollect $10000 from other players!");
                    babyCollect.setText("Collect $10000");
                    babyCollect.setDisable(false);
                    break;
            }
        }
        else if(e.getSource() == babyCollect) {
            //update money here
            babyCollect.setDisable(true);
            babyCollect.setVisible(false);
        }
        babyCont.setVisible(true);
        babyCont.setDisable(false);
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
        Parent editView = FXMLLoader.load(getClass().getResource("View/editableAttributes.fxml"));

        Scene editScene = new Scene(editView);
        editStage.setScene(editScene);
        editStage.show();
    }

    @FXML
    public void noEdit() throws Exception {
        Stage doneStage = (Stage)editBack.getScene().getWindow();
        Parent doneView = FXMLLoader.load(getClass().getResource("View/editMenu.fxml"));

        Scene doneScene = new Scene(doneView);
        doneStage.setScene(doneScene);
        doneStage.show();
    }

    @FXML
    public void editDone() throws Exception {

        model.setStarterCash((int)cashSlider.getValue());
        model.setNumCareer((int)ccSlider.getValue());
        model.setNumSalary((int)scSlider.getValue());
        model.setNumAction((int)acSlider.getValue());
        System.out.println("Starter cash set to: " + model.getStarterCash());
        System.out.println("Career Deck set to: " + model.getNumCareer());
        System.out.println("Salary Deck set to: " + model.getNumSalary());
        System.out.println("Action Deck set to:  " + model.getNumAction());

        Stage doneStage = (Stage)editSave.getScene().getWindow();
        Parent doneView = FXMLLoader.load(getClass().getResource("View/editMenu.fxml"));

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