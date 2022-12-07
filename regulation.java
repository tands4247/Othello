public class regulation {

    //コマがおけるか判定
    public static boolean put_on(int my, int mx){
        int flag = 0;
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                try{
                    //置ける場合
                    if((Board.board[my][mx] != Board.board[my+i][mx+j]) || (Board.board[my+i][mx+j] != 0)){
                        flag = 1;
                    }
                }catch(Exception e){
                    //何もしない
                }
            }
        }
        //置ける場合、true  置けない場合、falseを返す
        if(flag == 1) return true;
        else {
            System.out.println("Can't Put");
            return  false;
        }
    }
}
