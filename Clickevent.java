import javafx.scene.input.MouseEvent;

public class Clickevent implements javafx.event.EventHandler<MouseEvent>{
    int flag = 0;
    public void handle(MouseEvent e){
        
        //クリックしたときの座標取得
        int mx = (int)e.getX() / 80;    //座標をマスの大きさである80で割り、
        int my = (int)e.getY() / 80;    //配列のインデックスを取得

        //置けるかどうかの判定
        if (regulation.put_on(my, mx) == false){
            Board.board[my][mx] = 0;
        }
        else if(flag == 0){     //黒と白を交互にコマを置く
            Board.board[my][mx] = Board.BLACK;
            flag = 1;
            System.out.println("next is ___WHITE Turn___");
        }else{
            Board.board[my][mx] = Board.WHITE;
            flag = 0;
            System.out.println("next is ___BLACK Turn___");
        }
        
        Board.Up_judge(my, mx);             //上判定
        Board.Under_judge(my, mx);          //下判定
        Board.Right_judge(my, mx);          //右判定
        Board.Left_judge(my, mx);           //左判定
        Board.Up_to_Left_judge(my, mx);     //左斜め上判定
        Board.Up_to_Right_judge(my, mx);    //右斜め上判定
        Board.Under_to_Left_judge(my, mx);  //左斜め下判定
        Board.Under_to_Right_judge(my, mx); //右斜め下
    }
    
}