import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;



    public class StaxRea {



        private static final String FILENAME = "src/krest.xml";

        public static void main(String[] args) {


            try {

                printXmlByXmlCursorReader(Paths.get(FILENAME));

            } catch (FileNotFoundException | XMLStreamException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private static void printXmlByXmlCursorReader(Path path)
                throws IOException, XMLStreamException {

            char[][] field = {{'1', '2', '3'},
                    {'4', '5', '6'},
                    {'7', '8', '9'}};

            ArrayList arrayList=new ArrayList();

            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(
                    new FileInputStream(path.toFile()));


            int eventType = reader.getEventType();
            System.out.println(eventType);
            System.out.println(reader);

            while (reader.hasNext()) {

                eventType = reader.next();

                if (eventType == XMLEvent.START_ELEMENT) {


                    switch (reader.getName().getLocalPart()) {

                        case "Step":
                            eventType = reader.next();
                            if (eventType == XMLEvent.CHARACTERS) {
                                arrayList.add(reader.getText());
                                char crossOrZero;
                                for (int i = 0; i < arrayList.size(); i++) {
                                    if (i%2==0){
                                        crossOrZero='X';
                                    }else {
                                        crossOrZero='o';
                                    }

                                    switch (arrayList.get(i).toString()) {
                                        case "1":
                                            field[0][0] = crossOrZero;

                                            break;
                                        case "2":

                                            field[0][1] = crossOrZero;
                                            break;
                                        case "3":
                                            field[0][2] = crossOrZero;
                                            break;
                                        case "4":

                                            field[1][0] = crossOrZero;
                                            break;
                                        case "5":

                                            field[1][1] = crossOrZero;
                                            break;
                                        case "6":

                                            field[1][2] = crossOrZero;
                                            break;
                                        case "7":
                                            field[2][0] = crossOrZero;
                                            break;
                                        case "8":

                                            field[2][1] = crossOrZero;
                                            break;
                                        case "9":

                                            field[2][2] = crossOrZero;
                                            break;
                                    }

                                }
                            }

                            System.out.println(Print.printField(field));

                            break;


                        case "Players":

                            String id = reader.getAttributeValue(null, "id");
                            String name = reader.getAttributeValue(null, "name");
                            String symbol = reader.getAttributeValue(null, "symbol");
                            System.out.print("Player " + id + " ->" + name + " is winner as " + symbol + "!\n" + "-->");


                            break;


                    }


                }


            }


        }
        public static char[][] checkingForMatch(char[][] field) {


            for (int i = 0; i < field.length; i++) {
                if (field[i][0] ==

                        field[i][1] && field[i][0] == field[i][2]  ||
                        field[0][i] == field[1][i] && field[0][i] == field[2][i] ||
                        field[0][0] == field[1][1] && field[0][0] == field[2][2] ||
                        field[2][0] == field[1][1] && field[2][0] == field[0][2]) {

                    break;
                }


            }
            return field;
        }
    }


