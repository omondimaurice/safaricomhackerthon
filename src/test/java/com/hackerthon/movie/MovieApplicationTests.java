package com.hackerthon.movie;

import com.hackerthon.movie.Controllers.ViewersController;
import com.hackerthon.movie.Entity.ApplicationUser;
import com.hackerthon.movie.service.ApplicationUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ViewersController.class)
public class MovieApplicationTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ApplicationUserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Test
    public void testUserts() throws Exception{

        ApplicationUser user = new ApplicationUser();
        user.setPassword(passwordEncoder.encode("password"));
        user.setUsername("john");
        user.setEmail("test@test.com");
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setCreatedOn(new Date(System.currentTimeMillis()));

        List<ApplicationUser> applicationUsers = Arrays.asList(user);


        given(userService.getUsers()).willReturn(applicationUsers);

        mvc.perform(get("api/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].name", is(user.getUsername())));

    }

}
