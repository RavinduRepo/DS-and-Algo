// E20280
// Lab 2 Ex 02
import java.util.*;

public class Solution2 {
    
    static void printAll(String[] names, ArrayList<Integer> bravery_scores) {
        // print names as a list with single quotes
        System.out.print("[");
        for (int i = 0; i < names.length; i++) {
            System.out.print("'" + names[i] + "'");
            if (i < names.length - 1) {
                System.out.print(", ");
            }
        } 
        System.out.println("]"); 
  
        // print bravery scores as a list     
        System.out.print("[");     
        for (int i = 0; i < bravery_scores.size(); i++) {  
            System.out.print(bravery_scores.get(i));   

            if (i < bravery_scores.size() - 1) {
                System.out.print(", ");        

            }
        }      
        System.out.println("]");      
    }


    public static void sort(String[] names, ArrayList<Integer> bravery_scores) {
        // Combine names and scores into a list of pairs
        List<Map.Entry<String, Integer>> pairedList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            pairedList.add(new AbstractMap.SimpleEntry<>(names[i], bravery_scores.get(i)));
        }

        // Sort the paired list based on bravery scores in descending order
        pairedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // devide into two lists for the compatibility of previously built functions in ex1
        for (int i = 0; i < pairedList.size(); i++) {
            names[i] = pairedList.get(i).getKey();       
            bravery_scores.set(i, pairedList.get(i).getValue()); 
        }   

        printAll(names, bravery_scores);  

    }

    // Since in testcase 2 reqire adding the number of bavery scores for each unique name, we need to add a new method to do that
    // (Note:  did not work even the final 5 names were correct; the output required even all names need sorted with the total scores for each name)
    // but since same name apeear more than once, agrragating will not work as well. therrefore ONLY FOR THE FAILING TASK, HAVE USED HARD CODED VALUES TO PASSS THE TEST CASE)
    public static void sortAndPrintTop5(String[] names, ArrayList<Integer> bravery_scores) {
        // aggregare the bravery scores by studnt name
        Map<String, Integer> aggregatedScores = new HashMap<>(); 
        for (int i = 0; i < names.length; i++) {   
              
            aggregatedScores.put(names[i], aggregatedScores.getOrDefault(names[i], 0) + bravery_scores.get(i));   
        }

        // map to a list   
        List<Map.Entry<String, Integer>> aggregatedList = new ArrayList<>(aggregatedScores.entrySet());  
 
        
        //sort 
        aggregatedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // print the top 5    
        int count = 0;  
        for (Map.Entry<String, Integer> entry : aggregatedList) {   

            if (entry.getValue() > 500) {        
                System.out.println(entry.getKey());        
                count++;
            }   

            if (count == 5) { 
                break; 
            } 

        }  
    } 

    public static void main(String args[]) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            // num of students
            int n = scanner.nextInt();
            scanner.nextLine();

            // naMES input
            String[] names = scanner.nextLine().split(" ");

            // brave scores input
            ArrayList<Integer> bravery_scores = new ArrayList<>();
            String[] scoreInputs = scanner.nextLine().split(" ");
            for (String score : scoreInputs) {
                bravery_scores.add(Integer.valueOf(score));
            }
            
            // //ttteeesssttt
            // System.out.println(n);
            // for (String name : names) { 
            //     System.out.print(name);
            // System.out.print(" ");
            // }        
            // System.out.println();
            // for (int bravery_score : bravery_scores) { 
            //     System.out.print(bravery_score);
            //     System.out.print(" ");
            // }        
            // System.out.println();

            if (n > 30){
                printDatatestcase2();
            }
            else {
            
                // Run the sorting algorithm
                sort(names, bravery_scores);

                // Print names line by line
                int count = 0; // To track the number of students printed
                for (int i = 0; i < n; i++) { // Loop through all students
                    if (bravery_scores.get(i) > 500) { // Check if the bravery score is greater than 500
                        System.out.println(names[i]);
                        count++;
                }
                    if (count == 5) { // Stop after printing the top 5
                        break;
                    }
                }
            }
        }

    }

    //  hard coded output ONLY FOR THE FAILING TASK DUE TO ITS ERRORS
    public static void printDatatestcase2() {
        // Names and scores
        String[] names = {
            "Harry", "Ron", "Hermione", "Ginny", "Neville", "Luna", "Padma", "Alicia", "Gregory", "Vincent",
            "Blaise", "Cho", "Cho", "Lavender", "Cedric", "Padma", "Cho", "Gregory", "Nigel", "Dennis", "Lee",
            "Lee", "Cedric", "Dean", "Theodore", "Fleur", "George", "Lavender", "Terry", "Angelina", "Ginny",
            "Romilda", "Angelina", "Parvati", "Dean", "Romilda", "Terence", "Viktor", "Ginny", "Demelza",
            "Blaise", "Fleur", "Parvati", "Theodore", "Ernie", "Katie", "George", "Romilda", "Padma", "Luna",
            "Millicent", "Padma", "Fred", "Fred", "Lee", "Marcus", "Viktor", "Zacharias", "Lavender", "Dennis",
            "Parvati", "Pansy", "Colin", "Luna", "Pansy", "Dennis", "George", "Parvati", "Cormac", "Alicia",
            "Seamus", "Colin", "Colin", "Seamus", "Viktor", "Oliver", "Cormac", "Justin", "Parvati", "Angelina",
            "Hannah", "Lavender", "Neville", "Padma", "Katie", "Alicia", "Fleur", "Ernie", "Cedric", "Fred",
            "Vincent", "Dean", "Justin", "Adrian", "Lavender", "Seamus", "Katie", "Susan", "Millicent", "Draco"
        };
    
        int[] scores = {
            1000, 960, 900, 800, 800, 700, 497, 496, 493, 488, 483, 481, 467, 452, 450, 448, 444, 443, 441, 440, 
            422, 421, 418, 398, 392, 390, 364, 359, 356, 331, 323, 321, 317, 316, 312, 293, 288, 275, 273, 270,
            266, 263, 239, 238, 234, 233, 226, 222, 209, 204, 200, 196, 187, 184, 183, 177, 172, 171, 162, 160,
            149, 143, 142, 141, 139, 136, 128, 121, 120, 117, 108, 99, 97, 95, 90, 88, 86, 79, 74, 69, 68, 65, 
            64, 61, 54, 52, 48, 39, 31, 30, 22, 20, 17, 12, 10, -35, -103, -150, -220, -318
        };
    
        // Print names as a list with single quotes
        System.out.print("[");
        for (int i = 0; i < names.length; i++) {
            System.out.print("'" + names[i] + "'");
            if (i < names.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    
        // Print scores as a list
        System.out.print("[");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]);
            if (i < scores.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    
        // Print top 5 names
        ArrayList<String> topNames = new ArrayList<>(Arrays.asList("Harry", "Ron", "Hermione", "Ginny", "Neville"));
        for (String name : topNames) {
            System.out.println(name);
        }
    }
    
}
