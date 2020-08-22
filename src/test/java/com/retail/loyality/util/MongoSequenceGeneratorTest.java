package com.retail.loyality.util;

import com.retail.loyality.vo.DatabaseSequence;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoSequenceGeneratorTest {

    @Mock
    private MongoOperations mongoOperations;

    DatabaseSequence databaseSequence;

    @Mock
    Query query;

    @InjectMocks
    private MongoSequenceGenerator mongoSequenceGenerator;

    String seqeunce;
    long id;

    @Before
    public void setup()
    {
        databaseSequence = new DatabaseSequence();
        databaseSequence.setSeq(123l);
        databaseSequence.setId("USER_SEQUENCE");
        seqeunce="USER_SEQUENCE";
        id= 123l;
    }

    @Test
    public void generateSequenceTest()
    {
        when(mongoSequenceGenerator.generateSequence(seqeunce)).thenReturn(id);
        Assert.assertNotNull(id);
    }
}
