package jasperReport;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

public class PdfFromXmlFile {
	 
	   public static void main(String[] args) throws JRException, IOException {
	 
	        // Compile jrxml file./jasperReport/StyledTextReport.jrxml
	       JasperReport jasperReport = JasperCompileManager
	               .compileReport("C:\\\\Users\\\\Mahadeva\\\\Videos\\\\kgf\\StyledTextReport.jrxml");
	 
	       // Parameters for report
	       HashMap<String, Object> parameters = new HashMap<String, Object>();
	       parameters.put("EMP_ID",123);
	       parameters.put("firstname","123");
	       parameters.put("lastname","123");

	       
	       parameters.put("USERNAME","123");
	       parameters.put("ROLE","123");
	       parameters.put("city","123");

	       
	       ArrayList list=new ArrayList();
list.add(parameters);
	       // DataSource
	       // This is simple example, no database.
	       // then using empty datasource.
	       JRDataSource dataSource = new JREmptyDataSource();
			JRBeanCollectionDataSource dataSourse1=new JRBeanCollectionDataSource( list);
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, parameters,dataSourse1);

	   
	 
	    
	       // Make sure the output directory exists.
	       File outDir = new File("C:\\Users\\Mahadeva\\Videos\\kgf");
	       outDir.mkdirs();
	 
	       // Export to PDF.
	       JasperExportManager.exportReportToPdfFile(jasperPrint,
	               "C:\\Users\\Mahadeva\\Videos\\kgf\\StyledTextReport.pdf");
	       System.out.println("Done!pdf");


	       String s="C:\\\\Users\\\\Mahadeva\\\\Videos\\\\kgf\\\\StyledTextReport.xlsx";
	       File xlsFile = new File(s);
	       JRXlsxExporter Xlsxexporter = new JRXlsxExporter();
	       Xlsxexporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	       Xlsxexporter.setParameter(JRExporterParameter.OUTPUT_FILE, xlsFile);
	       Xlsxexporter.exportReport();
	        
	       System.out.println("Done!excel");
	   }
	}
