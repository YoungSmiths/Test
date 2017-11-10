package cn.young.dev.test.springboot.test1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-9-18 下午4:02
 */
@Profile({"client"})
@Service
public class FirstService {
    Logger logger = LoggerFactory.getLogger(FirstService.class);
    public FirstService(){
        logger.info("the first Service has run!");
    }
}
