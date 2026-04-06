package aed;
class Main {
    public static void main(String[] args) {
		CTD ctd = new CTD();
		ctd.anotarGasto(0, 100);
		ctd.anotarGasto(0, 200);
		ctd.anotarGasto(1, 100);
		ctd.anotarGasto(1, 100);
		ctd.anotarGasto(1, 100);
		ctd.anotarGasto(1, 100);
		ctd.anotarGasto(1, 100);
		ctd.anotarGasto(1, 100);
		ctd.anotarGasto(1, 100);
		ctd.anotarGasto(1, 100);
		ctd.anotarGasto(1, 100);
		ctd.anotarGasto(1, 100);
		ctd.anotarGasto(1, 100);

		System.out.println("Gastos Persona 1: " + ctd.gastos(0));
		System.out.println("Gastos Persona 2: " + ctd.gastos(1));
		System.out.println("Quien se tiene que poner: " + ctd.quienDebe());

		CTD ctd2 = new CTD();
		ctd2.anotarGasto(0, 100);
		ctd2.anotarGasto(0, 200);
		ctd2.anotarGasto(1, 100);

		CTD ctd3 = new CTD();
		ctd3.anotarGasto(0, 100);
		ctd3.anotarGasto(0, 200);
		ctd3.anotarGasto(1, 100);

		CTD ctd4 = new CTD();
		ctd4.anotarGasto(0, 100);
		ctd4.anotarGasto(0, 200);
		ctd4.anotarGasto(1, 200);

		CTD ctd5 = new CTD(ctd);

		System.out.println("Iguales 1 y 2: " + ctd.equals(ctd2));
		System.out.println("Iguales 2 y 3: " + ctd2.equals(ctd3));
		System.out.println("Iguales 3 y 4: " + ctd3.equals(ctd4));
		System.out.println("Iguales 1 y 5: " + ctd5.equals(ctd));

		// Ya no iguales
		ctd5.anotarGasto(0,100);
		System.out.println("Iguales 1 y 5: " + ctd5.equals(ctd));
		
	}

}