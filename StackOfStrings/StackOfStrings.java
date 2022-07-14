package StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = data;
    }

    public void push(String input){
        data.add(input);
    }

    public String pop(){
        return data.remove(data.size() - 1);
    }

    public String peek(){
        return data.get(data.size() - 1);
    }
}
