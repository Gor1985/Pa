public class Drow {
    IsWin isWin = new IsWin();
    Field field = new Field();

    public static boolean draw(char[][] field) {
        if (IsWin.c == 8)
            IsWin.isWin = true;
        return IsWin.isWin;
    }

}

