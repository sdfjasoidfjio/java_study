import java.util.*;

public class Q1_2024 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double weight, height, min_weight, max_weight;
        float bmi;
        String name;

        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Weight(kg): ");
        weight = sc.nextDouble();
        System.out.print("Height(cm): ");
        height = sc.nextDouble();

        bmi = (float)(weight / ((height/100) * (height/100)));
        System.out.println("The BMI value of " + name + " is " + String.format("%.2f", bmi));
        min_weight = 18.5 * ((height/100) * (height/100));
        max_weight = 23 * ((height/100) * (height/100));

        if(bmi < 18.5) System.out.println("You are Underweight");
        else if (bmi <= 23) System.out.println("You are Noraml");
        else System.out.println("You are over weight");

        if(bmi < 18.5 || 23 < bmi) 
            System.out.println("You need to maintain your weight between "+ String.format("%.2f", min_weight) + " and "+ String.format("%.2f", max_weight));
        sc.close();
    }
}
