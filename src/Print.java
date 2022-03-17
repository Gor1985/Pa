public class Print {


    public static String printField(char[][] field) { // печать поля
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (j != 2) {
                    System.out.print(field[i][j] + "|");
                } else
                    System.out.print(field[i][j]);


            }
            System.out.println();


        }

        return "-----";
    }


}
