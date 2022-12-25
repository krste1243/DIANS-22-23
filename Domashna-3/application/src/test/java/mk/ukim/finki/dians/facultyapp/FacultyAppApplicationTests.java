package mk.ukim.finki.dians.facultyapp;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
class FacultyAppApplicationTests {
    MockMvc mockMvc;
    @BeforeEach
    public void setup(WebApplicationContext wac){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetFaculties() throws Exception{
        MockHttpServletRequestBuilder facultiesRequest= MockMvcRequestBuilders.get("/faculties");
        this.mockMvc.perform(facultiesRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("faculties"))
                .andExpect(MockMvcResultMatchers.view().name("faculties"));
    }
    @Test
    public void testGetHomePage() throws Exception{
        MockHttpServletRequestBuilder homePageRequest= MockMvcRequestBuilders.get("/home");
        this.mockMvc.perform(homePageRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("home"));
    }

    @Test
    public void testGetCitiesPage() throws Exception{
        MockHttpServletRequestBuilder homeCitiesPageRequest= MockMvcRequestBuilders.get("/cities");
        this.mockMvc.perform(homeCitiesPageRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("cities"))
                .andExpect(MockMvcResultMatchers.view().name("cities"));
    }

    @Test
    public void testGetAboutUsPage() throws Exception{
        MockHttpServletRequestBuilder homePageRequest= MockMvcRequestBuilders.get("/aboutUs");
        this.mockMvc.perform(homePageRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("aboutUs"));
    }
}
