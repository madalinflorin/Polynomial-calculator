
public class Monom {
	protected int coef;
	protected double coef1;
	protected int putere;
	
public Monom(int a,int b) {
	coef=a;
	putere=b;
}

public Monom(double a,int b)
{
	coef1=a;
	putere=b;
}

public Number getCoef() {
	return this.coef;
}
public int getPutere() {
	return this.putere;
}

public void setCoef1(int a) {
	this.coef=a;
}

public void setCoef(double a) {
	this.coef1=a;
}

public void setPutere(int a) {
	this.putere=a;
}
}
