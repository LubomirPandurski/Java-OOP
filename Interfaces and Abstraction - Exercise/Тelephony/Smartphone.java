package Тelephony;

import java.util.List;

public class Smartphone implements  Callable, Browsable{

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    private boolean hasNumbers(String data){
        for (int i = 0; i < data.length(); i++) {
            if(Character.isDigit(data.charAt(i))){
                return true;
            }
        }
        return false;
    }

    private boolean hasOnlyNumbers(String data){
        for (int i = 0; i < data.length(); i++) {
            if(!Character.isDigit(data.charAt(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String phoneNumber : numbers) {
            if(!hasOnlyNumbers(phoneNumber)){
                sb.append("Invalid number!").append(System.lineSeparator());
            } else {
                sb.append(String.format("Calling... %s", phoneNumber)).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if(hasNumbers(url)){
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
