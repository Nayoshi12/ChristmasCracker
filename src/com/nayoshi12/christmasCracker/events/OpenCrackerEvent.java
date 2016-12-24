package com.nayoshi12.christmasCracker.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Matthew on 12/23/2016.
 */
public class OpenCrackerEvent extends Event implements Cancellable {
    private String text;
    private boolean cancelled;
    private Player target;
    private Player from;

    public OpenCrackerEvent(Player target,Player from) {
        super();
        this.target = target;
        this.from = from;
    }
    public Player getPlayerTarget(){
        return target;
    }
    public Player getPlayerFrom(){
        return from;
    }
    public void setCancelled(boolean bln) {
        this.cancelled = bln;
    }
    public boolean isCancelled(){
        return cancelled;
    }
    private static final HandlerList HANDLERS = new HandlerList();

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
