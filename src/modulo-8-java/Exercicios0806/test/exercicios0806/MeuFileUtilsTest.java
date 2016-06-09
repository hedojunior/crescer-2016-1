/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios0806;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hedo
 */
public class MeuFileUtilsTest {
    
    public MeuFileUtilsTest() {
    }
    
    
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MeuFileUtils.main(args);
        fail("The test case is a prototype.");
    }

    /**
     * Test of createFileOrFolder method, of class MeuFileUtils.
     */
    @Test
    public void testCreateFileOrFolder() {
        System.out.println("createFileOrFolder");
        String fileName = "pasta";
        MeuFileUtils instance = new MeuFileUtils();
        instance.createFileOrFolder(fileName);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteFile() {
        System.out.println("deleteFile");
        String fileName = "";
        MeuFileUtils instance = new MeuFileUtils();
        instance.deleteFile(fileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showAbsolutePath method, of class MeuFileUtils.
     */
    @Test
    public void testShowAbsolutePath() {
        System.out.println("showAbsolutePath");
        String fileName = "";
        MeuFileUtils instance = new MeuFileUtils();
        instance.showAbsolutePath(fileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveFile method, of class MeuFileUtils.
     */
    @Test
    public void testMoveFile() {
        System.out.println("moveFile");
        String fileName = "";
        String fileNewName = "";
        MeuFileUtils instance = new MeuFileUtils();
        instance.moveFile(fileName, fileNewName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
