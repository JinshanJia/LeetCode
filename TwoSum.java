/*
* Name: Jinshan Jia
* 10/01/2013
* Email: jiajinshan2009@gmail.com
*/
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
	    int max = target;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) { 
                max = numbers[i];
            }
        }

        int[] hash = new int[max+1];
        for (int i = 0; i < numbers.length; i++) {
            hash[numbers[i]] = i + 1;
        }
        
        int numbers2[] = new int[numbers.length];
        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = target - numbers[i];
        }
        
        int[] result = {-1, -1};
        for (int i = 0; i < numbers2.length; i++) {
            if (numbers2[i] > 0 && hash[numbers2[i]] > 0 && hash[numbers2[i]] != i + 1) {
                if (i + 1 > hash[numbers2[i]]) {
                    result[0] = hash[numbers2[i]];
                    result[1] = i + 1;
                } else {
                    result[1] = hash[numbers2[i]];
                    result[0] = i + 1;
                }
            }
        }
        return result;
    }
}
