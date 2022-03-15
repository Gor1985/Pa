import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException, XMLStreamException, TransformerException {

        PlayerOne playerOne = new PlayerOne();
        PlayerTwo playerTwo = new PlayerTwo();
        Switch s = new Switch();
        IsWin isWin = new IsWin();
        Step step=new Step();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Первый игрок, введите имя ");
            String player1 = reader.readLine();
            playerOne.setName(player1);

            System.out.println("Второй игрок, введите имя ");
            String player2 = reader.readLine();
            playerTwo.setName(player2);

        } catch (StackOverflowError e) {
            e.printStackTrace();
        }
        Print.printField(s.sswitch());

        isWin.swich();
        for (int i = 0; i <isWin.arrayList.size() ; i++) {
            step.setStep(Integer.parseInt(String.valueOf(isWin.arrayList.get(i))));
        }
        System.out.println("Всем привет: "+step.getStep());

        XmlParsing.man();
//checingForMath.checkingForMatch(s.sswitch());
    }

}
