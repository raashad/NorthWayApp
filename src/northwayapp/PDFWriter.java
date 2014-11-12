/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Rashad
 */
public class PDFWriter {
    PDDocument document;
    List<PDPage> pages;
    PDPageContentStream contentStream;
    int INDENT1 = 50;
    int INDENT2 = 60;
    int PAGEHEIGHT = 792;
    int PAGEWIDTH = 612;
    int TOPGUTTER = 50;
    int HEADER1GAP = 40;
    int LABELGAP = 15;
    int LINEDOWN = 10;
    int HEADERSIZE1 = 14;
    int LABELSIZE = 12;
    PDFont headerFont1 = PDType1Font.HELVETICA_BOLD;
    PDFont labelFont = PDType1Font.HELVETICA;
    int[] cursor = {0,PAGEHEIGHT};
    int pageIndex = 0;
    
    public PDFWriter() throws IOException{
        document = new PDDocument();
        pages = new ArrayList<>();
        this.newPage();
    }
    
    private void newPage() throws IOException{
        pages.add(new PDPage());
        pageIndex = pages.size()-1;
        document.addPage(pages.get(pageIndex));
        contentStream = new PDPageContentStream(document, pages.get(pageIndex));
        contentStream.beginText();
        
        contentStream.moveTextPositionByAmount(0, PAGEHEIGHT);
        contentStream.moveTextPositionByAmount(0, -TOPGUTTER);
        cursor[0] = 0;
        cursor[1] = PAGEHEIGHT;
    }
    private void moveCursor(int x, int y) throws IOException{
        contentStream.moveTextPositionByAmount(x, -1*y);
        cursor[0] += x;
        cursor[1] -= y;
    }
    private void moveCursorDown(int y) throws IOException{
        contentStream.moveTextPositionByAmount(0, -y);
        cursor[1] -= y;
    }
    private void moveCursorX(int x) throws IOException{
        contentStream.moveTextPositionByAmount(x, 0);
        cursor[0] += x;
    }
    private void placeCursorX(int x) throws IOException{
        contentStream.moveTextPositionByAmount(x - cursor[0], 0);
        cursor[0] = x;
    }
    
    private void drawHeader1(String text) throws IOException{

        contentStream.setFont(headerFont1, HEADERSIZE1);
        this.placeCursorX(INDENT1);
        this.moveCursorDown(HEADER1GAP);
        contentStream.drawString(text);


    }
    private void drawLabel(String text) throws IOException{
        contentStream.setFont(labelFont, LABELSIZE);
        this.placeCursorX(INDENT2);
        this.moveCursorDown(LABELGAP);
        contentStream.drawString(text);
    }
    private void writeText(String text) throws IOException{
        contentStream.drawString(text);
        

    }
    
    private void saveAndClose(String fileName) throws IOException, COSVisitorException{
        contentStream.endText();
        contentStream.close();
        document.save(fileName);
        document.close();
    }
    
    public void testRun() throws IOException, COSVisitorException{
        //this.writeText("TEST");
        this.drawHeader1("FAKE AUTO QUOTE");
        this.drawLabel("Group");
        this.drawLabel("Date");
        this.drawLabel("Address");
        this.drawHeader1("Hello again!");
        this.saveAndClose("zz fake auto quote.pdf");
    }
    
    public void printSurvey(Survey survey, String fileName) throws IOException, COSVisitorException{
        this.drawHeader1("HOMEOWNERS QUOTES");
        for(int i = 0; i < survey.size(); i++){
            this.drawLabel(survey.get(i).getName() + ":");
            this.moveCursorX(50);
            this.writeText(survey.get(i).getAnswer());
            
        }
        this.saveAndClose(fileName);
    }
}
