package org.launchcode.techjobs_oo;

import javax.swing.text.Position;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;


public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    // toString() method
    @Override
    public String toString() {
        String emptyLine1 = "\n";
        String emptyLine2 = "\n ";


        // This is what I ended up doing, but it is not what I want.
        StringBuffer field = new StringBuffer();
        String[] fieldNames = {"ID: ", "Name: ", "Employer: ", "Location: ", "Position Type: ", "Core Competency: "};
        Object[] actualFields = {this.id, this.name, this.employer, this.location, this.positionType,
                this.coreCompetency};
        int emptyFieldCounter = 0;
        String text;
        

        for (int i = 0; i < fieldNames.length; i++){
            if (i == fieldNames.length - 1){
                emptyLine1 = "";
            }
            try{
                if(actualFields[i].toString().length() > 0){
                    field.append(fieldNames[i] + actualFields[i].toString() + emptyLine1);
                }
            }
            catch(NullPointerException e){
                field.append(fieldNames[i] + "Data not available" + emptyLine1);
                emptyFieldCounter ++;
            }
            emptyLine1 = "\n";
        }
        if(emptyFieldCounter < actualFields.length - 1){
            text = field.toString();
        }else{
            text = "OOPS! This job does not seem to exist.";
        }

        String output = emptyLine1 + text + emptyLine2;

        return output;

        //ToDo: Find a way to iterate through the fields without manually create an array
        // making the toString() method transparent to any future changes in fields.

        // I found a couple of solutions online that I tried to adapt but I couldn't.
        //1. Here I succeeded at printing out the properties but not the values.
        //Field [] fields = Job.class.getDeclaredFields();
//        for(Field f: fields){
//            System.out.println(f.getName() + ": ");
//        }

     //2. This one needs a dependency to be added (I added the whole repo https://github.com/diffplug/durian
        // to my project, but maybe I did not know how to do it the right way.

//        FieldsAndGetters.fields(this)
//                .map(field -> {
//                    return field.getKey().getName() + " = " + field.getValue();
//                });
        //.forEach(System.out::println);
    }
}
