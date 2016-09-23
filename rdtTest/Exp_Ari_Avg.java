import java.io.File;  
import java.io.PrintWriter;
import java.io.FileNotFoundException;  
import java.util.Scanner;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
import java.util.ArrayList;  
import java.io.IOException;  
import java.util.Random;

public class Exp_Ari_Avg{  	 
	 public static double expAvg(double preExpAvg, int newSample){
	 	// To be completed...
	 	return 0;
	 }
	 
	 public static double ariAvg(double preAriAvg, int newSample, int n){
		// To be completed...
	 	return 0;
	 }
	 
	 public static void sampleRTT2EstimatedRTT(Scanner in, PrintWriter out)throws IOException{ 
	 	// To be completed...
	 }
	 public static void main (String[] args){ 
	 	try{
			
			Scanner fileScanner = new Scanner(new File("data.txt")); 
			PrintWriter filePrinter = new PrintWriter(new File("output.txt"));
			
			filePrinter.print("SampleRTTs\tExpAvgs\tAriAvgs");
			filePrinter.println();
			
			sampleRTT2EstimatedRTT(fileScanner, filePrinter);
			
			fileScanner.close();
			filePrinter.close();
	
		}catch(IOException e){
			System.out.println("Error opening file.");
			System.exit(0);
		}
		
		
	 }
}  