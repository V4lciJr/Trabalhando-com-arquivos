import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Enter file path: ");
		String path = tec.nextLine();
		
		File file = new File(path);
		List<Product> productList = new ArrayList<>();
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			String line = br.readLine();
			
			boolean sucess = new File(file.getParent() + "\\out").mkdir();
			System.out.println("Arquivo criado com sucesso: " +sucess);
			
			
			
			while(line != null)
			{
				String [] s = line.split(",");
				String name = s[0];
				Double price = Double.parseDouble(s[1]);
				int quantity = Integer.parseInt(s[2]);
								 		
				productList.add(new Product(name, price, quantity));
				
				try(BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\temp\\out\\sumary.csv")))
				{
					for(Product prod : productList)
					{
						bw.write(prod.getName());
						bw.write(",");
						bw.write(String.format("%.2f", prod.total()));
						
						bw.newLine();
					}
				}
										
					line = br.readLine();
			}
			

			
			
			try(BufferedReader br2 = new BufferedReader(new FileReader("c:\\temp\\out\\sumary.csv")))
			{
				String result = br2.readLine();
				
				while(result != null)
				{
					System.out.println(result);
					 result = br2.readLine();
				}
			}
		
		}
		catch(IOException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		
	
	}
	

}
