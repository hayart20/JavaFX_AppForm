/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.Person;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.RadioCheckField;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Hayk Harutyunyan
 */
public class ItextPDF
{

    public static final String FONT_RU = "arialuni.ttf";
    public static final String FONT_CH = "hxb-meixinti.ttf";
    
    public void createPdf(String filename, Person person)  {
        // step 1
        Document document = new Document();
        // step 2
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            // step 3
            document.open();
            
            BaseFont bf_ru = BaseFont.createFont(FONT_RU, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font_ru = new Font(bf_ru, 10);
            BaseFont bf_ch = BaseFont.createFont(FONT_CH, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font_ch = new Font(bf_ch, 10);
            ResourceBundle rb_ch = ResourceBundle.getBundle("bundles/lang", Locale.CHINA);
            ResourceBundle rb_ru = ResourceBundle.getBundle("bundles/lang", Locale.GERMANY);
            //
            Paragraph preface = new Paragraph(rb_ch.getString("pdfFileheder1"), font_ch); 
            preface.setAlignment(Element.ALIGN_CENTER);
            document.add(preface);

            preface = new Paragraph(rb_ru.getString("pdfFileheder1"), font_ru); 
            preface.setAlignment(Element.ALIGN_CENTER);
            document.add(preface);
            document.add(new Phrase(rb_ch.getString("pdfFileheder2"), font_ch));
            document.add(new Phrase(rb_ru.getString("pdfFileheder2"), font_ru));
            Phrase pr = new Phrase("\n ");
            pr.add(new Phrase(rb_ch.getString("part1"), font_ch));
            pr.add(new Phrase(" "));
            pr.add(new Phrase(rb_ru.getString("part1"), font_ru));

            document.add(pr);

            PdfPTable basetable = new PdfPTable(2);
            basetable.setWidthPercentage(100);

            PdfPTable table1 = new PdfPTable(4);
                pr = new Phrase(rb_ch.getString("nameDesc"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("nameDesc"), font_ru));
                PdfPCell cell = new PdfPCell(pr);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setRowspan(3);
                table1.addCell(cell);

                //line 1
                //PdfPTable table2 = new PdfPTable(2);
                pr = new Phrase(rb_ch.getString("lastname"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("lastname"), font_ru));
                PdfPCell cell1 = new PdfPCell(pr);
                PdfPCell cell2 = new PdfPCell(new Paragraph(person.getField1()));
                cell2.setColspan(2);
                table1.addCell(cell1);
                table1.addCell(cell2);

                pr = new Phrase(rb_ch.getString("fathername"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("fathername"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(person.getField2()));
                table1.addCell(cell1);
                cell2.setColspan(2);
                table1.addCell(cell2);
                
                pr = new Phrase(rb_ch.getString("firstname"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("firstname"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(person.getField3()));
                table1.addCell(cell1);
                cell2.setColspan(2);
                table1.addCell(cell2);
                //basetable.addCell(table1);
                //basetable.addCell(table2);
                ///line 2 1.2 1.3
                //table1 = new PdfPTable(4);

                pr = new Phrase(rb_ch.getString("chinaseName"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("chinaseName"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(person.getField4()));
                table1.addCell(cell1);
                table1.addCell(cell2);
                
                pr = new Phrase(rb_ch.getString("othername"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("othername"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(person.getField5()));
                table1.addCell(cell1);
                table1.addCell(cell2);
                //1.4 1.5
                pr = new Phrase(rb_ch.getString("sex"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("sex"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(person.getField6() + " " + person.getField7()));
                table1.addCell(cell1);
                table1.addCell(cell2);
                pr = new Phrase(rb_ch.getString("databirth"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("databirth"), font_ru));
                cell1 = new PdfPCell(pr);
                pr = new Phrase();
                pr.add(new Phrase(person.getField8()));
                pr.add(new Phrase("/"));
                pr.add(new Phrase(person.getField9()));
                pr.add(new Phrase("/"));
                pr.add(new Phrase(person.getField10()));
                cell2 = new PdfPCell(pr);
                table1.addCell(cell1);
                table1.addCell(cell2);
                //1.6 1.7
                pr = new Phrase(rb_ch.getString("citizen"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("citizen"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(person.getField11()));
                table1.addCell(cell1);
                table1.addCell(cell2);
                pr = new Phrase(rb_ch.getString("old_citizen_of"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("old_citizen_of"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(person.getField12()));
                table1.addCell(cell1);
                table1.addCell(cell2);
                //1.8
                pr = new Phrase(rb_ch.getString("birthplace"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("birthplace"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(person.getField13()));
                cell1.setColspan(2);
                table1.addCell(cell1);
                cell2.setColspan(2);
                table1.addCell(cell2);
                //1.9
                pr = new Phrase(rb_ch.getString("passportData"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("passportData"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(person.getField14()));
                cell1.setColspan(2);
                table1.addCell(cell1);
                cell2.setColspan(2);
                table1.addCell(cell2);
                //1.10
                pr = new Phrase(rb_ch.getString("passportType"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("passportType"), font_ru));
                cell1 = new PdfPCell(pr);
                pr = new Phrase(
                        person.getField15() + " " +
                        person.getField16() + " " +
                        person.getField17() + " " +
                        person.getField18() + " " +
                        person.getField19(), font_ru);
                cell2 = new PdfPCell(pr);
                cell1.setColspan(2);
                table1.addCell(cell1);
                cell2.setColspan(2);
                table1.addCell(cell2);
                //1.11 1.12
                pr = new Phrase(rb_ch.getString("passportNumber"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("passportNumber"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(person.getField20()));
                table1.addCell(cell1);
                table1.addCell(cell2);
                pr = new Phrase(rb_ch.getString("passportGivenDate"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("passportGivenDate"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(
                        person.getField21() + "/" +
                        person.getField22() + "/" +
                        person.getField23()
                        ));
                table1.addCell(cell1);
                table1.addCell(cell2);
                //1.13 1.14
                pr = new Phrase(rb_ch.getString("passportGivenPlace"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("passportGivenPlace"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(person.getField24()));
                table1.addCell(cell1);
                table1.addCell(cell2);
                pr = new Phrase(rb_ch.getString("passportValidDate"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("passportValidDate"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(
                        person.getField25() + "/" +
                        person.getField26() + "/" +
                        person.getField27()
                        ));
                table1.addCell(cell1);
                table1.addCell(cell2);
                //1.15
                pr = new Phrase(rb_ch.getString("passportProfession"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("passportProfession"), font_ru));
                cell1 = new PdfPCell(pr);
                /*cell2 = new PdfPCell(new Paragraph(
                        person.getField28() + " " +
                        person.getField29() + " " +
                        person.getField30()
                        ));*/
                table1.addCell(cell1);
                //table1.addCell(cell2);
                //cell2 = new PdfPCell(new Paragraph(rs.getString("FIELD" + 16)));
                PdfPTable innertable = new PdfPTable(2);
                innertable.setWidthPercentage(100);
                
                pr = new Phrase(rb_ch.getString("profession1"), font_ch);
                if(!person.getField28().equals("")) {
                    pr.add(new Phrase("                                      "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }    
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession1"), font_ru));
                    
                PdfPCell innercell = new PdfPCell(pr);
                
                //innercell.setBorder(Rectangle.BOTTOM);
                innertable.addCell(innercell);

                pr = new Phrase(rb_ch.getString("profession10"), font_ch);
                if(!person.getField37().equals("")) {
                    pr.add(new Phrase("    "));
                    pr.add(new Phrase(person.getField38(), font_ru));
                } 
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession10"), font_ru));
                innercell = new PdfPCell(pr);
                //innercell.setBorder(Rectangle.LEFT);
                innertable.addCell(innercell);

                pr = new Phrase(rb_ch.getString("profession2"), font_ch);
                if(!person.getField29().equals("")) {
                    pr.add(new Phrase("                             "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                } 
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession2"), font_ru));
                innercell = new PdfPCell(pr);
                //innercell.setBorder(Rectangle.BOTTOM);
                innertable.addCell(innercell);

                pr = new Phrase(rb_ch.getString("profession11"), font_ch);
                if(!person.getField39().equals("")) {
                    pr.add(new Phrase("    "));
                    pr.add(new Phrase(person.getField40(), font_ru));
                } 
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession11"), font_ru));
                innercell = new PdfPCell(pr);
                //innercell.setBorder(Rectangle.LEFT);
                innertable.addCell(innercell);

                pr = new Phrase(rb_ch.getString("profession3"), font_ch);
                if(!person.getField30().equals("")) {
                    pr.add(new Phrase("                             "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                } 
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession3"), font_ru));
                innercell = new PdfPCell(pr);
                //innercell.setBorder(Rectangle.RIGHT);
                innertable.addCell(innercell);

                pr = new Phrase(rb_ch.getString("profession12"), font_ch);
                if(!person.getField41().equals("")) {
                    pr.add(new Phrase("    "));
                    pr.add(new Phrase(person.getField42(), font_ru));
                }  
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession12"), font_ru));
                innercell = new PdfPCell(pr);
                //innercell.setBorder(Rectangle.NO_BORDER);
                innertable.addCell(innercell);

                pr = new Phrase(rb_ch.getString("profession4"), font_ch);
                if(!person.getField31().equals("")) {
                    pr.add(new Phrase("                           "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                } 
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession4"), font_ru));
                innercell = new PdfPCell(pr);
                //innercell.setBorder(Rectangle.RIGHT);
                innertable.addCell(innercell);

                pr = new Phrase(rb_ch.getString("profession13"), font_ch);
                if(!person.getField43().equals("")) {
                    pr.add(new Phrase("                              "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                } 
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession13"), font_ru));
                innercell = new PdfPCell(pr);
                //innercell.setBorder(Rectangle.NO_BORDER);
                innertable.addCell(innercell);

                pr = new Phrase(rb_ch.getString("profession5"), font_ch);
                if(!person.getField32().equals("")) {
                    pr.add(new Phrase("                                      "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                } 
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession5"), font_ru));
                innercell = new PdfPCell(pr);
                //innercell.setBorder(Rectangle.RIGHT);
                innertable.addCell(innercell);

                pr = new Phrase(rb_ch.getString("profession14"), font_ch);
                if(!person.getField44().equals("")) {
                     pr.add(new Phrase("                                          "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                } 
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession14"), font_ru));
                innercell = new PdfPCell(pr);
                //innercell.setBorder(Rectangle.NO_BORDER);
                innertable.addCell(innercell);

                pr = new Phrase(rb_ch.getString("profession6"), font_ch);
                if(!person.getField33().equals("")) {
                    pr.add(new Phrase("                              "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                 
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession6"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(rb_ch.getString("profession15"), font_ch);
                if(!person.getField45().equals("")) {
                     pr.add(new Phrase("                                 "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                } 
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession15"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(rb_ch.getString("profession7"), font_ch);
                if(!person.getField34().equals("")) {
                    pr.add(new Phrase("                                        "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession7"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase("");
                innertable.addCell(pr);
                

                pr = new Phrase(rb_ch.getString("profession8"), font_ch);
                if(!person.getField35().equals("")) {
                    pr.add(new Phrase("                                        "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession8"), font_ru));
                innertable.addCell(pr);
                pr = new Phrase("");
                innertable.addCell(pr);
                
                pr = new Phrase(rb_ch.getString("profession9"), font_ch);
                if(!person.getField36().equals("")) {
                     pr.add(new Phrase("                                        "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                } 
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession9"), font_ru));
                innertable.addCell(pr);
                pr = new Phrase("");
                innertable.addCell(pr);
                
                
                pr = new Phrase(rb_ch.getString("profession16"), font_ch);
                if(!person.getField173().equals("")) {
                    pr.add(new Phrase("                                        "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase(person.getField174(), font_ru));
                    pr.add(new Phrase("\n"));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                } 
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("profession16"), font_ru));
                innertable.addCell(pr);
                pr = new Phrase("");
                innertable.addCell(pr);
                
                cell2.setColspan(3);
                cell2.addElement(innertable);
                table1.addCell(cell2);
                //1.16
                pr = new Phrase(rb_ch.getString("education"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("education"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(""));
                cell1.setColspan(1);
                table1.addCell(cell1);

                innertable = new PdfPTable(2);
                innertable.setWidthPercentage(100);

                pr = new Phrase(rb_ch.getString("education1"), font_ch);
                if(!person.getField46().equals("")) {
                    pr.add(new Phrase("                                   "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("education1"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(rb_ch.getString("education2"), font_ch);
                if(!person.getField47().equals("")) {
                    pr.add(new Phrase("                                              "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("education2"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(rb_ch.getString("education3"), font_ch);
                if(!person.getField48().equals("")) {
                    pr.add(new Phrase("           "));
                    pr.add(new Phrase(person.getField49(), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("education3"), font_ru));
                innertable.addCell(pr);

                innertable.addCell(new Phrase());

                cell2.setColspan(3);
                cell2.addElement(innertable);
                table1.addCell(cell2);
                //1.17
                pr = new Phrase(rb_ch.getString("workPlace"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("workPlace"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(""));
                cell1.setColspan(1);
                table1.addCell(cell1);

                innertable = new PdfPTable(2);
                innertable.setWidthPercentage(100);

                pr = new Phrase(rb_ch.getString("workPlace1"), font_ch);
                if(!person.getField50().equals("")) {
                    pr.add(new Phrase("    "));
                    pr.add(new Phrase(person.getField50(), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("workPlace1"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(rb_ch.getString("workPlace2"), font_ch);
                if(!person.getField51().equals("")) {
                    pr.add(new Phrase("    "));
                    pr.add(new Phrase(person.getField51(), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("workPlace2"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(rb_ch.getString("workPlace3"), font_ch);
                if(!person.getField52().equals("")) {
                    pr.add(new Phrase("    "));
                    pr.add(new Phrase(person.getField52(), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("workPlace3"), font_ru));
                innertable.addCell(pr);


                pr = new Phrase(rb_ch.getString("workPlace4"), font_ch);
                if(!person.getField53().equals("")) {
                    pr.add(new Phrase("    "));
                    pr.add(new Phrase(person.getField53(), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("workPlace4"), font_ru));
                innertable.addCell(pr);

                cell2.setColspan(3);
                cell2.addElement(innertable);
                table1.addCell(cell2);
                //
                PdfPCell tcell = new PdfPCell(table1);
                tcell.setColspan(2);
                basetable.addCell(tcell);
                //
                document.add(basetable);

                //////////////////////////////////////////////////////////page2
                basetable = new PdfPTable(2);
                basetable.setWidthPercentage(100);
                table1 = new PdfPTable(4);
                //1.18 1.19
                pr = new Phrase(rb_ch.getString("homeAddr"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("homeAddr"), font_ru));
                cell1 = new PdfPCell(pr);
                pr = new Paragraph("");
                if(!person.getField54().equals("")) {
                    pr.add(new Phrase(person.getField54(), font_ru));
                }
                cell2 = new PdfPCell(pr);
                table1.addCell(cell1);
                table1.addCell(cell2);
                pr = new Phrase(rb_ch.getString("zipCode"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("zipCode"), font_ru));
                cell1 = new PdfPCell(pr);
                pr = new Paragraph("");
                if(!person.getField55().equals("")) {
                    pr.add(new Phrase(person.getField55(), font_ru));
                }
                cell2 = new PdfPCell(pr);
                table1.addCell(cell1);
                table1.addCell(cell2);
                //1.20 1.21
                pr = new Phrase(rb_ch.getString("phoneNum"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("phoneNum"), font_ru));
                cell1 = new PdfPCell(pr);
                pr = new Paragraph("");
                if(!person.getField56().equals("")) {
                    pr.add(new Phrase(person.getField56(), font_ru));
                }
                cell2 = new PdfPCell(pr);
                table1.addCell(cell1);
                table1.addCell(cell2);
                pr = new Phrase(rb_ch.getString("email"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("email"), font_ru));
                cell1 = new PdfPCell(pr);
                pr = new Paragraph("");
                if(!person.getField57().equals("")) {
                    pr.add(new Phrase(person.getField57(), font_ru));
                }
                cell2 = new PdfPCell(pr);
                table1.addCell(cell1);
                table1.addCell(cell2);
                //1.22
                pr = new Phrase(rb_ch.getString("familyStatus"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("familyStatus"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                pr = new Phrase(" ");
                if(!person.getField66().equals("")) {
                    pr.add(new Phrase(rb_ru.getString("familyStatus1"), font_ru));
                    pr.add(new Phrase(" "));
                }
                if(!person.getField67().equals("")) {
                    pr.add(new Phrase(rb_ru.getString("familyStatus2"), font_ru));
                    pr.add(new Phrase(" "));
                }
                if(!person.getField68().equals("")) {
                    pr.add(new Phrase(rb_ru.getString("familyStatus3"), font_ru));
                    pr.add(new Phrase(" "));
                    pr.add(new Phrase(person.getField69(), font_ru));
                }
                cell2 = new PdfPCell(pr);
                cell2.setColspan(3);
                table1.addCell(cell2);

                /*tcell = new PdfPCell(table1);
                tcell.setColspan(2);
                basetable.addCell(tcell);*/
                //1.23
                pr = new Phrase(rb_ch.getString("familyStaff"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("familyStaff"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);

                innertable = new PdfPTable(4);
                innertable.setWidthPercentage(100);
                pr = new Phrase(rb_ch.getString("familyStaff1"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("familyStaff1"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(rb_ch.getString("familyStaff2"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("familyStaff2"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(rb_ch.getString("familyStaff3"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("familyStaff3"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(rb_ch.getString("familyStaff4"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("familyStaff4"), font_ru));
                innertable.addCell(pr);

                //add 4 empty row
                //for(int l =0 ; l < 16; l++){
                innertable.addCell(new Phrase(person.getField58(), font_ru));
                innertable.addCell(new Phrase(person.getField59(), font_ru));
                innertable.addCell(new Phrase(person.getField60(), font_ru));
                innertable.addCell(new Phrase(person.getField61(), font_ru));
                
                innertable.addCell(new Phrase(person.getField62(), font_ru));
                innertable.addCell(new Phrase(person.getField63(), font_ru));
                innertable.addCell(new Phrase(person.getField64(), font_ru));
                innertable.addCell(new Phrase(person.getField65(), font_ru));
                
                innertable.addCell(new Phrase(person.getField66(), font_ru));
                innertable.addCell(new Phrase(person.getField67(), font_ru));
                innertable.addCell(new Phrase(person.getField68(), font_ru));
                innertable.addCell(new Phrase(person.getField69(), font_ru));
                
                innertable.addCell(new Phrase(person.getField70(), font_ru));
                innertable.addCell(new Phrase(person.getField71(), font_ru));
                innertable.addCell(new Phrase(person.getField72(), font_ru));
                innertable.addCell(new Phrase(person.getField73(), font_ru));
                //}

                tcell = new PdfPCell(innertable);
                tcell.setColspan(3);
                table1.addCell(tcell);
                //1.24
                pr = new Phrase(rb_ch.getString("contactPerson"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("contactPerson"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);

                innertable = new PdfPTable(2);
                innertable.setWidthPercentage(100);
                pr = new Phrase(rb_ch.getString("contactPerson1"), font_ch);
                if(!person.getField74().equals("")) {
                    pr.add(new Phrase("    "));
                    pr.add(new Phrase(person.getField74(), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("contactPerson1"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(rb_ch.getString("contactPerson2"), font_ch);
                if(!person.getField75().equals("")) {
                    pr.add(new Phrase("    "));
                    pr.add(new Phrase(person.getField75(), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("contactPerson2"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(rb_ch.getString("contactPerson3"), font_ch);
                if(!person.getField76().equals("")) {
                    pr.add(new Phrase("    "));
                    pr.add(new Phrase(person.getField76(), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("contactPerson3"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(" ");
                innertable.addCell(pr);

                tcell = new PdfPCell(innertable);
                tcell.setColspan(3);
                table1.addCell(tcell);
                //1.25
                pr = new Phrase(rb_ch.getString("visitedPlace"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("visitedPlace"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(2);
                table1.addCell(cell1);

                pr = new Phrase(""); 
                if(!person.getField77().equals("")) {
                    pr.add(new Phrase("    "));
                    pr.add(new Phrase(person.getField77(), font_ru));
                }
                cell2 = new PdfPCell(pr);
                cell2.setColspan(2);
                table1.addCell(cell2);

                //
                tcell = new PdfPCell(table1);
                tcell.setColspan(2);
                basetable.addCell(tcell);
                //////////////////////////////////////////////

                document.add(basetable);

                ///////////////////////////////////////part2
                pr = new Phrase("\n");
                pr.add(new Phrase(rb_ch.getString("part2Title"), font_ch));
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("part2Title"), font_ru));
                pr.add(new Phrase("\n"));
                document.add(pr);
                 //2.1
                basetable = new PdfPTable(2);
                basetable.setWidthPercentage(100);
                table1 = new PdfPTable(2);
                table1.setWidths(new int[]{1, 5});

                pr = new Phrase(rb_ch.getString("travelPurpose"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setRowspan(6);
                table1.addCell(cell1);

                innertable = new PdfPTable(2);
                innertable.setWidthPercentage(100);

                pr = new Phrase(rb_ch.getString("travelPurpose1"), font_ch);
                
                if(!person.getField78().equals("")) {
                    pr.add(new Phrase("                                               "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose1"), font_ru));
                innertable.addCell(pr);
                
                pr = new Phrase(rb_ch.getString("travelPurpose8"), font_ch);
                if(!person.getField79().equals("")) {
                    pr.add(new Phrase("                                    "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose8"), font_ru));
                innertable.addCell(pr);
                
                pr = new Phrase(rb_ch.getString("travelPurpose2"), font_ch);
                if(!person.getField80().equals("")) {
                    pr.add(new Phrase("                                                       "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                 pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose2"), font_ru));
                innertable.addCell(pr);
                
                pr = new Phrase(rb_ch.getString("travelPurpose9"), font_ch);
                if(!person.getField82().equals("")) {
                    pr.add(new Phrase("                                         "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose9"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(rb_ch.getString("travelPurpose3"), font_ch);
                if(!person.getField81().equals("")) {
                    pr.add(new Phrase("                              "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose3"), font_ru));
                innertable.addCell(pr);
                
                pr = new Phrase(rb_ch.getString("travelPurpose10"), font_ch);
                if(!person.getField84().equals("")) {
                    pr.add(new Phrase("                                              "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose10"), font_ru));
                innertable.addCell(pr);
                
                pr = new Phrase(rb_ch.getString("travelPurpose4"), font_ch);
                if(!person.getField83().equals("")) {
                    pr.add(new Phrase("                                              "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose4"), font_ru));
                innertable.addCell(pr);
                
                pr = new Phrase(rb_ch.getString("travelPurpose11"), font_ch);
                if(!person.getField86().equals("")) {
                    pr.add(new Phrase("                                              "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose11"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(rb_ch.getString("travelPurpose5"), font_ch);
                if(!person.getField85().equals("")) {
                    pr.add(new Phrase("                                              "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose5"), font_ru));
                innertable.addCell(pr);
                innertable.addCell(new Phrase(" "));
                
                pr = new Phrase(rb_ch.getString("travelPurpose6"), font_ch);
                
                if(!person.getField87().equals("")) {
                    pr.add(new Phrase("                                              "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose6"), font_ru));
                innertable.addCell(pr);
                innertable.addCell(new Phrase(" "));
                
                
                pr = new Phrase(rb_ch.getString("travelPurpose7"), font_ch);
                
                if(!person.getField88().equals("")) {
                    pr.add(new Phrase("                                                      "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose7"), font_ru));
                innertable.addCell(pr);
                innertable.addCell(new Phrase(" "));
                
                innertable.addCell(new Phrase());
                cell2.addElement(innertable);
                table1.addCell(cell2);
                //
                innertable = new PdfPTable(2);
                innertable.setWidthPercentage(100);

                pr = new Phrase(rb_ch.getString("travelPurpose12"), font_ch);
                if(!person.getField89().equals("")) {
                    pr.add(new Phrase("                                                      "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose12"), font_ru));
                innertable.addCell(pr);
                
                pr = new Phrase(rb_ch.getString("travelPurpose13"), font_ch);
                if(!person.getField90().equals("")) {
                    pr.add(new Phrase("                                                      "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose13"), font_ru));
                innertable.addCell(pr);
                /*for(int j=12; j < 14; j++){
                    pr = new Phrase(rb_ch.getString("travelPurpose"+j), font_ch);
                    pr.add(new Phrase(" "));
                    pr.add(new Phrase(rb_ru.getString("travelPurpose"+j), font_ru));
                    innertable.addCell(pr);
                }*/
                cell2 = new PdfPCell(new Phrase(""));
                cell2.addElement(innertable);
                table1.addCell(cell2);
                //
                innertable = new PdfPTable(2);
                innertable.setWidthPercentage(100);

                /*for(int j=14; j < 16; j++){
                    pr = new Phrase(rb_ch.getString("travelPurpose"+j), font_ch);
                    pr.add(new Phrase(" "));
                    pr.add(new Phrase(rb_ru.getString("travelPurpose"+j), font_ru));
                    innertable.addCell(pr);
                }*/
                pr = new Phrase(rb_ch.getString("travelPurpose14"), font_ch);
                if(!person.getField91().equals("")) {
                    pr.add(new Phrase("                                                      "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose14"), font_ru));
                innertable.addCell(pr);
                
                pr = new Phrase(rb_ch.getString("travelPurpose15"), font_ch);
                if(!person.getField92().equals("")) {
                    pr.add(new Phrase("                                                      "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose15"), font_ru));
                innertable.addCell(pr);
                
                cell2 = new PdfPCell(new Phrase(""));
                cell2.addElement(innertable);
                table1.addCell(cell2);
                //
                innertable = new PdfPTable(2);
                innertable.setWidthPercentage(100);

                pr = new Phrase(rb_ch.getString("travelPurpose16"), font_ch);
                if(!person.getField93().equals("")) {
                    pr.add(new Phrase("                                                      "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose16"), font_ru));
                innertable.addCell(pr);
                
                
                pr = new Phrase(rb_ch.getString("travelPurpose17"), font_ch);
                if(!person.getField94().equals("")) {
                    pr.add(new Phrase("                                                      "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose17"), font_ru));
                innertable.addCell(pr);
                /*for(int j=16; j < 18; j++){
                    pr = new Phrase(rb_ch.getString("travelPurpose"+j), font_ch);
                    pr.add(new Phrase(" "));
                    pr.add(new Phrase(rb_ru.getString("travelPurpose"+j), font_ru));
                    innertable.addCell(pr);
                }*/
                cell2 = new PdfPCell(new Phrase(""));
                cell2.addElement(innertable);
                table1.addCell(cell2);
                //
                innertable = new PdfPTable(2);
                innertable.setWidthPercentage(100);

                /*for(int j=18; j < 20; j++){
                    pr = new Phrase(rb_ch.getString("travelPurpose"+j), font_ch);
                    pr.add(new Phrase(" "));
                    pr.add(new Phrase(rb_ru.getString("travelPurpose"+j), font_ru));
                    innertable.addCell(pr);
                }*/
                pr = new Phrase(rb_ch.getString("travelPurpose18"), font_ch);
                if(!person.getField95().equals("")) {
                    pr.add(new Phrase("                                                      "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose18"), font_ru));
                innertable.addCell(pr);
                
                pr = new Phrase(rb_ch.getString("travelPurpose19"), font_ch);
                if(!person.getField96().equals("")) {
                    pr.add(new Phrase("                                                      "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("travelPurpose19"), font_ru));
                innertable.addCell(pr);
                
                cell2 = new PdfPCell(new Phrase(""));
                cell2.addElement(innertable);
                table1.addCell(cell2);
                //
                innertable = new PdfPTable(2);
                innertable.setWidthPercentage(100);

                    pr = new Phrase(rb_ch.getString("travelPurpose20"), font_ch);
                    if(!person.getField97().equals("")) {
                        pr.add(new Phrase("          "));
                        pr.add(new Phrase(person.getField98(), font_ru));
                    }
                    pr.add(new Phrase("\n"));
                    pr.add(new Phrase(rb_ru.getString("travelPurpose20"), font_ru));
                    PdfPCell innerCell2 = new PdfPCell(pr);
                    innerCell2.setColspan(2);
                    innertable.addCell(innerCell2);

                cell2 = new PdfPCell(new Phrase(""));
                cell2.addElement(innertable);
                table1.addCell(cell2);
                ///2.2
                pr = new Phrase(rb_ch.getString("planingTravel"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("planingTravel"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);

                pr = new Phrase(rb_ch.getString("planingTravel1"), font_ch);
                if(!person.getField99().equals("")) {
                    pr.add(new Phrase("                                                                 "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("planingTravel1"), font_ru));
                pr.add(new Phrase("\n \n"));
                
                pr.add(new Phrase(rb_ch.getString("planingTravel2"), font_ch));
                if(!person.getField100().equals("")) {
                    pr.add(new Phrase("                                                           "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("planingTravel2"), font_ru));
                pr.add(new Phrase("\n \n"));
                
                pr.add(new Phrase(rb_ch.getString("planingTravel3"), font_ch));
                if(!person.getField101().equals("")) {
                    pr.add(new Phrase("                                                      "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("planingTravel3"), font_ru));
                pr.add(new Phrase("\n \n"));
                
                pr.add(new Phrase(rb_ch.getString("planingTravel4"), font_ch));
                if(!person.getField102().equals("")) {
                    pr.add(new Phrase("                                                        "));
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("planingTravel4"), font_ru));
                pr.add(new Phrase("\n \n"));
                
                pr.add(new Phrase(rb_ch.getString("planingTravel5"), font_ch));
                if(!person.getField103().equals("")) {
                    pr.add(new Phrase("                   "));
                    pr.add(new Phrase(person.getField104(), font_ch));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("planingTravel5"), font_ru));
                pr.add(new Phrase("\n \n"));
                cell2 = new PdfPCell(pr);

                table1.addCell(cell2);

                tcell = new PdfPCell(table1);
                tcell.setColspan(2);
                basetable.addCell(tcell);
                /////////////////////////////////////
                table1 = new PdfPTable(2);
                table1.setWidths(new int[]{4, 1});
                pr = new Phrase(rb_ch.getString("fastService"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("fastService"), font_ru));
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ch.getString("fastService2"), font_ch));
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("fastService2"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                
                pr = new Phrase("");
                if(!person.getField144().equals("")) {
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                if(!person.getField105().equals("")) {
                    pr.add(new Phrase(rb_ch.getString("no"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("no"), font_ru));
                }
                cell2 = new PdfPCell(pr);
                table1.addCell(cell2);

                tcell = new PdfPCell(table1);
                tcell.setColspan(2);
                basetable.addCell(tcell);
                document.add(basetable);
                //////////////////////////////////////////////////////////page3
                basetable = new PdfPTable(2);
                basetable.setWidthPercentage(100);
                table1 = new PdfPTable(3);
                table1.setWidths(new int[]{1, 1, 1});
                //2.4 2.5
                pr = new Phrase(rb_ch.getString("dataSuggestion"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("dataSuggestion"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(""));
                cell1.setColspan(2);
                table1.addCell(cell1);
                table1.addCell(cell2);
                pr = new Phrase(rb_ch.getString("dataViseted"), font_ch);
                if(!person.getField106().equals("")) {
                    pr.add(new Phrase("        "));
                    pr.add(new Phrase(person.getField106(), font_ch));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("dataViseted"), font_ru));
                cell1 = new PdfPCell(pr);
                cell2 = new PdfPCell(new Paragraph(""));
                cell1.setColspan(2);
                table1.addCell(cell1);
                table1.addCell(cell2);
                //2.6
                pr = new Phrase(rb_ch.getString("marshrut"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("marshrut"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);

                innertable = new PdfPTable(2);
                innertable.setWidthPercentage(100);
                pr = new Phrase(rb_ch.getString("date"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("date"), font_ru));
                innertable.addCell(pr);

                pr = new Phrase(rb_ch.getString("addressMore"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("addressMore"), font_ru));
                innertable.addCell(pr);

                //add 4 empty row
                /*for(int l =0 ; l < 10; l++){
                    innertable.addCell(new Phrase(" "));
                }*/
                pr = new Phrase("");
                if(!person.getField107().equals("")) {
                    pr.add(new Phrase(person.getField107(), font_ru));
                }
                if(!person.getField108().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField108(), font_ru));
                }
                if(!person.getField109().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField109(), font_ru));
                }
                innertable.addCell(pr);
                
                pr = new Phrase("");
                if(!person.getField110().equals("")) {
                    pr.add(new Phrase(person.getField110(), font_ru));
                }
                innertable.addCell(pr);
                
                pr = new Phrase("");
                if(!person.getField111().equals("")) {
                    pr.add(new Phrase(person.getField111(), font_ru));
                }
                if(!person.getField112().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField112(), font_ru));
                }
                if(!person.getField113().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField113(), font_ru));
                }
                innertable.addCell(pr);
                
                pr = new Phrase("");
                if(!person.getField114().equals("")) {
                    pr.add(new Phrase(person.getField114(), font_ru));
                }
                innertable.addCell(pr);
                
                pr = new Phrase("");
                if(!person.getField115().equals("")) {
                    pr.add(new Phrase(person.getField115(), font_ru));
                }
                if(!person.getField116().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField116(), font_ru));
                }
                if(!person.getField117().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField117(), font_ru));
                }
                innertable.addCell(pr);
                
                pr = new Phrase("");
                if(!person.getField118().equals("")) {
                    pr.add(new Phrase(person.getField118(), font_ru));
                }
                innertable.addCell(pr);
                
                pr = new Phrase("");
                if(!person.getField119().equals("")) {
                    pr.add(new Phrase(person.getField119(), font_ru));
                }
                if(!person.getField120().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField120(), font_ru));
                }
                if(!person.getField121().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField121(), font_ru));
                }
                innertable.addCell(pr);
                
                pr = new Phrase("");
                if(!person.getField122().equals("")) {
                    pr.add(new Phrase(person.getField122(), font_ru));
                }
                innertable.addCell(pr);
                
                pr = new Phrase("");
                if(!person.getField123().equals("")) {
                    pr.add(new Phrase(person.getField123(), font_ru));
                }
                if(!person.getField124().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField124(), font_ru));
                }
                if(!person.getField125().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField125(), font_ru));
                }
                innertable.addCell(pr);
                
                pr = new Phrase("");
                if(!person.getField126().equals("")) {
                    pr.add(new Phrase(person.getField126(), font_ru));
                }
                innertable.addCell(pr);
                
                tcell = new PdfPCell(innertable);
                tcell.setColspan(2);
                table1.addCell(tcell);
                //2.7
                pr = new Phrase(rb_ch.getString("howpay"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("howpay"), font_ru));
                cell1 = new PdfPCell(pr);
                pr = new Phrase("");
                if(!person.getField127().equals("")) {
                    pr.add(new Phrase(person.getField127(), font_ru));
                }
                cell2 = new PdfPCell(pr);
                cell1.setColspan(2);
                table1.addCell(cell1);
                table1.addCell(cell2);
                //2.8
                pr = new Phrase(rb_ch.getString("infoAboutVisit"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("infoAboutVisit"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setRowspan(4);
                table1.addCell(cell1);

                pr = new Phrase(rb_ch.getString("nazvanie"), font_ch);
                if(!person.getField128().equals("")) {
                    pr.add(new Phrase(" "));
                    pr.add(new Phrase(person.getField128(), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("nazvanie"), font_ru));
                cell2 = new PdfPCell(pr);
                cell2.setColspan(2);
                table1.addCell(cell2);


                pr = new Phrase(rb_ch.getString("address"), font_ch);
                if(!person.getField129().equals("")) {
                    pr.add(new Phrase(" "));
                    pr.add(new Phrase(person.getField129(), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("address"), font_ru));
                cell2 = new PdfPCell(pr);
                cell2.setColspan(2);
                table1.addCell(cell2);


                pr = new Phrase(rb_ch.getString("tel"), font_ch);
                if(!person.getField130().equals("")) {
                    pr.add(new Phrase(" "));
                    pr.add(new Phrase(person.getField130(), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("tel"), font_ru));
                cell2 = new PdfPCell(pr);
                cell2.setColspan(2);
                table1.addCell(cell2);


                pr = new Phrase(rb_ch.getString("relation"), font_ch);
                if(!person.getField131().equals("")) {
                    pr.add(new Phrase(" "));
                    pr.add(new Phrase(person.getField131(), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("relation"), font_ru));
                cell2 = new PdfPCell(pr);
                cell2.setColspan(2);
                table1.addCell(cell2);
                //2.9
                pr = new Phrase(rb_ch.getString("oldVisa"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("oldVisa"), font_ru));
                cell1 = new PdfPCell(pr);
                pr = new Paragraph("");
                if(!person.getField132().equals("")) {
                    pr.add(new Phrase(person.getField132(), font_ru));
                }
                cell2 = new PdfPCell(pr);
                cell1.setColspan(2);
                table1.addCell(cell1);
                table1.addCell(cell2);
                //2.10
                pr = new Phrase(rb_ch.getString("otherViseted"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("otherViseted"), font_ru));
                cell1 = new PdfPCell(pr);
                pr = new Paragraph("");
                if(!person.getField133().equals("")) {
                    pr.add(new Phrase(person.getField133(), font_ru));
                }
                cell2 = new PdfPCell(pr);
                cell1.setColspan(2);
                table1.addCell(cell1);
                table1.addCell(cell2);
                //
                tcell = new PdfPCell(table1);
                tcell.setColspan(2);
                basetable.addCell(tcell);
                /////////////////////////////////////
                document.add(basetable);

                ///////////////////////////////////////part3
                pr = new Phrase("\n");
                pr.add(new Phrase(rb_ch.getString("part3"), font_ch));
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("part3"), font_ru));
                pr.add(new Phrase("\n"));
                document.add(pr);
                 //3.1
                basetable = new PdfPTable(2);
                basetable.setWidthPercentage(100);
                table1 = new PdfPTable(4);
                table1.setWidths(new int[]{1, 1, 1, 1});

                pr = new Phrase(rb_ch.getString("wrongVisit"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("wrongVisit"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(3);
                table1.addCell(cell1);

                pr = new Phrase("");
                if(!person.getField134().equals("")) {
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                if(!person.getField135().equals("")) {
                    pr.add(new Phrase(rb_ch.getString("no"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("no"), font_ru));
                }
                
                cell2 = new PdfPCell(pr);
                table1.addCell(cell2);
                //3.2
                pr = new Phrase(rb_ch.getString("rejectedVisit"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("rejectedVisit"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(3);
                table1.addCell(cell1);

                pr = new Phrase("");
                if(!person.getField136().equals("")) {
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                if(!person.getField137().equals("")) {
                    pr.add(new Phrase(rb_ch.getString("no"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("no"), font_ru));
                }
                cell2 = new PdfPCell(pr);
                table1.addCell(cell2);
                //3.3
                pr = new Phrase(rb_ch.getString("sudimost"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("sudimost"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(3);
                table1.addCell(cell1);

               pr = new Phrase("");
                if(!person.getField138().equals("")) {
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                if(!person.getField139().equals("")) {
                    pr.add(new Phrase(rb_ch.getString("no"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("no"), font_ru));
                }
                cell2 = new PdfPCell(pr);
                table1.addCell(cell2);

                //3.4
                pr = new Phrase(rb_ch.getString("illness"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("illness"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(3);
                table1.addCell(cell1);

                pr = new Phrase("");
                if(!person.getField140().equals("")) {
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                if(!person.getField141().equals("")) {
                    pr.add(new Phrase(rb_ch.getString("no"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("no"), font_ru));
                }
                cell2 = new PdfPCell(pr);
                table1.addCell(cell2);

                //3.5
                pr = new Phrase(rb_ch.getString("ilnessContry"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("ilnessContry"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(3);
                table1.addCell(cell1);

                pr = new Phrase("");
                if(!person.getField142().equals("")) {
                    pr.add(new Phrase(rb_ch.getString("yes"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("yes"), font_ru));
                }
                if(!person.getField143().equals("")) {
                    pr.add(new Phrase(rb_ch.getString("no"), font_ch));
                    pr.add(new Phrase("  "));
                    pr.add(new Phrase(rb_ru.getString("no"), font_ru));
                }
                cell2 = new PdfPCell(pr);
                table1.addCell(cell2);
                //3.6
                pr = new Phrase(rb_ch.getString("ilnessContryMoreDesc"), font_ch);
                if(!person.getField145().equals("")) {
                    pr.add(new Phrase(person.getField145(), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("ilnessContryMoreDesc"), font_ru));
                
                cell1 = new PdfPCell(pr);
                cell1.setColspan(4);
                table1.addCell(cell1);
                //3.7
                pr = new Phrase(rb_ch.getString("ilnessContryOtherDesc"), font_ch);
                if(!person.getField146().equals("")) {
                    pr.add(new Phrase(person.getField146(), font_ru));
                }
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("ilnessContryOtherDesc"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(4);
                table1.addCell(cell1);
                //3.8
                pr = new Phrase(rb_ch.getString("ilnessContryPersonData"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("ilnessContryPersonData"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(4);
                table1.addCell(cell1);
                //3.8.1
                pr = new Phrase(rb_ch.getString("info"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("info"), font_ru));
                pr.add(new Phrase("\n"));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                //3.8.2
                pr = new Phrase(rb_ch.getString("person1"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("person1"), font_ru));
                pr.add(new Phrase("\n"));
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ch.getString("photo"), font_ch));
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("photo"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                //3.8.3
                pr = new Phrase(rb_ch.getString("person2"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("person2"), font_ru));
                pr.add(new Phrase("\n"));
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ch.getString("photo"), font_ch));
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("photo"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                //3.8.4
                pr = new Phrase(rb_ch.getString("person3"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("person3"), font_ru));
                pr.add(new Phrase("\n"));
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ch.getString("photo"), font_ch));
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("photo"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                //3.8.body
                //for(int i = 1; i< 4; i++){
                //fio
                pr = new Phrase(rb_ch.getString("part3.8_1"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("part3.8_1"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);

                pr = new Phrase();
                if(!person.getField147().equals("")) {
                    pr.add(new Phrase(person.getField147(), font_ru));
                }
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                
                pr = new Phrase();
                if(!person.getField148().equals("")) {
                    pr.add(new Phrase(person.getField148(), font_ru));
                }
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                
                pr = new Phrase();
                if(!person.getField149().equals("")) {
                    pr.add(new Phrase(person.getField149(), font_ru));
                }
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                //sex
                pr = new Phrase(rb_ch.getString("part3.8_2"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("part3.8_2"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                
                pr = new Phrase();
                if(!person.getField150().equals("")) {
                    pr.add(new Phrase(person.getField150(), font_ru));
                }
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                
                 pr = new Phrase();
                if(!person.getField151().equals("")) {
                    pr.add(new Phrase(person.getField151(), font_ru));
                }
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                
                pr = new Phrase();
                if(!person.getField152().equals("")) {
                    pr.add(new Phrase(person.getField152(), font_ru));
                }
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                //
                pr = new Phrase(rb_ch.getString("part3.8_3"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("part3.8_3"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                pr = new Phrase("");
                if(!person.getField153().equals("")) {
                    pr.add(new Phrase(person.getField153(), font_ru));
                }
                if(!person.getField154().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField154(), font_ru));
                }
                if(!person.getField155().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField155(), font_ru));
                }
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                
                pr = new Phrase("");
                if(!person.getField156().equals("")) {
                    pr.add(new Phrase(person.getField156(), font_ru));
                }
                if(!person.getField157().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField157(), font_ru));
                }
                if(!person.getField158().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField158(), font_ru));
                }
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                
                pr = new Phrase("");
                if(!person.getField159().equals("")) {
                    pr.add(new Phrase(person.getField159(), font_ru));
                }
                if(!person.getField160().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField160(), font_ru));
                }
                if(!person.getField161().equals("")) {
                    pr.add(new Phrase("/"));
                    pr.add(new Phrase(person.getField161(), font_ru));
                }
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                //}
                 tcell = new PdfPCell(table1);
                tcell.setColspan(2);
                basetable.addCell(tcell);
                document.add(basetable);
                //////////////////////////////////////part4
                pr = new Phrase("\n");
                pr.add(new Phrase(rb_ch.getString("part4"), font_ch));
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("part4"), font_ru));
                pr.add(new Phrase("\n"));
                document.add(pr);
                 //4.1
                basetable = new PdfPTable(2);
                basetable.setWidthPercentage(100);
                table1 = new PdfPTable(2);
                table1.setWidths(new int[]{1, 1});

                pr = new Phrase(rb_ch.getString("part4.1"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("part4.1"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(2);
                table1.addCell(cell1);

                 //4.2
                pr = new Phrase(rb_ch.getString("part4.2"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("part4.2"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(2);
                table1.addCell(cell1);

                 //4.3
                pr = new Phrase(rb_ch.getString("part4.3"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("part4.3"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(2);
                table1.addCell(cell1);
                 //4.4
                pr = new Phrase(rb_ch.getString("part4.4"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("part4.4"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                pr = new Phrase(rb_ch.getString("part4.5"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("part4.5"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                 //4.5
                pr = new Phrase(rb_ch.getString("part4.5"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("part4.5"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(2);
                table1.addCell(cell1);
                //
                tcell = new PdfPCell(table1);
                tcell.setColspan(2);
                basetable.addCell(tcell);
                //
                document.add(basetable);
                //////////////////////////////////////part5
                pr = new Phrase("\n");
                pr.add(new Phrase(rb_ch.getString("part5"), font_ch));
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("part5"), font_ru));
                pr.add(new Phrase("\n"));
                document.add(pr);

                basetable = new PdfPTable(2);
                basetable.setWidthPercentage(100);
                table1 = new PdfPTable(4);
                table1.setWidths(new int[]{1, 1, 1, 1});
                //5.1 5.2
                pr = new Phrase(rb_ch.getString("part5.1"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("part5.1"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                
                pr = new Phrase();
                if(!person.getField162().equals("")) {
                    pr.add(new Phrase("                "));
                    pr.add(new Phrase(person.getField162(), font_ru));
                }
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);

                pr = new Phrase(rb_ch.getString("part5.2"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("part5.2"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                
                pr = new Phrase();
                if(!person.getField163().equals("")) {
                    pr.add(new Phrase("                "));
                    pr.add(new Phrase(person.getField163(), font_ru));
                }
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                //5.3 5.4
                pr = new Phrase(rb_ch.getString("part5.3"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("part5.3"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                
                pr = new Phrase();
                if(!person.getField164().equals("")) {
                    pr.add(new Phrase("                "));
                    pr.add(new Phrase(person.getField164(), font_ru));
                }
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);

                pr = new Phrase(rb_ch.getString("part5.4"), font_ch);
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ru.getString("part5.4"), font_ru));
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);

                pr = new Phrase();
                if(!person.getField165().equals("")) {
                    pr.add(new Phrase("                "));
                    pr.add(new Phrase(person.getField165(), font_ru));
                }
                cell1 = new PdfPCell(pr);
                table1.addCell(cell1);
                //5.5
                pr = new Phrase(rb_ch.getString("part5.5"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("part5.5"), font_ru));
                pr.add(new Phrase("\n"));
                pr.add(new Phrase(rb_ch.getString("part5.5.1"), font_ch));
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("part5.5.1"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(4);
                table1.addCell(cell1);
                //5.5
                pr = new Phrase(rb_ch.getString("part5.6"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("part5.6"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(2);
                table1.addCell(cell1);

                pr = new Phrase(rb_ch.getString("part5.7"), font_ch);
                pr.add(new Phrase(" "));
                pr.add(new Phrase(rb_ru.getString("part5.7"), font_ru));
                cell1 = new PdfPCell(pr);
                cell1.setColspan(2);
                table1.addCell(cell1);
                //
                tcell = new PdfPCell(table1);
                tcell.setColspan(2);
                basetable.addCell(tcell);
                /////////////////////////////////////
                document.add(basetable);
            } catch ( Exception e ) {
              System.err.println( e.getClass().getName() + ": " + e.getMessage() );
              System.exit(0);
            }
        
        // step 5
        document.close();
        //
    }
    
    public void openPDF(String filename){
	  try {
 
		if ((new File(filename)).exists()) {
 
			Process p = Runtime
			   .getRuntime()
			   .exec("rundll32 url.dll,FileProtocolHandler "+filename);
			p.waitFor();
 
		} else {
 
			System.out.println("File is not exists");
 
		}
 
		System.out.println("Done");
 
  	  } catch (Exception ex) {
		ex.printStackTrace();
	  }
    }
    
     public boolean deleteFile(String filename){    
        try{
 
    		File file = new File(filename);
 
    		if(file.delete()){
    			//System.out.println(file.getName() + " is deleted!");
    		}else{
    			//System.out.println("Delete operation is failed.");
    		}
            return true;    
    	}catch(Exception e){
 
    		e.printStackTrace();
            return false;    
    	}
    }
}
