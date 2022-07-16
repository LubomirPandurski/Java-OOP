package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();

        String input = scanner.nextLine();

        while(!input.equals("End")){

            String [] data = input.split("");

            Identifiable identifiable =
                    data.length == 2
                    ? new Robot(data[1], data[0])
                    : new Citizen(data[2], Integer.parseInt(data[1]), data[1]);

            identifiables.add(identifiable);

            input = scanner.nextLine();
        }

        String fakeIdPostfix = scanner.next();

        identifiables.stream()
                .map(Identifiable::getId)
                .filter(i -> i.endsWith(fakeIdPostfix))
                .forEach(System.out::println);
    }
}
