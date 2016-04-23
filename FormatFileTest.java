/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatfile;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nevarezfamily
 */
public class FormatFileTest {
    
    public FormatFileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readXLSXFile method, of class FormatFile.
     */
    @Test
    public void testReadXLSXFile() throws Exception {
        System.out.println("readXLSXFile");
        File filepath = null;
        String xlsFile = "";
        FormatFile.readXLSXFile(filepath, xlsFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class FormatFile.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        FormatFile.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
