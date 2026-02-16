import java.util.Scanner;
class RobotSafetyException extends Exception {
    public RobotSafetyException(String message) {
        super(message);
    }
}

class RobotHazardAuditor {

    private static final double WORN_RISK_FACTOR = 1.3;
    private static final double FAULTY_RISK_FACTOR = 2.0;
    private static final double CRITICAL_RISK_FACTOR = 3.0;

    public double CalculateHazardRisk(double armPrecision, int workerDensity, String machineryState)
            throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException("Error: Worker density must be 1-20");
        }

        double machineRiskFactor = getMachineRiskFactor(machineryState);
        return ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
    }

    private double getMachineRiskFactor(String machineryState) throws RobotSafetyException {
        switch (machineryState) {
            case "Worn":
                return WORN_RISK_FACTOR;
            case "Faulty":
                return FAULTY_RISK_FACTOR;
            case "Critical":
                return CRITICAL_RISK_FACTOR;
            default:
                throw new RobotSafetyException("Error: Unsupported machinery state");
        }
    }
}



class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RobotHazardAuditor auditor = new RobotHazardAuditor();

        try {
            System.out.println("Enter Arm Precision (0.0 - 1.0):");
            double armPrecision = scanner.nextDouble();

            System.out.println("Enter Worker Density (1 - 20):");
            int workerDensity = scanner.nextInt();

            System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
            scanner.nextLine();
            String machineryState = scanner.nextLine();

            double hazardRisk = auditor.CalculateHazardRisk(armPrecision, workerDensity, machineryState);
            System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}