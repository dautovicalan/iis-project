package utils;

import com.alan.soap.nba.Team;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public final class XMLUtils {
    
    public static final String DIR = "/Users/alandautovic/development/uni_projects/iis-project/JAXBTask/xml";
    
    private static final DocumentBuilderFactory documentBuilderFactory
            = DocumentBuilderFactory.newInstance();

    private static final DocumentBuilder documentBuilder;
    static {
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private static final XPath xPath = XPathFactory.newInstance().newXPath();
    public static Team performXPathAndSaving(HashMap<String, Team> teams, String term) throws XPathExpressionException, TransformerException {
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("nbaTeams");
        document.appendChild(root);

        for (Map.Entry<String, Team> entry : teams.entrySet()) {
            Element teamElement = document.createElement("team");
            teamElement.setAttribute("id", String.valueOf(entry.getValue().getId()));

            Element teamName = document.createElement("name");
            teamName.appendChild(document.createTextNode(entry.getValue().getName()));
            teamElement.appendChild(teamName);

            Element teamNickname = document.createElement("nickname");
            teamNickname.appendChild(document.createTextNode(entry.getValue().getNickname()));
            teamElement.appendChild(teamNickname);

            Element teamCode = document.createElement("code");
            teamCode.appendChild(document.createTextNode(entry.getValue().getCode()));
            teamElement.appendChild(teamCode);

            Element teamCity = document.createElement("city");
            teamCity.appendChild(document.createTextNode(entry.getValue().getCity()));
            teamElement.appendChild(teamCity);

            Element teamLogo = document.createElement("logo");
            teamLogo.appendChild(document.createTextNode(entry.getValue().getLogo()));
            teamElement.appendChild(teamLogo);

            Element teamNbaFranchise = document.createElement("nbaFranchise");
            teamNbaFranchise.appendChild(document.createTextNode(String.valueOf(true)));
            teamElement.appendChild(teamNbaFranchise);

            root.appendChild(teamElement);
        }

        String expression = "/nbaTeams/team[code=\"" + term + "\"]";
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(DIR + File.separator + "SOAP_Generated_XML.xml"));

        transformer.transform(domSource, streamResult);


        Team team = new Team();
        for (int i = 0; i < nodeList.getLength(); i++){
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) nodeList.item(i);
                if (element.getNodeName().contains("team")){
                    team.setId(new BigInteger(element.getAttribute("id")));
                    team.setName(element.getElementsByTagName("name").item(0).getTextContent());
                    team.setNickname(element.getElementsByTagName("nickname").item(0).getTextContent());
                    team.setCode(element.getElementsByTagName("code").item(0).getTextContent());
                    team.setCity(element.getElementsByTagName("city").item(0).getTextContent());
                    team.setLogo(element.getElementsByTagName("logo").item(0).getTextContent());
                    team.setNbaFranchise(Boolean.parseBoolean(element.getElementsByTagName("nbaFranchise").item(0).getTextContent()));
                }
            }
        }
        return team;
    }
}
