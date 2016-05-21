/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coviam;

import coviam.pdf.PdfParser;

/**
 *
 * @author amit
 */
public class Main {
    
    public static void main(String[] argv){
        PdfParser p = new PdfParser();
        p.getText();
    }
    
}
