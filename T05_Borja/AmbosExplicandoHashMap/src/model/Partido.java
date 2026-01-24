package model;

public class Partido {
    private Equipo eLocal;
    private Equipo eVisitante;
    private int gLocal;
    private int gVisitante;
    private boolean jugado;

    public Partido(){}

    public Partido(Equipo eLocal, Equipo eVisitante, int gLocal, int gVisitante){
        if (eLocal.getNombre().equals(eVisitante.getNombre())){
            System.out.println("Tongo, partido no valido");
        } else {
            this.eLocal = eLocal;
            this.eVisitante = eVisitante;
            this.gLocal = gLocal;
            this.gVisitante = gVisitante;
            jugado = true;
            eLocal.setgFavor(eLocal.getgFavor()+gLocal);
            eLocal.setgContra(eLocal.getgContra()+gVisitante);
            eVisitante.setgFavor(eVisitante.getgFavor()+gVisitante);
            eVisitante.setgContra(eVisitante.getgContra()+gLocal);
        }

    }

    public void mostrarDatos(){
        System.out.printf("%s:%d - %d:%s",eLocal.getNombre(), gLocal, gVisitante, eVisitante.getNombre());
        System.out.printf("\n");
    }

    public Equipo geteLocal() {
        return eLocal;
    }

    public void seteLocal(Equipo eLocal) {
        this.eLocal = eLocal;
    }

    public Equipo geteVisitante() {
        return eVisitante;
    }

    public void seteVisitante(Equipo eVisitante) {
        this.eVisitante = eVisitante;
    }

    public int getgLocal() {
        return gLocal;
    }

    public void setgLocal(int gLocal) {
        this.gLocal = gLocal;
    }

    public int getgVisitante() {
        return gVisitante;
    }

    public void setgVisitante(int gVisitante) {
        this.gVisitante = gVisitante;
    }
}
