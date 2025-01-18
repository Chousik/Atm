package stack;

import java.util.*;

public class MyStack<K extends Comparable<K>> {
    private final List<K> stack = new ArrayList<K>();
    private final List<K> sortedStack = new ArrayList<K>();
    public void push(K value){
        stack.add(value);
        sortedStack.add(value);
        Collections.sort(sortedStack);
    }
    private Optional<K> pop(K value){
        K result = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        sortedStack.remove(result);
        return Optional.ofNullable(result);
    }
    private Optional<K> peekMin(){
        return stack.isEmpty() ? Optional.empty() : Optional.of(sortedStack.get(0));
    }
}