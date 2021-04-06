
// imports all of the import statements
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;


public class FinalProject_CST240_JA extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage)
    {
        final Label label = new Label();

        // Creates the array for all 10 songs in the playlist
        File soundFile[] = new File[10];
        soundFile[0] = new File(""); // Type MP3 File Path In Between Quotations Marks
        soundFile[1] = new File(""); // Type MP3 File Path In Between Quotations Marks 
        soundFile[2] = new File(""); // Type MP3 File Path In Between Quotation Marks
        soundFile[3] = new File(""); // Type MP3 File Path In Between Quotation Marks
        soundFile[4] = new File(""); // Type MP3 File Path In Between Quotation Marks
        soundFile[5] = new File(""); // Type MP3 File Path In Between Quotation Marks
        soundFile[6] = new File(""); // Type MP3 File Path In Between Quotation Marks
        soundFile[7] = new File(""); // Type MP3 File Path In Between Quotation Marks
        soundFile[8] = new File(""); // Type MP3 File Path In Between Quotation Marks
        soundFile[9] = new File(""); // Type MP3 File Path In Between Quotation Marks

        //Creates the buttons for play, pause, stop, rewind, and fast forward buttons
        Button playButton = new Button("");
        Button pauseButton = new Button("");
        Button stopButton = new Button("");
        Button fastForward = new Button("");
        Button rewind = new Button("");
        Button selector = new Button("Select File");

        // Imports the graphic used for the play button
        Image playPic = new Image("file:"); //Type File Path For Play Button In Between Quotations After "file"
        ImageView playpicIV = new ImageView(playPic);
        playpicIV.setFitHeight(40);
        playpicIV.setPreserveRatio(true);
        playButton.setPrefSize(50,20);
        playButton.setGraphic(playpicIV);

        // Imports the graphic used for the pause button
        Image pauPic = new Image("file:"); //Type File Path For Pause Button In Between Quotations After "file"
        ImageView pauPicIV = new ImageView(pauPic);
        pauPicIV.setFitHeight(40);
        pauPicIV.setPreserveRatio(true);
        pauseButton.setPrefSize(50,20);
        pauseButton.setGraphic(pauPicIV);

        // Imports te graphic used for the stop button
        Image stopPic = new Image("file:"); //Type File Path For Stop Button In Between Quotations After "file"
        ImageView stopPicIV = new ImageView(stopPic);
        stopPicIV.setFitHeight(40);
        stopPicIV.setPreserveRatio(true);
        stopButton.setPrefSize(50,20);
        stopButton.setGraphic(stopPicIV);


        // Imports the graphic used for the fast forward button
        Image fastfor = new Image("file:"); //Type File Path For FastForward Button In Between Quotations After "file"
        ImageView fastforIV = new ImageView(fastfor);
        fastforIV.setFitHeight(40);
        fastforIV.setPreserveRatio(true);
        fastForward.setPrefSize(50,20);
        fastForward.setGraphic(fastforIV);

        // Imports the graphic used for the rewind button
        Image rr = new Image("file:"); //Type File Path For Rewind Button In Between Quotations After "file"
        ImageView rrIV = new ImageView(rr);
        rrIV.setFitHeight(40);
        rrIV.setPreserveRatio(true);
        rewind.setPrefSize(50,20);
        rewind.setGraphic(rrIV);

        // Gets the song from the array and puts it into a format that java can read
        Media[] songs = {new Media(soundFile[0].toURI().toString())};
        MediaPlayer[] player = new MediaPlayer[]{new MediaPlayer(songs[0])};

        // Creates the file selector button
        selector.setOnAction(event ->
        {
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("")); //Enter file path of where the program should look for the MP3 files In Between Quotation Marks
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.mp3", "*.mp3"));
            File file = fc.showOpenDialog(null);
            String path = file.getAbsolutePath();
            path = path.replace("\\", "/");
            songs[0] = new Media(new File(path).toURI().toString());
            player[0] = new MediaPlayer(songs[0]);

            // Displays the name of the song
            label.setText("Now Playing: "+ file.getName());
            primaryStage.setTitle(label.getText());

        });

            // Links the play button to the play action
            playButton.setOnAction(event ->
            {
                player[0].play();
            });

            // Links the pause button to the pause action
            pauseButton.setOnAction(event ->
            {
                player[0].pause();
            });

            // Links the stop button to the stop action
            stopButton.setOnAction(event ->
            {
                player[0].stop();
            });

            // Links the fast forward button to the fast forward action
            fastForward.setOnAction(event ->
            {
                double t = player[0].getCurrentTime().toSeconds();
                t = t + 5;
                player[0].seek(new Duration(t * 1000));
            });

            // Links the rewind button to the rewind action
            rewind.setOnAction(event ->
            {
                double t = player[0].getCurrentTime().toSeconds();
                t = t - 10;
                player[0].seek(new Duration(t * 1000));
            });

        // Adds the buttons to the HBox layout
        HBox hbox = new HBox(10,playButton,pauseButton,stopButton,rewind,fastForward,selector);
        // Centers all of the buttons
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10));

        // Adds the HBox to the scene and displays
        Scene scene = new Scene(hbox);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}

/*
    Juan Alexander
    Final Programming Project
    CST 240 - 005
    11/29/20
 */
