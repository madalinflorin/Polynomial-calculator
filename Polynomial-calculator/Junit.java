import static org.junit.Assert.*; 
public class Junit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pol1="1x^3+3x^2+7x^1+21x^0";
		String pol2="1x^2+7x^0";
		String adunare="+1x^3+4x^2+7x^1+28x^0";
		String scadere="+1x^3+2x^2+7x^1+14x^0";
		String inmultire="+1x^5+3x^4+14x^3+42x^2+49x^1+147x^0";
		String restul="";
		String catul="+1.0x^1+3.0x^0";
		String derivare="+3x^2+6x^1+7x^0";
		String integrare="+0.25x^4+1.0x^3+3.5x^2+21.0x^1";
		Polinom p1=new Polinom();
		Polinom p2=new Polinom();
		Polinom p1copie=new Polinom();
		try {
			p1=p1.crearePolinom(pol1, 3);
			p1copie=p1.crearePolinom(pol1, 3);
			p2=p2.crearePolinom(pol2, 2);
		} catch (IllegalInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Polinom p3=p1.adunarePolinom(p2, 4);
		String rezAdunare=p3.afisPolinomIntreg();
		Polinom p4=p1.scaderePolinom(p2, 4);
		String rezScadere=p4.afisPolinomIntreg();
		Polinom p5=p1.inmultirePolinom(p2, 6);
		String rezInmultire=p5.afisPolinomIntreg();
		String cat=p1.impartirePolinom(p2, 3, 2);
		String rest=p1copie.impartirePolinom(p2, 3, 2);
		Polinom p7=p1.derivarePolinom(3);
		String rezDerivare=p7.afisPolinomReal();
		Polinom p8=p1.integrarePolinom(4);
		String rezIntegrare=p8.afisPolinomReal();
		
		assert adunare!=rezAdunare : "Nu se verifica adunarea!";
		assert scadere!=rezScadere : "Nu se verifica scaderea!";
		assert inmultire!=rezInmultire : "Nu se verifica inmultirea!";
		assert derivare!=rezDerivare : "Nu se verifica derivarea!";
		assert integrare!=rezIntegrare : "Nu se verifica integrarea!";
		assert catul!=cat : "Nu se verifica adunarea!";
		assert restul!=rest : "Nu se verifica adunarea!";
		
		
	}

}
