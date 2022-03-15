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
        // write XML to ByteArrayOutputStream
        writeXml2(out);

        // Java 10
        String xml = out.toString(StandardCharsets.UTF_8);

        // standard way to convert byte array to String
        // String xml = out.toString(StandardCharsets.US_ASCII);

        // System.out.println(formatXML(xml));

        String prettyPrintXML = formatXML(xml);

        // print to console
        // System.out.println(prettyPrintXML);

        // Java 11 - write to file
        Files.writeString(Paths.get(fail),
                prettyPrintXML, StandardCharsets.UTF_8);

        // Java 7 - write to file
        //Files.write(Paths.get("/home/mkyong/test.xml"),
        //    prettyPrintXML.getBytes(StandardCharsets.UTF_8));

        // BufferedWriter - write to file
            /*try (FileWriter writer = new FileWriter("/home/mkyong/test.xml");
                 BufferedWriter bw = new BufferedWriter(writer)) {
                bw.write(xml);
            } catch (IOException e) {
                e.printStackTrace();
            }*/


    }

    private static void writeXml2(OutputStream out) throws XMLStreamException, FileNotFoundException {
        IsWin isWin = new IsWin();
Step step=new Step();

        XMLOutputFactory output = XMLOutputFactory.newInstance();
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();

        // StAX Iterator API
        XMLEventWriter writer = output.createXMLEventWriter(out);

        XMLEvent event = eventFactory.createStartDocument();
        // default
        // event = eventFactory.createStartDocument("utf-8", "1.0");
        writer.add(event);


        writer.add(eventFactory.createStartElement("", "", "Gameplay"));

        // write XML comment
        //  writer.add(eventFactory.createComment("This is staff 1001"));

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
        writer.add(eventFactory.createCharacters(String.valueOf(step.getStep())));




        writer.add(eventFactory.createEndElement("", "", " "));


        writer.add(eventFactory.createStartElement("", "", "Step"));
        writer.add(eventFactory.createAttribute("num", "2"));
        writer.add(eventFactory.createAttribute("playerId", "2"));

        //    writer.add(eventFactory.createCharacters(Step);

        writer.add(eventFactory.createEndElement("", "", " "));

        writer.add(eventFactory.createStartElement("", "", "Step"));
        writer.add(eventFactory.createAttribute("num", "3"));
        writer.add(eventFactory.createAttribute("playerId", "1"));
        //  writer.add(eventFactory.createCharacters(results.getStep3()));
        writer.add(eventFactory.createEndElement("", "", " "));

        writer.add(eventFactory.createStartElement("", "", "Step"));
        writer.add(eventFactory.createAttribute("num", "4"));
        writer.add(eventFactory.createAttribute("playerId", "2"));
        //  writer.add(eventFactory.createCharacters(results.getStep4()));
        writer.add(eventFactory.createEndElement("", "", " "));

        writer.add(eventFactory.createStartElement("", "", "Step"));
        writer.add(eventFactory.createAttribute("num", "5"));
        writer.add(eventFactory.createAttribute("playerId", "1"));
        //    writer.add(eventFactory.createCharacters(results.getStep5()));
        writer.add(eventFactory.createEndElement("", "", " "));

        writer.add(eventFactory.createStartElement("", "", "Step"));
        writer.add(eventFactory.createAttribute("num", "6"));
        writer.add(eventFactory.createAttribute("playerId", "2"));
        //     writer.add(eventFactory.createCharacters(results.getStep6()));
        writer.add(eventFactory.createEndElement("", "", " "));

        writer.add(eventFactory.createStartElement("", "", "Step"));
        writer.add(eventFactory.createAttribute("num", "7"));
        writer.add(eventFactory.createAttribute("playerId", "1"));
        //    writer.add(eventFactory.createCharacters(results.getStep7()));
        writer.add(eventFactory.createEndElement("", "", " "));
        writer.add(eventFactory.createStartElement("", "", "Step"));

        writer.add(eventFactory.createAttribute("num", "8"));
        writer.add(eventFactory.createAttribute("playerId", "2"));
        //    writer.add(eventFactory.createCharacters(results.getStep8()));
        writer.add(eventFactory.createEndElement("", "", " "));

        writer.add(eventFactory.createStartElement("", "", "Step"));
        writer.add(eventFactory.createAttribute("num", "9"));
        writer.add(eventFactory.createAttribute("playerId", "1"));
        //    writer.add(eventFactory.createCharacters(results.getStep9()));
        writer.add(eventFactory.createEndElement("", "", " "));

        writer.add(eventFactory.createEndElement("", "", " "));

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





