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
        Main Menu Controllers (DONE)
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
        Player Selection Controllers (DONE)
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
        Start Game Controllers (DONE)
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
        Board proper controllers (DONE)
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
            case "magenta":

                break;
        }
        nextPlayer.setDisable(false);
    }

  /*
        Action Card Controllers (DONE)
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
          Blue Card Controllers (DONE)
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
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        BlueCard blueCard = b.getBlueDeck().getDeck().peek();
        System.out.println(blueCard);
        String result = checkBlueCard(players.get(counter), blueCard, players);
        if (e.getSource() == blueDraw) {
            //card draw and conditional ladder can be set here
            blueDraw.setVisible(false);
            blueDraw.setDisable(true);
            switch (result) {
                case "hasBlueCard":
                    collectBankBlue.setVisible(true);
                    collectBankBlue.setDisable(false);
                    break;
                case "noOne":
                    payBankBlue.setVisible(true);
                    payBankBlue.setDisable(false);
                    break;

                default:
                    payPlayer.setVisible(true);
                    payPlayer.setDisable(false);
            }
        } else if (e.getSource() == collectBankBlue) {
            blueLabel.setText("It is your career! You get $15000!");
            players.get(counter).receiveBlueCard(b.getBlueDeck().drawCard(), players);
            collectBankBlue.setDisable(true);

            blueDone.setVisible(true);
            blueDone.setDisable(false);
        } else if (e.getSource() == payBankBlue) {
            blueLabel.setText("Nobody has this career. Pay the bank $15000!");
            players.get(counter).receiveBlueCard(b.getBlueDeck().drawCard(), players);
            payBankBlue.setDisable(true);

            blueDone.setVisible(true);
            blueDone.setDisable(false);
        } else if (e.getSource() == payPlayer) {
            blueLabel.setText("You have paid " + result + " $15000!");
            players.get(counter).receiveBlueCard(b.getBlueDeck().drawCard(), players);
            payPlayer.setDisable(true);

            blueDone.setVisible(true);
            blueDone.setDisable(false);
        }
    }

    @FXML
    public String checkBlueCard (Player p, BlueCard b, ArrayList<Player> players){

        // case 1: player's career matches blue card
        if (b.getCareerLink() == p.getCareerCard().getName())
            return "hasBlueCard";

        // case 2: blue card matches another player's career
        for (Player x : players) {
            if (x.getCareerCard().getName() == b.getCareerLink()){
                return x.getName();
            }
        }

        // case 3: nobody's career in the game matches the blue card
        return "noOne";
    }

    /*
          Green Card Controllers (DONE)
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
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        if (e.getSource() == greenWhat) {
            switch (players.get(counter).getCurrentPath()) {
                case "mainPath":
                    if (players.get(counter).getSpace() == 17 || players.get(counter).getSpace() == 35)  {
                        greenLabel.setText("Pay Day! You received your salary of $" + players.get(counter).getSalaryCard().computeSalary() + "!");
                        players.get(counter).receiveSalary();
                    } else if (players.get(counter).getSpace() == 29) {
                        players.get(counter).receivePayRaise();
                        greenLabel.setText("You get a pay raise! Your new salary is $" + players.get(counter).getSalaryCard().computeSalary() + "! (Tax included)");
                    }
                    break;

                case "careerPath":
                    if (players.get(counter).getSpace() == 8) {
                        greenLabel.setText("Pay Day! You received your salary of $" + players.get(counter).getSalaryCard().computeSalary() + "!");
                        players.get(counter).receiveSalary();
                    } else if (players.get(counter).getSpace() == 3) {
                        players.get(counter).receivePayRaise();
                        greenLabel.setText("You get a pay raise! Your new salary is $" + players.get(counter).getSalaryCard().computeSalary() + "! (Tax included)");
                    }
                    break;

                case "changeCareerPath":
                    if (players.get(counter).getSpace() == 3) {
                        greenLabel.setText("Pay Day! You received your salary of $" + players.get(counter).getSalaryCard().computeSalary() + "!");
                        players.get(counter).receiveSalary();
                    }
                    break;
            }

            greenWhat.setVisible(false);
            greenWhat.setDisable(true);

            greenDone.setVisible(true);
            greenDone.setDisable(false);
        }
    }

    /*
        Get Married Controllers (DONE)
     */
    @FXML
    private Button marryEven, marryOdd, marryRoll, marryCont;
    @FXML
    private Label marryLabel;

    @FXML // NOTE: This will be called when player lands on magenta space
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
        int diceRoll = 0;
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        marryRoll.setDisable(false);

        if (e.getSource() == marryRoll) {
            diceRoll = players.get(counter).spin();
            marryLabel.setText(Integer.toString(diceRoll));

            if (diceRoll % 2 == 0) {
                marryEven.setDisable(false);
            } else {
                marryOdd.setDisable(false);
            }
        } else if (e.getSource() == marryOdd) {

            players.get(counter).marry(diceRoll, players);
            marryOdd.setDisable(true);
            marryRoll.setVisible(false);
            marryCont.setVisible(true);
        } else if (e.getSource() == marryEven) {

            players.get(counter).marry(diceRoll, players);
            marryEven.setDisable(true);
            marryRoll.setVisible(false);
            marryCont.setVisible(true);
        }
    }

    /*
        Job Search Controllers (DONE)
    */
    @FXML
    private Button bRetain, bChange, jobDraw, jobDone;
    @FXML
    private Label jobDescription, salaryDescription;

    @FXML // NOTE: This will be called from magenta space at index achuchu
    public void jobHunt() throws Exception {
        Stage jobP = new Stage();
        Parent jobCard = FXMLLoader.load(getClass().getResource("View/jobSearch.fxml"));

        jobP.initStyle(StageStyle.UNDECORATED);
        jobP.initModality(Modality.APPLICATION_MODAL);
        jobP.setScene(new Scene(jobCard, 600, 400));
        jobP.setResizable(false);
        jobP.showAndWait();
    }

    // FUNCTIONAL
    public void huntAction(ActionEvent e) {
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        CareerCard c = b.getCareerDeck().getDeck().peek();
        SalaryCard s = b.getSalaryDeck().getDeck().peek();

        if (e.getSource() == jobDraw) {

            jobDescription.setText(c.getName());
            salaryDescription.setText(Integer.toString(s.getSalary()));

            bChange.setDisable(false);
            bRetain.setDisable(false);
        } else if (e.getSource() == bRetain) {

            bChange.setDisable(true);
            bRetain.setDisable(true);
        } else if (e.getSource() == bChange) {

            // set method to update values here
            players.get(counter).jobSearch(b.getCareerDeck().drawCard(), b.getSalaryDeck().drawCard(), b.getCareerDeck(), b.getSalaryDeck());
            bChange.setDisable(true);
            bRetain.setDisable(true);
        }
        jobDone.setVisible(true);
        jobDone.setDisable(false);
    }

    /*
         Buy a House Controllers (DONE)
    */
    @FXML
    private Label mobileHomeLabel, cabinLabel, apartmentLabel, villaLabel, condoLabel;
    @FXML
    private Button bMobileHome, bCabin, bApartment, bVilla, bCondo, houseRoll, houseCont;

    @FXML // NOTE: this will be called on magenta spaces
    public void buyHouse() throws Exception {
        Stage houseP = new Stage();
        Parent hCard = FXMLLoader.load(getClass().getResource("View/buyHouse.fxml"));

        houseP.initStyle(StageStyle.UNDECORATED);
        houseP.initModality(Modality.APPLICATION_MODAL);
        houseP.setScene(new Scene(hCard, 600, 400));
        houseP.setResizable(false);
        houseP.showAndWait();
    }

    // FOR TESTING
    public void houseAction(ActionEvent e) {
        int diceRoll = 0;
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();
        if (e.getSource() == houseRoll) {
            diceRoll = players.get(counter).spin();

            houseRoll.setDisable(true);
            houseRoll.setVisible(false);

            //if else for odd or even pricing. dont forget setText on the labels
            if (diceRoll % 2 == 0) {
                mobileHomeLabel.setText("Price: $" + HouseCard.HOUSE_EVEN[0]);
                cabinLabel.setText("Price: $" + HouseCard.HOUSE_EVEN[1]);
                apartmentLabel.setText("Price: $" + HouseCard.HOUSE_EVEN[2]);
                condoLabel.setText("Price: $" + HouseCard.HOUSE_EVEN[3]);
                villaLabel.setText("Price: $" + HouseCard.HOUSE_EVEN[4]);
            } else {
                mobileHomeLabel.setText("Price: $" + HouseCard.HOUSE_ODD[0]);
                cabinLabel.setText("Price: $" + HouseCard.HOUSE_ODD[1]);
                apartmentLabel.setText("Price: $" + HouseCard.HOUSE_ODD[2]);
                condoLabel.setText("Price: $" + HouseCard.HOUSE_ODD[3]);
                villaLabel.setText("Price: $" + HouseCard.HOUSE_ODD[4]);
            }

            bMobileHome.setDisable(false);
            bCabin.setDisable(false);
            bApartment.setDisable(false);
            bVilla.setDisable(false);
            bCondo.setDisable(false);
        } else if (e.getSource() == bMobileHome) {
            players.get(counter).receiveHouseCard(diceRoll, HouseCard.HOUSE[0], b.getHouseDeck());
            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);
        } else if (e.getSource() == bCabin) {
            players.get(counter).receiveHouseCard(diceRoll, HouseCard.HOUSE[1], b.getHouseDeck());
            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);
        } else if (e.getSource() == bApartment) {
            players.get(counter).receiveHouseCard(diceRoll, HouseCard.HOUSE[2], b.getHouseDeck());
            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);
        } else if (e.getSource() == bVilla) {
            players.get(counter).receiveHouseCard(diceRoll, HouseCard.HOUSE[4], b.getHouseDeck());
            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);
        } else if (e.getSource() == bCondo) {
            players.get(counter).receiveHouseCard(diceRoll, HouseCard.HOUSE[3], b.getHouseDeck());
            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);
        }

        houseCont.setVisible(true);
        houseCont.setDisable(false);
    }

    /*
        Change career path Controllers (DONE)
     */
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
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        CareerCard c = b.getCareerDeck().drawCard();
        SalaryCard s = b.getSalaryDeck().drawCard();

        if (e.getSource() == careerChange) {

            forkLabel.setText("Your new career is " + c.getName() + "!" + "\nSalary: $" + s.getSalary());
            players.get(counter).jobSearch(c, s, b.getCareerDeck(), b.getSalaryDeck());
            careerChange.setVisible(false);
            careerChange.setDisable(true);
            continuePath.setVisible(false);
            continuePath.setDisable(true);
        } else if (e.getSource() == continuePath) {

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

    /*
        College Career Choice Controllers Theoretically FUNCTIONAL
     */
    @FXML
    private Label jobLabel1, jobLabel2, wageLabel1, wageLabel2;
    @FXML
    private Button career1, career2, salary1, salary2, showThem, collegeCont;

    @FXML // NOTE: Will be called when player lands on first magenta space
    public void chooseCareer() throws Exception {
        Stage pickP = new Stage();
        Parent pickCard = FXMLLoader.load(getClass().getResource("View/collegeChoice.fxml"));

        pickP.initStyle(StageStyle.UNDECORATED);
        pickP.initModality(Modality.APPLICATION_MODAL);
        pickP.setScene(new Scene(pickCard, 600, 400));
        pickP.setResizable(false);
        pickP.showAndWait();
    }

    @FXML // FOR TESTING
    public void careerAction(ActionEvent e) {
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        CareerCard c1 = b.getCareerDeck().drawCard();
        CareerCard c2 = b.getCareerDeck().drawCard();
        SalaryCard s1 = b.getSalaryDeck().drawCard();
        SalaryCard s2 = b.getSalaryDeck().drawCard();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(s1);
        System.out.println(s2);

        if(e.getSource() == showThem) {
            jobLabel1.setText(c1.getName());
            jobLabel2.setText(c2.getName());
            wageLabel1.setText(Integer.toString(s1.getSalary()));
            wageLabel2.setText(Integer.toString(s2.getSalary()));
            showThem.setVisible(false);

            career1.setVisible(true);
            career2.setVisible(true);
            salary1.setVisible(true);
            salary2.setVisible(true);
        }
        else if(e.getSource() == career1) {
            players.get(counter).receiveCareerCard(c1, c2, b.getCareerDeck());
            career1.setDisable(true);
            career2.setDisable(true);
        }
        else if(e.getSource() == career2) {
            players.get(counter).receiveCareerCard(c2, c1, b.getCareerDeck());
            career1.setDisable(true);
            career2.setDisable(true);
        }
        else if(e.getSource() == salary1) {
            players.get(counter).receiveSalaryCard(s1, s2, b.getSalaryDeck());
            salary1.setDisable(true);
            salary2.setDisable(true);
        }
        else if(e.getSource() == salary2) {
            players.get(counter).receiveSalaryCard(s2, s1, b.getSalaryDeck());
            salary1.setDisable(true);
            salary2.setDisable(true);
        }
        collegeCont.setVisible(true);
    }

    /*
        Winner Screen Controllers
    */

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
        Have a baby Controllers (DONE)
    */
    @FXML
    private Label babyLabel;
    @FXML
    private Button babyRoll, babyCollect, babyCont;

    @FXML // NOTE: this will be called on a magenta space
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
        int diceRoll = 0;
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        if(e.getSource() == babyRoll) {
            diceRoll = (int)(Math.random() * ((2-1)+1) + 1);

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
            players.get(counter).haveBabies(diceRoll, players);
            babyCollect.setDisable(true);
            babyCollect.setVisible(false);
        }
        babyCont.setVisible(true);
        babyCont.setDisable(false);
    }    
    
    /*
        Options Controllers (DONE)
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