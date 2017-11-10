package cn.young.dev.test.springboot.test1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-9-18 下午4:05
 */
@Profile({"!client"})
@Service
public class TestProfileService {
    private static final Logger logger = LoggerFactory.getLogger(TestProfileService.class);
    public TestProfileService(){
        logger.info("the testProfileService has run!");

    }
}
