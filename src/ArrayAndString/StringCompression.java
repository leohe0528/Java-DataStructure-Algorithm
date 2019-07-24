package ArrayAndString;

import DesignDataStructure.DoublyLinkedList;

import java.util.Arrays;
import java.util.List;

public class StringCompression {
    public int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
        }
        return indexAns;
    }
    public static void main(String[] args) {
//        char[] chars = {'a', 'b', 'b', 'b', 'c', 'c'};
//        int res = new StringCompression().compress(chars);
//        String a = "0.1";
//        String[] s = a.split("[.]");
//
    }
}

