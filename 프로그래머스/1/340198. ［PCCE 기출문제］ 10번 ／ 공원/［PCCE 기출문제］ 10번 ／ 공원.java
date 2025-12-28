import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {

        Arrays.sort(mats);
        // 큰 매트부터
        for (int m = mats.length - 1; m >= 0; m--) {
            int mat = mats[m];

            for (int i = 0; i + mat <= park.length; i++) {
                for (int j = 0; j + mat <= park[0].length; j++) {

                    boolean isAvailable = true;

                    outer:
                    for (int w = i; w < i + mat; w++) {
                        for (int h = j; h < j + mat; h++) {
                            if (!park[w][h].equals("-1")) {
                                isAvailable = false;
                                break outer;
                            }
                        }
                    }

                    if (isAvailable) {
                        return mat;
                    }
                }
            }
        }

        return -1;
    }
}
