import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class IsWin {

    public static boolean isWin = false;
    public static int id;
    private static int a = 0;
    private static int b = 0;
    public static String name;
    public static String symvol;
    static int c = 0;
    ArrayList<Integer> arrayList = new <Integer>ArrayList();

    PlayerOne playerOne = new PlayerOne();
    PlayerTwo playerTwo = new PlayerTwo();
    Switch aSwitch = new Switch();

    char[][] field = {{'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}};


    // send the output to System.out
    // writeXml(System.out);

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    char crossOrZero;
    int switcher = 0; // переключатель между первым и вторым игроком


    public ArrayList<Integer> swich() throws IOException {


        while (true) {
            if (switcher % 2 == 0) {

                crossOrZero = 'x';
                a = a + 1;
                String e = Integer.toString(a);

            } else crossOrZero = 'o';

            b = b + 1;
            String z = Integer.toString(b);

            Print.printField(field);

            int num;
            try {
                num = Integer.parseInt(reader.readLine()); // запрет ввода символов, отличных от чисел

                arrayList.add(num);
            } catch (NumberFormatException | IOException e) {
                System.out.println("Число, только число!");
                continue;
            }
            if (Arrays.deepToString(field).contains(Integer.toString(num)) && num <= 9 && num > 0) {
                switch (num) {
                    case 1 -> {
                        field[0][0] = crossOrZero;
                        c = c + 1;
                    }
                    case 2 -> {
                        c = c + 1;
                        field[0][1] = crossOrZero;
                    }
                    case 3 -> {
                        c = c + 1;
                        field[0][2] = crossOrZero;
                    }
                    case 4 -> {
                        c = c + 1;
                        field[1][0] = crossOrZero;
                    }
                    case 5 -> {
                        c = c + 1;
                        field[1][1] = crossOrZero;
                    }
                    case 6 -> {
                        c = c + 1;
                        field[1][2] = crossOrZero;
                    }
                    case 7 -> {
                        c = c + 1;
                        field[2][0] = crossOrZero;
                    }
                    case 8 -> {
                        c = c + 1;
                        field[2][1] = crossOrZero;
                    }
                    case 9 -> field[2][2] = crossOrZero;
                }
            } else {
                System.out.println("Введите число из оставшихся на поле!");
                continue;
            }
            if (c >= 9) {
                System.out.println("Ничья");
                System.exit(1);
            }


            ChecingForMath.checkingForMatch(field);
            if (isWin) {


               if (aSwitch.randomPlayer == 1) {

                    symvol = symbol();
                    System.out.println("Победа: " + PlayerOne.getName() + crossOrZero);
                    id = 1;
                    name = PlayerOne.getName();

                    System.out.println(symvol + id + name);
                    try {
                        for (Integer integer : arrayList)
                            while (arrayList!=null) {

                                Step.setStep(arrayList.get(0));
                                Step.setStep1(arrayList.get(1));
                                Step.setStep2(arrayList.get(2));
                                Step.setStep3(arrayList.get(3));
                                Step.setStep4(arrayList.get(4));
                               Step.setStep5(arrayList.get(5));
                                Step.setStep6(arrayList.get(6));
                               Step.setStep7(arrayList.get(7));
                            }
                    } catch (IndexOutOfBoundsException e) {

                        System.out.println("");
                    }
                    isWin=true;

                    break;


                } else {
                    symvol = symbol();
                    name = PlayerTwo.getName();
                    id = 2;
                    System.out.println("Победа: " + playerTwo.getName() + crossOrZero);

                    try {

                        while (arrayList!=null) {
                            Step.setStep(arrayList.get(0));
                            Step.setStep1(arrayList.get(1));
                            Step.setStep2(arrayList.get(2));
                            Step.setStep3(arrayList.get(3));
                            Step.setStep4(arrayList.get(4));
                           Step.setStep5(arrayList.get(5));
                            Step.setStep6(arrayList.get(6));
                            Step.setStep7(arrayList.get(7));
                        }


                    } catch(IndexOutOfBoundsException e){
                        System.out.println("");
                    }
                }



                break;
            } else {
                System.out.println("Пока никто не выиграл. Играем дальше");

            }

            if (a > b) {
                if (aSwitch.randomPlayer == 1) {
                    System.out.println("Ведет игрок х: " + playerOne.getName() + ", у него " + " " + a + " очков, у игрока " + playerTwo.getName() + b + "очков");

                } else
                    System.out.println("Ведет игрок х: " + playerTwo.getName() + ", у него " + " " + a + " очков ,у игрока " + playerOne.getName() + " " + b + " очков");

            } else {
                if (aSwitch.randomPlayer == 1) {
                    System.out.println("Ведет игрок 0: " + playerOne.getName() + ", у него " + " " + b + " очков, " + " у игрока " + playerTwo.getName() + " " + a + " очков");


                } else
                    System.out.println("Ведет игрок 0: " + playerTwo.getName() + ", у него " + " " + b + " очков , у игрока " + playerOne.getName() + " " + b + " очков");

            }
            switcher++;
        }

        return arrayList;
    }

    String symbol() {
        String a;
        if (crossOrZero == 'x') {
            a = "X";
        } else {
            a = "0";
        }
        return a;
    }
}
