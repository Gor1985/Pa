import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;

import static java.lang.System.out;

public class XmlParsing {


    // send the output to a xml file
    public static void man() throws XMLStreamException, TransformerException, IOException {
        final String fail = "src/krest.xml";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        writeXml2(out);
        String xml = out.toString(StandardCharsets.UTF_8);
        String prettyPrintXML = formatXML(xml);

        Files.writeString(Paths.get(fail),
                prettyPrintXML, StandardCharsets.UTF_8);

    }

    private static void writeXml2(OutputStream out) throws XMLStreamException, FileNotFoundException {
        IsWin isWin = new IsWin();


        XMLOutputFactory output = XMLOutputFactory.newInstance();

        XMLEventFactory eventFactory = XMLEventFactory.newInstance();

        XMLEventWriter writer = output.createXMLEventWriter(out);


           XMLEvent event = eventFactory.createStartDocument();

               writer.add(event);







        writer.add(eventFactory.createStartElement("", "", "Gameplay"));


        writer.add(eventFactory.createStartElement("", "", "Player"));
        writer.add(eventFactory.createAttribute("id", "1"));
        writer.add(eventFactory.createAttribute("name", PlayerOne.getName()));
        writer.add(eventFactory.createAttribute("symbol", "X"));

        writer.add(eventFactory.createEndElement("", " ", " "));


        writer.add(eventFactory.createStartElement("", "", "Player"));
        writer.add(eventFactory.createAttribute("id", "2"));
        writer.add(eventFactory.createAttribute("name", PlayerTwo.getName()));
        writer.add(eventFactory.createAttribute("symbol", "O"));
        writer.add(eventFactory.createEndElement("", "", " "));

        writer.add(eventFactory.createStartElement("", "", "Game"));

           writer.add(eventFactory.createStartElement("", "", "Step"));
           writer.add(eventFactory.createAttribute("num", "1"));
           writer.add(eventFactory.createAttribute("playerId", "1"));
        if (Step.getStep()!=0) {
            writer.add(eventFactory.createCharacters(String.valueOf(Step.getStep())));
        }
           writer.add(eventFactory.createEndElement("", "", " "));


           writer.add(eventFactory.createStartElement("", "", "Step"));
           writer.add(eventFactory.createAttribute("num", "2"));
           writer.add(eventFactory.createAttribute("playerId", "2"));
        if (Step.getStep1()!=0) {
            writer.add(eventFactory.createCharacters(String.valueOf(Step.getStep1())));
        }
           writer.add(eventFactory.createEndElement("", "", " "));

           writer.add(eventFactory.createStartElement("", "", "Step"));
           writer.add(eventFactory.createAttribute("num", "3"));
           writer.add(eventFactory.createAttribute("playerId", "1"));
        if (Step.getStep2()!=0) {
            writer.add(eventFactory.createCharacters(String.valueOf(Step.getStep2())));
        }
           writer.add(eventFactory.createEndElement("", "", " "));

           writer.add(eventFactory.createStartElement("", "", "Step"));
           writer.add(eventFactory.createAttribute("num", "4"));
           writer.add(eventFactory.createAttribute("playerId", "2"));
        if (Step.getStep3()!=0) {
            writer.add(eventFactory.createCharacters(String.valueOf(Step.getStep3())));
        }
           writer.add(eventFactory.createEndElement("", "", " "));

           writer.add(eventFactory.createStartElement("", "", "Step"));
           writer.add(eventFactory.createAttribute("num", "5"));
           writer.add(eventFactory.createAttribute("playerId", "1"));
        if (Step.getStep4()!=0) {
            writer.add(eventFactory.createCharacters(String.valueOf(Step.getStep4())));
        }
           writer.add(eventFactory.createEndElement("", "", " "));

           writer.add(eventFactory.createStartElement("", "", "Step"));
           writer.add(eventFactory.createAttribute("num", "6"));
           writer.add(eventFactory.createAttribute("playerId", "2"));
        if (Step.getStep5()!=0) {
            writer.add(eventFactory.createCharacters(String.valueOf(Step.getStep5())));
        }
           writer.add(eventFactory.createEndElement("", "", " "));

           writer.add(eventFactory.createStartElement("", "", "Step"));
           writer.add(eventFactory.createAttribute("num", "7"));
           writer.add(eventFactory.createAttribute("playerId", "1"));
        if (Step.getStep6()!=0) {
            writer.add(eventFactory.createCharacters(String.valueOf(Step.getStep6())));
        }
           writer.add(eventFactory.createEndElement("", "", " "));
           writer.add(eventFactory.createStartElement("", "", "Step"));

           writer.add(eventFactory.createAttribute("num", "8"));
           writer.add(eventFactory.createAttribute("playerId", "2"));
        if (Step.getStep7()!=0) {
            writer.add(eventFactory.createCharacters(String.valueOf(Step.getStep7())));
        }
           writer.add(eventFactory.createEndElement("", "", " "));

           writer.add(eventFactory.createStartElement("", "", "Step"));
           writer.add(eventFactory.createAttribute("num", "9"));
           writer.add(eventFactory.createAttribute("playerId", "1"));
           if (Step.getStep8()!=0) {
               writer.add(eventFactory.createCharacters(String.valueOf(Step.getStep8())));
           }
           writer.add(eventFactory.createEndElement("", "", " "));

           writer.add(eventFactory.createEndElement("", "", " "));


        writer.add(eventFactory.createStartElement("", "", "GameResult"));
        writer.add(eventFactory.createStartElement("", "", "Players"));


        writer.add(eventFactory.createAttribute("id", String.valueOf(IsWin.id)));
        writer.add(eventFactory.createAttribute("name", IsWin.name));
        writer.add(eventFactory.createAttribute("symbol", String.valueOf(IsWin.symvol)));

        writer.add(eventFactory.createEndElement("", "", ""));
        writer.add(eventFactory.createEndElement("", "", "Gameplay"));

        writer.add(eventFactory.createEndDocument());

        writer.flush();

        writer.close();
    }


    private static String formatXML(String fail) throws TransformerException {

        // write data to xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // pretty print by indention
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // add standalone="yes", add line break before the root element
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

        StreamSource source = new StreamSource(new StringReader(fail));
        StringWriter output = new StringWriter();
        transformer.transform(source, new StreamResult(output));

        return output.toString();

    }

}





