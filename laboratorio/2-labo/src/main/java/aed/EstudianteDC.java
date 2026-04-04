
public class EstudianteDC {

    private String[] materiasPlan93 = new String[]{/*...*/};
    private String[] materiasPlan23 = new String[]{/*...*/};
    private String[] materiasDatos = new String[]{/*...*/};

    private String[][] planesDeEstudio = {
        materiasPlan93,
        materiasPlan23,
        materiasDatos
    }; 

    private int _planDeEstudios;
    private LU _libreta_universitaria;
    private String[] _materiasAprobadas;
    private float[] _notasPorMaterias;
    
    private class LU {
        public int _añoDeIngreso;
        public int _numeroDeIngresante;

        LU(int num, int año){
            _añoDeIngreso = año;
            _numeroDeIngresante = num;
        }

        String lu_str(){
            String ingresante = String.valueOf(_numeroDeIngresante);
            String año = String.valueOf(_añoDeIngreso % 100);

            return ingresante + "/" + año;
        }
    }

    EstudianteDC(int añoDeIngreso, int numeroDeIngresante, int planDeEstudios) {
        _planDeEstudios = planDeEstudios;
        _libreta_universitaria = new LU(numeroDeIngresante, añoDeIngreso);
        _materiasAprobadas = new String[0];
        _notasPorMaterias = new float[0];    
    }

    public boolean agregarMateria(String nombre, float nota){
        boolean res = false;
        String[] planDeEstudio = new String[0];
        if(0 <_planDeEstudios && _planDeEstudios < planesDeEstudio.length){
            planDeEstudio = planesDeEstudio[_planDeEstudios];
        }
        if( laMateriaEsta(nombre, planDeEstudio) 
            && !laMateriaEsta(nombre, _materiasAprobadas))
        {
            String[] nueva_lista_materiasAprobadas = new String[_materiasAprobadas.length + 1];
            float[] nueva_lista_notasPorMaterias = new float[_notasPorMaterias.length + 1];
            for (int i = 0; i < _materiasAprobadas.length; i++){
                nueva_lista_materiasAprobadas[i] = _materiasAprobadas[i];
                nueva_lista_notasPorMaterias[i] = _notasPorMaterias[i];
            }
            nueva_lista_materiasAprobadas[_materiasAprobadas.length] = nombre;
            nueva_lista_notasPorMaterias[_notasPorMaterias.length] = nota;

            res = true;
        }
        return res;
    }


    public int añoDeIngreso(){
        return _libreta_universitaria._añoDeIngreso;
    }

    public float promedio(){
        float total = 0;
        for(float nota : _notasPorMaterias){
            total += nota;
        }
        return total/_notasPorMaterias.length;
    }

    public String lu(){
        return _libreta_universitaria.lu_str();
    }


    @Override
    public boolean equals(Object otro) {
        // Algunos chequeos burocraticos...
        String otraLibreta = "";
        
        boolean otroNoEsNull = (otro != null);
        boolean esObjetoDeLamismaClase = otroNoEsNull && otro.getClass() == this.getClass();

        if (esObjetoDeLamismaClase) {
            //  casting -> cambiar el tipo
            otraLibreta = ((EstudianteDC) otro).lu();
        }

        // comparar item a ítem
        return esObjetoDeLamismaClase && lu().equals(otraLibreta);
    }

    private boolean laMateriaEsta(String materia, String[] plan){
        boolean esta = false;
        for (String nombre : plan){
            esta |= materia.equals(nombre);
        }
        return esta;
    }

}
