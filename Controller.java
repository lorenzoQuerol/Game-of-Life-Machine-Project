import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Model model = Model.getInstance();

    /*
        ----------Main menu controllers-----------
    */

    @FXML
    private Button optionsMenu, playGame;

    @FXML
    public void handlePlay() throws Exception {
        Stage playerStage = (Stage) playGame.getScene().getWindow();
        Parent playerView = FXMLLoader.load(getClass().getResource("View/playerChoose.fxml"));

        Scene playerScene = new Scene(playerView);
        playerStage.setScene(playerScene);
        playerStage.show();
    }

    @FXML
    public void handleOptions() throws Exception {
        Stage optionStage = (Stage) optionsMenu.getScene().getWindow();
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
    private TextField textFieldP1, textFieldP2, textFieldP3;

    @FXML
    public void twoPlayerGame() throws Exception {

        model.setNumPlayers(2);
        System.out.println("Players set to: " + model.getNumPlayers());

        for (int i = 0; i < model.getNumPlayers(); i++)
            model.getB().getPlayers().add(new Player(model.getStarterCash()));

        Stage twoP = (Stage) player2.getScene().getWindow();
        Parent twoView = FXMLLoader.load(getClass().getResource("View/twoPlayers.fxml"));

        Scene twoScene = new Scene(twoView);
        twoP.setScene(twoScene);
        twoP.show();
    }

    @FXML
    public void threePlayerGame() throws Exception {

        model.setNumPlayers(3);
        System.out.println("Players set to: " + model.getNumPlayers());

        for (int i = 0; i < model.getNumPlayers(); i++)
            model.getB().getPlayers().add(new Player(model.getStarterCash()));

        Stage threeP = (Stage) player3.getScene().getWindow();
        Parent threeView = FXMLLoader.load(getClass().getResource("View/threePlayers.fxml"));

        Scene threeScene = new Scene(threeView);
        threeP.setScene(threeScene);
        threeP.show();
    }

    @FXML
    public void playerReturn() throws Exception {

        Stage pReturn = (Stage) playerBack.getScene().getWindow();
        Parent pRView = FXMLLoader.load(getClass().getResource("View/mainMenu.fxml"));

        Scene pRScene = new Scene(pRView);
        pReturn.setScene(pRScene);
        pReturn.show();
    }

    /*
        ------------Start Game controllers---------
    */

    @FXML
    private Button startGame, P1_mainPath, P1_careerPath, P2_mainPath, P2_careerPath, P3_mainPath, P3_careerPath;

    @FXML
    public void gameStart() throws Exception {

        model.getB().initializeData(model.getNumAction(), model.getNumCareer(), model.getNumSalary(), 0, 0);
        model.getB().getPlayers().get(0).setName(textFieldP1.getText());
        model.getB().getPlayers().get(1).setName(textFieldP2.getText());

        if (model.getNumPlayers() == 3)
            model.getB().getPlayers().get(2).setName(textFieldP3.getText());

        Stage startStage = (Stage) startGame.getScene().getWindow();
        Parent startView = FXMLLoader.load(getClass().getResource("View/playerPath1.fxml"));
        Scene startScene = new Scene(startView);
        startStage.setScene(startScene);
        startStage.show();
    }

    @FXML
    public void secondPlayer(ActionEvent event) throws Exception {

        if (event.getSource().equals(P1_mainPath))
            model.getB().getPlayers().get(0).setCurrentPath("mainPath");
        else if (event.getSource().equals(P1_careerPath))
            model.getB().getPlayers().get(0).setCurrentPath("CareerPath");

        Stage boardStage = (Stage) P1_mainPath.getScene().getWindow();
        Parent boardView = FXMLLoader.load(getClass().getResource("View/playerPath2.fxml"));
        Scene boardScene = new Scene(boardView);
        boardStage.setScene(boardScene);
        boardStage.show();
    }

    @FXML
    public void countPlayers(ActionEvent event) throws Exception {
        if (model.getNumPlayers() == 2)
            displayBoard(event);
        else
            thirdPlayer(event);
    }

    @FXML
    public void thirdPlayer(ActionEvent event) throws Exception {

        if (event.getSource().equals(P2_mainPath))
            model.getB().getPlayers().get(1).setCurrentPath("mainPath");
        else if (event.getSource().equals(P2_careerPath))
            model.getB().getPlayers().get(1).setCurrentPath("CareerPath");

        Stage boardStage = (Stage) P2_mainPath.getScene().getWindow();
        Parent boardView = FXMLLoader.load(getClass().getResource("View/playerPath3.fxml"));
        Scene boardScene = new Scene(boardView);
        boardStage.setScene(boardScene);
        boardStage.show();
    }

    @FXML
    public void displayBoard(ActionEvent event) throws Exception {

        if (event.getSource().equals(P2_mainPath))
            model.getB().getPlayers().get(1).setCurrentPath("mainPath");
        else if (event.getSource().equals(P2_careerPath))
            model.getB().getPlayers().get(1).setCurrentPath("CareerPath");

        System.out.println(model.getB().getPlayers().get(0).getName() + " : " + model.getB().getPlayers().get(0).getCurrentPath());
        System.out.println(model.getB().getPlayers().get(1).getName() + " : " + model.getB().getPlayers().get(1).getCurrentPath());

        Stage boardStage = (Stage) P2_mainPath.getScene().getWindow();
        Parent boardView = FXMLLoader.load(getClass().getResource("View/gameBoard.fxml"));

        Scene boardScene = new Scene(boardView);
        boardStage.setScene(boardScene);
        boardStage.show();
    }

    // this accepts from third player
    @FXML
    public void copy_displayBoard(ActionEvent event) throws Exception {

        if (event.getSource().equals(P3_mainPath))
            model.getB().getPlayers().get(2).setCurrentPath("mainPath");
        else if (event.getSource().equals(P3_careerPath))
            model.getB().getPlayers().get(2).setCurrentPath("CareerPath");

        System.out.println(model.getB().getPlayers().get(0).getName() + " : " + model.getB().getPlayers().get(0).getCurrentPath());
        System.out.println(model.getB().getPlayers().get(1).getName() + " : " + model.getB().getPlayers().get(1).getCurrentPath());
        System.out.println(model.getB().getPlayers().get(2).getName() + " : " + model.getB().getPlayers().get(2).getCurrentPath());

        Stage boardStage = (Stage) P3_mainPath.getScene().getWindow();
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
    public void rollDice(ActionEvent event) {
        int diceRoll;
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        ActionDeck actionDeck = model.getB().getActionDeck();
        BlueDeck blueDeck = model.getB().getBlueDeck();
        CareerDeck careerDeck = model.getB().getCareerDeck();
        SalaryDeck salaryDeck = model.getB().getSalaryDeck();
        HouseDeck houseDeck = model.getB().getHouseDeck();

        nameLabel.setText(players.get(counter).getName());
        moneyLabel.setText(Integer.toString(players.get(counter).getCash()));

        diceRoll = players.get(counter).spin();
        diceLabel.setText(Integer.toString(diceRoll));

        rollSpin.setDisable(true);
        drawCard.setDisable(false);

        //should contain move instructions for pieces
        players.get(counter).setSpaceType(model.getB().takeTurn(players.get(counter), diceRoll, event, actionDeck, careerDeck, blueDeck, salaryDeck, houseDeck));
    }

    @FXML
    public void cardDraw() throws Exception {

        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        int space = players.get(counter).getSpace();

        //if else ladder can be placed here for space color identification
        //i.e. if space is orange, call openAction, else if, call blueAction etc
        drawCard.setDisable(true);

        switch (model.getB().checkSpace(players.get(counter))) {
            case "orange":
                openAction();
                break;
            case "blue":
                openBlue();
                break;
            case "green":
                openGreen();
                break;
        }
        nextPlayer.setDisable(false);
    }

  /*
        Action Card Controllers
  */

    @FXML
    private Label actionLabel;
    @FXML
    private Button actionDraw, payPlayer1, payPlayer2, collectPlayer1, collectPlayer2, payBank, collectBank;

    @FXML // FUNCTIONAL
    public void openAction() throws Exception {
        Stage actionP = new Stage();
        Parent popCard = FXMLLoader.load(getClass().getResource("View/actionCardPop.fxml"));

        actionP.initStyle(StageStyle.UNDECORATED);
        actionP.initModality(Modality.APPLICATION_MODAL);

        actionP.setScene(new Scene(popCard, 600, 400));
        actionP.setResizable(false);

        actionP.showAndWait();
    }

    @FXML // FUNCTIONAL
    public void otherAction(ActionEvent event) {
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        ActionCard actionCard = b.getActionDeck().getDeck().peek();
        System.out.println(actionCard);

        if (event.getSource() == actionDraw) {
            actionDraw.setVisible(false);
            switch (actionCard.getName()) {
                    case "Collect From Bank":
                        actionLabel.setText(actionCard.getName());
                        collectBank.setVisible(true);
                        collectBank.setDisable(false);

                        collectBank.setVisible(false);
                        collectBank.setDisable(true);

                        players.get(counter).receiveActionCard(players.get(counter), b.getActionDeck().drawCard(), players);
                        actionLabel.setText(actionCard.getActionType() + "! Collect $" + actionCard.getPayAmount());
                        actionDone.setVisible(true);
                        actionDone.setDisable(false);
                        break;

                    case "Pay the Bank":
                        actionLabel.setText(actionCard.getName());
                        payBank.setVisible(true);
                        payBank.setDisable(false);

                        payBank.setVisible(false);
                        payBank.setDisable(true);

                        players.get(counter).receiveActionCard(players.get(counter), b.getActionDeck().drawCard(), players);
                        actionLabel.setText(actionCard.getActionType() + "! Pay $" + (-1 * actionCard.getPayAmount()));
                        actionDone.setVisible(true);
                        actionDone.setDisable(false);
                        break;

                    case "Collect from Player":
                    case "Pay the Player":
                        if (model.getNumPlayers() == 2) {
                            if (b.getCounter() == 0) {
                                collectPlayer1.setVisible(false);
                                collectPlayer1.setDisable(true);
                                collectPlayer2.setVisible(true);
                                collectPlayer2.setDisable(false);
                            } else {
                                collectPlayer1.setVisible(true);
                                collectPlayer1.setDisable(false);
                                collectPlayer2.setVisible(false);
                                collectPlayer2.setDisable(true);
                            }
                        } else {
                                collectPlayer1.setVisible(true);
                                collectPlayer1.setDisable(false);
                                collectPlayer2.setVisible(true);
                                collectPlayer2.setDisable(false);
                                actionDone.setVisible(false);
                                actionDone.setDisable(true);
                        }
            }

        } else {
            actionLabel.setText(actionCard.getName());
            if (model.getNumPlayers() == 2) {
                if (event.getSource().equals(collectPlayer1) || event.getSource().equals(collectPlayer2)) {
                    players.get(counter).receiveActionCard(players.get(counter), b.getActionDeck().drawCard(), players);
                    if (b.getCounter() == 0 && actionCard.getName() == "Collect from Player") {
                        if (b.getCounter() == 0) {
                            actionLabel.setText("You have collected " + actionCard.getPayAmount() + " from " + players.get(1).getName() + "!");
                        } else {
                            actionLabel.setText("You have collected " + actionCard.getPayAmount() + " from " + players.get(0).getName() + "!");
                        }
                    } else {
                        if (b.getCounter() == 0) {
                            actionLabel.setText("You have paid " + (actionCard.getPayAmount() * -1) + " to " + players.get(1).getName() + "!");
                        } else {
                            actionLabel.setText("You have paid " + (actionCard.getPayAmount() * -1) + " to " + players.get(0).getName() + "!");
                        }
                    }

                    collectPlayer1.setDisable(true);
                    actionDone.setVisible(true);
                    actionDone.setDisable(false);
                }
            } else {
                switch (b.getCounter()) {
                    case 0:
                        if (event.getSource().equals(collectPlayer1)) {
                            players.get(counter).receiveActionCard(players.get(1), b.getActionDeck().drawCard(), players);
                            if (actionCard.getName() == "Collect from Player")
                                actionLabel.setText("You have collected " + actionCard.getPayAmount() + " from " + players.get(1).getName() + "!");
                            else
                                actionLabel.setText("You have paid " + (actionCard.getPayAmount() * -1) + " to " + players.get(1).getName() + "!");
                            collectPlayer1.setVisible(false);
                            collectPlayer2.setVisible(false);
                            actionDone.setVisible(true);
                            actionDone.setDisable(false);
                        } else if (event.getSource().equals(collectPlayer2)) {
                            players.get(counter).receiveActionCard(players.get(2), b.getActionDeck().drawCard(), players);
                            if (actionCard.getName() == "Collect from Player")
                                actionLabel.setText("You have collected " + actionCard.getPayAmount()  + " from " + players.get(1).getName() + "!");
                            else
                                actionLabel.setText("You have paid " + (actionCard.getPayAmount() * -1) + " to " + players.get(1).getName() + "!");
                            collectPlayer1.setVisible(false);
                            collectPlayer2.setVisible(false);
                            actionDone.setVisible(true);
                            actionDone.setDisable(false);
                        }
                        break;
                    case 1:
                        if (event.getSource().equals(collectPlayer1)) {
                            players.get(counter).receiveActionCard(players.get(0), b.getActionDeck().drawCard(), players);
                            if (actionCard.getName() == "Collect from Player")
                                actionLabel.setText("You have collected " + actionCard.getPayAmount() + " from " + players.get(1).getName() + "!");
                            else
                                actionLabel.setText("You have paid " + (actionCard.getPayAmount() * -1) + " to " + players.get(1).getName() + "!");
                            collectPlayer1.setVisible(false);
                            collectPlayer2.setVisible(false);
                            actionDone.setVisible(true);
                            actionDone.setDisable(false);
                        } else if (event.getSource().equals(collectPlayer2)) {
                            players.get(counter).receiveActionCard(players.get(2), b.getActionDeck().drawCard(), players);
                            if (actionCard.getName() == "Collect from Player")
                                actionLabel.setText("You have collected " + actionCard.getPayAmount() + " from " + players.get(1).getName() + "!");
                            else
                                actionLabel.setText("You have paid " + (actionCard.getPayAmount() * -1) + " to " + players.get(1).getName() + "!");
                            collectPlayer1.setVisible(false);
                            collectPlayer2.setVisible(false);
                            actionDone.setVisible(true);
                            actionDone.setDisable(false);
                        }
                        break;
                    case 2:
                        if (event.getSource().equals(collectPlayer1)) {
                            players.get(counter).receiveActionCard(players.get(0), b.getActionDeck().drawCard(), players);
                            if (actionCard.getName() == "Collect from Player")
                                actionLabel.setText("You have collected " + actionCard.getPayAmount() + " from " + players.get(1).getName() + "!");
                            else
                                actionLabel.setText("You have paid " + actionCard.getPayAmount() + " to " + players.get(1).getName() + "!");
                            collectPlayer1.setVisible(false);
                            collectPlayer2.setVisible(false);
                            actionDone.setVisible(true);
                            actionDone.setDisable(false);
                        } else if (event.getSource().equals(collectPlayer2)) {
                            players.get(counter).receiveActionCard(players.get(1), b.getActionDeck().drawCard(), players);
                            if (actionCard.getName() == "Collect from Player")
                                actionLabel.setText("You have collected " + actionCard.getPayAmount() + " from " + players.get(1).getName() + "!");
                            else
                                actionLabel.setText("You have paid " + actionCard.getPayAmount() + " to " + players.get(1).getName() + "!");
                            collectPlayer1.setVisible(false);
                            collectPlayer2.setVisible(false);
                            actionDone.setVisible(true);
                            actionDone.setDisable(false);
                        }
                        break;
                }
            }
        }
    }

    /*
          Blue Card Controllers
    */
    @FXML
    private Button blueDone, blueDraw, payPlayer, payBankBlue, collectBankBlue;
    @FXML
    private Label blueLabel;

    @FXML
    public void openBlue() throws Exception {
        Stage blueP = new Stage();
        Parent popCard = FXMLLoader.load(getClass().getResource("View/blueCardPop.fxml"));

        blueP.initStyle(StageStyle.UNDECORATED);
        blueP.initModality(Modality.APPLICATION_MODAL);
        blueP.setScene(new Scene(popCard, 600, 400));
        blueP.setResizable(false);
        blueP.showAndWait();
    }

    public void otherBlue(ActionEvent e) {
        if (e.getSource() == blueDraw) {

            //card draw and conditional ladder can be set here
            blueDraw.setDisable(true);
            blueDraw.setVisible(false);

            blueLabel.setText("Salary Tax Due\n Pay the Tax Collector");

            payPlayer.setText("Pay Enzo");
            payPlayer.setVisible(true);
            payPlayer.setDisable(false);
        } else if (e.getSource() == collectBankBlue) {
            blueLabel.setText("It is your career! You get paid");

            collectBankBlue.setDisable(true);

            blueDone.setVisible(true);
            blueDone.setDisable(false);
        } else if (e.getSource() == payBankBlue) {
            blueLabel.setText("Nobody has this career. Pay the bank");

            payBankBlue.setDisable(true);

            blueDone.setVisible(true);
            blueDone.setDisable(false);
        } else if (e.getSource() == payPlayer) {
            blueLabel.setText("You have paid the player");

            payPlayer.setDisable(true);

            blueDone.setVisible(true);
            blueDone.setDisable(false);
        }
    }


    /*
          Green Card Controllers
    */
    @FXML
    private Label greenLabel;
    @FXML
    private Button greenWhat, greenDone;

    @FXML
    public void openGreen() throws Exception {
        Stage greenP = new Stage();
        Parent popCard = FXMLLoader.load(getClass().getResource("View/greenSpacePop.fxml"));

        greenP.initStyle(StageStyle.UNDECORATED);
        greenP.initModality(Modality.APPLICATION_MODAL);
        greenP.setScene(new Scene(popCard, 600, 400));
        greenP.setResizable(false);
        greenP.showAndWait();
    }

    public void greenAction(ActionEvent e) {
        if (e.getSource() == greenWhat) {

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
    public void getMarried() throws Exception {
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

        if (e.getSource() == marryRoll) {
            diceRoll = (int) (Math.random() * (10) + 1);
            marryLabel.setText(Integer.toString(diceRoll));

            if (diceRoll % 2 == 0) {
                marryEven.setDisable(false);
            } else {
                marryOdd.setDisable(false);
            }
        } else if (e.getSource() == marryOdd) {

            //set method to collect money from other players here

            marryOdd.setDisable(true);
            marryRoll.setVisible(false);
            marryCont.setVisible(true);
        } else if (e.getSource() == marryEven) {

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
    public void jobHunt() throws Exception {
        Stage jobP = new Stage();
        Parent jobCard = FXMLLoader.load(getClass().getResource("View/jobSearch.fxml"));

        jobP.initStyle(StageStyle.UNDECORATED);
        jobP.initModality(Modality.APPLICATION_MODAL);
        jobP.setScene(new Scene(jobCard, 600, 400));
        jobP.setResizable(false);
        jobP.showAndWait();
    }

    public void huntAction(ActionEvent e) {
        if (e.getSource() == jobDraw) {

            //draw career and salary card method call
            bChange.setDisable(false);
            bRetain.setDisable(false);
        } else if (e.getSource() == bRetain) {

            //set method to update values here
            bChange.setDisable(true);
            bRetain.setDisable(true);
        } else if (e.getSource() == bChange) {

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

        if (e.getSource() == houseRoll) {
            diceRoll = (int) (Math.random() * (10) + 1);

            houseRoll.setDisable(true);
            houseRoll.setVisible(false);

            //if else for odd or even pricing. dont forget setText on the labels

            bMobileHome.setDisable(false);
            bCabin.setDisable(false);
            bApartment.setDisable(false);
            bVilla.setDisable(false);
            bCondo.setDisable(false);
        } else if (e.getSource() == bMobileHome) {

            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);
        } else if (e.getSource() == bCabin) {

            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);
        } else if (e.getSource() == bApartment) {

            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);
        } else if (e.getSource() == bVilla) {

            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);
        } else if (e.getSource() == bCondo) {

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

    @FXML
    public void chosenAction(ActionEvent e) {
        if (e.getSource() == careerChange) {

            //position update on game piece here
            forkLabel.setText("Your new career is Engineer!\nSalary: 90000");
            careerChange.setVisible(false);
            careerChange.setDisable(true);
            continuePath.setVisible(false);
            continuePath.setDisable(true);
        } else if (e.getSource() == continuePath) {

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

    @FXML //FUNCTIONAL
    public void closeAction(ActionEvent e) {
        Stage actionP = (Stage) ((Node) e.getSource()).getScene().getWindow();
        actionP.close();
    }

    @FXML // FUNCTIONAL
    public void nextTurn() {

        if (model.getNumPlayers() == 2) {
            if (model.getB().getCounter() == 1) {
                model.getB().setCounter(0);
                nameLabel.setText(model.getB().getPlayers().get(model.getB().getCounter()).getName());
                moneyLabel.setText(Integer.toString(model.getB().getPlayers().get(model.getB().getCounter()).getCash()));
            } else {
                model.getB().setCounter(model.getB().getCounter() + 1);
                nameLabel.setText(model.getB().getPlayers().get(model.getB().getCounter()).getName());
                moneyLabel.setText(Integer.toString(model.getB().getPlayers().get(model.getB().getCounter()).getCash()));
            }

        } else if (model.getNumPlayers() == 3) {
            if (model.getB().getCounter() == 2) {
                model.getB().setCounter(0);
                nameLabel.setText(model.getB().getPlayers().get(model.getB().getCounter()).getName());
                moneyLabel.setText(Integer.toString(model.getB().getPlayers().get(model.getB().getCounter()).getCash()));
            } else {
                model.getB().setCounter(model.getB().getCounter() + 1);
                nameLabel.setText(model.getB().getPlayers().get(model.getB().getCounter()).getName());
                moneyLabel.setText(Integer.toString(model.getB().getPlayers().get(model.getB().getCounter()).getCash()));
            }
        }

        rollSpin.setDisable(false);
        nextPlayer.setDisable(true);
    }
    
    /*
        Options Controllers (FUNCTIONAL)
    */

    @FXML
    private Button editBack, editAtt, editSave;
    @FXML
    private Label acLabel, scLabel, ccLabel, cashLabel;
    @FXML
    private Slider acSlider, scSlider, ccSlider, cashSlider;

    @FXML
    public void adjustActionDeck() {
        acLabel.setText(Integer.toString((int) acSlider.getValue()));
    }

    @FXML
    public void adjustSalaryDeck() {
        scLabel.setText(Integer.toString((int) scSlider.getValue()));
    }

    @FXML
    public void adjustCareerDeck() {
        ccLabel.setText(Integer.toString((int) ccSlider.getValue()));
    }

    @FXML
    public void adjustCash() {
        cashLabel.setText(Integer.toString((int) cashSlider.getValue()));
    }

    @FXML
    public void editAttributes() throws Exception {

        Stage editStage = (Stage) editAtt.getScene().getWindow();
        Parent editView = FXMLLoader.load(getClass().getResource("View/editableAttributes.fxml"));

        Scene editScene = new Scene(editView);
        editStage.setScene(editScene);
        editStage.show();
    }

    @FXML
    public void noEdit() throws Exception {
        Stage doneStage = (Stage) editBack.getScene().getWindow();
        Parent doneView = FXMLLoader.load(getClass().getResource("View/editMenu.fxml"));

        Scene doneScene = new Scene(doneView);
        doneStage.setScene(doneScene);
        doneStage.show();
    }

    @FXML
    public void editDone() throws Exception {

        model.setStarterCash((int) cashSlider.getValue());
        model.setNumCareer((int) ccSlider.getValue());
        model.setNumSalary((int) scSlider.getValue());
        model.setNumAction((int) acSlider.getValue());
        System.out.println("Starter cash set to: " + model.getStarterCash());
        System.out.println("Career Deck set to: " + model.getNumCareer());
        System.out.println("Salary Deck set to: " + model.getNumSalary());
        System.out.println("Action Deck set to:  " + model.getNumAction());

        Stage doneStage = (Stage) editSave.getScene().getWindow();
        Parent doneView = FXMLLoader.load(getClass().getResource("View/editMenu.fxml"));

        Scene doneScene = new Scene(doneView);
        doneStage.setScene(doneScene);
        doneStage.show();
    }

    @FXML
    public void optionReturn() throws Exception {
        Stage returnStage = (Stage) editBack.getScene().getWindow();
        Parent returnView = FXMLLoader.load(getClass().getResource("View/mainMenu.fxml"));

        Scene returnScene = new Scene(returnView);
        returnStage.setScene(returnScene);
        returnStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}