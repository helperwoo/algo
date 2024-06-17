import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Double> grade = new HashMap<>();
        
        grade.put("A+", 4.5);
        grade.put("A0", 4.0);
        grade.put("B+", 3.5);
        grade.put("B0", 3.0);
        grade.put("C+", 2.5);
        grade.put("C0", 2.0);
        grade.put("D+", 1.5);
        grade.put("D0", 1.0);
        grade.put("F", 0.0);
        
        double totalScore = 0;
        double totalCredits = 0;
        
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.trim().isEmpty()) {
                break;
            }
            
            String[] data = input.split(" ");
            double credits = Double.parseDouble(data[1]);
            String gradeReceived = data[2];
            
            // "P" 등급 과목은 계산에서 제외
            if (!gradeReceived.equals("P")) {
                totalScore += credits * grade.get(gradeReceived);
                totalCredits += credits;
            }
        }
        
        sc.close();
        
        if (totalCredits == 0) {
            System.out.println("0.0");
        } else {
            System.out.printf("%.6f", totalScore / totalCredits);
        }
    }
}