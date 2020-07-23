package com.example.demo;


//import java.io.File;
//import java.io.File;
//import java.io.IOException;
//
//import org.apache.tika.Tika;
//import org.apache.tika.exception.TikaException;
//
//import org.xml.sax.SAXException;

//public class tikademo {
//    public static void main(final String[] args) throws IOException, TikaException {
//
//        //选择要提取的文件C:\Users\Administrator\Desktop
//        File file = new File("C:/Users/Administrator/Desktop/2019年Q4移动互联网行业数据研究报告.pdf");
//
//        //获取并打印文件内容
//        Tika tika = new Tika();
//        String filecontent = tika.parseToString(file);
//        System.out.println("Extracted Content: " + filecontent);
//    }
//}


import java.io.File;
        import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

        import org.apache.tika.exception.TikaException;
        import org.apache.tika.metadata.Metadata;
        import org.apache.tika.parser.ParseContext;
        import org.apache.tika.parser.pdf.PDFParser;
        import org.apache.tika.sax.BodyContentHandler;

        import org.xml.sax.SAXException;

public class tikademo {

    public static void main(final String[] args) throws IOException, TikaException, SAXException {

        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputstream = new FileInputStream(new File("C:/Users/Administrator/Desktop/快手-《2019快手内容报告》-2020.3-17页.pdf"));
        ParseContext pcontext = new ParseContext();

        //parsing the document using PDF parser
        PDFParser pdfparser = new PDFParser();
        pdfparser.parse(inputstream, handler, metadata,pcontext);

        //getting the content of the document
        System.out.println("Contents of the PDF :" + handler.toString());

        FileWriter fw=new FileWriter("C:/Users/Administrator/Desktop//test.txt");
        fw.write(handler.toString());
        fw.close();

        //getting metadata of the document
        System.out.println("Metadata of the PDF:");
        String[] metadataNames = metadata.names();

        for(String name : metadataNames) {
            System.out.println(name+ " : " + metadata.get(name));
        }
    }
}