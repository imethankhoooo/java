import java.util.*;

/**
 * Quick test export functionality
 */
public class TestExportQuick {
    public static void main(String[] args) {
        System.out.println("=== Export Function Test ===");
        
        // Create export service
        ReportExportService exportService = new ReportExportService();
        
        // Prepare test data
        String reportTitle = "Test Report";
        List<String> headers = Arrays.asList("ID", "Name", "Quantity", "Status");
        List<List<String>> data = new ArrayList<>();
        
        data.add(Arrays.asList("001", "Vehicle A", "10", "Available"));
        data.add(Arrays.asList("002", "Vehicle B", "5", "Maintenance"));
        data.add(Arrays.asList("003", "Vehicle C", "8", "Available"));
        
        // Test Excel export
        System.out.println("\nTesting Excel export...");
        boolean excelResult = exportService.exportToExcel(reportTitle, headers, data, "test_export.xlsx");
        System.out.println("Excel export: " + (excelResult ? "Success" : "Failed"));
        
        // Test PDF export
        System.out.println("\nTesting PDF export...");
        boolean pdfResult = exportService.exportToPDF(reportTitle, headers, data, "test_export.pdf");
        System.out.println("PDF export: " + (pdfResult ? "Success" : "Failed"));
        
        System.out.println("\nTest completed!");
    }
} 