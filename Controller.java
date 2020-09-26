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

    @FXML private Button startGame, player1p, player2p, P3_player2p, player3p;
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
    public void secondPlayer() throws Exception {
        Parent boardView;
        Stage boardStage = (Stage)player1p.getScene().getWindow();
        boardView = FXMLLoader.load(getClass().getResource("View/playerPath2.fxml"));
        Scene boardScene = new Scene(boardView);
        boardStage.setScene(boardScene);
        boardStage.show();
    }

    @FXML
    public void thirdPlayer() throws Exception {
        Stage boardStage = (Stage)player2p.getScene().getWindow();
        Parent boardView = FXMLLoader.load(getClass().getResource("View/playerPath3.fxml"));

        Scene boardScene = new Scene(boardView);
        boardStage.setScene(boardScene);
        boardStage.show();
    }

    @FXML
    public void displayBoard() throws Exception {
        Stage boardStage = (Stage)player2p.getScene().getWindow();
        Parent boardView = FXMLLoader.load(getClass().getResource("View/gameBoard.fxml"));

        Scene boardScene = new Scene(boardView);
        boardStage.setScene(boardScene);
        boardStage.show();
    }

    /*
        ------------Board proper controllers------------
    */

    @FXML
    private Label diceLabel, nameLabel, moneyLabel, jobLabel, salaryLabel, houseLabel;
    @FXML
    private Button rollSpin, nextPlayer, drawCard, actionDone;

    @FXML
    public void rollDice() {
        int diceRoll;

        diceRoll = (int)(Math.random() * (10) + 1);
        diceLabel.setText(Integer.toString(diceRoll));

        rollSpin.setDisable(true);
        drawCard.setDisable(false);

        //should contain move instructions for pieces
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