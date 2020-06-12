import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
public class Test {
	
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

	public static void main(String[] args) throws IllegalInputException {
		// TODO Auto-generated method stub

JFrame frame = new JFrame("Calculator polinoame");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(640, 480);

JPanel panel = new JPanel();
panel.setLayout(new GridLayout(8, 2));

JButton buton1 = new JButton("Adunare");
panel.add(buton1);
JButton buton2 = new JButton("Scadere");
panel.add(buton2);
JButton buton3 = new JButton("Inmultire");
panel.add(buton3);
JButton buton4 = new JButton("Impartire");
panel.add(buton4);
JButton buton5 = new JButton("Derivare");
panel.add(buton5);
JButton buton6 = new JButton("Integrare");
panel.add(buton6);

JLabel primulPolinom = new JLabel("Polinom 1: ");
panel.add(primulPolinom);
JTextField pol1 = new JTextField("Introdu primul polinom");
panel.add(pol1);

JLabel alDoileaPolinom = new JLabel("Polinom 2: ");
panel.add(alDoileaPolinom);
JTextField pol2 = new JTextField("Introdu al doilea polinom");
panel.add(pol2);

JLabel rezultat = new JLabel("Rezultat: ");
panel.add(rezultat);
JTextField afis = new JTextField("Afisare rezultat operatie");
panel.add(afis);

JLabel impartire = new JLabel("Catul: ");
panel.add(impartire);
JTextField afis1 = new JTextField("Afisare rezultat operatie");
panel.add(afis1);

JLabel impartire1 = new JLabel("Restul: ");
panel.add(impartire1);

JTextField afis2 = new JTextField("Afisare rezultat operatie");
panel.add(afis2);

buton1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		int grad=0,grad1=0,gradMax,zero=0,zero1=0;
		String polinom=pol1.getText();
        String polinom1=pol2.getText();
        for(int i=0;i<polinom.length();i++) {
				int produs=1;
				if(polinom.charAt(i)=='x') {
					int j=i+2;
					while(polinom.charAt(j)>='0'&&polinom.charAt(j)<='9'&&j<polinom.length()) {
						if((int)polinom.charAt(j)-48==0) zero++;
					grad=grad+((int)polinom.charAt(j)-48)*produs;
					produs=produs*10;
					j++;
					if(j==polinom.length()) break;}
				break;
				}		
}
        grad=Test.invers(grad,zero);
        
        for(int i=0;i<polinom1.length();i++) {
    		int produs=1;
    		if(polinom1.charAt(i)=='x') {
    			int j=i+2;
    			while(polinom1.charAt(j)>='0'&&polinom1.charAt(j)<='9'&&j<polinom1.length()) {
    				if((int)polinom.charAt(j)-48==0) zero1++;
    			grad1=grad1+((int)polinom1.charAt(j)-48)*produs;
    			produs=produs*10;
    			j++;
    			if(j==polinom1.length()) break;}
    		break;
    		}		
    }
    grad1=Test.invers(grad1,zero1);	
		
		if(grad>grad1) gradMax=grad;
		else gradMax=grad1;
		Polinom p=new Polinom();
		Polinom p1=new Polinom();
		try {
			p=p.crearePolinom(polinom, grad);
			p1=p1.crearePolinom(polinom1, grad1);
			p=p.adunarePolinom(p1, gradMax+1);
			String a=p.afisPolinomIntreg();
			afis.setText(a);	
					} catch (IllegalInputException e1) {

			afis.setText("Ai introdus polinomul gresit!");
		}	
	}	
});

buton2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		int grad=0,grad1=0,gradMax,zero=0,zero1=0;
		String polinom=pol1.getText();
        String polinom1=pol2.getText();
        for(int i=0;i<polinom.length();i++) {
			int produs=1;
			if(polinom.charAt(i)=='x') {
				int j=i+2;
				while(polinom.charAt(j)>='0'&&polinom.charAt(j)<='9'&&j<polinom.length()) {
					if((int)polinom.charAt(j)-48==0) zero++;
				grad=grad+((int)polinom.charAt(j)-48)*produs;
				produs=produs*10;
				j++;
				if(j==polinom.length()) break;}
			break;
			}		
}
   grad=Test.invers(grad,zero);
  
   for(int i=0;i<polinom1.length();i++) {
		int produs=1;
		if(polinom1.charAt(i)=='x') {
			int j=i+2;
			while(polinom1.charAt(j)>='0'&&polinom1.charAt(j)<='9'&&j<polinom1.length()) {
				if((int)polinom.charAt(j)-48==0) zero1++;
			grad1=grad1+((int)polinom1.charAt(j)-48)*produs;
			produs=produs*10;
			j++;
			if(j==polinom1.length()) break;}
		break;
		}		
}
grad1=Test.invers(grad1,zero1);	

		if(grad>grad1) gradMax=grad;
		else gradMax=grad1;
		Polinom p=new Polinom();
		Polinom p1=new Polinom();
		try {
			p=p.crearePolinom(polinom, grad);
			p1=p1.crearePolinom(polinom1, grad1);
			p=p.scaderePolinom(p1, gradMax+1);
			String a=p.afisPolinomIntreg();
			afis.setText(a);
		} catch (IllegalInputException e1) {
			
			afis.setText("Ai introdus polinomul gresit!");
		}
			
	}
});

buton3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		int grad=0,grad1=0,zero=0,zero1=0;
		String polinom=pol1.getText();
        String polinom1=pol2.getText();
        for(int i=0;i<polinom.length();i++) {
			int produs=1;
			if(polinom.charAt(i)=='x') {
				int j=i+2;
				while(polinom.charAt(j)>='0'&&polinom.charAt(j)<='9'&&j<polinom.length()) {
					if((int)polinom.charAt(j)-48==0) zero++;
				grad=grad+((int)polinom.charAt(j)-48)*produs;
				produs=produs*10;
				j++;
				if(j==polinom.length()) break;}
			break;
			}		
}
   grad=Test.invers(grad,zero);
		for(int i=0;i<polinom1.length();i++) {
			int produs=1;
			if(polinom1.charAt(i)=='x') {
				int j=i+2;
				while(polinom1.charAt(j)>='0'&&polinom1.charAt(j)<='9'&&j<polinom1.length()) {
				if((int)polinom1.charAt(j)-48==0) zero1++;
				grad1=grad1+((int)polinom1.charAt(j)-48)*produs;
				produs=produs*10;
				j++;
				if(j==polinom1.length()) break;}
			break;
			}		
}
  grad1=Test.invers(grad1,zero1);	
		
		Polinom p=new Polinom();
		Polinom p1=new Polinom();
		try {
			p=p.crearePolinom(polinom, grad);
			p1=p1.crearePolinom(polinom1, grad1);
			p=p.inmultirePolinom(p1, grad+grad1+1);
			String a=p.afisPolinomIntreg();
			afis.setText(a);
		} catch (IllegalInputException e1) {
			
			afis.setText("Ai introdus polinomul gresit!");
		}	
	}	
});

buton4.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		int grad=0,grad1=0,zero=0,zero1=0;
		String polinom=pol1.getText();
		String polinom2=pol1.getText();
        String polinom1=pol2.getText();
        for(int i=0;i<polinom.length();i++) {
				int produs=1;
				if(polinom.charAt(i)=='x') {
					int j=i+2;
					while(polinom.charAt(j)>='0'&&polinom.charAt(j)<='9'&&j<polinom.length()) {
						if((int)polinom.charAt(j)-48==0) zero++;
					grad=grad+((int)polinom.charAt(j)-48)*produs;
					produs=produs*10;
					j++;
					if(j==polinom.length()) break;}
				break;
				}		
}
      grad=Test.invers(grad,zero);
       
       for(int i=0;i<polinom1.length();i++) {
				int produs=1;
				if(polinom1.charAt(i)=='x') {
					int j=i+2;
					while(polinom1.charAt(j)>='0'&&polinom1.charAt(j)<='9'&&j<polinom1.length()) {
						if((int)polinom.charAt(j)-48==0) zero1++;
					grad1=grad1+((int)polinom1.charAt(j)-48)*produs;
					produs=produs*10;
					j++;
					if(j==polinom1.length()) break;}
				break;
				}		
}
      grad1=Test.invers(grad1,zero1);	
		

		Polinom p=new Polinom();
		Polinom p1=new Polinom();
		Polinom p2=new Polinom();
		try {
			p=p.crearePolinom(polinom, grad);
			p2=p2.crearePolinom(polinom2, grad);
			p1=p1.crearePolinom(polinom1, grad1);
		
if(grad<grad1)	{ afis.setText("Nu se pot impartii!");}
                          
else {
			String a=p.impartirePolinom(p1, grad, grad1);	
			String b=p2.impartirePolinom1(p1, grad, grad1);
			afis1.setText(a);
			afis2.setText(b);}
			
		} catch (IllegalInputException e1) {
			
			afis.setText("Ai introdus polinomul gresit!");
		}
		
	
	}	
});

buton5.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		int grad=0,zero=0;
		String polinom=pol1.getText();
		for(int i=0;i<polinom.length();i++) {
				int produs=1;
				if(polinom.charAt(i)=='x') {
					int j=i+2;
					while(polinom.charAt(j)>='0'&&polinom.charAt(j)<='9'&&j<polinom.length()) {
						if((int)polinom.charAt(j)-48==0) zero++;
					grad=grad+((int)polinom.charAt(j)-48)*produs;
					produs=produs*10;
					j++;
					if(j==polinom.length()) break;}
				break;
				}		
}
       grad=Test.invers(grad,zero);

		Polinom p=new Polinom();
		try {
			p=p.crearePolinom(polinom, grad);
			p=p.derivarePolinom(grad);
			String a=p.afisPolinomIntreg();
			afis.setText(a);
		} catch (IllegalInputException e1) {
			
			afis.setText("Ai introdus polinomul gresit!");
		}

	}
	
});

buton6.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		int grad=0,zero=0;
		String polinom=pol1.getText();
		for(int i=0;i<polinom.length();i++) {
				int produs=1;
				if(polinom.charAt(i)=='x') {
					int j=i+2;
					while(polinom.charAt(j)>='0'&&polinom.charAt(j)<='9'&&j<polinom.length()) {
						if((int)polinom.charAt(j)-48==0) zero++;
					grad=grad+((int)polinom.charAt(j)-48)*produs;
					produs=produs*10;
					j++;
					if(j==polinom.length()) break;}
				break;
				}		
}
       grad=Test.invers(grad,zero);

		Polinom p=new Polinom();
		try {
			p=p.crearePolinom(polinom, grad);
			p=p.integrarePolinom(grad+1);
			String a=p.afisPolinomReal();
			afis.setText(a);
		} catch (IllegalInputException e1) {
			
			afis.setText("Ai introdus polinomul gresit!");
		}	
	}
	
});

frame.setContentPane(panel);
frame.setVisible(true);

}
}
