package com.example.erwan_lecoz_morpiob;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNDECORATED);
        FXMLLoader fxmlMenuLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
        Scene sceneMenu = new Scene(fxmlMenuLoader.load());
        stage.setTitle("Titre");
        stage.setScene(sceneMenu);

        Stage modalPlayerPage = new Stage(StageStyle.UNDECORATED); // Remove the title bar
        modalPlayerPage.initModality(Modality.WINDOW_MODAL); // Set as a modal window
        modalPlayerPage.initOwner(stage);

        FXMLLoader fxmlPlayPageLoader = new FXMLLoader(HelloApplication.class.getResource("playerPage.fxml"));
        Scene scenePlayPage = new Scene(fxmlPlayPageLoader.load());
        modalPlayerPage.setScene(scenePlayPage);

        MenuController menucontroller = (MenuController)fxmlMenuLoader.getController();
        menucontroller.setGameWindow(modalPlayerPage);

        Stage modalLogo = new Stage(StageStyle.UNDECORATED); // Remove the title bar
        modalLogo.initModality(Modality.APPLICATION_MODAL); // Set as a modal window
        modalLogo.initOwner(stage);
        FXMLLoader fxmlLogoLoader = new FXMLLoader(getClass().getResource("changeLogo.fxml"));
        Scene sceneLogo = new Scene(fxmlLogoLoader.load());
        modalLogo.setScene(sceneLogo);
        menucontroller.setLogoWindow(modalLogo);

        ChangeLogoController logocontroller = (ChangeLogoController) fxmlLogoLoader.getController();
        logocontroller.setController(menucontroller);
        menucontroller.setControllerLogo(logocontroller);

        Stage modalWindow = new Stage(StageStyle.UNDECORATED); // Remove the title bar
        modalWindow.initModality(Modality.WINDOW_MODAL); // Set as a modal window
        modalWindow.initOwner(stage);

        FXMLLoader fxmlGameLoader = new FXMLLoader(getClass().getResource("game.fxml"));
        Scene sceneGame = new Scene(fxmlGameLoader.load()); // Load the FXML and then get the controller
        modalWindow.setScene(sceneGame);

        PlayPageController playpagecontroller = (PlayPageController)fxmlPlayPageLoader.getController();
        playpagecontroller.setGameWindow(modalWindow);
        playpagecontroller.setController(fxmlGameLoader.getController());

        FXMLLoader fxmlRelanceLoader = new FXMLLoader(getClass().getResource("relanceGame.fxml"));
        Scene sceneRelance = new Scene(fxmlRelanceLoader.load()); // Load the FXML and then get the controller

        GameController controller = (GameController)fxmlGameLoader.getController();
        controller.setStage(modalWindow);
        controller.setGameScene(sceneRelance);
        controller.setSecondaryController(fxmlRelanceLoader.getController());
        menucontroller.setControllerGame(controller);

        relanceController controllerRelance = (relanceController)fxmlRelanceLoader.getController();
        controllerRelance.setStage(modalWindow);
        controllerRelance.setGameScene(sceneGame);
        controllerRelance.setScenePseudo(scenePlayPage);
        controllerRelance.setController(fxmlGameLoader.getController());


        //LeaveWindow
        Stage modalLeave = new Stage(StageStyle.UNDECORATED); // Remove the title bar
        modalLeave.initModality(Modality.APPLICATION_MODAL); // Set as a modal window
        modalLeave.initOwner(stage);
        FXMLLoader fxmlLeaveLoader = new FXMLLoader(getClass().getResource("leaveGame.fxml"));
        Scene sceneLeave = new Scene(fxmlLeaveLoader.load()); // Load the FXML and then get the controller
        modalLeave.setScene(sceneLeave);
        controller.modalLeave=modalLeave;

        //RègleWindow
        Stage modalRules = new Stage(StageStyle.UNDECORATED); // Remove the title bar
        modalRules.initModality(Modality.APPLICATION_MODAL); // Set as a modal window
        modalRules.initOwner(stage);
        FXMLLoader fxmlRulesLoader = new FXMLLoader(getClass().getResource("rules.fxml"));
        Scene sceneRules = new Scene(fxmlRulesLoader.load()); // Load the FXML and then get the controller
        modalRules.setScene(sceneRules);
        controller.modalRules=modalRules;

        //WhoPlay
        Stage modalWhoPlay = new Stage(StageStyle.UNDECORATED); // Remove the title bar
        modalWhoPlay.initModality(Modality.APPLICATION_MODAL); // Set as a modal window
        modalWhoPlay.initOwner(stage);
        FXMLLoader fxmlWhoPlayLoader = new FXMLLoader(getClass().getResource("whoPlay.fxml"));
        Scene sceneWhoPlay = new Scene(fxmlWhoPlayLoader.load()); // Load the FXML and then get the controller
        modalWhoPlay.setScene(sceneWhoPlay);
        controller.modalWhoPlay=modalWhoPlay;
        playpagecontroller.setControllerWhoPlay(fxmlWhoPlayLoader.getController());
        WhoPlayController whoplaycontroller = (WhoPlayController) fxmlWhoPlayLoader.getController();
        whoplaycontroller.setController(fxmlGameLoader.getController());


        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
