import java.util.*;
import java.text.DecimalFormat;
public class Polinom  {
	private int gradMaxim;
	private List<Monom> l1 = new ArrayList<Monom>(gradMaxim);
		
	public Polinom() {
	}
	public Polinom(int g)  {
		this.gradMaxim=g;
		l1=new ArrayList<Monom>(gradMaxim);
		for(int i=0;i<gradMaxim;i++){
	Monom m=new Monom(0,i);
	m.coef1=0;
	l1.add(m);	
	}
	}
	
	public void adaugaMonom(Monom m) {
		this.l1.set(m.putere,m);
	}
	
	public String afisPolinomIntreg() {
		String a="";
		ListIterator<Monom> itr = l1.listIterator(); 
		while(itr.hasNext()) {
			itr.next();	
			}
		while(itr.hasPrevious()) {
			Monom m=(Monom) itr.previous();
			Number c=m.coef;
			int p=m.putere;
			if(m.coef!=0&&m.coef<0) a=a+c+"x^"+p;
					else if(m.coef!=0) a=a+"+"+c+"x^"+p;
		}
		return a;
	}
	
	public String afisPolinomReal() {
		String a="";
		ListIterator<Monom> itr = l1.listIterator(); 
		while(itr.hasNext()) {
			itr.next();	
			}
		while(itr.hasPrevious()) {
			Monom m=(Monom) itr.previous();
			Number c=m.coef1;
			int p=m.putere;
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			if(m.coef1!=0.0&&m.coef1<0)
			a=a+df.format(c)+"x^"+p;
			
			else if(m.coef1!=0.0)
				a=a+"+"+df.format(c)+"x^"+p;
		}
		return a;
	}
	
	public static int invers(int nr,int zero) {
		int inv=0;
		while(nr>0) {
			inv=inv*10+nr%10;
			nr=nr/10;
		}
		while(zero>0) {
			inv=inv*10;
			zero--;
		}
		return inv;
	}
	
    public Polinom crearePolinom(String polinom,int grad) throws IllegalInputException {
		Polinom pp=new Polinom(grad+1);
		if(polinom.length()<4) throw new IllegalInputException();
		else {
		for(int i=0;i<polinom.length();i++) {
			if(polinom.charAt(i)!='-'&&polinom.charAt(i)!='+'&&polinom.charAt(i)!='x'&&polinom.charAt(i)!='^'&&(polinom.charAt(i)<'0'||polinom.charAt(i)>'9'))
			{
				throw new IllegalInputException();
			}
			
		   if((polinom.charAt(i)=='^'&&polinom.charAt(i+1)=='^')||(polinom.charAt(i)=='^'&&polinom.charAt(i+1)=='x')||(polinom.charAt(i)=='x'&&polinom.charAt(i+1)=='+')||(polinom.charAt(i)=='+'&&polinom.charAt(i+1)=='x')||(polinom.charAt(i)=='x'&&polinom.charAt(i+1)=='-'))
		   {
			   throw new IllegalInputException();
		   }
		   
		  
		   if((polinom.charAt(i)=='x'&&polinom.charAt(i+1)=='x')||(polinom.charAt(i)=='-'&&polinom.charAt(i+1)=='x')||(polinom.charAt(i)=='+'&&polinom.charAt(i+1)=='^')||(polinom.charAt(i)=='^'&&polinom.charAt(i+1)=='+')||(polinom.charAt(i)=='-'&&polinom.charAt(i+1)=='^'))
		   {
			   throw new IllegalInputException();
		   }
		   
		   if((polinom.charAt(i)=='^'&&polinom.charAt(i+1)=='-')||(polinom.charAt(i)=='+'&&(polinom.charAt(i+1)>='0'&&polinom.charAt(i+1)<='9'&&i+1==polinom.length()-1))||(polinom.charAt(i)=='-'&&(polinom.charAt(i+1)>='0'&&polinom.charAt(i+1)<='9'&&i+1==polinom.length()-1)))
		   {
			   throw new IllegalInputException();
		   }	   

		}
		}
		int c1,j,nr=0,sumac1=0; Monom m;
		if(polinom.charAt(0)!='-') {
			j=0;
			nr=0;
			while(polinom.charAt(j)>='0'&&polinom.charAt(j)<='9') {
				c1=((int) polinom.charAt(j)-48);
				sumac1=sumac1*10+c1;
				j++; nr++;}		
		 c1=sumac1;	 
		}
		else {j=1; nr=0;
		while(polinom.charAt(j)>='0'&&polinom.charAt(j)<='9') {
			
			c1=((int) polinom.charAt(j)-48);
		sumac1=sumac1*10+c1;
			j++; nr++;}
		c1=-sumac1;
		}

		m=new MonomIntreg(c1,grad);
		m.coef1=c1;
		pp.adaugaMonom(m);

		for(int i=nr+3;i<polinom.length();i++) {
			if(polinom.charAt(i)=='x') {
				int a=0,b=0,p=1; j=i-1;
				while(polinom.charAt(j)>='0'&&polinom.charAt(j)<='9') {
				a=a+((int)polinom.charAt(j)-48)*p;
				p=p*10; j--;
				}
				if(polinom.charAt(j)=='-') a=-a;	
				int produs=1,gradaux=0,zero=0;j=i+2;
				while(polinom.charAt(j)>='0'&&polinom.charAt(j)<='9'&&j<polinom.length()) {
					if((int)polinom.charAt(j)-48==0) zero++;
				gradaux=gradaux+((int)polinom.charAt(j)-48)*produs;
				produs=produs*10;j++;
				if(j==polinom.length()) break;}
				b=Polinom.invers(gradaux,zero);
				if(gradaux>grad) throw new IllegalInputException();
				 m=new MonomIntreg(a,b);
				 m.coef1=a;
			pp.adaugaMonom(m);
			}
		}
		return pp;
		
	}
    
	public Polinom adunarePolinom(Polinom a,int grad) {
		Polinom result=new Polinom(grad);
		Iterator<Monom> itr = this.l1.iterator(); 
		Iterator<Monom> itr1 = a.l1.iterator();
		while(itr.hasNext()&&itr1.hasNext()) {
			Monom m=(Monom) itr.next();
			Monom m1=(Monom) itr1.next();
			m.coef=m.coef+m1.coef;
			m.coef1=m.coef1+m1.coef1;
			result.l1.set(m.putere, m);		
		}
		while(itr.hasNext()) {
			Monom m=(Monom) itr.next();
			result.l1.set(m.putere, m);
		}
		while(itr1.hasNext()) {
			Monom m=(Monom) itr1.next();
			result.l1.set(m.putere, m);
		}
		return result;

}
	
	public Polinom scaderePolinom(Polinom a,int gradMax) {
		Polinom result=new Polinom(gradMax);
		Iterator<Monom> itr = this.l1.iterator(); 
		Iterator<Monom> itr1 = a.l1.iterator();
		while(itr.hasNext()&&itr1.hasNext()) {
			Monom m=(Monom) itr.next();
			Monom m1=(Monom) itr1.next();
			m.coef=m.coef-m1.coef;
			m.coef1=m.coef1-m1.coef1;
			result.l1.set(m.putere, m);		
		}
		while(itr.hasNext()) {
			Monom m=(Monom) itr.next();
			result.l1.set(m.putere, m);
		}
		while(itr1.hasNext()) {
			Monom m=(Monom) itr1.next();
			result.l1.set(m.putere, m);
		}
		return result;	
}
	
	public double coefMaxim(int putere) {
		double coeficient=0;
		Iterator<Monom> itr = this.l1.iterator(); 
		while(itr.hasNext()) {
			Monom m=(Monom) itr.next();
			if(m.putere==this.gradMaxim-1) coeficient=m.coef1;
	}
		return coeficient;
}
	
	public Polinom inmultirePolinom(Polinom a,int gradMaxProdus) {
		Polinom result=new Polinom(gradMaxProdus);
		Iterator<Monom> itr = this.l1.iterator(); 
		while(itr.hasNext()) {
			Iterator<Monom> itr1 = a.l1.iterator();
			Monom m=(Monom) itr.next();
			while(itr1.hasNext()) {
				Polinom result1= new Polinom(gradMaxProdus);
			Monom aux=new Monom(0,0);
			Monom m1=(Monom) itr1.next();
			aux.coef=m.coef * m1.coef;
			aux.coef1=m.coef1 * m1.coef1;
			aux.putere=m.putere + m1.putere;
            if(aux.coef1!=0)
			{result1.adaugaMonom(aux);
			result=result.adunarePolinom(result1, gradMaxProdus);}		
		}
			}		
		return result;		
}
	public Polinom derivarePolinom(int gradPolinom) {
		Polinom result=new Polinom(gradPolinom);
		Iterator<Monom> itr = this.l1.iterator(); 
		while(itr.hasNext()) {
	        Polinom result1=new Polinom(gradPolinom);
			Monom m=(Monom) itr.next();
			Monom aux=new Monom(0,0);
			if(m.putere==0) {aux.coef=0;aux.coef1=0;}
			else {
			aux.coef=m.coef*m.putere;
			aux.coef1=m.coef1*m.putere;
			aux.putere=m.putere-1;}
			result1.adaugaMonom(aux);	
			result=result.adunarePolinom(result1,gradPolinom);
	}
	return result;
}
	public Polinom integrarePolinom(int gradPolinom) {
		Polinom result=new Polinom(gradPolinom+1);
		Iterator<Monom> itr= this.l1.iterator();
		while(itr.hasNext()) {
			Monom m=(Monom) itr.next();
			Monom aux=new Monom(0.0,0);
			aux.coef1=m.coef1/(m.putere+1);
			aux.putere=m.putere+1;
			result.adaugaMonom(aux);
		}
		return result;
	}
	
	public String impartirePolinom(Polinom a,int gradPolinom1,int gradPolinom2) {
		Polinom cat=new Polinom(gradPolinom1-gradPolinom2+1);
		Polinom result=new Polinom(gradPolinom1);
		Polinom rest=new Polinom(gradPolinom1+1);
			
			while(this.gradMaxim>=a.gradMaxim) {
				Polinom result1=new Polinom(gradPolinom1-gradPolinom2+1);	
				Monom m=new Monom(0.0,0);				
				m.putere=this.gradMaxim-a.gradMaxim;
				m.coef1=(this.coefMaxim(this.gradMaxim)*1.0)/a.coefMaxim(a.gradMaxim);
				cat.adaugaMonom(m);
				cat.afisPolinomReal();
				Monom mm=new Monom(0.0,0);
				mm.putere=this.gradMaxim-a.gradMaxim;
				mm.coef1=(this.coefMaxim(this.gradMaxim)*1.0)/a.coefMaxim(a.gradMaxim);
				mm.coef1=-mm.coef1;
				result1.adaugaMonom(mm);
				result1.afisPolinomReal();
			    result=result1.inmultirePolinom(a, gradPolinom2+gradPolinom1);
			    result.afisPolinomReal();
				rest=this.adunarePolinom(result,gradPolinom1+2);
				rest.afisPolinomReal();
				this.gradMaxim--;
			}	
		String aa=cat.afisPolinomReal();
		return aa;
}
	
	public String impartirePolinom1(Polinom a,int gradPolinom1,int gradPolinom2) {
		Polinom cat=new Polinom(gradPolinom1-gradPolinom2+1);
		Polinom result=new Polinom(gradPolinom1);
		Polinom rest=new Polinom(gradPolinom1+1);

			while(this.gradMaxim>=a.gradMaxim) {
				Polinom result1=new Polinom(gradPolinom1-gradPolinom2+1);	
				Monom m=new Monom(0.0,0);				
				m.putere=this.gradMaxim-a.gradMaxim;
				m.coef1=(this.coefMaxim(this.gradMaxim)*1.0)/a.coefMaxim(a.gradMaxim);
				cat.adaugaMonom(m);
				cat.afisPolinomReal();
				Monom mm=new Monom(0.0,0);
				mm.putere=this.gradMaxim-a.gradMaxim;
				mm.coef1=(this.coefMaxim(this.gradMaxim)*1.0)/a.coefMaxim(a.gradMaxim);
				mm.coef1=-mm.coef1;
				result1.adaugaMonom(mm);
				result1.afisPolinomReal();
			    result=result1.inmultirePolinom(a, gradPolinom2+gradPolinom1);
			    result.afisPolinomReal();
				rest=this.adunarePolinom(result,gradPolinom1+2);
				rest.afisPolinomReal();
				this.gradMaxim--;
			}		
		String aa=rest.afisPolinomReal();
		return aa;
	}		
}