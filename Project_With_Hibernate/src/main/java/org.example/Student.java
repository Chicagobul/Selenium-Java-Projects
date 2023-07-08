package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.example.Certificate;

@Entity
public class Student
{
    @Id
    private int id;
    private String name;
    private String city;

    private Certificate cert;
    public Student(int id, String name, String city)
    {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Certificate getCert() {
        return cert;
    }

    public void setCert(Certificate cert) {
        this.cert = cert;
    }

    public Student()
    {
        super();
    }

    @Override
    public String toString()
    {
        return this.id+" : "+this.name+" : "+this.city;
    }
}

/* @Entity - it is used to mark the table as an entity that means hibernate will create an object & table
   for this class

   @Id - to make Id as a primary key for the table

   @Table - used to change the table details

   @Column - To change the column name in the associated table in DB, specifies the details of the column for this
   property or field

   @Transient - tells hibernate not to save this field(column)

   @Temporal - tells hibernate the format in which the date needs to be saved

   @GeneratedValue - The @GeneratedValue annotation specifies how to generate values for the given column.
   This annotation will help in creating primary keys values according to the specified strategy.
   The only thing we need to do is to add @GeneratedValue annotation in the POJO class.

   @Embeddable - by using this we can add/embed one class fields into another class table ex. we are embedding
   certificate class fields into student class table
 */
