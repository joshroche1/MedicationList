import static org.junit.Assert.fail;

import org.junit.Test;

import cmsc495.DAOlogin;
public class LoginTests {
    @Before
    void setUp(){
        
    }
   
    
    @Test 
     validatePatientHappyPath() {
         assertTrue(DAOlogin.validatePatient("patient", "password"));
       
    }
    @Test 
    validatePatientSadPath() {
        assertFalse(DAOlogin.validatePatient("random", "password"));
   }
   @Test 
     validateProviderHappyPath() {
        assertTrue(DAOlogin.validateProvider("provider", "password", "1111111"));
    }
    @Test 
    validateProviderSadPath() {
        assertTrue(DAOlogin.validateProvider("patient", "password", "1"));
   }

    
}
