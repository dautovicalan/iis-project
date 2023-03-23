/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jaxbtask;

import generated.NbaTeams;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author alandautovic
 */
public class JAXBTask {

    private static final String DIR = "xml";
    private static final String FILE = "SOAP_Generated_XML.xml";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(NbaTeams.class);
            Marshaller marshaller = jc.createMarshaller();
            
            Unmarshaller unmarshaller = jc.createUnmarshaller();           
            File file = new File(DIR + File.separator + FILE);
            
            if (file.exists() && !file.isDirectory()) {
                NbaTeams nbaTeams = (NbaTeams) unmarshaller.unmarshal(file);
                marshaller.marshal(nbaTeams, System.out);
                System.out.println("\nSucessfully unmarshalled");
            }                                        
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
