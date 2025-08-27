package com.example.Online.Billing.Symtem.Pahana.Edu.service;

import com.example.Online.Billing.Symtem.Pahana.Edu.entity.Order;
import com.example.Online.Billing.Symtem.Pahana.Edu.repository.OrderRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private OrderRepository orderRepository;

    public byte[] generateOrderBill(Long orderId) throws FileNotFoundException, JRException {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));

        File file = ResourceUtils.getFile("classpath:reports/order_bill.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(order.getOrderDetails());

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("shopName", "Pahana Edu Bookshop");
        parameters.put("shopAddress", "Colombo City, Sri Lanka");
        parameters.put("shopPhone", "+94 11 234 5678");
        parameters.put("customerName", order.getCustomer().getName());
        parameters.put("orderId", order.getId());
        parameters.put("orderDate", order.getOrderDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        parameters.put("totalAmount", order.getTotalAmount());
        parameters.put("orderDetails", dataSource);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
