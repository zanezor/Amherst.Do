package com.example.zeinaamhaz.amherstdo;

/**
 * Created by zeinaamhaz on 3/7/17.
 */

public class Item {
    private String urgency;
    private String todoItem;
    private String description;
    private boolean done;

    public Item(String urgency, String todoItem, String description, boolean done) {
        this.urgency = urgency;
        this.todoItem = todoItem;
        this.description = description;
        this.done = done;
    }

    public String getUrgency() {
        return this.urgency;
    }

    public String getTodoItem() {
        return this.todoItem;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDone(boolean done){
        this.done = done;
    }
    public boolean isDone() {return done;}
}
