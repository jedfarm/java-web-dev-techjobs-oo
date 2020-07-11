package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.launchcode.techjobs_oo.*;

import org.junit.Test;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class JobTest {
    Job job1 = null;
    Job job2 = null;
    Job job3 = null;
    Job job4 = null;
    Job job5 = null;

    @Before
    public void someJobObjects() {
         job1 = new Job();
         job2 = new Job();
         job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                 new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job5 = new Job("Product tester", new Employer(), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        assertTrue(job2.getId() - job1.getId() == 1);
    }

    @Test
    public void testJobConstructorSetAllFields(){
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().toString());
        assertEquals("Desert", job3.getLocation().toString());
        assertEquals("Quality control", job3.getPositionType().toString());
        assertEquals("Persistence", job3.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(job3 == job4);
    }

    @Test
    public void testToString(){
        List<String> myList = new ArrayList<String>(Arrays.asList(job4.toString().split("\n")));
        assertTrue(myList.get(0).isEmpty());
        assertTrue(myList.get(myList.size()-1).equals(" "));

        assertEquals("\n" +
                "ID: 9\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n ", job4.toString());

        assertEquals("\nOOPS! This job does not seem to exist.\n ", job1.toString());
    }
}
