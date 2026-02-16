import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = scanner.nextDouble();

        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = scanner.nextInt();

        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        scanner.nextLine();
        String machineryState = scanner.nextLine();

        System.out.println("Arm Precision: " + armPrecision);
        System.out.println("Worker Density: " + workerDensity);
        System.out.println("Machinery State: " + machineryState);

        scanner.close();
    }
}