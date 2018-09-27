/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Line;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfName;

import static com.itextpdf.kernel.pdf.PdfName.Font;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.ILineDrawer;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import javax.servlet.http.HttpServletRequest;



/**
 *
 * @author Евгений
 */
public class PdfCreator {
     private String patientName = "";
     private int age = 0;
     private String adress = "";
     private String gengre = "";
     private String region = "";
     private String surveyName = "";
     private String diagnosis = "";
     private String surveyType = "type";
     private String anethesia = "";
     private String surgeonName = "";
     private String protocol = "";
     private String conclusion = "";
     private String helicoTest = "";
     private String acidityTest = "";
     private String surveydate = "";

    public PdfCreator(String surveyName, String patientName, int age, String surveydate, String gengre, String adress, String region, String diagnosis, 
            String surveyType, String anethesia, String protocol, String helicoTest, String acidityTest, String conclusion, String surgeonName) {
     
        this.surveyName = surveyName;
        this.patientName = patientName;
        this.age = age;
        this.gengre = gengre;
        this.adress = adress;
        this.region = region;
        this.diagnosis = diagnosis;
        this.surveyType = surveyType;
        this.anethesia = anethesia;
        this.protocol = protocol;
        this.helicoTest = helicoTest;
        this.acidityTest = acidityTest;
        this.conclusion = conclusion;
        this.surgeonName = surgeonName;
        this.surveydate = surveydate;
               
    }

    public PdfCreator() {
    }
    

    
 
public void createPdf() throws FileNotFoundException, IOException, DocumentException{
    
     
    
    PdfWriter writer = new PdfWriter("protocol.pdf");
    PdfDocument pdf = new PdfDocument(writer);
   
    Document document = new Document(pdf);
    ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    String pathBase = context.getRealPath("WEB-INF/font/times.ttf");
    String pathBold = context.getRealPath("WEB-INF/font/timesbd.ttf");
    String pathToImg = context.getRealPath("WEB-INF/img/pharmacy.png");
    Table table = new Table( new float[]{1,8}).setWidthPercent(100).setBorder(Border.NO_BORDER);
    Cell imgCell = new Cell();
    Cell logoCell = new Cell();
    imgCell.setBorder(Border.NO_BORDER);
    logoCell.setBorder(Border.NO_BORDER);
    table.addCell(imgCell);
    table.addCell(logoCell);
    Image image = new Image(ImageDataFactory.create(pathToImg));
    image.setHeight(70);
    image.setWidth(50);
    image.setBorder(Border.NO_BORDER);
    imgCell.add(image);
    
    PdfFont fontBase = PdfFontFactory.createFont(pathBase, "Cp1251", true);
    PdfFont fontBold = PdfFontFactory.createFont(pathBold, "Cp1251", true);
    
    Paragraph fioParagraph = new Paragraph("ФИО: " + patientName).setFont(fontBase).setFontSize(12).setTextAlignment(TextAlignment.LEFT);
    Paragraph ageParagraph = new Paragraph("Возраст: "  + age).setFont(fontBase).setFontSize(12).setTextAlignment(TextAlignment.LEFT);
    Paragraph gengerParagraph = new Paragraph("Пол: " + gengre).setFont(fontBase).setFontSize(12).setTextAlignment(TextAlignment.LEFT);
    Paragraph adressParagraph = new Paragraph("Адрес: " + adress).setFont(fontBase).setFontSize(12).setTextAlignment(TextAlignment.LEFT);
    Paragraph regionParagraph = new Paragraph("Район Башкирии: " + region).setFont(fontBase).setFontSize(12).setTextAlignment(TextAlignment.LEFT);
    Paragraph diagnosisParagraph= new Paragraph("Направительный диагноз: " + diagnosis).setFont(fontBase).setFontSize(12).setTextAlignment(TextAlignment.LEFT);
    Paragraph surveyTypeParagraph = new Paragraph("Вид обследования: " + surveyType).setFont(fontBase).setFontSize(12).setTextAlignment(TextAlignment.LEFT);
    Paragraph anestesyParagrapgh = new Paragraph("Анестезия: " + anethesia).setFont(fontBase).setFontSize(12).setTextAlignment(TextAlignment.LEFT);
    Paragraph protocolParagrapgh = new Paragraph(protocol).setFont(fontBase).setFontSize(12);
    Paragraph expressTestHPParagrapgh = new Paragraph("Экспресс тест на HP: " + helicoTest).setFont(fontBase).setFontSize(12).setTextAlignment(TextAlignment.LEFT);
    Paragraph expressTestPhParagrapgh = new Paragraph("Экспресс тест на Ph: " + acidityTest).setFont(fontBase).setFontSize(12).setTextAlignment(TextAlignment.LEFT);
    Paragraph conclusionParagrapgh = new Paragraph("Заключение: " + conclusion).setFont(fontBase).setFontSize(12);
    Paragraph surgeonParagrapgh = new Paragraph("Врач:                          " + surgeonName).setFont(fontBase).setFontSize(12).setTextAlignment(TextAlignment.LEFT);
//    Text text = new Text(protocol).setFont(fontBase);
//    protocolParagrapgh.add(text);
    Paragraph topParagrapgh = new Paragraph();
    topParagrapgh.add("ГБУЗ РБ ДЮРТЮЛИНСКАЯ ЦЕНТРАЛЬНАЯ РАЙОННАЯ БОЛЬНИЦА\n" + "ОТДЕЛЕНИЕ ЭНДОСКОПИИ");
    topParagrapgh.setFont(fontBold).setFontSize(11).setTextAlignment(TextAlignment.CENTER);
    Paragraph surveyTypeParag = new Paragraph();
    surveyTypeParag.add("Протокол " + surveyName + " от " + surveydate).setFont(fontBold).setFontSize(12).setTextAlignment(TextAlignment.CENTER).setFixedLeading(1);
    ILineDrawer drawer = new SolidLine();
    drawer.setLineWidth(0.1f);
    drawer.setColor(Color.GRAY);
    LineSeparator lineSeparator = new LineSeparator(drawer);
  
    logoCell.add(topParagrapgh).setBorder(Border.NO_BORDER);

    document.add(table);
    document.add(surveyTypeParag.setFont(fontBold));
    document.add(lineSeparator);
    document.add(fioParagraph.setMultipliedLeading(1));
    document.add(ageParagraph.setFixedLeading(1));
    document.add(gengerParagraph.setFixedLeading(1));
    document.add(adressParagraph.setFixedLeading(1));
    document.add(regionParagraph.setFixedLeading(1));
    document.add(lineSeparator);
    document.add(diagnosisParagraph.setMultipliedLeading(1));
    document.add(surveyTypeParagraph.setFixedLeading(1));
    document.add(anestesyParagrapgh.setFixedLeading(1));
    document.add(protocolParagrapgh.setMultipliedLeading(1));
    document.add(expressTestHPParagrapgh.setMultipliedLeading(1));
    document.add(expressTestPhParagrapgh.setFixedLeading(1));
    document.add(conclusionParagrapgh);
    document.add(surgeonParagrapgh);
    
    
    
    
    
    document.close();
     
}

public void download() throws IOException, FileNotFoundException, DocumentException{
    createPdf();
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext(); 
    HttpServletResponse response = (HttpServletResponse)externalContext .getResponse();
    response.reset();
         
    File pdf = new File("protocol.pdf");
    InputStream input = new BufferedInputStream(new FileInputStream(pdf));
    ServletOutputStream output = response.getOutputStream();
         
    response.setContentType("application/pdf");
 //   response.addHeader("Content-Disposition", "attachment; filename=" + "protocol.pdf");        
    response.setContentLength((int)pdf.length());
         
    try{
         int read = 0;
         while ((read = input.read()) != -1){
          output.write(read);
         }
    }
    finally{
         input.close();
         output.flush();
         output.close();
    }     
         
    facesContext.responseComplete();
}

//TODO   
private String dateToWordsConverter(Date date){
    
    return null;
}



}
