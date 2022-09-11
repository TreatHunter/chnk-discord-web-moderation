package unit.services;

import com.chnk.chnk_discord_web_moderation.entities.ChnkLeetCodeNum;
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
import org.mockito.invocation.InvocationOnMock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class LeetCodeServiceUnitTests {

    @Mock
    ChnkNumbersRepository chnkNumbersRepository;

    @Mock
    ChnkLeetCodeNumRepository chnkLeetCodeNumRepository;

    @InjectMocks
    LeetCodeService leetCodeService;

    @Test
    @DisplayName("Just test")
    public void test(){
        ChnkLeetCodeNum chnkLeetCodeNum = new ChnkLeetCodeNum();
        Set<ChnkNumber> chnkNumberSet = new LinkedHashSet<>();

        ChnkNumber chnkNumber = new ChnkNumber();
        chnkNumber.setValue(9);
        given(chnkNumbersRepository.getFirstByValue(9)).willReturn(Optional.ofNullable(chnkNumber));
        chnkLeetCodeNum.setTarget(chnkNumber);

        chnkNumber = new ChnkNumber();
        chnkNumber.setValue(2);
        given(chnkNumbersRepository.getFirstByValue(2)).willReturn(Optional.ofNullable(chnkNumber));
        chnkNumberSet.add(chnkNumber);

        chnkNumber = new ChnkNumber();
        chnkNumber.setValue(7);
        given(chnkNumbersRepository.getFirstByValue(7)).willReturn(Optional.ofNullable(chnkNumber));
        chnkNumberSet.add(chnkNumber);

        chnkNumber = new ChnkNumber();
        chnkNumber.setValue(44);
        given(chnkNumbersRepository.getFirstByValue(44)).willReturn(Optional.ofNullable(chnkNumber));
        chnkNumberSet.add(chnkNumber);

        chnkNumber = new ChnkNumber();
        chnkNumber.setValue(55);
        given(chnkNumbersRepository.getFirstByValue(55)).willReturn(Optional.ofNullable(chnkNumber));
        chnkNumberSet.add(chnkNumber);

        chnkLeetCodeNum.setNums(chnkNumberSet);

        given(chnkLeetCodeNumRepository.save(any(ChnkLeetCodeNum.class))).will((InvocationOnMock invocation) -> {
                ChnkLeetCodeNum number = (ChnkLeetCodeNum) invocation.getArgument(0);
                number.setPrimaryKey(UUID.randomUUID());
                return number;
        });

        ChnkLeetCodeNum answer = leetCodeService.twoSum(chnkLeetCodeNum);

        Assertions.assertEquals(9, answer.getTarget().getValue());
        Assertions.assertEquals(2, answer.getAnswer().size());
        Assertions.assertFalse(answer
                .getAnswer()
                .stream()
                .anyMatch(chnkNum -> chnkNum.getValue() != 7 && chnkNum.getValue() != 2));

        Assertions.assertEquals(4, answer.getNums().size());
        Assertions.assertFalse(answer
                .getNums()
                .stream()
                .anyMatch(chnkNum -> chnkNum.getValue() != 7 && chnkNum.getValue() != 2 && chnkNum.getValue() != 44 && chnkNum.getValue() != 55));
    }
}
