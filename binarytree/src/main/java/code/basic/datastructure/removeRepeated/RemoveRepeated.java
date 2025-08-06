package code.basic.datastructure.removeRepeated;

import java.util.*;

public class RemoveRepeated {
    private Character currentCharacter;
    private Integer count;
    private Deque<Character> characters = new LinkedList<>();
    private Stack<Integer>  countHistory = new Stack<>();

    public String removeRepeated(String str) {
        for (Character c : str.toCharArray()
        ) {
            if(Objects.isNull(currentCharacter)){
                currentCharacter = c;
                count = 0;
            }
            if(c.equals(currentCharacter)){
                count = count + 1;
                if(count >= 3){
                    characters.removeLast();
                    characters.removeLast();
                    if(characters.size()>0) {
                        currentCharacter = characters.peekLast();
                        count=countHistory.pop();
                    }else {
                        currentCharacter = null;
                    }
                }else{
                    characters.add(c);
                }
            }else{
                currentCharacter = c;
                countHistory.add(count);
                characters.add(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!characters.isEmpty()){
            stringBuilder.append(characters.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveRepeated().removeRepeated("aabcccbbad"));
        System.out.println(new RemoveRepeated().removeRepeated("aaad"));
    }
}
