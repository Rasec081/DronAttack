/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Comandos;

/**
 *
 * @author gambo
 */
public interface ICommand {
    public String getCommandName();       
    public void execute(String[] args); 
}
