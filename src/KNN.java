import java.util.ArrayList;
import java.util.Vector;


public class KNN {

	float x1 = 1;
	float x2 = 1;
	float x3 = 1;
	float tn = 0;
	float yn;
	final float LERNKONSTANTE = 0.3f;
	ArrayList<Float> gewichte = new ArrayList<Float>();
	ArrayList<Float> vektorWerte = new ArrayList<>();

	
	public KNN() {
		
		ArrayList<Float> vektorWerte = new ArrayList<>();
		vektorWerte.add(x1);
		vektorWerte.add(x2);
		vektorWerte.add(x3);
		
		gewichte.add(0f);
		gewichte.add(0.1f);
		gewichte.add(-2f);
		
		Vector anfangsVektor = new Vector(vektorWerte);
		System.out.println(gewichte);
		for(int i = 0;  i < 100; i++) {
			for(int j = 0; j < gewichte.size(); j++) {
//				System.out.println("Größe: " + gewichte.size() + " j: " + j);
//				System.out.println(anfangsVektor);
				float neth = vektorWerte.get(0)*gewichte.get(0)  + vektorWerte.get(1)*gewichte.get(1)+ vektorWerte.get(2)*gewichte.get(2);
				System.out.println(neth);
				float fact = (float) (1/(1+Math.pow(Math.E, -neth)));
				float factAbl = fact *(1- fact);
				yn = fact;
				float deltah  = factAbl * (tn -yn);
				float gewicht = gewichte.get(j);
				gewichte.remove(j);
				gewicht = gewicht + LERNKONSTANTE * fact * deltah;
//				System.out.println((1/2) * fact * deltah);
				gewichte.add(j, gewicht);
//				System.out.println(gewicht);
			}
		}
		
	}
	
	public void berechneOutput() {
		
	}
	
}
