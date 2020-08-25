package array;

import java.util.Arrays;

public class T733_floodFill {
    public static void main(String[] args) {
        int[][] image = {{0,0,0},{0,0,0}};
        T733_floodFill t = new T733_floodFill();
        System.out.println(Arrays.deepToString(t.floodFill(image, 0, 0, 2)));
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color == newColor) {
            return image;
        }
        dfs(image, sr, sc, color, newColor);
        return  image;
    }
    public void dfs (int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0|| sc < 0 || sr > image.length - 1 || sc > image[0].length - 1) {
            return;
        }
        if (image[sr][sc] == color) {
            image[sr][sc] = newColor;
            dfs (image, sr - 1, sc, color, newColor);
            dfs (image, sr, sc - 1, color, newColor);
            dfs (image, sr + 1, sc, color, newColor);
            dfs (image, sr, sc + 1, color, newColor);
        }
    }
}

