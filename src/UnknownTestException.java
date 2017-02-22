/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.protocol;

/**
 *
 * @author A661517
 */
public class UnknownTestException extends Exception
{
    /*
    private String id;
    
    public UnknownTestException(String id)
    {
        this.id = id;
    }*/
    
    public UnknownTestException(String id)
    {
        super("Test not found with ID: " + id);
    }
    
    @Override
    public String toString()
    {
        return "Test not found.";
    }
}
