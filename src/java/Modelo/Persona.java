
package Modelo;

public class Persona {
    int id;
    String nom;
    String dni;

    public Persona() {
    }

    public Persona(int id, String nom, String dni) {
        this.id = id;
        this.nom = nom;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
     
}
