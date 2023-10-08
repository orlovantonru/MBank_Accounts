package com.minibank.mbank_accounts.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.minibank.mbank_accounts.model.Account;
import com.minibank.mbank_accounts.service.AccountService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountRestControllerV1.class)
public class AccountRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
   // private UserService userService;
    private AccountService accountService;


    Account accountOne;
    Account accountTwo;
    List<Account> accountList = new ArrayList<>();
    Date date = new Date();
    @BeforeEach
    void setUp() {

        accountOne = new Account(1L,"40817810000000000012",date,1L, 10F, 100000F);
        accountTwo = new Account(2L,"40817810000000000013",date,1L, 9F, 50000F);
        accountList.add(accountOne);
        accountList.add(accountTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAccountsDetails() throws Exception {
        when(accountService.findByUserId(1L)).thenReturn(accountList);
        this.mockMvc.perform(get("/bank/account/" + "1")).andDo(print()).andExpect(status().isOk());
    }



    @Test
    void createAccountDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(accountOne);

        when(accountService.saveAccount(accountOne)).thenReturn("Success");
        this.mockMvc.perform(post("/bank/account/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }
}
