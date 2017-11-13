/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.model;

/**
 *
 * @author 2101359
 */
public class ServerMessage {

    private String content;
    private Tablero server;
    private int id;

    public ServerMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    /**
     * @return the server
     */
    public Tablero getServer() {
        return server;
    }

    /**
     * @param server the server to set
     */
    public void setServer(Tablero server) {
        this.server = server;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
