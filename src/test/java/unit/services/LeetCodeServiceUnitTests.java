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

import java.util.*;

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

        ChnkLeetCodeNum answer = leetCodeService.twoSum(chnkLeetCodeNum);

        Assertions.assertEquals(9, answer.getTarget().getValue());
        //bad test because it can pass when its 7,7 or 2,2
        Assertions.assertEquals(2,answer.getAnswer().size());
        Assertions.assertEquals(false,answer
                .getAnswer()
                .stream()
                .anyMatch(chnkNumber -> chnkNumber.getValue() != 7 && chnkNumber.getValue() != 2)
        );
        // the same
        Assertions.assertEquals(4,answer.getNums().size());
        Assertions.assertEquals(false,answer
                .getNums()
                .stream()
                .anyMatch(chnkNumber -> chnkNumber.getValue() != 7 && chnkNumber.getValue() != 2
                        && chnkNumber.getValue() != 44 && chnkNumber.getValue() != 55)
        );

    }
}
