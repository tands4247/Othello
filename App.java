import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.scene.canvas.*;
import javafx.scene.input.MouseEvent;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;


public class App extends Application{   //JavaFXパッケージのApplicationクラスを継承
    
    Canvas cv;  //図形や画像を描画するための部品キャンバス
    Scene sc;   //シーン。内容全体
    Board board = new Board();  //Boardオブジェクト作成
    int X, Y;
    public static void main(String[] args){
        launch(args);
    }    

    //8x8マスの画面表示
    public void start(Stage stage)throws Exception{
        //コントロールの作成
        cv = new Canvas(800,800);
        
        BorderPane bp = new BorderPane();   //ペインに追加
        bp.setCenter(cv);                   //ペインにコントロールを追加
        sc = new Scene(bp, 800,800);        //ペインを設定したシーンを作成
        
        stage.setScene(sc);                 //ステージにシーンを追加する
        
        banmen();       //緑の盤面を表示するメソッド
        view();         //盤面に白黒のコマを置くメソッド

        //ソースにイベントハンドラーを登録（クリックイベント処理）
        sc.addEventHandler(MouseEvent.MOUSE_CLICKED, new Clickevent());
        
        stage.setTitle("オセロ");
        stage.show();  
        roopView();         //盤面を描画し続けるメソッド（盤面の更新）
    }
    
    
    public void banmen(){
        GraphicsContext gc = cv.getGraphicsContext2D();     //図形や色を描画するオブジェクト
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
        GraphicsContext gc = cv.getGraphicsContext2D();     //図形や色を描画するオブジェクト

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
    
    //100ミリ秒ごとに描画（viewメソッド）する処理
    public void roopView() throws ParseException {
        Timer timer = new Timer(false);
		TimerTask task = new TimerTask(){

            @Override
            public void run(){
                view();
            }
        };
        timer.schedule(task, 0, 100);
    }
}