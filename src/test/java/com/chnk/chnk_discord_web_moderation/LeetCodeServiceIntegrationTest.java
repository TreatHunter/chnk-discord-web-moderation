package com.chnk.chnk_discord_web_moderation;

import com.chnk.chnk_discord_web_moderation.entities.ChnkLeetCodeNum;
import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;
import com.chnk.chnk_discord_web_moderation.repositories.ChnkLeetCodeNumRepository;
import com.chnk.chnk_discord_web_moderation.repositories.ChnkNumbersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LeetCodeServiceIntegrationTest {
    @MockBean
    ChnkLeetCodeNumRepository chnkLeetCodeNumRepository;

    @MockBean
    ChnkNumbersRepository chnkNumbersRepository;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void test() {
        ChnkLeetCodeNum chnkLeetCodeNum = new ChnkLeetCodeNum();
        ChnkNumber num = new ChnkNumber();
        num.setValue(9);
        given(chnkNumbersRepository.getFirstByValue(9)).willReturn(Optional.ofNullable(num));
        chnkLeetCodeNum.setTarget(num);
        Set<ChnkNumber> chnkNumberSet = new LinkedHashSet<>();

        num = new ChnkNumber();
        num.setValue(2);
        given(chnkNumbersRepository.getFirstByValue(2)).willReturn(Optional.ofNullable(num));
        chnkNumberSet.add(num);

        num = new ChnkNumber();
        num.setValue(7);
        given(chnkNumbersRepository.getFirstByValue(7)).willReturn(Optional.ofNullable(num));
        chnkNumberSet.add(num);

        num = new ChnkNumber();
        num.setValue(44);
        given(chnkNumbersRepository.getFirstByValue(44)).willReturn(Optional.ofNullable(num));
        chnkNumberSet.add(num);

        num = new ChnkNumber();
        num.setValue(55);
        given(chnkNumbersRepository.getFirstByValue(55)).willReturn(Optional.ofNullable(num));
        chnkNumberSet.add(num);

        chnkLeetCodeNum.setNums(chnkNumberSet);

        given(chnkLeetCodeNumRepository.save(any(ChnkLeetCodeNum.class))).will((InvocationOnMock invocation) -> {
            ChnkLeetCodeNum number = (ChnkLeetCodeNum) invocation.getArgument(0);
            number.setPrimaryKey(UUID.randomUUID());
            return number;
        });

        ResponseEntity<ChnkLeetCodeNum> responceEntity = testRestTemplate.exchange(
            "/LeetCode_1",
                HttpMethod.POST,
                new HttpEntity<>(chnkLeetCodeNum),
                ChnkLeetCodeNum.class
        );
        Assertions.assertEquals(HttpStatus.OK,responceEntity.getStatusCode());
        System.out.println(responceEntity.getBody());
    }
}
