package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {

        pillars = new Pillar[4];

    }

    public void precargarPilares(){
        Pillar biodiversidad = new Pillar("Biodiversidad");
        pillars[0] = biodiversidad;

        Pillar agua = new Pillar("Agua");
        pillars[1] = agua;

        Pillar basuras = new Pillar("Tratamiento de Basuras");
        pillars[2] = basuras;

        Pillar energia = new Pillar("Tratamiento de Energia");
        pillars[3] = energia;
    }

    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema
     * 
     * @return boolean true si se logra añadir el Prject en el Pillar, false en caso
     *         contrario
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description,boolean status) {
        Pillar pilar;

        Project newProject = new Project(id, name, description, status);

        switch(pillarType){
            case 1 -> {
                pilar = pillars[0];
                pilar.registerProject(newProject);
                return true;
            }

            case 2 -> {
                pilar = pillars[1];
                pilar.registerProject(newProject);
                return true;
            }

            case 3 -> {
                pilar = pillars[2];
                pilar.registerProject(newProject);
                return true;
            }

            case 4 -> {
                pilar = pillars[3];
                pilar.registerProject(newProject);
                return true;
            }
            
        }

        return false;
    }

    /**
     * Descripcion: Calcula el valor en dinero correspondiente al arrendamiento
     * mensual de todos los Edificios
     * pre: El arreglo edificios debe estar inicializado
     * 
     * @return String cadena en formato lista con la información de los
     * Project registrados en el Pillar
     */
    public String queryProjectsByPillar(int pillarType) {
        //  Al consultar un pilar, debe visualizarse el nombre del pilar y el listado de proyectos asociados
        String query = "";
        Pillar pilar;

        switch(pillarType){
            case 1 -> {
                pilar = pillars[0];
                query += pilar.toString();
            }

            case 2 -> {
                pilar = pillars[1];
                query += pilar.toString();
            }
            case 3 -> {
                pilar = pillars[2];
                query += pilar.toString();
            }

            case 4 -> {
                pilar = pillars[3];
                query += pilar.toString();
            }
            
        }

        return query;

    }

}