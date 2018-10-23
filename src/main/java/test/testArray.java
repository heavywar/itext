package test;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;


import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class testArray {

    public static final String DEST = "./fonts/tutorial/test5.pdf";
    public static final String DEST2 = "./fonts/tutorial/test2.pdf";

    public static final String pdfMain = "D:\\pdfMain.pdf";
    public static final String FONT = "D:\\ofont.ru_VoronovFont.ttf";


    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new testArray().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PageSize ps = PageSize.A5;
        PdfFont font = PdfFontFactory.createFont(FONT, "Cp1251", true);
        float WidthSpase =    font.getWidth(" ",11);
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc,ps);
        doc.setMargins(5, 7, 0, 0);

        int countSpace = 0;
 int []countSpacetest;
        List<Integer> countspace = new ArrayList<>();
 main.ReturnLine ReturnLine = new main.ReturnLine();
        List<String> ar = ReturnLine.splitLine(DEST2);
        for(String a :ar)
        {
            System.out.println(a);
        }
        System.out.println("______________________");

        for(int i =0; i<ar.size();i++)
        {
            countspace =  ReturnLine.countSpace((ArrayList<String>) ar);

            Paragraph p = new Paragraph();
           // countSpace = 0;
            for(int j = 0; j <ar.get(i).length();j++)
            {
                Text t = new Text("");
            t.setText(String.valueOf(ar.get(i).charAt(j)));
                p.add(t);
            }


            System.out.println("Строка" + ar.get(i) +" Пробелов в начале" + countspace.get(i));
            float result = countspace.get(i)*WidthSpase;
            p.setMarginLeft(result);
            p.setFixedLeading(2);
            // p.add(ar.get(i));

            doc.add(p.setFont(font));


        }


        doc.close();


    }
}
