package com.gis.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.gis.entity.EmpEntity;
import com.gis.repo.EmpRepo;
import com.gis.service.EmpServiceImpl;

@SpringBootTest
public class EmpServiceImplTest {
		@InjectMocks//to create class instances that need to be tested in the test class
		private EmpServiceImpl empServiceImpl;
		@Mock
		private EmpRepo empRepo;
		
    @Test
    public void testSaveEmpSuccess() {
        EmpEntity entity = new EmpEntity(); // Create a sample entity

        Mockito.when(empRepo.save(Mockito.any(EmpEntity.class))).thenReturn(entity);

        boolean result = empServiceImpl.saveEmp(entity);

        assertTrue(result); // The saveEmp method should return true
        Mockito.verify(empRepo, Mockito.times(1)).save(entity);
    }

    @Test
    public void testSaveEmpFailure() {
        Mockito.when(empRepo.save(Mockito.any(EmpEntity.class))).thenReturn(null);

        boolean result = empServiceImpl.saveEmp(new EmpEntity());

        assertFalse(result); // The saveEmp method should return false
        Mockito.verify(empRepo, Mockito.times(1)).save(Mockito.any(EmpEntity.class));
    }

    @Test
    public void testUpdateEmpSuccess() {
        EmpEntity empDto = new EmpEntity(1, "Ram", 1500.0);
        EmpEntity existingEntity = new EmpEntity(1, "Java", 1000.0);

        Mockito.when(empRepo.findById(empDto.getEmpId())).thenReturn(Optional.of(existingEntity));
        Mockito.when(empRepo.save(Mockito.any(EmpEntity.class))).thenReturn(empDto);

        boolean result = empServiceImpl.updateEmp(empDto);

        assertTrue(result); // The updateEmp method should return true
        Mockito.verify(empRepo, Mockito.times(1)).findById(empDto.getEmpId());
        Mockito.verify(empRepo, Mockito.times(1)).save(Mockito.any(EmpEntity.class));
    }

    @Test
    public void testUpdateEmpFailure() {
        EmpEntity empDto = new EmpEntity(1, "Ram", 1500.0);

        Mockito.when(empRepo.findById(empDto.getEmpId())).thenReturn(Optional.empty());

        boolean result = empServiceImpl.updateEmp(empDto);

        assertFalse(result); // The updateEmp method should return false
        Mockito.verify(empRepo, Mockito.times(1)).findById(empDto.getEmpId());
        Mockito.verify(empRepo, Mockito.times(0)).save(Mockito.any(EmpEntity.class));
    }




    @Test
    public void testGetByIdExistingEmp() {
        Integer empId = 1;
        EmpEntity empEntity = new EmpEntity(empId, "John", 50000.0);
        when(empRepo.findById(empId)).thenReturn(Optional.of(empEntity));

        EmpEntity result = empServiceImpl.getById(empId);

        assertEquals(empEntity, result);
    }

    @Test
    public void testGetByIdNonExistingEmp() {
        Integer empId = 1;
        when(empRepo.findById(empId)).thenReturn(Optional.empty());

        EmpEntity result = empServiceImpl.getById(empId);

        assertNull(result);
    }

    @Test
    public void testGetAllCoursesPositive() {
	        // Arrange
	        List<EmpEntity> mockCourseList = new ArrayList<>();
	        mockCourseList.add(new EmpEntity(100, "Python", 669.9));
	        mockCourseList.add(new EmpEntity(100, "JSE", 666.9));
	        when(empRepo.findAll()).thenReturn(mockCourseList);

	        // Act
	        List<EmpEntity> result = empServiceImpl.getAllEmps();

	        // Assert
	        assertEquals(2, result.size()); // Assuming two mock courses were added
	        assertEquals(mockCourseList, result);
	        Mockito.verify(empRepo, Mockito.times(1)).findAll();
	}

    @Test
    public void testGetAllCoursesEmptyList() {
        List<EmpEntity> expectedEmpList = new ArrayList<>();

        when(empRepo.findAll()).thenReturn(expectedEmpList);

        List<EmpEntity> result = empServiceImpl.getAllEmps();

        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetAllCourses_NullList() {
        when(empRepo.findAll()).thenReturn(null);

        List<EmpEntity> result = empServiceImpl.getAllEmps();

        assertNull(result);
    }



}

