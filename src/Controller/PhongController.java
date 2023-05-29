/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.PhongModel;
/**
 *
 * @author hiep0
 */
public class PhongController {
    public static PhongModel phong;
    
   public int thongkePhong(){
       return new PhongModel().CountPhong();
   }

    public PhongController() {
    }
   
   
}