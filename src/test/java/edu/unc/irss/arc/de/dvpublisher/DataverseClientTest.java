/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unc.irss.arc.de.dvpublisher;

import java.io.File;
import java.net.MalformedURLException;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class DataverseClientTest {
    
    private String fileName ="DFC-Incubator_dataverse-publisher";
    private String persistentId = "10.5072/FK2/BUH13T";
    
    public DataverseClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("injected test:apikey=" + System.getProperty("apiKey"));
        System.out.println("injected test:dataversealias=" + System.getProperty("dataverseAlias"));
                System.out.println("injected test:dataverseUrl=" + System.getProperty("dataverseUrl"));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of publishDatafile method, of class DataverseClient.
     * @throws java.net.MalformedURLException
     */
    @Test
    public void testPublishDatafile_String_File() throws MalformedURLException {
        System.out.println("publishDatafile");
        assertThat(persistentId, not(startsWith("doi:")));
//        DataverseClient instance = null;
        File file = new File(fileName);
        
//        DataverseClient instance = new DataverseClient(System.getProperty("dataverseUrl"), System.getProperty("apiKey"), System.getProperty("dataverseAlias"));
//        

    }

    /**
     * Test of publishDatafile method, of class DataverseClient.
     * @throws java.net.MalformedURLException
     */
    @Test
    public void testPublishDatafile_String_String() throws MalformedURLException {
        System.out.println("publishDatafile");
        assertThat(persistentId, not(startsWith("doi:")));
        
//        DataverseClient instance = new DataverseClient(System.getProperty("dataverseUrl"), System.getProperty("apiKey"), System.getProperty("dataverseAlias"));
//        
        
    }
    
}
