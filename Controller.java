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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.geometry.Pos;
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
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        b.initializeData(model.getNumAction(), model.getNumCareer(), model.getNumSalary(), 0, 0);

        b.getPlayers().get(0).setName(textFieldP1.getText());
        if (b.getPlayers().get(0).getName().equals(""))
            b.getPlayers().get(0).setName("Player 1");

        b.getPlayers().get(1).setName(textFieldP2.getText());
        if (b.getPlayers().get(1).getName().equals(""))
            b.getPlayers().get(1).setName("Player 2");

        if (model.getNumPlayers() == 3) {
            model.getB().getPlayers().get(2).setName(textFieldP3.getText());
            if (b.getPlayers().get(2).getName().equals(""))
                b.getPlayers().get(2).setName("Player 3");
        }

        Stage startStage = (Stage) startGame.getScene().getWindow();
        Parent startView = FXMLLoader.load(getClass().getResource("View/playerPath1.fxml"));
        Scene startScene = new Scene(startView);
        startStage.setScene(startScene);
        startStage.show();
    }

    @FXML // DONT DELETE
    public void secondPlayer(ActionEvent e) throws Exception {
        if (e.getSource() == P1_careerPath) {
            model.getB().getPlayers().get(0).setCurrentPath("careerPath");
            Stage chooseP = new Stage();
            Parent chooseCard = FXMLLoader.load(getClass().getResource("View/startCareerChoice.fxml"));

            chooseP.initStyle(StageStyle.UNDECORATED);
            chooseP.initModality(Modality.APPLICATION_MODAL);
            chooseP.setScene(new Scene(chooseCard, 600, 400));
            chooseP.setResizable(false);
            chooseP.showAndWait();

            Stage boardStage = (Stage)P1_careerPath.getScene().getWindow();
            Parent boardView = FXMLLoader.load(getClass().getResource("View/playerPath2.fxml"));
            model.getB().setCounter(model.getB().getCounter() + 1);

            Scene boardScene = new Scene(boardView);
            boardStage.setScene(boardScene);
            boardStage.show();
        } else if (e.getSource() == P1_mainPath) {
            model.getB().getPlayers().get(0).setCurrentPath("mainPath");
            Stage boardStage = (Stage)P1_mainPath.getScene().getWindow();
            Parent boardView = FXMLLoader.load(getClass().getResource("View/playerPath2.fxml"));

            Scene boardScene = new Scene(boardView);
            boardStage.setScene(boardScene);
            boardStage.show();
        }
    }

    @FXML // DONT DELETE
    public void thirdPlayer(ActionEvent e) throws Exception {
        if (e.getSource() == P2_careerPath) {
            model.getB().getPlayers().get(1).setCurrentPath("careerPath");
            Stage chooseP = new Stage();
            Parent chooseCard = FXMLLoader.load(getClass().getResource("View/startCareerChoice.fxml"));

            chooseP.initStyle(StageStyle.UNDECORATED);
            chooseP.initModality(Modality.APPLICATION_MODAL);
            chooseP.setScene(new Scene(chooseCard, 600, 400));
            chooseP.setResizable(false);
            chooseP.showAndWait();

            if (model.getNumPlayers() == 2) {
                Stage boardStage = (Stage) P2_mainPath.getScene().getWindow();
                Parent boardView = FXMLLoader.load(getClass().getResource("View/gameBoard.fxml"));

                Scene boardScene = new Scene(boardView);
                boardStage.setScene(boardScene);
                boardStage.show();
            } else if (model.getNumPlayers() == 3) {
                Stage boardStage = (Stage) P2_mainPath.getScene().getWindow();
                Parent boardView = FXMLLoader.load(getClass().getResource("View/playerPath3.fxml"));
                model.getB().setCounter(model.getB().getCounter() + 1);

                Scene boardScene = new Scene(boardView);
                boardStage.setScene(boardScene);
                boardStage.show();
            }
            
        } else if (e.getSource() == P2_mainPath) {
            model.getB().getPlayers().get(1).setCurrentPath("mainPath");

            if (model.getNumPlayers() == 3) {
                Stage boardStage = (Stage) P2_mainPath.getScene().getWindow();
                Parent boardView = FXMLLoader.load(getClass().getResource("View/playerPath3.fxml"));
                model.getB().setCounter(model.getB().getCounter() + 1);
                Scene boardScene = new Scene(boardView);
                boardStage.setScene(boardScene);
                boardStage.show();
            } else if (model.getNumPlayers() == 2) {
                Stage boardStage = (Stage) P2_mainPath.getScene().getWindow();
                Parent boardView = FXMLLoader.load(getClass().getResource("View/gameBoard.fxml"));

                Scene boardScene = new Scene(boardView);
                boardStage.setScene(boardScene);
                boardStage.show();
            }
        }
    }

    @FXML
    public void countPlayers(ActionEvent event) throws Exception {
        if (model.getNumPlayers() == 2)
            displayBoard(event);
        else if (model.getNumPlayers() == 3)
            thirdPlayer(event);
    }

    @FXML
    public void displayBoard(ActionEvent event) throws Exception {
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        if (event.getSource().equals(P2_mainPath))
            model.getB().getPlayers().get(1).setCurrentPath("mainPath");
        else if (event.getSource().equals(P2_careerPath)) {
            model.getB().getPlayers().get(1).setCurrentPath("careerPath");

            Stage chooseP = new Stage();
            Parent chooseCard = FXMLLoader.load(getClass().getResource("View/startCareerChoice.fxml"));

            chooseP.initStyle(StageStyle.UNDECORATED);
            chooseP.initModality(Modality.APPLICATION_MODAL);
            chooseP.setScene(new Scene(chooseCard, 600, 400));
            chooseP.setResizable(false);
            chooseP.showAndWait();
        }

        System.out.println(players.get(0).getName() + " : " + players.get(0).getCurrentPath() + " : " + players.get(0).getCareerCard());
        System.out.println(players.get(1).getName() + " : " + players.get(1).getCurrentPath() + " : " + players.get(1).getCareerCard());
        b.setCounter(0);
        Stage boardStage = (Stage) P2_mainPath.getScene().getWindow();
        Parent boardView = FXMLLoader.load(getClass().getResource("View/gameBoard.fxml"));

        Scene boardScene = new Scene(boardView);
        boardStage.setScene(boardScene);
        boardStage.show();
    }

    public void copy_displayBoard(ActionEvent event) throws Exception {
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        if (event.getSource().equals(P3_mainPath))
            model.getB().getPlayers().get(2).setCurrentPath("mainPath");
        else if (event.getSource().equals(P3_careerPath)) {
            model.getB().getPlayers().get(2).setCurrentPath("CareerPath");
            Stage chooseP = new Stage();
            Parent chooseCard = FXMLLoader.load(getClass().getResource("View/startCareerChoice.fxml"));

            chooseP.initStyle(StageStyle.UNDECORATED);
            chooseP.initModality(Modality.APPLICATION_MODAL);
            chooseP.setScene(new Scene(chooseCard, 600, 400));
            chooseP.setResizable(false);
            chooseP.showAndWait();
        }

        System.out.println(model.getB().getPlayers().get(0).getName() + " : " + model.getB().getPlayers().get(0).getCurrentPath() + " : " + model.getB().getPlayers().get(0).getCareerCard());
        System.out.println(model.getB().getPlayers().get(1).getName() + " : " + model.getB().getPlayers().get(1).getCurrentPath() + " : " + model.getB().getPlayers().get(1).getCareerCard());
        System.out.println(model.getB().getPlayers().get(2).getName() + " : " + model.getB().getPlayers().get(2).getCurrentPath() + " : " + model.getB().getPlayers().get(2).getCareerCard());
        model.getB().setCounter(0);

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
    private Button rollSpin, nextPlayer, drawCard, settleLoan, rankings;
    @FXML
    private Rectangle space1, space2, space3, space4, space5, space6, space7, space8, space9, space10, space11, space12, space13, space14, space15, space16, space17, space18, space19, space20, space21, space22, space23, space24, space25, space26, space27, space28, space29, space30, space31, space32, space33, space34, space35, space36, space37, space38, space39, space40, space41;
    @FXML
    private Rectangle space1a, space2a, space3a, space4a, space5a, space6a, space7a, space8a, space20a, space21a, space22a, space23a, space24a, space25a, space26a, space27a;
    @FXML
    private Circle gamePiece1, gamePiece2, gamePiece3;

    private static int countP1 = 0;
    private static int countP2 = 0;
    private static int countP3 = 0;

    private static int stopPinkP1 = 0;
    private static int stopPinkP2 = 0;
    private static int stopPinkP3 = 0;

    @FXML
    public void updateValues (MouseEvent mouseEvent) throws Exception {
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        if (players.size() == 0) {
            leaveGame.setVisible(false);
            nextPlayer.setDisable(false);
            rankings.setVisible(true);
            rankings.setDisable(false);
        } else {
            leaveGame.setVisible(false);
            rankings.setVisible(false);
        }


        try {
            if (players.get(counter).getSpace() == 41) {
                retireMyself();
                drawCard.setDisable(true);
                nextPlayer.setDisable(false);
                leaveGame.setVisible(false);
            }

            if (b.getWinners().size() == model.getNumPlayers()) {
                leaveGame.setVisible(true);
                leaveGame.setDisable(false);
                rankings.setVisible(false);
                rankings.setDisable(true);
            } else {
                leaveGame.setVisible(true);
                leaveGame.setDisable(false);
                rankings.setVisible(true);
                rankings.setDisable(true);
            }

            nameLabel.setText(players.get(counter).getName());
            moneyLabel.setText(Integer.toString(players.get(counter).getCash()));

            if (players.get(counter).getBankLoan() == 0)
                settleLoan.setDisable(true);

            try {
                jobLabel.setText(players.get(counter).getCareerCard().getName());
                salaryLabel.setText(Integer.toString(players.get(counter).getSalaryCard().getSalary()));
            } catch (NullPointerException e) {
                jobLabel.setText("None");
                salaryLabel.setText("None");
            }

            try {
                houseLabel.setText((players.get(counter).getHouse().getName()));
            } catch (NullPointerException e) {
                houseLabel.setText("None");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Game is finished");
        }
    }

    @FXML
    private Button leaveGame;

    @FXML
    public void endGame() throws Exception {
        Stage endStage = (Stage)leaveGame.getScene().getWindow();
        Parent endView = FXMLLoader.load(getClass().getResource("View/mainMenu.fxml"));

        Scene endScene = new Scene(endView);
        endStage.setScene(endScene);
        endStage.show();
    }

    @FXML
    public void settleBankLoan (ActionEvent event) {
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        players.get(counter).settleBankLoan();
    }

    @FXML
    public void rollDice(ActionEvent event) throws Exception {

        int diceRoll;
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();
        int countMove;

        switch (b.getCounter()) {
            case 0:
                if (countP1 == 0 && players.get(counter).getCurrentPath().equals("mainPath")) {
                    stopPinkP1 = 8;
                } else if (countP1 == 0 && players.get(counter).getCurrentPath().equals("careerPath")) {
                    stopPinkP1 = 15;
                } else if (countP1 == 19 && players.get(counter).getCurrentPath().equals("mainPath")) {
                    stopPinkP1 = 21;
                }  else if (countP1 == 19 && players.get(counter).getCurrentPath().equals("changeCareerPath")) {
                    stopPinkP1 = 30;
                }
                break;
            case 1:
                if (countP2 == 0 && players.get(counter).getCurrentPath().equals("mainPath")) {
                    stopPinkP2 = 8;
                } else if (countP2 == 0 && players.get(counter).getCurrentPath().equals("careerPath")) {
                    stopPinkP2 = 15;
                } else if (countP2 == 19 && players.get(counter).getCurrentPath().equals("mainPath")) {
                    stopPinkP2 = 21;
                }  else if (countP2 == 19 && players.get(counter).getCurrentPath().equals("changeCareerPath")) {
                    stopPinkP2 = 30;
                }
                break;
            case 2:
                if (countP3 == 0 && players.get(counter).getCurrentPath().equals("mainPath")) {
                    stopPinkP3 = 8;
                } else if (countP3 == 0 && players.get(counter).getCurrentPath().equals("careerPath")) {
                    stopPinkP3 = 15;
                } else if (countP3 == 19 && players.get(counter).getCurrentPath().equals("mainPath")) {
                    stopPinkP3 = 21;
                }  else if (countP3 == 19 && players.get(counter).getCurrentPath().equals("changeCareerPath")) {
                    stopPinkP3 = 30;
                }
                break;
        }

        ArrayList<ActionCard> actionDeck = model.getB().getActionDeck().getTemp();
        ArrayList<BlueCard> blueDeck = model.getB().getBlueDeck().getTemp();
        ArrayList<CareerCard> careerDeck = model.getB().getCareerDeck().getTemp();
        ArrayList<SalaryCard> salaryDeck = model.getB().getSalaryDeck().getTemp();
        ArrayList<HouseCard> houseDeck = model.getB().getHouseDeck().getTemp();

        System.out.println("Current player: " + b.getCounter());

        diceRoll = players.get(counter).spin();
        diceLabel.setText(Integer.toString(diceRoll));

        countMove = 0; // takes the current value of the current player's moves

        if(b.getCounter() == 0) {
            countP1 += diceRoll;
            countMove = countP1;
            if(countMove >= stopPinkP1) {
                countMove = stopPinkP1;
                countP1 = stopPinkP1;
            }
        }
        else if(b.getCounter() == 1) {
            countP2 += diceRoll;
            countMove = countP2;
            if(countMove >= stopPinkP2) {
                countMove = stopPinkP2;
                countP2 = stopPinkP2;
            }
        }
        else if(b.getCounter() == 2) {
            countP3 += diceRoll;
            countMove = countP3;
            if(countMove >= stopPinkP3) {
                countMove = stopPinkP3;
                countP3 = stopPinkP3;
            }
        }

        System.out.println("Count move: " + countMove);
        if(countMove <= 41) {
            switch(countMove) {
                case 1:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("careerPath"))){
                        gamePiece1.setLayoutX(space1.getLayoutX() + (space1.getWidth() / 2));
                        gamePiece1.setLayoutY(space1.getLayoutY() + (space1.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece2.setLayoutX(space1.getLayoutX() + (space1.getWidth() / 2));
                        gamePiece2.setLayoutY(space1.getLayoutY() + (space1.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece3.setLayoutX(space1.getLayoutX() + (space1.getWidth() / 2));
                        gamePiece3.setLayoutY(space1.getLayoutY() + (space1.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){ // UNDER TESTING
                        gamePiece1.setLayoutX(space1a.getLayoutX() + (space1a.getWidth() / 2));
                        gamePiece1.setLayoutY(space1a.getLayoutY() + (space1a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space1a.getLayoutX() + (space1a.getWidth() / 2));
                        gamePiece2.setLayoutY(space1a.getLayoutY() + (space1a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space1a.getLayoutX() + (space1a.getWidth() / 2));
                        gamePiece3.setLayoutY(space1a.getLayoutY() + (space1a.getHeight() / 2));
                    } //UNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTING
                    break;
                case 2:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("careerPath"))){
                        gamePiece1.setLayoutX(space2.getLayoutX() + (space2.getWidth() / 2));
                        gamePiece1.setLayoutY(space2.getLayoutY() + (space2.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece2.setLayoutX(space2.getLayoutX() + (space2.getWidth() / 2));
                        gamePiece2.setLayoutY(space2.getLayoutY() + (space2.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece3.setLayoutX(space2.getLayoutX() + (space2.getWidth() / 2));
                        gamePiece3.setLayoutY(space2.getLayoutY() + (space2.getHeight() / 2));
                    } //UNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTING
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space2a.getLayoutX() + (space2a.getWidth() / 2));
                        gamePiece1.setLayoutY(space2a.getLayoutY() + (space2a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space2a.getLayoutX() + (space2a.getWidth() / 2));
                        gamePiece2.setLayoutY(space2a.getLayoutY() + (space2a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space2a.getLayoutX() + (space2a.getWidth() / 2));
                        gamePiece3.setLayoutY(space2a.getLayoutY() + (space2a.getHeight() / 2));
                    }//UNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTING
                    break;
                case 3:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("careerPath"))){
                        gamePiece1.setLayoutX(space3.getLayoutX() + (space3.getWidth() / 2));
                        gamePiece1.setLayoutY(space3.getLayoutY() + (space3.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece2.setLayoutX(space3.getLayoutX() + (space3.getWidth() / 2));
                        gamePiece2.setLayoutY(space3.getLayoutY() + (space3.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece3.setLayoutX(space3.getLayoutX() + (space3.getWidth() / 2));
                        gamePiece3.setLayoutY(space3.getLayoutY() + (space3.getHeight() / 2));
                    } //UNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTING
                   else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space3a.getLayoutX() + (space3a.getWidth() / 2));
                        gamePiece1.setLayoutY(space3a.getLayoutY() + (space3a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space3a.getLayoutX() + (space3a.getWidth() / 2));
                        gamePiece2.setLayoutY(space3a.getLayoutY() + (space3a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space3a.getLayoutX() + (space3a.getWidth() / 2));
                        gamePiece3.setLayoutY(space3a.getLayoutY() + (space3a.getHeight() / 2));
                    } //UNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTING
                    break;
                case 4:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("careerPath"))){
                        gamePiece1.setLayoutX(space4.getLayoutX() + (space4.getWidth() / 2));
                        gamePiece1.setLayoutY(space4.getLayoutY() + (space4.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece2.setLayoutX(space4.getLayoutX() + (space4.getWidth() / 2));
                        gamePiece2.setLayoutY(space4.getLayoutY() + (space4.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece3.setLayoutX(space4.getLayoutX() + (space4.getWidth() / 2));
                        gamePiece3.setLayoutY(space4.getLayoutY() + (space4.getHeight() / 2));
                    } //UNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTING
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space4a.getLayoutX() + (space4a.getWidth() / 2));
                        gamePiece1.setLayoutY(space4a.getLayoutY() + (space4a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space4a.getLayoutX() + (space4a.getWidth() / 2));
                        gamePiece2.setLayoutY(space4a.getLayoutY() + (space4a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space4a.getLayoutX() + (space4a.getWidth() / 2));
                        gamePiece3.setLayoutY(space4a.getLayoutY() + (space4a.getHeight() / 2));
                    } //UNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTING
                    break;
                case 5:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("careerPath"))){
                        gamePiece1.setLayoutX(space5.getLayoutX() + (space5.getWidth() / 2));
                        gamePiece1.setLayoutY(space5.getLayoutY() + (space5.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece2.setLayoutX(space5.getLayoutX() + (space5.getWidth() / 2));
                        gamePiece2.setLayoutY(space5.getLayoutY() + (space5.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece3.setLayoutX(space5.getLayoutX() + (space5.getWidth() / 2));
                        gamePiece3.setLayoutY(space5.getLayoutY() + (space5.getHeight() / 2));
                    } //UNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTING
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space5a.getLayoutX() + (space5a.getWidth() / 2));
                        gamePiece1.setLayoutY(space5a.getLayoutY() + (space5a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space5a.getLayoutX() + (space5a.getWidth() / 2));
                        gamePiece2.setLayoutY(space5a.getLayoutY() + (space5a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space5a.getLayoutX() + (space5a.getWidth() / 2));
                        gamePiece3.setLayoutY(space5a.getLayoutY() + (space5a.getHeight() / 2));
                    } //UNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTING
                    break;
                case 6:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("careerPath"))){
                        gamePiece1.setLayoutX(space6.getLayoutX() + (space6.getWidth() / 2));
                        gamePiece1.setLayoutY(space6.getLayoutY() + (space6.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece2.setLayoutX(space6.getLayoutX() + (space6.getWidth() / 2));
                        gamePiece2.setLayoutY(space6.getLayoutY() + (space6.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece3.setLayoutX(space6.getLayoutX() + (space6.getWidth() / 2));
                        gamePiece3.setLayoutY(space6.getLayoutY() + (space6.getHeight() / 2));
                    } //UNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTING
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space6a.getLayoutX() + (space6a.getWidth() / 2));
                        gamePiece1.setLayoutY(space6a.getLayoutY() + (space6a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space6a.getLayoutX() + (space6a.getWidth() / 2));
                        gamePiece2.setLayoutY(space6a.getLayoutY() + (space6a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space6a.getLayoutX() + (space6a.getWidth() / 2));
                        gamePiece3.setLayoutY(space6a.getLayoutY() + (space6a.getHeight() / 2));
                    } //UNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTING
                    break;
                case 7:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("careerPath"))){
                        gamePiece1.setLayoutX(space7.getLayoutX() + (space7.getWidth() / 2));
                        gamePiece1.setLayoutY(space7.getLayoutY() + (space7.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece2.setLayoutX(space7.getLayoutX() + (space7.getWidth() / 2));
                        gamePiece2.setLayoutY(space7.getLayoutY() + (space7.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece3.setLayoutX(space7.getLayoutX() + (space7.getWidth() / 2));
                        gamePiece3.setLayoutY(space7.getLayoutY() + (space7.getHeight() / 2));
                    } //UNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTING
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space7a.getLayoutX() + (space7a.getWidth() / 2));
                        gamePiece1.setLayoutY(space7a.getLayoutY() + (space7a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space7a.getLayoutX() + (space7a.getWidth() / 2));
                        gamePiece2.setLayoutY(space7a.getLayoutY() + (space7a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space7a.getLayoutX() + (space7a.getWidth() / 2));
                        gamePiece3.setLayoutY(space7a.getLayoutY() + (space7a.getHeight() / 2));
                    } //UNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTINGUNDER TESTING
                    break;
                case 8:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("careerPath"))){
                        gamePiece1.setLayoutX(space8.getLayoutX() + (space8.getWidth() / 2));
                        gamePiece1.setLayoutY(space8.getLayoutY() + (space8.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece2.setLayoutX(space8.getLayoutX() + (space8.getWidth() / 2));
                        gamePiece2.setLayoutY(space8.getLayoutY() + (space8.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece3.setLayoutX(space8.getLayoutX() + (space8.getWidth() / 2));
                        gamePiece3.setLayoutY(space8.getLayoutY() + (space8.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space8a.getLayoutX() + (space8a.getWidth() / 2));
                        gamePiece1.setLayoutY(space8a.getLayoutY() + (space8a.getHeight() / 2));
                        stopPinkP1 = 15;
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space8a.getLayoutX() + (space8a.getWidth() / 2));
                        gamePiece2.setLayoutY(space8a.getLayoutY() + (space8a.getHeight() / 2));
                        stopPinkP2 = 15;
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space8a.getLayoutX() + (space8a.getWidth() / 2));
                        gamePiece3.setLayoutY(space8a.getLayoutY() + (space8a.getHeight() / 2));
                        stopPinkP3 = 15;
                    }
                    break;
                case 9:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("careerPath"))){
                        gamePiece1.setLayoutX(space9.getLayoutX() + (space9.getWidth() / 2));
                        gamePiece1.setLayoutY(space9.getLayoutY() + (space9.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece2.setLayoutX(space9.getLayoutX() + (space9.getWidth() / 2));
                        gamePiece2.setLayoutY(space9.getLayoutY() + (space9.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("careerPath"))) {
                        gamePiece3.setLayoutX(space9.getLayoutX() + (space9.getWidth() / 2));
                        gamePiece3.setLayoutY(space9.getLayoutY() + (space9.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece1.setLayoutX(space9.getLayoutX() + (space9.getWidth() / 2));
                        gamePiece1.setLayoutY(space9.getLayoutY() + (space9.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space9.getLayoutX() + (space9.getWidth() / 2));
                        gamePiece2.setLayoutY(space9.getLayoutY() + (space9.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space9.getLayoutX() + (space9.getWidth() / 2));
                        gamePiece3.setLayoutY(space9.getLayoutY() + (space9.getHeight() / 2));
                    }
                    break;
                case 10:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space10.getLayoutX() + (space10.getWidth() / 2));
                        gamePiece1.setLayoutY(space10.getLayoutY() + (space10.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space10.getLayoutX() + (space10.getWidth() / 2));
                        gamePiece2.setLayoutY(space10.getLayoutY() + (space10.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space10.getLayoutX() + (space10.getWidth() / 2));
                        gamePiece3.setLayoutY(space10.getLayoutY() + (space10.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece1.setLayoutX(space10.getLayoutX() + (space10.getWidth() / 2));
                        gamePiece1.setLayoutY(space10.getLayoutY() + (space10.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space10.getLayoutX() + (space10.getWidth() / 2));
                        gamePiece2.setLayoutY(space10.getLayoutY() + (space10.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space10.getLayoutX() + (space10.getWidth() / 2));
                        gamePiece3.setLayoutY(space10.getLayoutY() + (space10.getHeight() / 2));
                    }
                    break;
                case 11:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space11.getLayoutX() + (space11.getWidth() / 2));
                        gamePiece1.setLayoutY(space11.getLayoutY() + (space11.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space11.getLayoutX() + (space11.getWidth() / 2));
                        gamePiece2.setLayoutY(space11.getLayoutY() + (space11.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space11.getLayoutX() + (space11.getWidth() / 2));
                        gamePiece3.setLayoutY(space11.getLayoutY() + (space11.getHeight() / 2));
                    }
                    break;
                case 12:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space12.getLayoutX() + (space12.getWidth() / 2));
                        gamePiece1.setLayoutY(space12.getLayoutY() + (space12.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space12.getLayoutX() + (space12.getWidth() / 2));
                        gamePiece2.setLayoutY(space12.getLayoutY() + (space12.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space12.getLayoutX() + (space12.getWidth() / 2));
                        gamePiece3.setLayoutY(space12.getLayoutY() + (space12.getHeight() / 2));
                    }
                    break;
                case 13:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space13.getLayoutX() + (space14.getWidth() / 2));
                        gamePiece1.setLayoutY(space13.getLayoutY() + (space14.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space13.getLayoutX() + (space14.getWidth() / 2));
                        gamePiece2.setLayoutY(space13.getLayoutY() + (space14.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space13.getLayoutX() + (space14.getWidth() / 2));
                        gamePiece3.setLayoutY(space13.getLayoutY() + (space14.getHeight() / 2));
                    }
                    break;
                case 14:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space14.getLayoutX() + (space14.getWidth() / 2));
                        gamePiece1.setLayoutY(space14.getLayoutY() + (space14.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space14.getLayoutX() + (space14.getWidth() / 2));
                        gamePiece2.setLayoutY(space14.getLayoutY() + (space14.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space14.getLayoutX() + (space14.getWidth() / 2));
                        gamePiece3.setLayoutY(space14.getLayoutY() + (space14.getHeight() / 2));
                    }
                    break;
                case 15:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space15.getLayoutX() + (space15.getWidth() / 2));
                        gamePiece1.setLayoutY(space15.getLayoutY() + (space15.getHeight() / 2));
                        stopPinkP1 = 19;
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space15.getLayoutX() + (space15.getWidth() / 2));
                        gamePiece2.setLayoutY(space15.getLayoutY() + (space15.getHeight() / 2));
                        stopPinkP2 = 19;
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space15.getLayoutX() + (space15.getWidth() / 2));
                        gamePiece3.setLayoutY(space15.getLayoutY() + (space15.getHeight() / 2));
                        stopPinkP3 = 19;
                    }
                    break;
                case 16:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space16.getLayoutX() + (space16.getWidth() / 2));
                        gamePiece1.setLayoutY(space16.getLayoutY() + (space16.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space16.getLayoutX() + (space16.getWidth() / 2));
                        gamePiece2.setLayoutY(space16.getLayoutY() + (space16.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space16.getLayoutX() + (space16.getWidth() / 2));
                        gamePiece3.setLayoutY(space16.getLayoutY() + (space16.getHeight() / 2));
                    }
                    break;
                case 17:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space17.getLayoutX() + (space17.getWidth() / 2));
                        gamePiece1.setLayoutY(space17.getLayoutY() + (space17.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space17.getLayoutX() + (space17.getWidth() / 2));
                        gamePiece2.setLayoutY(space17.getLayoutY() + (space17.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space17.getLayoutX() + (space17.getWidth() / 2));
                        gamePiece3.setLayoutY(space17.getLayoutY() + (space17.getHeight() / 2));
                    }
                    break;
                case 18:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space18.getLayoutX() + (space18.getWidth() / 2));
                        gamePiece1.setLayoutY(space18.getLayoutY() + (space18.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space18.getLayoutX() + (space18.getWidth() / 2));
                        gamePiece2.setLayoutY(space18.getLayoutY() + (space18.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space18.getLayoutX() + (space18.getWidth() / 2));
                        gamePiece3.setLayoutY(space18.getLayoutY() + (space18.getHeight() / 2));
                    }
                    break;
                case 19:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))){
                        gamePiece1.setLayoutX(space19.getLayoutX() + (space19.getWidth() / 2));
                        gamePiece1.setLayoutY(space19.getLayoutY() + (space19.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece2.setLayoutX(space19.getLayoutX() + (space19.getWidth() / 2));
                        gamePiece2.setLayoutY(space19.getLayoutY() + (space19.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece3.setLayoutX(space19.getLayoutX() + (space19.getWidth() / 2));
                        gamePiece3.setLayoutY(space19.getLayoutY() + (space19.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space19.getLayoutX() + (space19.getWidth() / 2));
                        gamePiece1.setLayoutY(space19.getLayoutY() + (space19.getHeight() / 2));
                        stopPinkP1 = 21;
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space19.getLayoutX() + (space19.getWidth() / 2));
                        gamePiece2.setLayoutY(space19.getLayoutY() + (space19.getHeight() / 2));
                        stopPinkP2 = 21;
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space19.getLayoutX() + (space19.getWidth() / 2));
                        gamePiece3.setLayoutY(space19.getLayoutY() + (space19.getHeight() / 2));
                        stopPinkP3 = 21;
                    }
                    break;
                case 20:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))){
                        gamePiece1.setLayoutX(space20.getLayoutX() + (space20.getWidth() / 2));
                        gamePiece1.setLayoutY(space20.getLayoutY() + (space20.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece2.setLayoutX(space20.getLayoutX() + (space20.getWidth() / 2));
                        gamePiece2.setLayoutY(space20.getLayoutY() + (space20.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece3.setLayoutX(space20.getLayoutX() + (space20.getWidth() / 2));
                        gamePiece3.setLayoutY(space20.getLayoutY() + (space20.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space20a.getLayoutX() + (space20a.getWidth() / 2));
                        gamePiece1.setLayoutY(space20a.getLayoutY() + (space20a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space20a.getLayoutX() + (space20a.getWidth() / 2));
                        gamePiece2.setLayoutY(space20a.getLayoutY() + (space20a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space20a.getLayoutX() + (space20a.getWidth() / 2));
                        gamePiece3.setLayoutY(space20a.getLayoutY() + (space20a.getHeight() / 2));
                    }
                    break;
                case 21:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))){
                        gamePiece1.setLayoutX(space21.getLayoutX() + (space21.getWidth() / 2));
                        gamePiece1.setLayoutY(space21.getLayoutY() + (space21.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece2.setLayoutX(space21.getLayoutX() + (space21.getWidth() / 2));
                        gamePiece2.setLayoutY(space21.getLayoutY() + (space21.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece3.setLayoutX(space21.getLayoutX() + (space21.getWidth() / 2));
                        gamePiece3.setLayoutY(space21.getLayoutY() + (space21.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space21a.getLayoutX() + (space21a.getWidth() / 2));
                        gamePiece1.setLayoutY(space21a.getLayoutY() + (space21a.getHeight() / 2));
                        stopPinkP1 = 30;
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space21a.getLayoutX() + (space21a.getWidth() / 2));
                        gamePiece2.setLayoutY(space21a.getLayoutY() + (space21a.getHeight() / 2));
                        stopPinkP2 = 30;
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space21a.getLayoutX() + (space21a.getWidth() / 2));
                        gamePiece3.setLayoutY(space21a.getLayoutY() + (space21a.getHeight() / 2));
                        stopPinkP3 = 30;
                    }
                    break;
                case 22:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece1.setLayoutX(space22.getLayoutX() + (space22.getWidth() / 2));
                        gamePiece1.setLayoutY(space22.getLayoutY() + (space22.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece2.setLayoutX(space22.getLayoutX() + (space22.getWidth() / 2));
                        gamePiece2.setLayoutY(space22.getLayoutY() + (space22.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece3.setLayoutX(space22.getLayoutX() + (space22.getWidth() / 2));
                        gamePiece3.setLayoutY(space22.getLayoutY() + (space22.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece1.setLayoutX(space22a.getLayoutX() + (space22a.getWidth() / 2));
                        gamePiece1.setLayoutY(space22a.getLayoutY() + (space22a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space22a.getLayoutX() + (space22a.getWidth() / 2));
                        gamePiece2.setLayoutY(space22a.getLayoutY() + (space22a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space22a.getLayoutX() + (space22a.getWidth() / 2));
                        gamePiece3.setLayoutY(space22a.getLayoutY() + (space22a.getHeight() / 2));
                    }
                    break;
                case 23:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))){
                        gamePiece1.setLayoutX(space23.getLayoutX() + (space23.getWidth() / 2));
                        gamePiece1.setLayoutY(space23.getLayoutY() + (space23.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece2.setLayoutX(space23.getLayoutX() + (space23.getWidth() / 2));
                        gamePiece2.setLayoutY(space23.getLayoutY() + (space23.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece3.setLayoutX(space23.getLayoutX() + (space23.getWidth() / 2));
                        gamePiece3.setLayoutY(space23.getLayoutY() + (space23.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space23a.getLayoutX() + (space23a.getWidth() / 2));
                        gamePiece1.setLayoutY(space23a.getLayoutY() + (space23a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space23a.getLayoutX() + (space23a.getWidth() / 2));
                        gamePiece2.setLayoutY(space23a.getLayoutY() + (space23a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space23a.getLayoutX() + (space23a.getWidth() / 2));
                        gamePiece3.setLayoutY(space23a.getLayoutY() + (space23a.getHeight() / 2));
                    }
                    break;
                case 24:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))){
                        gamePiece1.setLayoutX(space24.getLayoutX() + (space24.getWidth() / 2));
                        gamePiece1.setLayoutY(space24.getLayoutY() + (space24.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece2.setLayoutX(space24.getLayoutX() + (space24.getWidth() / 2));
                        gamePiece2.setLayoutY(space24.getLayoutY() + (space24.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece3.setLayoutX(space24.getLayoutX() + (space24.getWidth() / 2));
                        gamePiece3.setLayoutY(space24.getLayoutY() + (space24.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space24a.getLayoutX() + (space24a.getWidth() / 2));
                        gamePiece1.setLayoutY(space24a.getLayoutY() + (space24a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space24a.getLayoutX() + (space24a.getWidth() / 2));
                        gamePiece2.setLayoutY(space24a.getLayoutY() + (space24a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space24a.getLayoutX() + (space24a.getWidth() / 2));
                        gamePiece3.setLayoutY(space24a.getLayoutY() + (space24a.getHeight() / 2));
                    }
                    break;
                case 25:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))){
                        gamePiece1.setLayoutX(space25.getLayoutX() + (space25.getWidth() / 2));
                        gamePiece1.setLayoutY(space25.getLayoutY() + (space25.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece2.setLayoutX(space25.getLayoutX() + (space25.getWidth() / 2));
                        gamePiece2.setLayoutY(space25.getLayoutY() + (space25.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece3.setLayoutX(space25.getLayoutX() + (space25.getWidth() / 2));
                        gamePiece3.setLayoutY(space25.getLayoutY() + (space25.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space25a.getLayoutX() + (space25a.getWidth() / 2));
                        gamePiece1.setLayoutY(space25a.getLayoutY() + (space25a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space25a.getLayoutX() + (space25a.getWidth() / 2));
                        gamePiece2.setLayoutY(space25a.getLayoutY() + (space25a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space25a.getLayoutX() + (space25a.getWidth() / 2));
                        gamePiece3.setLayoutY(space25a.getLayoutY() + (space25a.getHeight() / 2));
                    }
                    break;
                case 26:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))){
                        gamePiece1.setLayoutX(space26.getLayoutX() + (space26.getWidth() / 2));
                        gamePiece1.setLayoutY(space26.getLayoutY() + (space26.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece2.setLayoutX(space26.getLayoutX() + (space26.getWidth() / 2));
                        gamePiece2.setLayoutY(space26.getLayoutY() + (space26.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece3.setLayoutX(space26.getLayoutX() + (space26.getWidth() / 2));
                        gamePiece3.setLayoutY(space26.getLayoutY() + (space26.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space26a.getLayoutX() + (space26a.getWidth() / 2));
                        gamePiece1.setLayoutY(space26a.getLayoutY() + (space26a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space26a.getLayoutX() + (space26a.getWidth() / 2));
                        gamePiece2.setLayoutY(space26a.getLayoutY() + (space26a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space26a.getLayoutX() + (space26a.getWidth() / 2));
                        gamePiece3.setLayoutY(space26a.getLayoutY() + (space26a.getHeight() / 2));
                    }
                    break;
                case 27:
                    if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))){
                        gamePiece1.setLayoutX(space27.getLayoutX() + (space27.getWidth() / 2));
                        gamePiece1.setLayoutY(space27.getLayoutY() + (space27.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece2.setLayoutX(space27.getLayoutX() + (space27.getWidth() / 2));
                        gamePiece2.setLayoutY(space27.getLayoutY() + (space27.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("changeCareerPath"))) {
                        gamePiece3.setLayoutX(space27.getLayoutX() + (space27.getWidth() / 2));
                        gamePiece3.setLayoutY(space27.getLayoutY() + (space27.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 0 && (players.get(counter).getCurrentPath().equals("mainPath"))){
                        gamePiece1.setLayoutX(space27a.getLayoutX() + (space27a.getWidth() / 2));
                        gamePiece1.setLayoutY(space27a.getLayoutY() + (space27a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece2.setLayoutX(space27a.getLayoutX() + (space27a.getWidth() / 2));
                        gamePiece2.setLayoutY(space27a.getLayoutY() + (space27a.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2 && (players.get(counter).getCurrentPath().equals("mainPath"))) {
                        gamePiece3.setLayoutX(space27a.getLayoutX() + (space27a.getWidth() / 2));
                        gamePiece3.setLayoutY(space27a.getLayoutY() + (space27a.getHeight() / 2));
                    }
                    break;
                case 28:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space28.getLayoutX() + (space28.getWidth() / 2));
                        gamePiece1.setLayoutY(space28.getLayoutY() + (space28.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space28.getLayoutX() + (space28.getWidth() / 2));
                        gamePiece2.setLayoutY(space28.getLayoutY() + (space28.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space28.getLayoutX() + (space28.getWidth() / 2));
                        gamePiece3.setLayoutY(space28.getLayoutY() + (space28.getHeight() / 2));
                    }
                    break;
                case 29:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space29.getLayoutX() + (space29.getWidth() / 2));
                        gamePiece1.setLayoutY(space29.getLayoutY() + (space29.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space29.getLayoutX() + (space29.getWidth() / 2));
                        gamePiece2.setLayoutY(space29.getLayoutY() + (space29.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space29.getLayoutX() + (space29.getWidth() / 2));
                        gamePiece3.setLayoutY(space29.getLayoutY() + (space29.getHeight() / 2));
                    }
                    break;
                case 30:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space30.getLayoutX() + (space30.getWidth() / 2));
                        gamePiece1.setLayoutY(space30.getLayoutY() + (space30.getHeight() / 2));
                        stopPinkP1 = 33;
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space30.getLayoutX() + (space30.getWidth() / 2));
                        gamePiece2.setLayoutY(space30.getLayoutY() + (space30.getHeight() / 2));
                        stopPinkP2 = 33;
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space30.getLayoutX() + (space30.getWidth() / 2));
                        gamePiece3.setLayoutY(space30.getLayoutY() + (space30.getHeight() / 2));
                        stopPinkP3 = 33;
                    }
                    break;
                case 31:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space31.getLayoutX() + (space31.getWidth() / 2));
                        gamePiece1.setLayoutY(space31.getLayoutY() + (space31.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space31.getLayoutX() + (space31.getWidth() / 2));
                        gamePiece2.setLayoutY(space31.getLayoutY() + (space31.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space31.getLayoutX() + (space31.getWidth() / 2));
                        gamePiece3.setLayoutY(space31.getLayoutY() + (space31.getHeight() / 2));
                    }
                    break;
                case 32:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space32.getLayoutX() + (space32.getWidth() / 2));
                        gamePiece1.setLayoutY(space32.getLayoutY() + (space32.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space32.getLayoutX() + (space32.getWidth() / 2));
                        gamePiece2.setLayoutY(space32.getLayoutY() + (space32.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space32.getLayoutX() + (space32.getWidth() / 2));
                        gamePiece3.setLayoutY(space32.getLayoutY() + (space32.getHeight() / 2));
                    }
                    break;
                case 33:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space33.getLayoutX() + (space33.getWidth() / 2));
                        gamePiece1.setLayoutY(space33.getLayoutY() + (space33.getHeight() / 2));
                        stopPinkP1 = 41;
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space33.getLayoutX() + (space33.getWidth() / 2));
                        gamePiece2.setLayoutY(space33.getLayoutY() + (space33.getHeight() / 2));
                        stopPinkP2 = 41;
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space33.getLayoutX() + (space33.getWidth() / 2));
                        gamePiece3.setLayoutY(space33.getLayoutY() + (space33.getHeight() / 2));
                        stopPinkP3 = 41;
                    }
                    break;
                case 34:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space34.getLayoutX() + (space34.getWidth() / 2));
                        gamePiece1.setLayoutY(space34.getLayoutY() + (space34.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space34.getLayoutX() + (space34.getWidth() / 2));
                        gamePiece2.setLayoutY(space34.getLayoutY() + (space34.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space34.getLayoutX() + (space34.getWidth() / 2));
                        gamePiece3.setLayoutY(space34.getLayoutY() + (space34.getHeight() / 2));
                    }
                    break;
                case 35:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space35.getLayoutX() + (space35.getWidth() / 2));
                        gamePiece1.setLayoutY(space35.getLayoutY() + (space35.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space35.getLayoutX() + (space35.getWidth() / 2));
                        gamePiece2.setLayoutY(space35.getLayoutY() + (space35.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space35.getLayoutX() + (space35.getWidth() / 2));
                        gamePiece3.setLayoutY(space35.getLayoutY() + (space35.getHeight() / 2));
                    }
                    break;
                case 36:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space36.getLayoutX() + (space36.getWidth() / 2));
                        gamePiece1.setLayoutY(space36.getLayoutY() + (space36.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space36.getLayoutX() + (space36.getWidth() / 2));
                        gamePiece2.setLayoutY(space36.getLayoutY() + (space36.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space36.getLayoutX() + (space36.getWidth() / 2));
                        gamePiece3.setLayoutY(space36.getLayoutY() + (space36.getHeight() / 2));
                    }
                    break;
                case 37:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space37.getLayoutX() + (space37.getWidth() / 2));
                        gamePiece1.setLayoutY(space37.getLayoutY() + (space37.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space37.getLayoutX() + (space37.getWidth() / 2));
                        gamePiece2.setLayoutY(space37.getLayoutY() + (space37.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space37.getLayoutX() + (space37.getWidth() / 2));
                        gamePiece3.setLayoutY(space37.getLayoutY() + (space37.getHeight() / 2));
                    }
                    break;
                case 38:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space38.getLayoutX() + (space38.getWidth() / 2));
                        gamePiece1.setLayoutY(space38.getLayoutY() + (space38.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space38.getLayoutX() + (space38.getWidth() / 2));
                        gamePiece2.setLayoutY(space38.getLayoutY() + (space38.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space38.getLayoutX() + (space38.getWidth() / 2));
                        gamePiece3.setLayoutY(space38.getLayoutY() + (space38.getHeight() / 2));
                    }
                    break;
                case 39:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space39.getLayoutX() + (space39.getWidth() / 2));
                        gamePiece1.setLayoutY(space39.getLayoutY() + (space39.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space39.getLayoutX() + (space39.getWidth() / 2));
                        gamePiece2.setLayoutY(space39.getLayoutY() + (space39.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space39.getLayoutX() + (space39.getWidth() / 2));
                        gamePiece3.setLayoutY(space39.getLayoutY() + (space39.getHeight() / 2));
                    }
                    break;
                case 40:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space40.getLayoutX() + (space40.getWidth() / 2));
                        gamePiece1.setLayoutY(space40.getLayoutY() + (space40.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space40.getLayoutX() + (space40.getWidth() / 2));
                        gamePiece2.setLayoutY(space40.getLayoutY() + (space40.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space40.getLayoutX() + (space40.getWidth() / 2));
                        gamePiece3.setLayoutY(space40.getLayoutY() + (space40.getHeight() / 2));
                    }
                    break;
                case 41:
                    if(b.getCounter()  == 0){
                        gamePiece1.setLayoutX(space41.getLayoutX() + (space41.getWidth() / 2));
                        gamePiece1.setLayoutY(space41.getLayoutY() + (space41.getHeight() / 2));
                    }
                    else if(b.getCounter()  == 1) {
                        gamePiece2.setLayoutX(space41.getLayoutX() + (space41.getWidth() / 3));
                        gamePiece2.setLayoutY(space41.getLayoutY() + (space41.getHeight() / 3));
                    }
                    else if(b.getCounter()  == 2) {
                        gamePiece3.setLayoutX(space41.getLayoutX() + (space41.getWidth() / 4));
                        gamePiece3.setLayoutY(space41.getLayoutY() + (space41.getHeight() / 4));
                    }
                    break;
            }
        }



        nextPlayer.setDisable(true);
        rollSpin.setDisable(true);
        drawCard.setDisable(false);
        //should contain move instructions for pieces
        players.get(counter).setSpaceType(b.takeTurn(players.get(counter), diceRoll));
        System.out.println(players.get(counter).getSpaceType());
    }

    @FXML
    public void cardDraw(ActionEvent event) throws Exception {

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
                int space = players.get(counter).getSpace();
                switch (space) {
                    case 8:
                        chooseCareer();
                        break;
                    case 15:
                        jobHunt();
                        break;
                    case 19:
                        chooseAgain();
                        break;
                    case 21:
                        getMarried();
                        break;
                    case 30:
                        if (players.get(counter).getIsMarried())
                            getBaby();
                        break;
                    case 33:
                        buyHouse();
                        break;
                }
                break;
        }
        nextPlayer.setDisable(false);
    }

/*
    Retirement controllers
*/

    @FXML
    private Label retirementPay, childPay, houseValue, myDebt;
    @FXML
    private Button retiredPlayer, retireCont;

    @FXML
    public void retireMyself() throws Exception {
    Stage retP = new Stage();
    Parent retCard = FXMLLoader.load(getClass().getResource("View/settleDown.fxml"));

    retP.initStyle(StageStyle.UNDECORATED);
    retP.initModality(Modality.APPLICATION_MODAL);
    retP.setScene(new Scene(retCard, 600, 400));
    retP.setResizable(false);
    retP.showAndWait();
    }

    public void retireAction(ActionEvent event) {
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();
        Player p = players.get(counter);

        if(event.getSource() == retiredPlayer) {
            b.getWinners().add(players.remove(counter));
            p.retire(players, b.getWinners());
            retirementPay.setText(Integer.toString(p.getRetirementPay()));
            childPay.setText(Integer.toString(p.getChildCash()));
            houseValue.setText(Integer.toString(p.getHouseCost()));
            myDebt.setText(Integer.toString(p.getTotalBankLoan()));
            retiredPlayer.setVisible(false);
            retireCont.setVisible(true);
            try {
                drawCard.setDisable(true);
                nextPlayer.setDisable(false);
            } catch (NullPointerException e) {
                System.out.println("Player has reached end game");
            }
        }
    
    }
  /*
        Action Card Controllers (DONE)
  */

    @FXML
    private Label actionLabel;
    @FXML
    private Button actionDone, actionDraw, payPlayer1, payPlayer2, collectPlayer1, collectPlayer2, payBank, collectBank, collectMoney;

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

        ActionCard actionCard = b.getActionDeck().getTemp().get(b.getActionDeck().getTemp().size()-1);
        System.out.println(actionCard);

        if (event.getSource() == actionDraw) {
            actionDraw.setVisible(false);
            actionLabel.setText(actionCard.getActionType());
            switch (actionCard.getName()) {
                    case "Collect From Bank":
                        actionLabel.setText(actionCard.getName());
                        collectBank.setVisible(true);
                        collectBank.setDisable(false);

                        collectBank.setVisible(false);
                        collectBank.setDisable(true);

                        players.get(counter).receiveActionCard(players.get(counter), b.getActionDeck().getTemp().remove(b.getActionDeck().getTemp().size()-1), players);
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

                        players.get(counter).receiveActionCard(players.get(counter), b.getActionDeck().getTemp().remove(b.getActionDeck().getTemp().size()-1), players);
                        actionLabel.setText(actionCard.getActionType() + "! Pay $" + actionCard.getPayAmount());
                        actionDone.setVisible(true);
                        actionDone.setDisable(false);
                        break;

                    case "Collect from Player":
                        if (actionCard.getActionType().equals("It's your Birthday!")) {
                            payPlayer2.setVisible(false);
                            payPlayer1.setVisible(false);
                            actionDone.setVisible(true);
                            actionDone.setDisable(false);
                            players.get(counter).receiveActionCard(players.get(counter), b.getActionDeck().getTemp().remove(b.getActionDeck().getTemp().size()-1), players);
                            actionLabel.setText(actionCard.getActionType() + " Everyone pays you $" + (actionCard.getPayAmount()));
                        } else {
                            if (model.getNumPlayers() == 2) {
                                if (b.getCounter() == 0) {
                                    payPlayer1.setVisible(false);
                                    payPlayer2.setVisible(false);
                                    collectPlayer1.setVisible(false);
                                    collectPlayer2.setVisible(true);
                                    actionDone.setVisible(false);
                                } else {
                                    payPlayer1.setVisible(false);
                                    payPlayer2.setVisible(false);
                                    collectPlayer1.setVisible(true);
                                    collectPlayer2.setVisible(false);
                                    actionDone.setVisible(false);
                                }
                            } else if (model.getNumPlayers() == 3) {
                                collectPlayer1.setVisible(true);
                                collectPlayer2.setVisible(true);
                                payPlayer1.setVisible(false);
                                payPlayer2.setVisible(false);
                                actionDone.setVisible(false);
                            }
                        }
                        break;

                    case "Pay the Player":
                        if (actionCard.getActionType().equals("Christmas Bonus")) {
                            players.get(counter).receiveActionCard(players.get(counter), b.getActionDeck().getTemp().remove(b.getActionDeck().getTemp().size()-1), players);
                            actionLabel.setText(actionCard.getActionType() + "! Pay everyone $" + actionCard.getPayAmount());
                            actionDone.setVisible(true);
                            actionDone.setDisable(false);
                        } else {
                            if (model.getNumPlayers() == 2) {
                                if (b.getCounter() == 0) {
                                    collectPlayer1.setVisible(false);
                                    collectPlayer2.setVisible(false);
                                    payPlayer1.setVisible(false);
                                    payPlayer2.setVisible(true);
                                    actionDone.setVisible(false);
                                } else {
                                    collectPlayer1.setVisible(false);
                                    collectPlayer2.setVisible(false);
                                    payPlayer1.setVisible(true);
                                    payPlayer2.setVisible(false);
                                    actionDone.setVisible(false);
                                }
                            } else if (model.getNumPlayers() == 3) {
                                collectPlayer1.setVisible(false);
                                collectPlayer2.setVisible(false);
                                payPlayer1.setVisible(true);
                                payPlayer2.setVisible(true);
                                actionDone.setVisible(false);
                            }
                        }
                        break;
            }

        } else {
            actionLabel.setText(actionCard.getActionType());
            if (model.getNumPlayers() == 2) {
                if (event.getSource().equals(payPlayer1) || event.getSource().equals(payPlayer2)) {{
                    payPlayer1.setVisible(false);
                    payPlayer2.setVisible(false);
                    if (b.getCounter() == 0)
                        players.get(counter).receiveActionCard(players.get(1), b.getActionDeck().getTemp().remove(b.getActionDeck().getTemp().size()-1), players);
                    else
                        players.get(counter).receiveActionCard(players.get(0), b.getActionDeck().getTemp().remove(b.getActionDeck().getTemp().size()-1), players);

                    if (b.getCounter() == 0)
                        actionLabel.setText("You have paid " + (actionCard.getPayAmount()) + " to " + players.get(1).getName() + "!");
                    else
                        actionLabel.setText("You have paid " + (actionCard.getPayAmount()) + " to " + players.get(0).getName() + "!"); }

                    actionDone.setVisible(true);
                    actionDone.setDisable(false);
                } else if (event.getSource().equals(collectPlayer1) || event.getSource().equals(collectPlayer2)) {{
                    collectPlayer1.setVisible(false);
                    collectPlayer2.setVisible(false);
                    if (b.getCounter() == 0)
                        players.get(counter).receiveActionCard(players.get(1), b.getActionDeck().getTemp().remove(b.getActionDeck().getTemp().size()-1), players);
                    else
                        players.get(counter).receiveActionCard(players.get(0), b.getActionDeck().getTemp().remove(b.getActionDeck().getTemp().size()-1), players);

                    if (b.getCounter() == 0)
                        actionLabel.setText("You have collected " + (actionCard.getPayAmount()) + " from " + players.get(1).getName() + "!");
                    else
                        actionLabel.setText("You have collected " + (actionCard.getPayAmount()) + " from " + players.get(0).getName() + "!"); }

                    actionDone.setVisible(true);
                    actionDone.setDisable(false);
                }
            } else {
                switch (b.getCounter()) {
                    case 0:
                        if (event.getSource().equals(collectPlayer1)) {
                            collectPlayer1.setVisible(false);
                            players.get(counter).receiveActionCard(players.get(1), b.getActionDeck().getTemp().remove(b.getActionDeck().getTemp().size()-1), players);
                            if (actionCard.getName() == "Collect from Player")
                                actionLabel.setText("You have collected " + actionCard.getPayAmount() + " from " + players.get(1).getName() + "!");
                            else
                                actionLabel.setText("You have paid " + (actionCard.getPayAmount()) + " to " + players.get(1).getName() + "!");
                            collectPlayer1.setVisible(false);
                            collectPlayer2.setVisible(false);
                            actionDone.setVisible(true);
                            actionDone.setDisable(false);
                        } else if (event.getSource().equals(collectPlayer2)) {
                            collectPlayer2.setVisible(false);
                            players.get(counter).receiveActionCard(players.get(2), b.getActionDeck().getTemp().remove(b.getActionDeck().getTemp().size()-1), players);
                            if (actionCard.getName() == "Collect from Player")
                                actionLabel.setText("You have collected " + actionCard.getPayAmount()  + " from " + players.get(1).getName() + "!");
                            else
                                actionLabel.setText("You have paid " + (actionCard.getPayAmount()) + " to " + players.get(1).getName() + "!");
                            collectPlayer1.setVisible(false);
                            collectPlayer2.setVisible(false);
                            actionDone.setVisible(true);
                            actionDone.setDisable(false);
                        }
                        break;
                    case 1:
                        if (event.getSource().equals(collectPlayer1)) {
                            collectPlayer1.setVisible(false);
                            players.get(counter).receiveActionCard(players.get(0), b.getActionDeck().getTemp().remove(b.getActionDeck().getTemp().size()-1), players);
                            if (actionCard.getName() == "Collect from Player")
                                actionLabel.setText("You have collected " + actionCard.getPayAmount() + " from " + players.get(1).getName() + "!");
                            else
                                actionLabel.setText("You have paid " + (actionCard.getPayAmount()) + " to " + players.get(1).getName() + "!");
                            collectPlayer1.setVisible(false);
                            collectPlayer2.setVisible(false);
                            actionDone.setVisible(true);
                            actionDone.setDisable(false);
                        } else if (event.getSource().equals(collectPlayer2)) {
                            collectPlayer2.setVisible(false);
                            players.get(counter).receiveActionCard(players.get(2), b.getActionDeck().getTemp().remove(b.getActionDeck().getTemp().size()-1), players);
                            if (actionCard.getName() == "Collect from Player")
                                actionLabel.setText("You have collected " + actionCard.getPayAmount() + " from " + players.get(1).getName() + "!");
                            else
                                actionLabel.setText("You have paid " + (actionCard.getPayAmount()) + " to " + players.get(1).getName() + "!");
                            collectPlayer1.setVisible(false);
                            collectPlayer2.setVisible(false);
                            actionDone.setVisible(true);
                            actionDone.setDisable(false);
                        }
                        break;
                    case 2:
                        if (event.getSource().equals(collectPlayer1)) {
                            collectPlayer1.setVisible(false);
                            players.get(counter).receiveActionCard(players.get(0), b.getActionDeck().getTemp().remove(b.getActionDeck().getTemp().size()-1), players);
                            if (actionCard.getName() == "Collect from Player")
                                actionLabel.setText("You have collected " + actionCard.getPayAmount() + " from " + players.get(1).getName() + "!");
                            else
                                actionLabel.setText("You have paid " + (actionCard.getPayAmount()) + " to " + players.get(1).getName() + "!");
                            collectPlayer1.setVisible(false);
                            collectPlayer2.setVisible(false);
                            actionDone.setVisible(true);
                            actionDone.setDisable(false);
                        } else if (event.getSource().equals(collectPlayer2)) {
                            collectPlayer2.setVisible(false);
                            players.get(counter).receiveActionCard(players.get(1), b.getActionDeck().getTemp().remove(b.getActionDeck().getTemp().size()-1), players);
                            if (actionCard.getName() == "Collect from Player")
                                actionLabel.setText("You have collected " + actionCard.getPayAmount() + " from " + players.get(1).getName() + "!");
                            else
                                actionLabel.setText("You have paid " + (actionCard.getPayAmount()) + " to " + players.get(1).getName() + "!");
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

        BlueCard blueCard = b.getBlueDeck().getTemp().get(b.getBlueDeck().getTemp().size()-1);
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
            blueLabel.setText(blueCard.getName() + "!\nIt is your career! You get $15000!");
            players.get(counter).receiveBlueCard(b.getBlueDeck().getTemp().remove(b.getBlueDeck().getTemp().size()-1), players);
            collectBankBlue.setDisable(true);

            blueDone.setVisible(true);
            blueDone.setDisable(false);
        } else if (e.getSource() == payBankBlue) {
            blueLabel.setText(blueCard.getName() + "!\nNobody has this career. Pay the bank $15000!");
            players.get(counter).receiveBlueCard(b.getBlueDeck().getTemp().remove(b.getBlueDeck().getTemp().size()-1), players);
            payBankBlue.setDisable(true);

            blueDone.setVisible(true);
            blueDone.setDisable(false);
        } else if (e.getSource() == payPlayer) {
            blueLabel.setText(blueCard.getName() + "\nYou have paid " + result + " $15000!");
            players.get(counter).receiveBlueCard(b.getBlueDeck().getTemp().remove(b.getBlueDeck().getTemp().size()-1), players);
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
                        greenLabel.setText("Pay Day!\n You received your salary of $" + players.get(counter).getSalaryCard().getSalary() + "!");
                        players.get(counter).receiveSalary();
                    } else if (players.get(counter).getSpace() == 29) {
                        players.get(counter).receivePayRaise();
                        greenLabel.setText("You get a pay raise!\n Your new salary is $" + players.get(counter).getSalaryCard().getSalary() + "!");
                    }
                    break;

                case "careerPath":
                    if (players.get(counter).getSpace() == 8) {
                        greenLabel.setText("Pay Day! You received your salary of $" + players.get(counter).getSalaryCard().getSalary() + "!");
                        players.get(counter).receiveSalary();
                    } else if (players.get(counter).getSpace() == 3) {
                        players.get(counter).receivePayRaise();
                        greenLabel.setText("You get a pay raise!\n Your new salary is $" + players.get(counter).getSalaryCard().getSalary() + "!");
                    }
                    break;

                case "changeCareerPath":
                    if (players.get(counter).getSpace() == 3) {
                        greenLabel.setText("Pay Day!\n You received your salary of $" + players.get(counter).getSalaryCard().getSalary() + "!");
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
            marryRoll.setVisible(false);
        } else if (e.getSource() == marryOdd) {

            players.get(counter).marry("odd", players);
            marryOdd.setDisable(true);
            marryRoll.setVisible(false);
            marryCont.setVisible(true);
        } else if (e.getSource() == marryEven) {

            players.get(counter).marry("even", players);
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
        ArrayList<CareerCard> cd = b.getCareerDeck().getTemp();
        ArrayList<SalaryCard> sd = b.getSalaryDeck().getTemp();

        CareerCard c = cd.get(cd.size()-1);
        SalaryCard s = sd.get(sd.size()-1);

        if (e.getSource() == jobDraw) {
            jobDone.setVisible(false);
            jobDescription.setText(c.getName());
            salaryDescription.setText(Integer.toString(s.getSalary()));
            jobDraw.setVisible(false);
            jobDraw.setDisable(true);
            bChange.setDisable(false);
            bRetain.setDisable(false);
        } else if (e.getSource() == bRetain) {

            bChange.setDisable(true);
            bRetain.setDisable(true);
            jobDone.setVisible(true);
            jobDone.setDisable(false);
        } else if (e.getSource() == bChange) {

            // set method to update values here
            bChange.setDisable(true);
            bRetain.setDisable(true);
            jobDone.setVisible(true);
            jobDone.setDisable(false);
            players.get(counter).jobSearch(cd.remove(cd.size()-1), sd.remove(sd.size()-1), cd, sd);
        }
    }

    /*
         Buy a House Controllers (DONE AND FUNCTIONAL)
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
        String str;
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        diceRoll = players.get(counter).spin();
        if (diceRoll % 2 == 0)
            str = "even";
        else
            str = "odd";
        Board b = model.getB();
        if (e.getSource() == houseRoll) {

            houseRoll.setDisable(true);
            houseRoll.setVisible(false);

            //if else for odd or even pricing. dont forget setText on the labels
            if (str.equals("even")) {
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
            houseCont.setVisible(false);
            bMobileHome.setDisable(false);
            bCabin.setDisable(false);
            bApartment.setDisable(false);

            bVilla.setDisable(false);
            bCondo.setDisable(false);
        } else if (e.getSource() == bMobileHome) {
            players.get(counter).receiveHouseCard(str, HouseCard.HOUSE[0], b.getHouseDeck());
            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);

            houseCont.setVisible(true);
            houseCont.setDisable(false);
        } else if (e.getSource() == bCabin) {
            players.get(counter).receiveHouseCard(str, HouseCard.HOUSE[1], b.getHouseDeck());
            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);

            houseCont.setVisible(true);
            houseCont.setDisable(false);
        } else if (e.getSource() == bApartment) {
            players.get(counter).receiveHouseCard(str, HouseCard.HOUSE[2], b.getHouseDeck());
            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);

            houseCont.setVisible(true);
            houseCont.setDisable(false);
        } else if (e.getSource() == bVilla) {
            players.get(counter).receiveHouseCard(str, HouseCard.HOUSE[4], b.getHouseDeck());
            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);

            houseCont.setVisible(true);
            houseCont.setDisable(false);
        } else if (e.getSource() == bCondo) {
            players.get(counter).receiveHouseCard(str, HouseCard.HOUSE[3], b.getHouseDeck());
            bMobileHome.setDisable(true);
            bCabin.setDisable(true);
            bApartment.setDisable(true);
            bVilla.setDisable(true);
            bCondo.setDisable(true);

            houseCont.setVisible(true);
            houseCont.setDisable(false);
        }
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
            players.get(counter).jobSearch(c, s, b.getCareerDeck().getTemp(), b.getSalaryDeck().getTemp());
            players.get(counter).setCurrentPath("changeCareerPath");
            players.get(counter).setSpace(0);
            careerChange.setVisible(false);
            continuePath.setVisible(false);

            forkContinue.setVisible(true);
            forkContinue.setDisable(false);
        } else if (e.getSource() == continuePath) {

            forkLabel.setText("It's time to start a family!");
            careerChange.setVisible(false);
            continuePath.setVisible(false);

            forkContinue.setVisible(true);
            forkContinue.setDisable(false);
        }
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
        Board b = model.getB();
        int counter = b.getCounter();

        if(e.getSource() == showThem) {
            CareerCard c1 = b.getCareerDeck().getTemp().get(b.getCareerDeck().getTemp().size()-1);
            CareerCard c2 = b.getCareerDeck().getTemp().get(b.getCareerDeck().getTemp().size()-2);

            SalaryCard s1 = b.getSalaryDeck().getTemp().get(b.getSalaryDeck().getTemp().size()-1);
            SalaryCard s2 = b.getSalaryDeck().getTemp().get(b.getSalaryDeck().getTemp().size()-2);

            jobLabel1.setText(c1.getName());
            wageLabel1.setText(Integer.toString(s1.getSalary()));
            jobLabel2.setText(c2.getName());
            wageLabel2.setText(Integer.toString(s2.getSalary()));

            collegeCont.setVisible(false);
            showThem.setVisible(false);
            career1.setVisible(true);
            career2.setVisible(true);
            salary1.setVisible(true);
            salary2.setVisible(true);

            career1.setDisable(false);
            career2.setDisable(false);
            salary1.setDisable(false);
            salary2.setDisable(false);
        }
        else if(e.getSource() == career1) {
            CareerCard c1 = b.getCareerDeck().getTemp().remove(b.getCareerDeck().getTemp().size()-1);
            CareerCard c2 = b.getCareerDeck().getTemp().remove(b.getCareerDeck().getTemp().size()-1);
            players.get(counter).receiveCareerCard(c1, c2, b.getCareerDeck());
            career1.setVisible(true);
            career1.setDisable(true);
            career2.setVisible(false);
            career2.setDisable(true);
        }
        else if(e.getSource() == career2) {
            CareerCard c1 = b.getCareerDeck().getTemp().remove(b.getCareerDeck().getTemp().size()-1);
            CareerCard c2 = b.getCareerDeck().getTemp().remove(b.getCareerDeck().getTemp().size()-1);
            players.get(counter).receiveCareerCard(c2, c1, b.getCareerDeck());
            career1.setVisible(false);
            career1.setDisable(true);
            career2.setVisible(true);
            career2.setDisable(true);
        }
        else if(e.getSource() == salary1) {
            SalaryCard s1 = b.getSalaryDeck().getTemp().remove(b.getSalaryDeck().getTemp().size()-1);
            SalaryCard s2 = b.getSalaryDeck().getTemp().remove(b.getSalaryDeck().getTemp().size()-1);
            players.get(counter).receiveSalaryCard(s1, s2, b.getSalaryDeck());
            salary1.setVisible(true);
            salary1.setDisable(true);
            salary2.setVisible(false);
            salary2.setDisable(true);
        }
        else if(e.getSource() == salary2) {
            SalaryCard s1 = b.getSalaryDeck().getTemp().remove(b.getSalaryDeck().getTemp().size()-1);
            SalaryCard s2 = b.getSalaryDeck().getTemp().remove(b.getSalaryDeck().getTemp().size()-1);
            players.get(counter).receiveSalaryCard(s2, s1, b.getSalaryDeck());
            salary1.setVisible(false);
            salary1.setDisable(true);
            salary2.setVisible(true);
            salary2.setDisable(true);
        }

        if ((salary1.isDisabled() && salary2.isDisabled()) && (career1.isDisabled() && career2.isDisabled()))
            collegeCont.setVisible(true);
    }

    /*
        Winner Screen Controllers
    */

    @FXML
    private Label winnerName, winnerCash, winnerKids, secondName, secondCash, secondKids, thirdName, thirdCash, thirdKids;
    @FXML
    private Button winnerDone, showWinner;

    @FXML
    public void displayWinner() throws Exception {
        Stage winnerP = new Stage();
        Parent winnerCard = FXMLLoader.load(getClass().getResource("View/showStats.fxml"));

        winnerP.initStyle(StageStyle.UNDECORATED);
        winnerP.initModality(Modality.APPLICATION_MODAL);
        winnerP.setScene(new Scene(winnerCard, 600, 400));
        winnerP.setResizable(false);
        winnerP.showAndWait();
    }

    @FXML
    public void displayStats(ActionEvent e) {

        ArrayList<Player> winners = model.getB().getWinners();
        Board b = model.getB();
        int counter = b.getCounter();

        if(e.getSource() == showWinner) {

            winnerName.setText("Player Name: " + winners.get(0).getName());
            winnerCash.setText("Cash Remaining: $" + + winners.get(0).getCash());
            winnerKids.setText("Children: " + + winners.get(0).getNumChildren());

            secondName.setText("Player Name: " + winners.get(1).getName());
            secondCash.setText("Cash Remaining: $" + + winners.get(1).getCash());
            secondKids.setText("Children: " + winners.get(1).getNumChildren());

            if ( model.getNumPlayers() == 3){
                thirdName.setText("Player Name: " + winners.get(2).getName());
                thirdCash.setText("Cash Remaining: $" + winners.get(2).getCash());
                thirdKids.setText("Children: " + winners.get(2).getNumChildren());
            }

            showWinner.setVisible(false);
            winnerDone.setVisible(true);
            leaveGame.setVisible(true);
            rankings.setVisible(false);
        }
    }
        
    @FXML // FUNCTIONAL
    public void nextTurn() throws Exception {
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        if (model.getNumPlayers() == 2) {
           if (b.getCounter() == players.size()-1)
               b.setCounter(0);
           else
               b.setCounter(b.getCounter()+1);
        } else if (model.getNumPlayers() == 3) {
            if (b.getCounter() == players.size()-1)
                b.setCounter(0);
            else
                b.setCounter(b.getCounter()+1);
        }
        rollSpin.setDisable(false);
        nextPlayer.setDisable(true);
        System.out.println(b.getCounter());
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
        int diceRoll = (int)(Math.random() * ((2-1)+1) + 1);
        ArrayList<Player> players = model.getB().getPlayers();
        int counter = model.getB().getCounter();
        Board b = model.getB();

        if(e.getSource() == babyRoll) {
            babyRoll.setDisable(true);
            babyRoll.setVisible(false);

            switch (diceRoll) {
                case 1 -> {
                    babyLabel.setText("Congratulations!\nCollect $5000 from other players!");
                    babyCollect.setText("Collect $5000");
                    babyCollect.setDisable(false);
                }
                case 2 -> {
                    babyLabel.setText("TWINS!\nCollect $10000 from other players!");
                    babyCollect.setText("Collect $10000");
                    babyCollect.setDisable(false);
                }

            }
        }
        else if(e.getSource() == babyCollect) {
            System.out.println(diceRoll);
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