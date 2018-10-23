package main;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReturnLineToLine extends PDFTextStripper {

    public static void main(String[] args) throws IOException {
        ReturnLineToLine ReturnLineToLine = new ReturnLineToLine();
        List<String> stringList = ReturnLineToLine.splitLine("./fonts/tutorial/TXTtest22.pdf");

            for(int i =0; i<stringList.size();i++)
            {

                System.out.println("Строка# " + i + " = "+stringList.get(i));


            }
    }




     static  List<String> lines = new ArrayList<String>();

    public ReturnLineToLine() throws IOException {
    }
    public List<String>  splitLine(String path)  throws IOException  {
    PDDocument document = null;
    String fileName = path;
        try {
        document = PDDocument.load( new File(fileName) );
        PDFTextStripper stripper = new ReturnLineToLine();
        stripper.setSortByPosition( true );
        stripper.setStartPage( 0 );
        stripper.setEndPage( document.getNumberOfPages() );

        Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
        stripper.writeText(document, dummy);

        // print lines
//        for(String line:lines){
//            System.out.println(line);
//        }
    }
        finally {
        if( document != null ) {
            document.close();
        }
    }
    return lines;
}

    /**
     * Override the default functionality of PDFTextStripper.writeString()
     */
    protected void writeString(String str, List<TextPosition> textPositions) throws IOException {
        lines.add(str);
        // you may process the line here itself, as and when it is obtained
    }
    public  ArrayList<Integer> countSpace(ArrayList<String> List)
    {
        int countSpace;
        ArrayList<Integer> arl = new ArrayList<Integer>();
        List<String> ar = List;
        for(int i =0; i<ar.size();i++)
        {


            countSpace = 0;
            for(int j = 0; j <ar.get(i).length();j++)
            {


                if(ar.get(i).charAt(j) == ' ') {
                    countSpace++;
                }
                else {
                    break;

                }

            }
            arl.add(i,countSpace);

        }
        return arl;
    }
}
