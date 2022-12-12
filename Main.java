import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /*
        *
        *
        input - abcd(efg)hijk
        output - abcd(gfe)hijk
        input - abcd(efg)hijk(lmn)opq
        output - abcd(gfe)hijk(nml)opq
        input - abcd
        output - abcd
        input - (abcd)
        output - (dcba)
        * */
        Arrays.asList(new String[]{"abcd(efg)hijk", "a(123)(456789)(8989)(1111)", "abcd(efg)hijk(lmn)opq","(abcd)","abcd"}).stream().forEach(
                e -> {
                    char[] string = e.toCharArray();
                    int left = 0;
                    if (string.length >= 3) {
                        while (left < string.length - 2) {
                            if (string[left] == '(') {
                                int right = left + 1;
                                while (string[right] != ')' && right < string.length) {
                                    right++;
                                }
                                if (right > left + 2) {
                                    int tempLeft = left + 1; //9
                                    int tempRight = right - 1; //11
                                    int index = 0;
                                    int tempLeftandTempRightMid = tempLeft + ((tempRight - tempLeft) / 2) + ((tempRight - tempLeft) % 2);
                                    while (tempLeft + index < tempLeftandTempRightMid) {
                                        char temp = string[tempLeft + index];
                                        string[tempLeft + index] = string[tempRight - index];
                                        string[tempRight - index] = temp;
                                        index++;
                                    }
                                    System.out.println(left + " " + right);
                                    left = right - 1;
                                }
                            }
                            left++;
                        }
                    }
                    System.out.println(string);
                }
        );

    }

}
