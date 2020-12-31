//package ro.tuc.ds2020.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import ro.tuc.ds2020.dtos.AddressDTO;
//import ro.tuc.ds2020.dtos.DoctorDTO;
//import ro.tuc.ds2020.dtos.UserAuthenticationDTO;
//import ro.tuc.ds2020.dtos.UserRoleDTO;
//
//import ro.tuc.ds2020.services.DoctorService;
//import java.util.Date;
//
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.hamcrest.CoreMatchers.is;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(DoctorController.class)
//public class DoctorControllerUnitTest{
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private DoctorService doctorService;
//
//
//    @Test
//    public void testInsertDoctor() throws Exception{
//        ObjectMapper objectMapper = new ObjectMapper();
//        DoctorDTO doctorDTO = new DoctorDTO("test", "test", new Date(1985-02-24), "male");
//        doctorDTO.setAddress(new AddressDTO("test", "test", "test", "test"));
//        doctorDTO.setUserAuthentication(new UserAuthenticationDTO("test1", "test1", "test1", new UserRoleDTO("ROLE_doctor")));
//
//        mockMvc.perform(post("/doctor")
//                .content(objectMapper.writeValueAsString(doctorDTO))
//                .contentType("application/json"))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    public void testInsertDoctorNull() throws Exception{
//        ObjectMapper objectMapper = new ObjectMapper();
//        DoctorDTO doctorDTO = new DoctorDTO("test", "test",new Date(1985-02-24), "male");
//        doctorDTO.setAddress(new AddressDTO("test", "test", "test", "test"));
//        doctorDTO.setUserAuthentication(null);
//
//        mockMvc.perform(post("/doctor")
//                .content(objectMapper.writeValueAsString(doctorDTO))
//                .contentType("application/json"))
//                .andExpect(status().isBadRequest());
//    }
//
//    @Test
//    public void testFindDoctorByWrongId() throws Exception{
//        DoctorDTO doctorDTO = new DoctorDTO("test", "test", new Date(1985-02-24), "male");
//        doctorDTO.setAddress(new AddressDTO("test", "test", "test", "test"));
//        doctorDTO.setUserAuthentication(new UserAuthenticationDTO("test1", "test1", "test1", new UserRoleDTO("ROLE_doctor")));
//
//
//        mockMvc.perform(get("/doctor/{id}", "6d6a4164-0064-491c-8148-8d3ab9496884"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.firstName", is(doctorDTO.getFirstName())))
//                .andExpect(jsonPath("$.lastName", is(doctorDTO.getLastName())))
//                .andExpect(jsonPath("$.userAuthentication.email", is(doctorDTO.getUserAuthentication().getEmail())));
//    }
//
//
////    @Test
////    public void testEditDoctor() throws Exception{
////        ObjectMapper objectMapper = new ObjectMapper();
////        DoctorDTO doctorDTO = new DoctorDTO("6d6a4164-0064-491c-8148-8d3ab9496884", "test11", "test11", new Date(1985-02-24), "male");
////        doctorDTO.setAddress(new AddressDTO("test", "test", "test", "test"));
////        doctorDTO.setUserAuthentication(new UserAuthenticationDTO("test1", "test1", "test1", new UserRoleDTO("ROLE_doctor")));
////
////        mockMvc.perform(put("/doctor"))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.firstName", is(doctorDTO.getFirstName())))
////                .andExpect(jsonPath("$.lastName", is(doctorDTO.getLastName())))
////                .andExpect(jsonPath("$.userAuthentication.email", is(doctorDTO.getUserAuthentication().getEmail())));
////    }
//
////    @Test
////    public void testDeleteDoctor() throws Exception{
////        ObjectMapper objectMapper = new ObjectMapper();
////
////    }
//
//}
