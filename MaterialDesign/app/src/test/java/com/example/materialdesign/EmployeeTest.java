package com.example.materialdesign;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmployeeTest {
    @Test
    public void multiple_rfour_returns_toStrings() {
// Arrange

        Employee employee1 = new Employee("asier","muñoz");
// Act
        String result;
        result = employee1.toString();
// Assert
        assertEquals("asier muñoz", result);
        // Arrange

        Employee employee2 = new Employee("asier","");
// Act
        String result2;
        result2 = employee2.toString();
// Assert
        assertEquals("asier -", result2);
        // Arrange

        Employee employee3 = new Employee("","muñoz");
// Act
        String result3;
        result3 = employee3.toString();
// Assert
        assertEquals("- muñoz", result3);
        // Arrange

        Employee employee4 = new Employee("","");
// Act
        String result4;
        result4 = employee4.toString();
// Assert
        assertEquals("- -", result4);
    }
}
