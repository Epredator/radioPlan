package com.etroya.radioplan.repository;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by eperedator on 04.08.17.
 */
@RunWith(Arquillian.class)
public class StationRepositoryTest {

    @Test
    public void testCreate() throws Exception {

    }

//    @Deployment
//    public static JavaArvhive createDeployment(){
//        return ShrinkWrap.create(JavaArchive.class)
//                .addClass(StationRepository.class)
//                .addAssMainResource(EmptyAsset.INSTANCE, target: "beans.xml");
//    }
}