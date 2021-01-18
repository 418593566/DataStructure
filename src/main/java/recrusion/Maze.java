package recrusion;

import java.util.HashMap;
import java.util.Map;

/**
 * 迷宫
 */
public class Maze {
    static int count;
    public static void main(String[] args) {
        int[][] map = new int[8][7];

        //上下
        for (int i = 0; i < 7; i++) {
            //行不变 列变
            map[7][i] = 1;
            map[0][i] = 1;
        }
        //左右
        for (int i = 0; i < 8; i++) {
            //列不变，行变
            map[i][6] = 1;
            map[i][0] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 7; i1++) {
                System.out.print("\t" + map[i][i1]);
            }
            System.out.println();
        }

        boolean b = Explorer(map, 1, 1);

        boolean b2 = Explorer2(map, 1, 1);

        getMap(map,8,7);
        System.out.println(count);

    }

    /**
     * 走迷宫
     * 约定：
     * -->map=0;表示没有走过
     * map=1;是墙
     * map=2;成功
     * map=3;死路
     * 走的方式     上 右 下 左
     *
     * @param map 地图
     * @param x   开始的x轴
     * @param y   开始的y轴
     * @return
     */
    public static boolean Explorer(int[][] map, int x, int y) {
        //成功的地点
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[x][y] == 0) {    //表示没有走过
                //起始位置
                map[x][y] = 2;
                if (map[x][y] == 2) {
                    count++;
                }
                //往上走
                if (Explorer(map, x + 1, y)) {
                    return true;
                    //往左走
                } else if (Explorer(map, x, y - 1)) {
                    return true;
                }
                else  if (Explorer(map, x - 1, y)) {
                    return true;
                    //往右走
                } else if (Explorer(map, x, y + 1)) {
                    return true;
                    //往下走
                } else {
                    //走不通
                    map[x][y] = 3;
                    return false;
                }
            } else {
                //如果map!=0   就是 1 ,2，3 其中如何一项
                return false;
            }
        }
    }

    //下 右 上 左
    public static boolean Explorer2(int[][] map, int x, int y) {
        //成功的地点
        if (map[5][5] == 2) {
            return true;
        } else {
            if (map[x][y] == 0) {    //表示没有走过
                //起始位置
                map[x][y] = 2;
                if (map[x][y]==2){
                    count++;
                }
                if (Explorer2(map, x + 1, y)) {
                    return true;
                } else if (Explorer2(map, x, y + 1)) {
                    return true;
                } else if (Explorer2(map, x - 1, y)) {
                    return true;
                } else if (Explorer2(map, x, y - 1)) {
                    return true;
                } else {
                    //走不通
                    map[x][y] = 3;
                    return false;
                }
            } else {
                //如果map!=0   就是 1 ,2，3 其中如何一项
                return false;
            }
        }
    }

    public static int getCount(int[][] map, boolean bool) {
        if (bool) {
            int count = 0;
            for (int i = 0; i < 8; i++) {
                for (int i1 = 0; i1 < 7; i1++) {
                    if (map[i][i1] == 2) {
                        count++;
                    }
                }
            }
            return count;
        }
        return 0;
    }

    public static void getMap(int[][] map, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
