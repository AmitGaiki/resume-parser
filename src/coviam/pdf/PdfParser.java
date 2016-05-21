/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coviam.pdf;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author amit
 */
public class PdfParser {

    public void getText() {

        String pdf = "/home/amit/NetBeansProjects/ResumeParser/data/resumes/ejd1.pdf";
        String text = "/home/amit/NetBeansProjects/ResumeParser/data/resumes/edj1.txt";
        StringBuffer textBuffer = new StringBuffer();
        String resultText = "";
        PdfReader reader;
        try {
            reader = new PdfReader(pdf);
            PdfReaderContentParser contentParser = new PdfReaderContentParser(reader);
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(text));
            TextExtractionStrategy strategy;
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                strategy = contentParser.processContent(i, new SimpleTextExtractionStrategy());
                textBuffer.append(strategy.getResultantText());
            }
            resultText = textBuffer.toString();
            resultText = resultText.replaceAll("-\n", "");
            System.out.println("-->" + resultText);

            StringTokenizer stringTokenizer = new StringTokenizer(resultText, "\n");
            PrintWriter lineWriter = new PrintWriter(new FileOutputStream("/home/amit/NetBeansProjects/ResumeParser/data/resumes/edj1.txt"));
            while (stringTokenizer.hasMoreTokens()) {
                String curToken = stringTokenizer.nextToken();
                lineWriter.println("line-->" + curToken);
            }
            lineWriter.flush();
            lineWriter.close();
            System.out.flush();
            System.out.close();
        } catch (IOException ioe) {

        }

    }

}
