package com.example.jasperreport.JasperController;


import com.example.jasperreport.Product;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


import java.util.*;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/1")
    public  String hello(){
        return "hello";
    }

    @GetMapping("/2")
    public  void hello1(HttpServletResponse response) throws JRException, IOException {
        String path="src/main/resources/firstJasperProjectjrxml.jrxml";

        Map<String , Object> map = new HashMap<>();
        map.put("firstName","usman khalid11");

        JasperReport report= JasperCompileManager.compileReport(path);
        JasperPrint print = JasperFillManager.fillReport(report,map, new JREmptyDataSource());


        JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");



    }

    @GetMapping("/3")
    public  void hello3(HttpServletResponse response) throws JRException, IOException {
        String path="src/main/resources/Blank_A4.jrxml";

        Map<String , Object> map = new HashMap<>();
        map.put("Sno","342810767");
        map.put("St", new Date());
        map.put("Od", "odendi");
        map.put("Sd", "hazirlaniyor");
        map.put("Sadi", "usman khalid");
        map.put("Adi", "bosver");
        map.put("adress", "Elazig Merkez Abdullahpasi ahmet kabaklik yurdu turkiye");
        map.put("tel", "123456789");
        map.put("amount", 56.7);
        map.put("kargo", 45.9);

        JasperReport report= JasperCompileManager.compileReport(path);
        JasperPrint print = JasperFillManager.fillReport(report,map, new JREmptyDataSource());



        JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");



    }

    @GetMapping("/4")
    public  void hello4(HttpServletResponse response) throws JRException, IOException {
        String path="src/main/resources/Blank.jrxml";
        List<Product> productList= new ArrayList<>();
        productList.add(new Product("usman",293.0));
        productList.add(new Product("usman1",236.0));
        productList.add(new Product("usman1",23.0));

        JRBeanCollectionDataSource dataSource = new
                JRBeanCollectionDataSource(productList);
        Map<String , Object> map = new HashMap<>();
        map.put("Sno","342810767");
        map.put("St", new Date());
        map.put("Od", "odendi");
        map.put("Sd", "hazirlaniyor");
        map.put("Sadi", "usman khalid");
        map.put("Adi", "bosver");
        map.put("adress", "Elazig Merkez Abdullahpasi ahmet kabaklik yurdu turkiye");
        map.put("tel", "123456789");

        map.put("kargo", 45.9);

        JasperReport report= JasperCompileManager.compileReport(path);
        JasperPrint print = JasperFillManager.fillReport(report,map,dataSource);



        JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");



    }
}
