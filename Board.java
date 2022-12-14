public class Board{

    public static int[][] board= new int[8][8];  //配列でコマを管理する
    public static int BLACK = 1;        //黒のコマを1
    public static int WHITE = 2;        //白のコマを2


    //コンストラクタ。初期の配置をセット
    public Board(){
        for(int x=0; x<8; x++){
            for(int y=0; y<8; y++){
                board[y][x] = 0;    //コマを初期化（0）にする
            }
        }
        //ゲーム開始前の初期の配置
        board[3][4] = BLACK;
        board[4][3] = BLACK;
        board[3][3] = WHITE;
        board[4][4] = WHITE;
    }

    //コマを反転させる
    public static void reversal(int y, int x){
        if(board[y][x] == BLACK){
            board[y][x] = WHITE;
        }else {
            board[y][x] = BLACK;
        }
    }

    //上判定
    public static void Up_judge(int my, int mx) {
        int y = my;
        int x = mx;
        int deference = 0;
        int flag = 0;
        try{
            if((board[my-1][mx] != board[my][mx]) && board[my-1][mx] != 0){   //上が相手のコマだったら
                do{
                    y--;
                    deference++;
    
                    if(board[y][x] == board[my][mx]){
                        flag = 1;   //ひっくり返すことが可能
                        break;
                    }
                    
                }while((board[my][mx] != board[y][x]) && board[y][x] != 0);
    
                if(flag == 1){      //ひっくり返すことが可能ならひっくり返す
                    for(int i=1; i<=deference-1; i++){
                        Board.reversal(my - i, mx);
                    }
                }
            }
        }catch(Exception e){
            //何もしない
        }
    }

    //下判定
    public static void Under_judge(int my, int mx){
        int y = my;
        int x = mx;
        int deference = 0;
        int flag = 0;
 
        try{
            if((board[my+1][mx] != board[my][mx]) && board[my+1][mx] != 0){   //下が相手のコマだったら
                do{
                    y++;
                    deference++;
                    if(board[y][x] == board[my][mx]){
                        flag = 1;   //ひっくり返すことが可能
                        break;
                    }
                }while((board[my][mx] != board[y][x]) && board[y][x] != 0);
    
                if(flag == 1){      //ひっくり返すことが可能ならひっくり返す
                    for(int i=1; i<=deference-1; i++){
                        Board.reversal(my + i, mx);
                    }
                }
            } 
        }catch(Exception e){
            //何もしない
        }
    }

    //右判定
    public static void Right_judge(int my, int mx){
        int y = my;
        int x = mx;
        int deference = 0;
        int flag = 0;
        try{
            if((board[my][mx+1] != board[my][mx]) && board[my][mx+1] != 0){   //右が相手のコマだったら
                do{
                    x++;
                    deference++;
                    if(board[y][x] == board[my][mx]){
                        flag = 1;   //ひっくり返すことが可能
                        break;
                    }
                }while((board[my][mx] != board[y][x]) && board[y][x] != 0);
    
                if(flag == 1){      //ひっくり返すことが可能ならひっくり返す
                    for(int i=1; i<=deference-1; i++){
                        Board.reversal(my, mx + i);
                    }
                }
            }
        }catch(Exception e){
            //何もしない
        }
    }

    //左判定
    public static void Left_judge(int my, int mx){
        int y = my;
        int x = mx;
        int deference = 0;
        int flag = 0;
        try{
            if((board[my][mx-1] != board[my][mx]) && board[my][mx-1] != 0){   //左が相手のコマだったら
                do{
                    x--;
                    deference++;
                    if(board[y][x] == board[my][mx]){
                        flag = 1;   //ひっくり返すことが可能
                        break;
                    }
                }while((board[my][mx] != board[y][x]) && board[y][x] != 0);
    
                if(flag == 1){      //ひっくり返すことが可能ならひっくり返す
                    for(int i=1; i<=deference-1; i++){
                        Board.reversal(my, mx - i);
                    }
                }
            }
        }catch(Exception e){
            //何もしない
        }
    }

    //左斜め上判定
    public static void Up_to_Left_judge(int my, int mx){
        int y = my;
        int x = mx;
        int deference = 0;
        int flag = 0;
        try{
            if((board[my-1][mx-1] != board[my][mx]) && board[my-1][mx-1] != 0){   //左斜め上が相手のコマだったら
                do{
                    x--;
                    y--;
                    deference++;
                    if(board[y][x] == board[my][mx]){
                        flag = 1;   //ひっくり返すことが可能
                        break;
                    }
                }while((board[my][mx] != board[y][x]) && board[y][x] != 0);
    
                if(flag == 1){      //ひっくり返すことが可能ならひっくり返す
                    for(int i=1; i<=deference-1; i++){
                        Board.reversal(my - i, mx - i);
                    }
                }
            }
        }catch(Exception e){
            //何もしない
        }
    }


    //右斜め上判定
    public static void Up_to_Right_judge(int my, int mx){
        int y = my;
        int x = mx;
        int deference = 0;
        int flag = 0;
        try{
            if((board[my-1][mx+1] != board[my][mx]) && board[my-1][mx+1] != 0){   //右斜め上が相手のコマだったら
                do{
                    x++;
                    y--;
                    deference++;
                    if(board[y][x] == board[my][mx]){
                        flag = 1;   //ひっくり返すことが可能
                        break;
                    }
                }while((board[my][mx] != board[y][x]) && board[y][x] != 0);
    
                if(flag == 1){      //ひっくり返すことが可能ならひっくり返す
                    for(int i=1; i<=deference-1; i++){
                        Board.reversal(my - i, mx + i);
                    }
                }
            }
        }catch(Exception e){
            //何もしない
        }   
    }


    //左斜め下判定
    public static void Under_to_Left_judge(int my, int mx){
        int y = my;
        int x = mx;
        int deference = 0;
        int flag = 0;
        try{
            if((board[my+1][mx-1] != board[my][mx]) && board[my+1][mx-1] != 0){   //左斜め下が相手のコマだったら
                do{
                    x--;
                    y++;
                    deference++;
                    if(board[y][x] == board[my][mx]){
                        flag = 1;   //ひっくり返すことが可能
                        break;
                    }
                }while((board[my][mx] != board[y][x]) && board[y][x] != 0);
    
                if(flag == 1){      //ひっくり返すことが可能ならひっくり返す
                    for(int i=1; i<=deference-1; i++){
                        Board.reversal(my + i, mx - i);
                    }
                }
            }
        }catch(Exception e){
            //何もしない
        }   
    }


    //右斜め下判定
    public static void Under_to_Right_judge(int my, int mx){
        int y = my;
        int x = mx;
        int deference = 0;
        int flag = 0;
        try{
            if((board[my+1][mx+1] != board[my][mx]) && board[my+1][mx+1] != 0){   //右斜め下が相手のコマだったら
                do{
                    x++;
                    y++;
                    deference++;
                    if(board[y][x] == board[my][mx]){
                        flag = 1;   //ひっくり返すことが可能
                        break;
                    }
                }while((board[my][mx] != board[y][x]) && board[y][x] != 0);
    
                if(flag == 1){      //ひっくり返すことが可能ならひっくり返す
                    for(int i=1; i<=deference-1; i++){
                        Board.reversal(my + i, mx + i);
                    }
                }
            }
        }catch(Exception e){
            //何もしない
        }   
    }
}