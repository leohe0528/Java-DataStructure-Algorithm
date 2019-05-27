package ArrayAndString;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] array = s.toCharArray();
        reverse(array, 0, s.length() - 1);
        int slow = 0;
        for (int fast = 0; fast < s.length(); fast++){
            if ((array[fast] == ' ') && (array[slow] != ' ')){
                reverse(array, slow, fast - 1);
                slow = fast;
            }else if ((array[fast] != ' ') && (array[slow] == ' ')){
                slow = fast;
            }else if (fast == s.length() - 1){
                reverse(array, slow, fast);
            }
        }
        String res = trim(array);
        return res;
    }
    private void reverse(char[] array, int i, int j){
        while (i < j){
            char temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;
        }
    }

    private String trim(char[] array){
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++){
            if (!(array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' '))){
                array[slow++] = array[fast];
            }
        }
        if (slow == 0) return "";
        return array[slow - 1] == ' ' ? new String(array, 0, slow - 1) : new String(array, 0, slow);
    }

    public static void main(String[] args){
        String s = "   you get   offer   ";
        String res = new ReverseWordsInString().reverseWords(s);
        System.out.println(res);
        String s2 = " Let's go to 'new york' ";
        String res2 = new ReverseWordsInString().reverseWords(s2);
        System.out.println(res2);
    }
}
