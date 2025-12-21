class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] arr1Final = helper(arr1, n);
        String[] arr2Final = helper(arr2, n);
         
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                int arr1Number = arr1Final[i].charAt(j) - '0';
                int arr2Number = arr2Final[i].charAt(j) - '0';
                if (arr1Number == 1 || arr2Number == 1) {
                    sb.append("#");
                }
                else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
                
    public String[] helper(int[] arr, int n) {
        String[] returnValue = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            StringBuilder sb = new StringBuilder();
            while (value >= 1){
                sb.append(value % 2);
                value /= 2;
            }
            while (sb.length() < n) {
                sb.append(0);
            }
            returnValue[i] = sb.reverse().toString();
        }
        return returnValue;
    }
}