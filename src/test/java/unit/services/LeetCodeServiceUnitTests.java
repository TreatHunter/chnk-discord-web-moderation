package unit.services;

import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;
import com.chnk.chnk_discord_web_moderation.repositories.ChnkLeetCodeNumRepository;
import com.chnk.chnk_discord_web_moderation.repositories.ChnkNumbersRepository;
import com.chnk.chnk_discord_web_moderation.services.LeetCodeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class LeetCodeServiceUnitTests {
    @Mock
    ChnkLeetCodeNumRepository chnkLeetCodeNumRepository;

    @Mock
    ChnkNumbersRepository chnkNumbersRepository;

    @InjectMocks
    LeetCodeService leetCodeService;

    @Test
    @DisplayName("Just test ")
    public void test() {
        ChnkNumber numb = new ChnkNumber();
        numb.setValue(44);
        numb.setPrimaryKey(UUID.randomUUID());
        given(chnkNumbersRepository.getFirstByValue(44)).willReturn(Optional.ofNullable(numb));
        System.out.println(chnkNumbersRepository.getFirstByValue(44).get());

        ChnkNumber numa = new ChnkNumber();
        numa.setValue(55);
        numa.setPrimaryKey(UUID.randomUUID());
        given(chnkNumbersRepository.getFirstByValue(any(Integer.class))).willReturn(Optional.ofNullable(numa));
        System.out.println(chnkNumbersRepository.getFirstByValue(400).get());
        System.out.println(chnkNumbersRepository.getFirstByValue(1).get());
        System.out.println(chnkNumbersRepository.getFirstByValue(44).get());
        Assertions.assertEquals(5,10);
    }
}
