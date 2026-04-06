package aed;

public class CTD {
	private int[] gastosPersona1;
	private int[] gastosPersona2;

    public CTD() {
        gastosPersona1 = new int[0];
        gastosPersona2 = new int[0];
    }

	public CTD(CTD otro) {
		// Copia el CTD, copiando en cascada
		gastosPersona1 = otro.gastosPersona1.clone();
		gastosPersona2 = otro.gastosPersona2.clone();
	}

	public void anotarGasto(int persona, int gasto) { 
		if (persona == 0) {
			gastosPersona1 = agregarGasto(gastosPersona1, gasto);
		} else {
			gastosPersona2 = agregarGasto(gastosPersona2, gasto);
		}
	}

	private int[] agregarGasto(int[] gasto_persona, int gasto) {
		int[] gasto_persona_nuevo = new int[gasto_persona.length + 1];
		for (int i = 0; i < gasto_persona.length; i++) {
			gasto_persona_nuevo[i] = gasto_persona[i];
		}
		gasto_persona_nuevo[gasto_persona_nuevo.length - 1] = gasto;
		return gasto_persona_nuevo;
	}

	public int gastos(int persona) {
		int total = 0;
		if (persona == 0) {
			for (int gasto : gastosPersona1) {
				total += gasto;
			}
		} else {
			for (int gasto : gastosPersona2) {
				total += gasto;
			}
		}
		return total;
	}
	
	public int quienDebe() {
		int gasto_persona1 = gastos(0);
		int gasto_persona2 = gastos(1);
		if (gasto_persona1 > gasto_persona2) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object otro) {
		// Algunos chequeos burocraticos...
		boolean otroEsNull = (otro == null);
		
		if(otroEsNull){
			return false;
		}

		boolean claseDistinta = otro.getClass() != this.getClass();

		if (claseDistinta) {
			return false;
		}

		//  casting -> cambiar el tipo
		CTD otroCTD = (CTD) otro;


		// comparar item a ítem
		return arraysIguales(gastosPersona1, otroCTD.gastosPersona1) 
			&& arraysIguales(gastosPersona2, otroCTD.gastosPersona2);
	}

	private boolean arraysIguales(int[] array1, int[] array2) {
		// comparar length 
		if (array1.length != array2.length) {
			return false;
		}
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) return false;
		}
		return true;
	}

}