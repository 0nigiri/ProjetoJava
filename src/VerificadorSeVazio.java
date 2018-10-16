
public class VerificadorSeVazio {
		static final String[] num = {"0","1","2","3","4","5","6","7","8","9","(",")",".","/"};
		public static boolean VerificadorSeVasio(String verifica, int minimo) {
			String aux;
			for (int i = 0; i < verifica.length(); i++) {
				aux = Character.toString(verifica.charAt(i));
				//System.out.println(aux);
				for (int j = 0; j < num.length; j++) {
					//System.out.println(num[j]);
					if(!aux.equals(num[j]))minimo--;
					//System.out.print(minimo + "\t");
					if(minimo ==0) {
						return false;
					}
				}
			}
			
				
			
			return true;
		}
}
