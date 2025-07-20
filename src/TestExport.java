import java.util.*;

/**
 * Test export functionality
 */
public class TestExport {
    public static void main(String[] args) {
        System.out.println("Testing report export functionality");
        
        RentalSystem system = new RentalSystem();
        // Create export service
        ReportExportService exportService = new ReportExportService();
        
        System.out.println();
        
        // Prepare test data
        String reportTitle = "System Statistics Report";
        List<String> headers = Arrays.asList("Project", "Quantity", "Percentage", "Status");
        
        List<List<String>> data = new ArrayList<>();
        data.add(Arrays.asList("Total Users", "1250", "100%", "Normal"));
        data.add(Arrays.asList("Active Users", "876", "70.08%", "Normal"));
        data.add(Arrays.asList("New Users", "45", "3.6%", "Normal"));
        data.add(Arrays.asList("Total Orders", "2340", "100%", "Normal"));
        data.add(Arrays.asList("Completed Orders", "2180", "93.16%", "Normal"));
        data.add(Arrays.asList("Pending Orders", "160", "6.84%", "Warning"));
        
        String baseFilename = "test_export";
        
        System.out.println("Starting test export functionality...");
        System.out.println();
        
        // Test Excel export
        System.out.println("1. Testing Excel export:");
        boolean excelSuccess = exportService.exportToExcel(reportTitle, headers, data, baseFilename + "_excel");
        System.out.println("Excel export result: " + (excelSuccess ? "Success" : "Failed"));
        System.out.println();
        
        // Test PDF export
        System.out.println("2. Testing PDF export:");
        boolean pdfSuccess = exportService.exportToPDF(reportTitle, headers, data, baseFilename + "_pdf");
        System.out.println("PDF export result: " + (pdfSuccess ? "Success" : "Failed"));
        System.out.println();
        
        // Display summary
        System.out.println("Test completion summary:");
        System.out.println("Excel export: " + (excelSuccess ? "✓" : "✗"));
        System.out.println("PDF export: " + (pdfSuccess ? "✓" : "✗"));
        
        if (excelSuccess || pdfSuccess) {
            System.out.println("\nExported files are saved in the reports/ directory");
        }
        
        // Test interactive export (optional)
        if (args.length > 0 && args[0].equals("interactive")) {
            Scanner scanner = new Scanner(System.in);
            exportService.promptForExport(scanner, "Interactive test report", headers, data, "interactive_test");
            scanner.close();
        }
    }
} 