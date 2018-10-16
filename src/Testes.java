import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
class testes{
	
 	public static void main(String[] args){
 		
 		
 		String data = JOptionPane.showInputDialog("digite a data");
 		
 		
 		
 		if( VerificadorSeVazio.VerificadorSeVasio(data, 3)== true) {
 			System.out.println("possui numero");
 		
 		} else {
 			System.out.println("sem numero");
 		}
 		
 		
 				
 				
 				
 	}
}