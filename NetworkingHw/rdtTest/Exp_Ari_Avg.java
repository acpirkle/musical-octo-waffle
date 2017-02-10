package rdtTest;

import java.io.File;  
import java.io.PrintWriter;
import java.io.FileNotFoundException;  
import java.util.Scanner;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;    
import java.io.IOException;  
import java.util.Random;

// this program compares the estimated Round Trip Time of the two methods, exponential averaging, and arithmetic averaging
public class Exp_Ari_Avg{ 
	 public static double expAvg(double preExpAvg, int newSample){
	 	// To be completed...
		 // (1 - a)*EstimatedRTT + a*SampleRTT
		 double a = .125;
		 preExpAvg = (1 - a)*preExpAvg + (a*newSample);
	 	return preExpAvg;
	 }
	 
	 public static double ariAvg(double preAriAvg, int newSample, int n, double all){
		// To be completed...
		 // (SampleRTT1 + SampleRTT2 +...+ SampleRTTn)/n
		 preAriAvg =  all/n;
	 	return preAriAvg;
	 }
	 
	 public static void sampleRTT2EstimatedRTT(Scanner in, PrintWriter out)throws IOException{ 
	 	// To be completed...
	//	Generate initial random number between 0 - 100
		 Random rn = new Random();
			double EstRTT1 = rn.nextInt(101);
			double EstRTT2 = rn.nextInt(101);
			int n = 1;
			double all = 0.0;
	// get time from text file		
			while(in.hasNextLine()){
				String pattern = in.nextLine();
				Pattern p = Pattern.compile("time=(.*?)ms");
				Matcher m = p.matcher(pattern);
				while(m.find()){
					int time = Integer.parseInt(m.group(1));
					EstRTT1 = expAvg(EstRTT1, time);
					all += time;
					EstRTT2 = ariAvg(EstRTT2, time, n, all);
					n++;
					System.out.printf(time +"\t"+ EstRTT1 + "\t" + EstRTT2 + "\n");
					out.printf("%d \t\t %.3f \t %.3f", time,EstRTT1,EstRTT2);
					out.println();
				}
			}
	 }
	 public static void main (String[] args){ 
	 	try{
			Scanner fileScanner = new Scanner(new File("data.txt"));
			PrintWriter filePrinter = new PrintWriter(new File("output.txt"));
//			while(fileScanner.hasNextLine()){
//				System.out.println(fileScanner.nextLine());
//			}
			filePrinter.print("SampleRTTs\tExpAvgs\t\tAriAvgs");
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
