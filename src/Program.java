import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		String path = "c:\\temp\\in.csv";
		Product p = new Product();
		File file = new File(path);
		
		try(BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			String line = br.readLine();
			
			boolean sucess = new File(file.getParent() + "\\out").mkdir();
			System.out.println("Arquivo criado com sucesso: " +sucess);
			String [] vect = line.split(",");
			p.setName(vect[0]);
			p.setPrice(Double.parseDouble(vect[1]));
			p.setQuantity(Integer.parseInt(vect[2]));
			
			while(line != null)
			{
				
				for(int i = 0; i < 20; i++)
				{
					p.setName(vect[i + 3]);
					p.setPrice(Double.parseDouble(vect[i + 4]));
					p.setQuantity(Integer.parseInt(vect[i + 5]));
					line = br.readLine();
				}
					try(BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\temp\\out\\sumary.csv", true)))
					{
						bw.write(p.getName());
						bw.write((int) p.total());
						bw.newLine();
					}
				
			}
			
			BufferedReader br2 = new BufferedReader(new FileReader("c:\\temp\\out\\sumary.csv"));
			String result = br2.readLine();
			
			while(result != null)
			{
				System.out.println(result);
				br2.readLine();
			}
			
			br2.close();
		}
		catch(IOException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	

}
