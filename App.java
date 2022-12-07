
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
//import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.scene.canvas.*;
import javafx.scene.input.MouseEvent;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;


public class App extends Application{
    
    Canvas cv;
    Scene sc;
    Board board = new Board();  //Boardオブジェクト作成
    
    int X, Y;
    
    public static void main(String[] args){
        launch(args);
    }    
    

    //8x8マスの画面表示
    //@Override
    public void start(Stage stage)throws Exception{
        //コントロールの作成
        cv = new Canvas(800,800);
        //コントロールの設定
        
        BorderPane bp = new BorderPane();
        bp.setCenter(cv);
        sc = new Scene(bp, 800,800);
        
        stage.setScene(sc);
        
        banmen();
        view();
        //ソースにイベントハンドラーを登録
        sc.addEventHandler(MouseEvent.MOUSE_CLICKED, new Clickevent());
        
        
        stage.setTitle("オセロ");
        stage.show();  
        roopView();
    }
    
    

    public void banmen(){
        GraphicsContext gc = cv.getGraphicsContext2D();

        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, 640, 640);
        
        gc.setStroke(Color.BLACK);
        for(int i=0; i<8; i++){
            X = i*80;
            Y = i*80;
            gc.strokeLine(0, Y+80, 640, Y+80);
            //点(0, Y+80)、点(640, Y+80)を線で結ぶ
            gc.strokeLine(X+80, 0, X+80, 640);
            //点(X+80, 0)、点(X+80, 640)を線で結ぶ
        }
    }

    
    public void view(){
        GraphicsContext gc = cv.getGraphicsContext2D();

        for(int x=0; x<8; x++){
            for(int y=0; y<8; y++){
                X = x*80;
                Y = y*80;

                if(Board.board[y][x] == Board.BLACK){
                    gc.setFill(Color.BLACK);
                    gc.fillOval(X+2, Y+5, x+68, y+68);
                }
                if(Board.board[y][x] == Board.WHITE){
                    gc.setFill(Color.WHITE);
                    gc.fillOval(X+2, Y+5, x+68, y+68);
                }
            }
        }
    }
    
    //400ミリ秒ごとに描画（viewメソッド）する処理
    public void roopView() throws ParseException {
        Timer timer = new Timer(false);
		TimerTask task = new TimerTask(){

            @Override
            public void run(){
                view();
            }
        };
        timer.schedule(task, 0, 100);    //10は重い？
    }
}