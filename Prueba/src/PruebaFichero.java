import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PruebaFichero {
	Scanner s = null;
	boolean add = true;
	
	public PruebaFichero() {
		try {
			s = new Scanner(
					new BufferedReader(
							new FileReader("archivo.txt")));
		} catch (FileNotFoundException e) {
			add = false;
		}
	}
	public void rellenar() {
		
		try {
			PrintStream ps = new PrintStream(new FileOutputStream("archivo.txt", true));
			for (int i = 0; i < 4;  i++) {
				ps.println("hola<> mi pna");
			}
			
			ps.println("hola mi pna");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void rellenar2() {
		try {
			PrintStream ps = new PrintStream(new FileOutputStream("archivo.txt", true));
			ps.println("kl<>");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void leer() {
		s.useDelimiter("<>");
		while(s.hasNext()) {
			s.next();
			if(s.hasNext()) {
				System.out.println(s.next());
			}
			s.useDelimiter("hola");
			while(s.hasNext()) {
				System.out.print(s.next());
			}
		}
	}
	
	public static void main(String [] Args) {
		PruebaFichero prueba = new PruebaFichero();
		prueba.rellenar();
		prueba.rellenar2();
		prueba.leer();
	}
}

