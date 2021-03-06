package com.gourianova.titles.model;

import java.io.Serializable;

public class TodoItem implements Serializable {

    private static final long serialVersionUID =3L;
    private Long id;
    private String category;
    private String name;
    private boolean complete;

    public TodoItem () {
    }

    public TodoItem ( String name, String category, boolean complete ) {
        this.name = name;
        this.category = category;
        this.complete = complete;
    }

    public TodoItem ( String category, String name ) {
        this.category = category;
        this.name = name;
        this.complete = false;
    }

    @Override
    public String toString () {
        return String.format (
                "TodoItem[id=%d, category='%s', name='%s', complete='%b']",
                id, category, name, complete);
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;

    }

    public String getCategory () {
        return category;
    }

    public void setCategory ( String category ) {
        this.category = category;

    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;

    }

    public boolean isComplete () {
        return complete;
    }

    public void setComplete ( boolean complete ) {
        this.complete = complete;
        return;
    }

}
