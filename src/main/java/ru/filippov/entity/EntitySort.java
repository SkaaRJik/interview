package ru.filippov.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "sorts", schema = "public", catalog = "interview")
public class EntitySort implements Entity {
    private long id;
    private String inputs;
    private String output;
    private Date date;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "inputs", nullable = false, length = -1)
    public String getInputs() {
        return inputs;
    }

    public void setInputs(String inputs) {
        this.inputs = inputs;
    }

    @Basic
    @Column(name = "output", nullable = true, length = -1)
    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Basic
    @Column(name = "created_date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntitySort that = (EntitySort) o;
        return id == that.id &&
                Objects.equals(inputs, that.inputs) &&
                Objects.equals(output, that.output);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inputs, output);
    }
}
