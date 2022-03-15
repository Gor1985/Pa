public class ChecingForMath {


     public static char[][] checkingForMatch(char[][] field) { // проверка на совпадение трёх элементов
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2] || // сравнение по горизонтали
                    field[0][i] == field[1][i] && field[0][i] == field[2][i] || // сравнение по вертикали
                    field[0][0] == field[1][1] && field[0][0] == field[2][2] || // сравнение по
                    field[2][0] == field[1][1] && field[2][0] == field[0][2]) { // диагоналям
                IsWin.isWin = true;
                break;
            }


        }
        return field;
    }

}
