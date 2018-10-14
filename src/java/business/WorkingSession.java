/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author nicola
 */
public class WorkingSession implements Serializable {
    
    private Timestamp startSession;
    private Timestamp finishSession;
    private boolean state; // true corrisponde a libero.

    public WorkingSession(Timestamp startSession, Timestamp finishSession, boolean state) {
        this.startSession = startSession;
        this.finishSession = finishSession;
        this.state = state;
    }

    public WorkingSession() {
        this.startSession = null;
        this.finishSession = null;
        this.state = true;
    }

    public Timestamp getStartSession() {
        return startSession;
    }

    public Timestamp getFinishSession() {
        return finishSession;
    }

    public void setStartSession(Timestamp startSession) {
        this.startSession = startSession;
    }

    public void setFinishSession(Timestamp finishSession) {
        this.finishSession = finishSession;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
}
