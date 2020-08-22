package com.retail.loyality.vo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DatabaseSequenceTest {

    DatabaseSequence databaseSequence;

    @Before
    public void setup()
    {
        databaseSequence = new DatabaseSequence();
        databaseSequence.setSeq(123l);
        databaseSequence.setId("USER_SEQUENCE");
    }

    @Test
    public void databaseSequenceTest()
    {
        Assert.assertEquals(123l,databaseSequence.getSeq());
        Assert.assertEquals("USER_SEQUENCE",databaseSequence.getId());
    }
}
