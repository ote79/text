package Chapter08;

import java.util.Scanner;
//黄色先手
//red = 1 yellow = 2
public class zy20 {
    public static void main(String[] age){
        Scanner input = new Scanner(System.in);
        int[][] list = new int[6][7];int count = 1;
        while ((!xy(list))&&(!x(list))&&(!y(list))){
            video(list);
            if (count % 2 == 1)
                System.out.println("该回合为 黄色 下棋！！！");
            else
                System.out.println("该回合为 红色 下棋！！！");
            int x = input.nextInt();int y = input.nextInt();
            if (list[x][y] != 0){
                System.out.println("-------------------------");
                System.out.println("|提示：该位置已经被占用！！！|");
                System.out.println("|      》请重试！！！《    |");
                System.out.println("-------------------------");
                continue;
            }
            list[x][y] = (count % 2 + 1);
            count++;
        }
        video(list);
        if (count % 2 == 1)
            System.out.println("红色获胜！！！");
        else
            System.out.println("黄色获胜！！！");
    }
    public static void video(int[][] list){
        for (int i = 0;i < list.length;i++){
            for (int n = 0;n < list[i].length;n++){
                if (n == 6){
                    if (list[i][n] == 0)
                        System.out.println("|"+" "+"|");
                    if (list[i][n] == 1)
                        System.out.println("|"+"R"+"|");
                    if (list[i][n] == 2)
                        System.out.println("|"+"Y"+"|");
                }
                else {
                    if (list[i][n] == 0)
                        System.out.print("|"+" ");
                    if (list[i][n] == 1)
                        System.out.print("|"+"R");
                    if (list[i][n] == 2)
                        System.out.print("|"+"Y");
                }
            }
        }
    }
//    public static boolean checkSame(int[][] list,int x,int y){
//        return list[x][y] == 0;
//    }
    public static boolean xy(int[][] list) {
        boolean x = false,y = false;
        for (int i = 0;i < list.length;i++){
            for (int n = 0;n < list[i].length;n++){
                int count = 0;
                if (list[i][n] == 0)
                    continue;
                else {
                    for (int row = i,link = n;row < list.length && link < list[i].length;row++,link++){
                        if (list[i][n] == list[row][link])
                            count++;
                        else break;
                    }
                }
                if (count == 4)
                    x = true;
            }
        }
        for (int i = 0;i < list.length;i++){
            for (int n = 0;n < list[i].length;n++){
                int count = 0;
                if (list[i][n] == 0)
                    continue;
                else {
                    for (int row = i,link = n;row > -1 && link < list[i].length;row--,link++){
                        if (list[i][n] == list[row][link])
                            count++;
                        else break;
                    }
                }
                if (count == 4)
                    y = true;
            }
        }
        return (x || y);
    }
    public static boolean x(int[][] list) {
        for (int i = 0; i < list.length; i++) {
            for (int n = 0; n < list[i].length; n++) {
                int count = 0;
                if (list[i][n] == 0)
                    continue;
                else {
                    for (int x = n; x < list.length;x++){
                        if (list[i][n] == list[i][x])
                            count++;
                        else break;
                    }
                }
                if (count == 4)
                    return true;
            }

        }
        return false;
    }
    public static boolean y(int[][] list) {
        for (int i = 0; i < list[0].length; i++) {
            for (int n = 0; n < list.length; n++) {
                int count = 0;
                if (list[n][i] == 0)
                    continue;
                else {
                    for (int x = n; x < list.length;x++){
                        if (list[x][i] == list[n][i])
                            count++;
                        else break;
                    }
                }
                if (count == 4)
                    return true;
            }

        }
        return false;
    }
}
