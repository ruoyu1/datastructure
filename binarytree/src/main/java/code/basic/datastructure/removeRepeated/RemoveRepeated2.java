package code.basic.datastructure.removeRepeated;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

public class RemoveRepeated2 {
    private Character currentCharacter;
    private Integer count;
    private Deque<Character> characters = new LinkedList<>();
    private Stack<Integer> countHistory = new Stack<>();

    public String removeRepeated(String str) {
        for (Character c : str.toCharArray()
        ) {
            if (Objects.isNull(currentCharacter)) {
                currentCharacter = c;
                count = 0;
            }
            if (c.equals(currentCharacter)) {
                count = count + 1;
                if (count >= 3) {
                      ifOver3();
                } else {
                    characters.add(c);
                }
            } else {
                currentCharacter = c;
                countHistory.add(count);
                characters.add(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!characters.isEmpty()) {
            stringBuilder.append(characters.pop());
        }
        return stringBuilder.toString();
    }

    public void ifOver3(){
        characters.removeLast();
        characters.removeLast();
        char before;
        if (!currentCharacter.equals('a')) {
            before = (char) (currentCharacter - 1);
            //如果和前个字符不相等，直接加入一个字符，并初始化count,并更新当前字符
             if(Objects.nonNull(characters.peekLast())){
                 if(!characters.peekLast().equals(before)){
                     characters.add(before);
                     count = 1;
                     this.currentCharacter = before;
                 }else{//相等的话，更新以前已经存入的历史统计值
                     count = countHistory.peek();
                     //加一个就大于等于三的话，调用自己
                     if(++count>=3){
                         ifOver3();
                     }else{
                         //不大于散的话，更新统计数值，更新当前字母，将before加入队列
                         count = countHistory.pop()+1;
                         this.currentCharacter = before;
                         characters.add(before);
                     }
                 }
             }

        }else {
            //是a的话没有替换过程和之前一样处理
            if (characters.size() > 0) {
                currentCharacter = characters.peekLast();
                count = countHistory.pop();
            } else {
                currentCharacter = null;
                count = 0;
            }
        }
    }


    public static void main(String[] args) {
        String re = new RemoveRepeated2().removeRepeated("abcccbad");
        System.out.println(re);
    }
}
