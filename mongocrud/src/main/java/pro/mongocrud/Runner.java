/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro.mongocrud;

/**
 *
 * @author 24167306
 */
public class Runner {
    public static void main(String[] args) {            
    ConectaMongo con = new ConectaMongo();
    //con.insereValores(6, "Caio Cardoso", "Analista de Sis Jr", false);
    //con.insereValores(6, "Leandro Cardoso", "Analista de Sis Jr", false);
    con.deleteValores("Carlos André");
    con.mostraValores();
    }
}
